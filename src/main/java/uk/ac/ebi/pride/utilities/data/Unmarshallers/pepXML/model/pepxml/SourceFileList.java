
package uk.ac.ebi.pride.utilities.data.Unmarshallers.pepXML.model.pepxml;

//import uk.ac.ebi.jmzml.model.mzml.MzMLObject;
import uk.ac.ebi.pride.utilities.data.Unmarshallers.pepXML.model.pepxml.pepXMLObject;
//import uk.ac.ebi.jmzml.model.mzml.SourceFile;
import uk.ac.ebi.pride.utilities.data.Unmarshallers.pepXML.model.pepxml.SourceFile;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * List and descriptions of the source files this mzML document was generated or derived from
 * 
 * <p>Java class for SourceFileListType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SourceFileListType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sourceFile" type="{http://psi.hupo.org/ms/mzml}SourceFileType" maxOccurs="unbounded"/>
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
@XmlType(name = "SourceFileListTypes", propOrder = {
    "sourceFile"
})
public class SourceFileList
    extends pepXMLObject
    implements Serializable
{

    private final static long serialVersionUID = 100L;
    @XmlElement(required = true)
    protected List<uk.ac.ebi.pride.utilities.data.Unmarshallers.pepXML.model.pepxml.SourceFile> sourceFile;
    @XmlAttribute(required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected Integer count;

    /**
     * Gets the value of the sourceFile property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sourceFile property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSourceFile().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link uk.ac.ebi.jmzml.model.mzml.SourceFile }
     *
     *
     */
    public List<uk.ac.ebi.pride.utilities.data.Unmarshallers.pepXML.model.pepxml.SourceFile> getSourceFile() {
        if (sourceFile == null) {
            sourceFile = new ArrayList<SourceFile>();
        }
        return this.sourceFile;
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
