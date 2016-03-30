
package uk.ac.ebi.pride.utilities.data.Unmarshallers.pepXML.model.pepxml;

import uk.ac.ebi.pride.utilities.data.Unmarshallers.pepXML.model.pepxml.Index;
import uk.ac.ebi.pride.utilities.data.Unmarshallers.pepXML.model.pepxml.pepXMLObject;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for IndexListType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IndexListType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="index" type="{http://psi.hupo.org/ms/mzml}IndexType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="count" use="required" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IndexListTypes", propOrder = {
    "index"
})
public class IndexList
    extends pepXMLObject
    implements Serializable
{

    private final static long serialVersionUID = 100L;
    @XmlElement(required = true)
    protected List<uk.ac.ebi.pride.utilities.data.Unmarshallers.pepXML.model.pepxml.Index> index;
    @XmlAttribute(required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected Integer count;

    /**
     * Gets the value of the index property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the index property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIndex().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link uk.ac.ebi.jmzml.model.mzml.Index }
     *
     *
     */
    public List<uk.ac.ebi.pride.utilities.data.Unmarshallers.pepXML.model.pepxml.Index> getIndex() {
        if (index == null) {
            index = new ArrayList<Index>();
        }
        return this.index;
    }

    /**
     * Gets the value of the count property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCount() {
        return count;
    }

    /**
     * Sets the value of the count property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCount(Integer value) {
        this.count = value;
    }

}
