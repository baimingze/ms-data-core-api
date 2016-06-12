
package uk.ac.ebi.pride.utilities.data.Unmarshallers.pepXML.model.pepxml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for massType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="massType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="monoisotopic"/>
 *     &lt;enumeration value="average"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "massType")
@XmlEnum
public enum MassType {

    @XmlEnumValue("monoisotopic")
    MONOISOTOPIC("monoisotopic"),
    @XmlEnumValue("average")
    AVERAGE("average");
    private final String value;

    MassType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static MassType fromValue(String v) {
        for (MassType c: MassType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
