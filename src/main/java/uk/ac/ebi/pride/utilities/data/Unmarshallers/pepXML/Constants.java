package uk.ac.ebi.pride.utilities.data.Unmarshallers.pepXML;

/**
 * Author: Zhe Sang, Yang Luo, Miao Hao
 */

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Constants {

    // ToDo: ? move to ModelConstants ?

    public static final String JAXB_ENCODING_PROPERTY = "jaxb.encoding";
    public static final String JAXB_FORMATTING_PROPERTY = "jaxb.formatted.output";
    public static final String JAXB_SCHEMALOCATION_PROPERTY = "jaxb.schemaLocation";
    public static final String JAXB_FRAGMENT_PROPERTY = "jaxb.fragment";



    private static Set<String> xpathsToIndex = new HashSet<String>();

    static {
        for (pepXMLElement element : pepXMLElement.values()) {
            if (element.isIndexed()) {
                xpathsToIndex.add(element.getXpath());

            }
        }



        // finally make the set unmodifiable
        xpathsToIndex = Collections.unmodifiableSet(xpathsToIndex);
    }


    public static final Set<String> XML_INDEXED_XPATHS = xpathsToIndex;

}

