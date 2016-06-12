
package uk.ac.ebi.pride.utilities.data.Unmarshallers.pepXML.model.pepxml;

import java.io.Serializable;
import javax.xml.bind.annotation.*;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="probability" use="required" type="{http://www.w3.org/2001/XMLSchema}float" />
 *       &lt;attribute name="all_ntt_prob" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "interprophet_result")
public class InterprophetResult
    extends pepXMLObject
    implements Serializable
{

    private final static long serialVersionUID = 100L;
    @XmlElement(name = "search_score_summary")
    protected SearchScoreSummary searchScoreSummary;
    @XmlAttribute(required = true)
    protected float probability;
    @XmlAttribute(name = "all_ntt_prob")
    protected String allNttProb;

    /**
     * Gets the value of the searchScoreSummary property.
     *
     * @return
     *     possible object is
     *     {@link SearchScoreSummary }
     *
     */
    public SearchScoreSummary getSearchScoreSummary() {
        return searchScoreSummary;
    }

    /**
     * Sets the value of the searchScoreSummary property.
     *
     * @param value
     *     allowed object is
     *     {@link SearchScoreSummary }
     *
     */
    public void setSearchScoreSummary(SearchScoreSummary value) {
        this.searchScoreSummary = value;
    }

    /**
     * Gets the value of the probability property.
     * 
     */
    public float getProbability() {
        return probability;
    }

    /**
     * Sets the value of the probability property.
     * 
     */
    public void setProbability(float value) {
        this.probability = value;
    }

    /**
     * Gets the value of the allNttProb property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAllNttProb() {
        return allNttProb;
    }

    /**
     * Sets the value of the allNttProb property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAllNttProb(String value) {
        this.allNttProb = value;
    }

}
