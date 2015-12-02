package uk.ac.ebi.pride.utilities.data.Unmarshallers.pepXML.model.pepxml.utilities;

import uk.ac.ebi.jmzml.model.mzml.utilities.MzMLElementConfig;

import java.util.List;

/**
 * @author Florian Reisinger
 *         Date: 19/12/11
 * @since $version
 */
public class pepXMLElementProperties {
    private List<MzMLElementConfig> configurations;


    public List<MzMLElementConfig> getConfigurations() {
        return configurations;
    }

    public void setConfigurations(List<MzMLElementConfig> configurations) {
        this.configurations = configurations;
    }

}
