
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
 *       &lt;attribute name="mz" use="required" type="{http://www.w3.org/2001/XMLSchema}float" />
 *       &lt;attribute name="offset" type="{http://www.w3.org/2001/XMLSchema}float" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class FragmentMasses
    extends pepXMLObject
    implements Serializable
{

    private final static long serialVersionUID = 100L;
    @XmlAttribute(required = true)
    protected long channel;
    @XmlAttribute(required = true)
    protected float mz;
    @XmlAttribute
    protected Float offset;

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
     * Gets the value of the mz property.
     * 
     */
    public float getMz() {
        return mz;
    }

    /**
     * Sets the value of the mz property.
     * 
     */
    public void setMz(float value) {
        this.mz = value;
    }

    /**
     * Gets the value of the offset property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getOffset() {
        return offset;
    }

    /**
     * Sets the value of the offset property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setOffset(Float value) {
        this.offset = value;
    }

}
