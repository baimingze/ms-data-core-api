package uk.ac.ebi.pride.utilities.data.Unmarshallers.pepXML.xml.jaxb.unmarshaller.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLFilterImpl;
import uk.ac.ebi.pride.utilities.data.Unmarshallers.pepXML.model.pepxml.utilities.ModelConstants;


public class pepXMLNamespaceFilter extends XMLFilterImpl {

    /*
        note that if "elementFormDefault" is set to "qualified", there should be
        a namespace associated with the startElement (so the uri should not be
        empty). If this is not the case (e.g. we only have a XML snippet which
        then does not have the ns definitions of the root element), this filter
        will replace the empty uri with the namespace defined for the mzML schema.
     */

    private static final Logger logger = LoggerFactory.getLogger(pepXMLNamespaceFilter.class);

    public pepXMLNamespaceFilter() {
        logger.debug("pepXMLNamespaceFilter created. Remember to call setParent(XMLReader)");
    }

    public pepXMLNamespaceFilter(XMLReader reader) {
        super(reader);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
        // the elements are defined by a qualified schema, but we rip them out of context with the xxindex
        // so the namespace information is lost and we have to add it again here manually
        logger.trace("Changing namespace. uri: " + uri + " \tlocalName: " + localName + " \tqName: " + qName + " \tatts: " + atts);
        if ( uri.length()== 0 ) super.startElement(ModelConstants.pepXML_NS, localName, qName, atts);
        else super.startElement(uri, localName, qName, atts);
    }
}
