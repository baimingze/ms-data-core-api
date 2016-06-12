
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
 *       &lt;attribute name="value" type="{http://www.w3.org/2001/XMLSchema}float" />
 *       &lt;attribute name="pos_dens" type="{http://www.w3.org/2001/XMLSchema}float" />
 *       &lt;attribute name="neg_dens" type="{http://www.w3.org/2001/XMLSchema}float" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class MixturemodelPoint
    extends pepXMLObject
    implements Serializable
{

    private final static long serialVersionUID = 100L;
    @XmlAttribute
    protected Float value;
    @XmlAttribute(name = "pos_dens")
    protected Float posDens;
    @XmlAttribute(name = "neg_dens")
    protected Float negDens;

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setValue(Float value) {
        this.value = value;
    }

    /**
     * Gets the value of the posDens property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getPosDens() {
        return posDens;
    }

    /**
     * Sets the value of the posDens property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setPosDens(Float value) {
        this.posDens = value;
    }

    /**
     * Gets the value of the negDens property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getNegDens() {
        return negDens;
    }

    /**
     * Sets the value of the negDens property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setNegDens(Float value) {
        this.negDens = value;
    }

}
