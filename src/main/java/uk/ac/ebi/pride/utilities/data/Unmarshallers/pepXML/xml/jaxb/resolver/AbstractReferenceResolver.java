package uk.ac.ebi.pride.utilities.data.Unmarshallers.pepXML.xml.jaxb.resolver;

import org.apache.log4j.Logger;
import org.xml.sax.InputSource;
//import uk.ac.ebi.jmzml.model.mzml.MzMLObject;
import uk.ac.ebi.pride.utilities.data.Unmarshallers.pepXML.model.pepxml.pepXMLObject;
//import uk.ac.ebi.jmzml.xml.io.MzMLObjectCache;
import uk.ac.ebi.pride.utilities.data.Unmarshallers.pepXML.xml.io.pepXMLObjectCache;
//import uk.ac.ebi.jmzml.xml.jaxb.unmarshaller.UnmarshallerFactory;
import uk.ac.ebi.pride.utilities.data.Unmarshallers.pepXML.xml.jaxb.unmarshaller.UnmarshallerFactory;
//import uk.ac.ebi.jmzml.xml.jaxb.unmarshaller.filters.MzMLNamespaceFilter;
import uk.ac.ebi.pride.utilities.data.Unmarshallers.pepXML.xml.jaxb.unmarshaller.filters.pepXMLNamespaceFilter;
//import uk.ac.ebi.jmzml.xml.xxindex.MzMLIndexer;
import uk.ac.ebi.pride.utilities.data.Unmarshallers.pepXML.xml.xxindex.pepXMLIndexer;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.sax.SAXSource;
import java.io.StringReader;

/**
 * Abstract base class for the reference resolver classes.
 * It provides basic functionality to resolve a ID reference and unmarshal
 * the according MzIdentMLObject.
 *
 * @author Florian Reisinger
 *         Date: 12-Nov-2010
 * @since 1.0
 */
public abstract class AbstractReferenceResolver<T extends pepXMLObject> extends Unmarshaller.Listener {

    private static final Logger log = Logger.getLogger(AbstractReferenceResolver.class);

    // ToDo: check if we need the cache here or if we can handle this from another level (e.g. the MzMLUnmarshaller)
    private pepXMLIndexer index = null;
    private pepXMLObjectCache cache = null;


    protected AbstractReferenceResolver(pepXMLIndexer index, pepXMLObjectCache cache) {
        this.index = index;
        this.cache = cache;
    }



    public <R extends pepXMLObject> R unmarshal(String refId, Class<R> cls) {
        R retVal = null;

        // check if we have a cache to look up, if so see if it contains the referenced object already
//        if (cache != null) {
//            retVal = cache.getCachedObject(refId, cls);
//        }

        // if the referenced object/element is not yet in the cache (or no cache
        // is available) create it from the XML using the index and ID maps
        if (retVal == null) {

            log.debug("AbstractReferenceResolver.unmarshal for id: " + refId);
            // first retrieve the XML snippet representing the referenced object/element
            String xml;

            xml = index.getXmlString(refId, cls);


            try {
                // required for the addition of namespaces to top-level objects
                pepXMLNamespaceFilter xmlFilter = new pepXMLNamespaceFilter();

                // initializeUnmarshaller will assign the proper reader to the xmlFilter
                Unmarshaller unmarshaller = UnmarshallerFactory.getInstance().initializeUnmarshaller(index, cache, xmlFilter);

                // need to do it this way because snippet does not have a XmlRootElement annotation
                JAXBElement<R> holder = unmarshaller.unmarshal(new SAXSource(xmlFilter, new InputSource(new StringReader(xml))), cls);
                retVal = holder.getValue();

                // add it to the cache, if we there is one (as it was not in there)
                // the cache may accept this object or not depending on the settings in MzIdentMLElement
//                if (cache != null) {
//                    cache.putInCache(refId, retVal);
//                }

            } catch (JAXBException e) {
                log.error("AbstractReferenceResolver.unmarshal", e);
                throw new IllegalStateException("Could not unmarshall refId: " + refId + " for element type: " + cls);
            }

        }

        // finally return the referenced object
        return retVal;
    }

    public abstract void updateObject(T object);

    public abstract void checkRefID(T object);
    
    // ToDo: update all the resolver and corresponding classes with id consistency methods
}
