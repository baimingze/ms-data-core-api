package uk.ac.ebi.pride.utilities.data.Unmarshallers.pepXML.xml.jaxb.marshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.ac.ebi.pride.utilities.data.Unmarshallers.pepXML.Constants;
import uk.ac.ebi.pride.utilities.data.Unmarshallers.pepXML.model.pepxml.utilities.ModelConstants;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class MarshallerFactory {

    private static final Logger logger = LoggerFactory.getLogger(MarshallerFactory.class);
    private static MarshallerFactory instance = new MarshallerFactory();
    private static JAXBContext jc = null;

    public static MarshallerFactory getInstance() {
        return instance;
    }

    private MarshallerFactory() {
    }

    public Marshaller initializeMarshaller() {
        logger.debug("Initializing Marshaller for pepXML.");
        try {
            // Lazy caching of JAXB context.
            if(jc == null) {
                jc = JAXBContext.newInstance(ModelConstants.PACKAGE);
            }
            //create marshaller and set basic properties
            Marshaller marshaller = jc.createMarshaller();
            marshaller.setProperty(Constants.JAXB_ENCODING_PROPERTY, "UTF-8");
            marshaller.setProperty(Constants.JAXB_FORMATTING_PROPERTY, true);


            logger.info("Marshaller initialized");

            return marshaller;

        } catch (JAXBException e) {
            logger.error("MarshallerFactory.initializeMarshaller", e);
            throw new IllegalStateException("Can't initialize marshaller: " + e.getMessage());
        }
    }

}
