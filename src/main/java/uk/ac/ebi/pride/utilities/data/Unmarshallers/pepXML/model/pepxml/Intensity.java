
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
 *       &lt;attribute name="target_mass" use="required" type="{http://www.w3.org/2001/XMLSchema}float" />
 *       &lt;attribute name="absolute" use="required" type="{http://www.w3.org/2001/XMLSchema}float" />
 *       &lt;attribute name="normalized" use="required" type="{http://www.w3.org/2001/XMLSchema}float" />
 *       &lt;attribute name="reject" type="{http://www.w3.org/2001/XMLSchema}boolean" default="0" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class Intensity
    extends pepXMLObject
    implements Serializable
{

    private final static long serialVersionUID = 100L;
    @XmlAttribute(required = true)
    protected long channel;
    @XmlAttribute(name = "target_mass", required = true)
    protected float targetMass;
    @XmlAttribute(required = true)
    protected float absolute;
    @XmlAttribute(required = true)
    protected float normalized;
    @XmlAttribute
    protected Boolean reject;

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
     * Gets the value of the targetMass property.
     * 
     */
    public float getTargetMass() {
        return targetMass;
    }

    /**
     * Sets the value of the targetMass property.
     * 
     */
    public void setTargetMass(float value) {
        this.targetMass = value;
    }

    /**
     * Gets the value of the absolute property.
     * 
     */
    public float getAbsolute() {
        return absolute;
    }

    /**
     * Sets the value of the absolute property.
     * 
     */
    public void setAbsolute(float value) {
        this.absolute = value;
    }

    /**
     * Gets the value of the normalized property.
     * 
     */
    public float getNormalized() {
        return normalized;
    }

    /**
     * Sets the value of the normalized property.
     * 
     */
    public void setNormalized(float value) {
        this.normalized = value;
    }

    /**
     * Gets the value of the reject property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean getReject() {
        if (reject == null) {
            return false;
        } else {
            return reject;
        }
    }

    /**
     * Sets the value of the reject property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setReject(Boolean value) {
        this.reject = value;
    }

}
