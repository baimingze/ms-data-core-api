
package uk.ac.ebi.pride.utilities.data.Unmarshallers.pepXML.model.pepxml;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="channel" use="required" type="{http://regis-web.systemsbiology.net/pepXML}positiveInt" />
 *       &lt;attribute name="correction" use="required" type="{http://www.w3.org/2001/XMLSchema}float" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class AffectedChannel
    extends pepXMLObject
    implements Serializable
{

    private final static long serialVersionUID = 100L;
    @XmlAttribute(required = true)
    protected long channel;
    @XmlAttribute(required = true)
    protected float correction;

    /**
     * Gets the value of the channel property.
     * 
     */
    public long getChannel() {
        return channel;
    }

    /**
     * Sets the value of the channel property.
     * 
     */
    public void setChannel(long value) {
        this.channel = value;
    }

    /**
     * Gets the value of the correction property.
     * 
     */
    public float getCorrection() {
        return correction;
    }

    /**
     * Sets the value of the correction property.
     * 
     */
    public void setCorrection(float value) {
        this.correction = value;
    }

}
