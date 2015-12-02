package uk.ac.ebi.pride.utilities.data.Unmarshallers.pepXML.xml.io;

/**
 * @author Florian Reisinger
 * @since 0.4
 */
public class pepXMLUnmarshallerException extends Exception {

    public pepXMLUnmarshallerException(String msg) {
        super(msg);
    }

    public pepXMLUnmarshallerException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
