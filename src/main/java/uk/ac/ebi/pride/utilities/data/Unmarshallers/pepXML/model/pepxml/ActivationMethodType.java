
package uk.ac.ebi.pride.utilities.data.Unmarshallers.pepXML.model.pepxml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for activationMethodType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="activationMethodType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ETD"/>
 *     &lt;enumeration value="ECD"/>
 *     &lt;enumeration value="CID"/>
 *     &lt;enumeration value="ETD/CID"/>
 *     &lt;enumeration value="HCD"/>
 *     &lt;enumeration value="PQD"/>
 *     &lt;enumeration value="IRMPD"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "activationMethodType")
@XmlEnum
public enum ActivationMethodType {

    ETD("ETD"),
    ECD("ECD"),
    CID("CID"),
    @XmlEnumValue("ETD/CID")
    ETD_CID("ETD/CID"),
    HCD("HCD"),
    PQD("PQD"),
    IRMPD("IRMPD");
    private final String value;

    ActivationMethodType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ActivationMethodType fromValue(String v) {
        for (ActivationMethodType c: ActivationMethodType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
