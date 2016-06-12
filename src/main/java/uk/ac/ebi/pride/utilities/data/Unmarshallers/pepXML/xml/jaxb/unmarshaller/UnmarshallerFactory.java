package uk.ac.ebi.pride.utilities.data.Unmarshallers.pepXML.xml.jaxb.unmarshaller;

import com.ctc.wstx.sax.WstxSAXParserFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import uk.ac.ebi.pride.utilities.data.Unmarshallers.pepXML.xml.io.pepXMLObjectCache;
import uk.ac.ebi.pride.utilities.data.Unmarshallers.pepXML.model.pepxml.utilities.ModelConstants;
import uk.ac.ebi.pride.utilities.data.Unmarshallers.pepXML.xml.jaxb.unmarshaller.filters.pepXMLNamespaceFilter;
import uk.ac.ebi.pride.utilities.data.Unmarshallers.pepXML.xml.xxindex.pepXMLIndexer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.UnmarshallerHandler;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class UnmarshallerFactory {

    private static final Logger logger = LoggerFactory.getLogger(UnmarshallerFactory.class);

    private static UnmarshallerFactory instance = new UnmarshallerFactory();
    private static JAXBContext jc = null;

    public static UnmarshallerFactory getInstance() {
        return instance;
    }

    private UnmarshallerFactory() {
    }

    public Unmarshaller initializeUnmarshaller(pepXMLIndexer index, pepXMLObjectCache cache, pepXMLNamespaceFilter xmlFilter) {
        return initializeUnmarshaller(index, xmlFilter, cache, true);
    }

    public Unmarshaller initializeUnmarshaller(pepXMLIndexer index, pepXMLNamespaceFilter xmlFilter, pepXMLObjectCache cache, boolean useCacheForSpectra) {

        try {
            // Lazy caching of the JAXB Context.
            if(jc == null) {
                jc = JAXBContext.newInstance(ModelConstants.PACKAGE);
            }

            //create unmarshaller
            Unmarshaller unmarshaller = jc.createUnmarshaller();



            UnmarshallerHandler uh = unmarshaller.getUnmarshallerHandler();

            // Create a new XML parser
            //SAXParserFactory factory = SAXParserFactory.newInstance();

//            WstxInputFactory inputFactory = new WstxInputFactory();
//            inputFactory.configureForSpeed();
//            SAXParserFactory factory = new WstxSAXParserFactory(inputFactory);

            SAXParserFactory factory = new WstxSAXParserFactory();

            factory.setNamespaceAware(true);
            SAXParser parser = factory.newSAXParser();
            XMLReader xmlReader = parser.getXMLReader();

            // Create a filter to intercept events -- and patch the missing namespace
            xmlFilter.setParent(xmlReader);
            xmlFilter.setContentHandler(uh);

            logger.debug("Unmarshaller Initialized");

            return unmarshaller;

        } catch (JAXBException e) {
            logger.error("UnmarshallerFactory.initializeUnmarshaller", e);
            throw new IllegalStateException("Could not initialize unmarshaller");
        } catch (SAXException e) {
            logger.error("UnmarshallerFactory.initializeUnmarshaller", e);
            throw new IllegalStateException("Could not initialize unmarshaller");
        } catch (ParserConfigurationException e) {
            logger.error("UnmarshallerFactory.initializeUnmarshaller", e);
            throw new IllegalStateException("Could not initialize unmarshaller");
        }

    }

}
