package uk.ac.ebi.pride.utilities.data.Unmarshallers.pepXML.model.pepxml.utilities;

import uk.ac.ebi.jmzml.model.mzml.utilities.MzMLElementConfig;

import java.util.List;

/**
 * @author Florian Reisinger
 *         Date: 19/12/11
 * @since $version
 */
public class pepXMLElementProperties {
    private List<pepXMLElementConfig> configurations;


    public List<pepXMLElementConfig> getConfigurations() {
        return configurations;
    }

    public void setConfigurations(List<pepXMLElementConfig> configurations) {
        this.configurations = configurations;
    }

}
