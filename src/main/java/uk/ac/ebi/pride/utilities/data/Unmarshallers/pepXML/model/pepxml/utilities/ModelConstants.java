package uk.ac.ebi.pride.utilities.data.Unmarshallers.pepXML.model.pepxml.utilities;

/**
 * Author: Zhe Sang, Yang Luo, Miao Hao
 */

import uk.ac.ebi.pride.utilities.data.Unmarshallers.pepXML.pepXMLElement;
import uk.ac.ebi.pride.utilities.data.Unmarshallers.pepXML.model.pepxml.MsmsPipelineAnalysis;
import javax.xml.namespace.QName;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class ModelConstants {

    public static final String PACKAGE = MsmsPipelineAnalysis.class.getPackage().getName();
    public static final String pepXML_NS = "http://regis-web.systemsbiology.net/pepXML";

    private static Map<Class, QName> modelQNames = new HashMap<Class, QName>();

    static {
       for (pepXMLElement element : pepXMLElement.values()) {
            if (element.getTagName() != null) {
                modelQNames.put(element.getClazz(), new QName(pepXML_NS, element.getTagName()));
            }
        }

        //now make set unmodifiable
        modelQNames = Collections.unmodifiableMap(modelQNames);

    }


    public static boolean isRegisteredClass(Class cls) {
        return modelQNames.containsKey(cls);
    }

    public static QName getQNameForClass(Class cls) {
        if (isRegisteredClass(cls)) {
            return modelQNames.get(cls);
        } else {
            throw new IllegalStateException("No QName registered for class: " + cls);
        }
    }

    public static String getElementNameForClass(Class cls) {
        if (isRegisteredClass(cls)) {
            return modelQNames.get(cls).getLocalPart();
        } else {
            throw new IllegalStateException("No QName registered for class: " + cls);
        }
    }

    public static Class getClassForElementName(String name) {
        for (Map.Entry<Class, QName> entry : modelQNames.entrySet()) {
            if (entry.getValue().getLocalPart().equals(name)) {
                return entry.getKey();
            }
        }
        return null;
    }

}
