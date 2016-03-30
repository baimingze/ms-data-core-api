package uk.ac.ebi.pride.utilities.data.io.file;

//~--- non-JDK imports --------------------------------------------------------

//import uk.ac.ebi.jmzml.model.mzml.*;
import uk.ac.ebi.pride.utilities.data.Unmarshallers.pepXML.model.pepxml.*;
import uk.ac.ebi.pride.utilities.data.Unmarshallers.pepXML.pepXMLUnmarshaller;

import java.io.File;
import java.util.*;

//~--- JDK imports ------------------------------------------------------------

/**
 * MzMLUnmarshallerHelper provides a list of convenient methods to access mzML files
 * <p/>
 * @author Rui Wang, Yasset Perez-Riverol
 * Date: 17-May-2010
 * Time: 10:37:45
 */
public class pepXMLUnmarshallerAdaptor extends pepXMLUnmarshaller {


    public pepXMLUnmarshallerAdaptor(File pepXMLFile) {
        super(pepXMLFile);

    }

    public CVList getCVList() {
        return (CVList) unmarshalFromXpath("/pepXML/cvList", CVList.class);
    }

    public FileDescription getFileDescription() {
        return (FileDescription) unmarshalFromXpath("/pepXML/fileDescription", FileDescription.class);
    }

    public ReferenceableParamGroupList getReferenceableParamGroupList() {
        return (ReferenceableParamGroupList) unmarshalFromXpath("/pepXML/referenceableParamGroupList", ReferenceableParamGroupList.class);
    }

    public SampleList getSampleList() {
        return (SampleList) unmarshalFromXpath("/pepXML/sampleList", SampleList.class);
    }

    public SoftwareList getSoftwares() {
        return (SoftwareList) unmarshalFromXpath("/pepXML/softwareList", SoftwareList.class);
    }

    public ScanSettingsList getScanSettingsList() {
        return (ScanSettingsList) unmarshalFromXpath("/pepXML/scanSettingsList", ScanSettingsList.class);
    }

    public InstrumentConfigurationList getInstrumentConfigurationList() {
        return (InstrumentConfigurationList) unmarshalFromXpath("/pepXML/instrumentConfigurationList", InstrumentConfigurationList.class);
    }

    public DataProcessingList getDataProcessingList() {
        return (DataProcessingList) unmarshalFromXpath("/pepXML/dataProcessingList", DataProcessingList.class);
    }

    public Set<String> getSpectrumIds() {
        return getSpectrumIDs();
    }

    public Set<String> getChromatogramIds() {
        return getChromatogramIDs();
    }

    public Date getCreationDate() {
        Map<String, String> runAttributes = getSingleElementAttributes("/pepXML/run");
        String startTimeStamp = runAttributes.get("startTimeStamp");
        Date dateCreation = null;

        if (startTimeStamp != null) {
            Calendar calendar = javax.xml.bind.DatatypeConverter.parseDateTime(startTimeStamp);
            dateCreation = calendar.getTime();
        }
        return dateCreation;
    }

    public List<Precursor> getPrecursors(){
        return null;
    }
}



