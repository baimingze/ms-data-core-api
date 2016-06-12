package uk.ac.ebi.pride.utilities.data.Unmarshallers.pepXML.xml.io;

/**
 * Author: Zhe Sang, Luo Yang, Miao Hao
 */

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * InstantMarshaller class extends pepXMLMarshaller (so it exists in its original
 * form) and adds methods for creating pepXML start and end tags so that
 * pepXML files can be written piecemeal instead of all at once, which can cause
 * problems with large pepXML objects.
 */
public class pepXMLInstantMarshaller extends pepXMLMarshaller {
    /**
     * The pepXML namespace, used in the pepXML header.
     */
    private static final String pepXML_NAMESPACE = "http://regis-web.systemsbiology.net/jpepxml";

    /**
     * The default pepXML version, used if one is not passed in.
     */
    private static final String DEFAULT_VERSION = "1.1.0";

    /**
     * Creates an instance of pepXMLInstantMarshaller.
     */
    public pepXMLInstantMarshaller() {
        super();
    }
    
    /**
     * Creates the XML header and returns it.
     * @return XML header
     */
    public final String createXmlHeader() {
        return "<?xml version=\"1.0\" encoding=\"" + "UTF-8" + "\"?>";
    }
    
    /**
     * Creates the msms_pipeline_analysis start tag and returns it.
     * @param fileName pepXML file name
     * @return msms_pipeline_analysis start tag.
     */
    public final String createpepXMLStartTag(final String fileName) {
        return createpepXMLStartTag(fileName, DEFAULT_VERSION);
    }
    
    /**
     * Creates the msms_pipeline_analysis start tag and returns it.
     * @param fileName pepXML file name
     * @param version pepXML version number
     * @return msms_pipeline_analysis start tag
     */
    public final String createpepXMLStartTag(final String fileName, final String version) {
        return "<msms_pipeline_analysis xmlns=\""
                + pepXML_NAMESPACE
                + "\" id=\""
                + fileName
                + "\" version=\""
                + version
                + "\">";
    }
    
    /**
     * Creates the msms_pipeline_analysis close tag and returns it.
     * @return msms_pipeline_analysis close tag
     */
    public final String createpepXMLCloseTag() {
        return "</msms_pipeline_analysis>";
    }
    
    /**
     * Creates the AnalysisSummary start tag with attributes and returns it.
     * @param attributes AnalysisSummary attributes
     * @return Run start tag
     */
    public final String createAnaylysisSummaryStartTag(final Map<String, String> attributes) {
        return "<analysis_summary " + getAttributesString(attributes) + ">";
    }
    
    /**
     * Creates the AnalysisSummary close tag and returns it.
     * @return AnalysisSummary close tag
     */
    public final String createAnaylysisSummaryCloseTag() {
        return "</analysis_summary>";
    }
    
    /**
     * Creates the DatasetDerivation start tag with attributes and returns it.
     * @param attributes DatasetDerivation attributes
     * @return DatasetDerivation start tag
     */
    public final String createDatasetDerivationStartTag(final Map<String, String> attributes) {
        return "<dataset_derivation " + getAttributesString(attributes) + ">";
    }
    
    /**
     * Creates the DatasetDerivation close tag and returns it.
     * @return DatasetDerivation close tag.
     */
    public final String createDatasetDerivationCloseTag() {
        return "</dataset_derivation>";
    }

    /**
     * Creates the MsmsRunSummary start tag with attributes and returns it.
     * @param attributes MsmsRunSummary attributes
     * @return MsmsRunSummary start tag
     */
    public final String createMsmsRunSummaryStartTag(final Map<String, String> attributes) {
        return "<msms_run_summary " + getAttributesString(attributes) + ">";
    }

    /**
     * Creates the MsmsRunSummary close tag and returns it.
     * @return MsmsRunSummary close tag.
     */
    public final String createMsmsRunSummaryCloseTag() {
        return "</msms_run_summary>";
    }
    
    /**
     * Gets attribute pairs formatted as a string for insertion into an XML tag.
     * @param attributes XML attributes
     * @return Attributes string
     */
    private String getAttributesString(final Map<String, String> attributes) {
        StringBuilder buffer = new StringBuilder();
        Set<Entry<String, String>> entries = attributes.entrySet();
        for (Entry<String, String> entry : entries) {
            buffer.append(entry.getKey());
            buffer.append("=\"");
            buffer.append(entry.getValue());
            buffer.append("\" ");
        }
        
        return buffer.toString().trim();
    }    
}
