
package uk.ac.ebi.pride.utilities.data.Unmarshallers.pepXML.model.pepxml;

import java.io.Serializable;
import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
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
 *       &lt;attribute name="version" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="author" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="elution" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="labeled_residues" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="area_flag" use="required" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" />
 *       &lt;attribute name="static_quant" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "asapratio_summary")
public class AsapratioSummary
    extends pepXMLObject
    implements Serializable
{

    private final static long serialVersionUID = 100L;
    @XmlAttribute(required = true)
    protected String version;
    @XmlAttribute(required = true)
    protected String author;
    @XmlAttribute(required = true)
    protected BigInteger elution;
    @XmlAttribute(name = "labeled_residues", required = true)
    protected String labeledResidues;
    @XmlAttribute(name = "area_flag", required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger areaFlag;
    @XmlAttribute(name = "static_quant", required = true)
    protected String staticQuant;

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

    /**
     * Gets the value of the author property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Sets the value of the author property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthor(String value) {
        this.author = value;
    }

    /**
     * Gets the value of the elution property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getElution() {
        return elution;
    }

    /**
     * Sets the value of the elution property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setElution(BigInteger value) {
        this.elution = value;
    }

    /**
     * Gets the value of the labeledResidues property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLabeledResidues() {
        return labeledResidues;
    }

    /**
     * Sets the value of the labeledResidues property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLabeledResidues(String value) {
        this.labeledResidues = value;
    }

    /**
     * Gets the value of the areaFlag property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getAreaFlag() {
        return areaFlag;
    }

    /**
     * Sets the value of the areaFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setAreaFlag(BigInteger value) {
        this.areaFlag = value;
    }

    /**
     * Gets the value of the staticQuant property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStaticQuant() {
        return staticQuant;
    }

    /**
     * Sets the value of the staticQuant property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStaticQuant(String value) {
        this.staticQuant = value;
    }

}
