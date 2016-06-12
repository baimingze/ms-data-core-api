package uk.ac.ebi.pride.utilities.data.Unmarshallers.pepXML.xml.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.InputSource;
import uk.ac.ebi.pride.utilities.data.Unmarshallers.pepXML.xml.jaxb.unmarshaller.UnmarshallerFactory;
import uk.ac.ebi.pride.utilities.data.Unmarshallers.pepXML.xml.jaxb.unmarshaller.filters.pepXMLNamespaceFilter;
import uk.ac.ebi.pride.utilities.data.Unmarshallers.pepXML.xml.util.EscapingXMLUtilities;
import uk.ac.ebi.pride.utilities.data.Unmarshallers.pepXML.xml.xxindex.pepXMLIndexer;
import uk.ac.ebi.pride.utilities.data.Unmarshallers.pepXML.model.pepxml.pepXMLObject;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.sax.SAXSource;
import java.io.StringReader;
import java.util.Iterator;

public class pepXMLObjectIterator<X extends pepXMLObject> implements Iterator<X> {

    private static Logger logger = LoggerFactory.getLogger(pepXMLObjectIterator.class);

    private pepXMLIndexer index;

    private Iterator<String> innerXpathIterator;
    private String xpath;
    private Class cls;
    private pepXMLObjectCache cache;
    private boolean useSpectrumCache = true;

    //package level constructor!
    pepXMLObjectIterator(String xpath, Class cls, pepXMLIndexer index, pepXMLObjectCache cache) {
        this(xpath, cls, index, cache, true);
    }

    pepXMLObjectIterator(String xpath, Class cls, pepXMLIndexer index, pepXMLObjectCache cache, boolean aUseSpectrumCache) {
        innerXpathIterator = index.getXmlStringIterator(xpath);
        this.xpath = xpath;
        this.cls = cls;
        this.index = index;
        this.cache = cache;
        this.useSpectrumCache = aUseSpectrumCache;
    }


    public boolean hasNext() {
        return innerXpathIterator.hasNext();
    }

    public X next() {

        try {
            String xmlSt = innerXpathIterator.next();

            //need to clean up XML to ensure that there are no weird control characters
            String cleanXML = EscapingXMLUtilities.escapeCharacters(xmlSt);

            if (logger.isDebugEnabled()) {
                logger.trace("XML to unmarshal: " + cleanXML);
            }

            //required for the addition of namespaces to top-level objects
            pepXMLNamespaceFilter xmlFilter = new pepXMLNamespaceFilter();
            //initializeUnmarshaller will assign the proper reader to the xmlFilter
            Unmarshaller unmarshaller = UnmarshallerFactory.getInstance().initializeUnmarshaller(index, xmlFilter, cache, useSpectrumCache);
            //unmarshall the desired object
            JAXBElement<X> holder = unmarshaller.unmarshal(new SAXSource(xmlFilter, new InputSource(new StringReader(cleanXML))), cls);

            X retval = holder.getValue();

            if (logger.isDebugEnabled()) {
                logger.debug("unmarshalled object = " + retval);
            }

            return retval;
        } catch (JAXBException e) {
            logger.error("pepXMLObjectIterator.next", e);
            throw new IllegalStateException("Could not unmarshal object at xpath:" + xpath);
        }

    }

    public void remove() {
        throw new UnsupportedOperationException(pepXMLObjectIterator.class.getName() + " can't be used to remove objects while iterating");
    }


}
