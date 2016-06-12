package uk.ac.ebi.pride.utilities.data.Unmarshallers.pepXML;

/**
 * Author: Zhe Sang
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.ac.ebi.pride.utilities.data.Unmarshallers.pepXML.model.pepxml.*;
import uk.ac.ebi.pride.utilities.data.Unmarshallers.pepXML.model.pepxml.utilities.pepXMLElementConfig;
import uk.ac.ebi.pride.utilities.data.Unmarshallers.pepXML.model.pepxml.utilities.pepXMLElementProperties;

import javax.xml.bind.JAXB;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;


@SuppressWarnings("unused")
public enum pepXMLElement {
// ToDo: define and document dependencies between flags/attributes
    // ToDo (for example: a element can not be ID mapped if it is not indexed,
    // ToDo: or an element can not be cached if it is not ID mapped)?
    // ToDo: !! idMapped can only be set to true if the element has an id
    // ToDo: implement according consistency checks

    // ToDo: complete xpath for all elements
    // ToDo: update indexed flag for elements that should be indexed
    // ToDo: check for which elements an id map should be generated

    SetuppepXMLElement(), // call the default constructor that will load that data from the configuration file
                        // BEFORE the following enum values are defined!

    //                          tag name                        indexed     xpath
    //*****************************************************************************************************************************************************************
//    AdditionalSearchParams   // no real model class
//    MsmsPipelineAnalysis(          "msms_pipeline_analysis",                     true,       "/msms_pipeline_analysis",
    MsmsPipeLineAnalysis(getCfg().get(MsmsPipelineAnalysis.class.getName()).getTagName(),
                      getCfg().get(MsmsPipelineAnalysis.class.getName()).isIndexed(),
                      getCfg().get(MsmsPipelineAnalysis.class.getName()).getXpath(),
                      getCfg().get(MsmsPipelineAnalysis.class.getName()).isIdMapped(),
                      getCfg().get(MsmsPipelineAnalysis.class.getName()).getClazz()),

//    AnalysisSummary(            "analysis_summary",              false,      "/msms_pipeline_analysis/analysis_summary",
    AnalysisSummary(getCfg().get(AnalysisSummary.class.getName()).getTagName(),
                    getCfg().get(AnalysisSummary.class.getName()).isIndexed(),
                    getCfg().get(AnalysisSummary.class.getName()).getXpath(),
                    getCfg().get(AnalysisSummary.class.getName()).isIdMapped(),
                    getCfg().get(AnalysisSummary.class.getName()).getClazz()),

//    DatasetDerivation(        "dataset_derivation",          false,      "/msms_pipeline_analysis/dataset_derivation",
    DatasetDerivation(getCfg().get(DatasetDerivation.class.getName()).getTagName(),
                        getCfg().get(DatasetDerivation.class.getName()).isIndexed(),
                        getCfg().get(DatasetDerivation.class.getName()).getXpath(),
                        getCfg().get(DatasetDerivation.class.getName()).isIdMapped(),
                        getCfg().get(DatasetDerivation.class.getName()).getClazz()),

//    MsmsRunSummary(               "msms_run_summary",                 true,       "/msms_pipeline_analysis/msms_run_summary",
    MsmsRunSummary(getCfg().get(MsmsRunSummary.class.getName()).getTagName(),
                 getCfg().get(MsmsRunSummary.class.getName()).isIndexed(),
                 getCfg().get(MsmsRunSummary.class.getName()).getXpath(),
                 getCfg().get(MsmsRunSummary.class.getName()).isIdMapped(),
                 getCfg().get(MsmsRunSummary.class.getName()).getClazz()),

//    SampleEnzyme(           "sample_enzyme",             true,       "msms_pipeline_analysis/msms_run_summary/sample_enzyme",
    SampleEnzyme(getCfg().get(SampleEnzyme.class.getName()).getTagName(),
                     getCfg().get(SampleEnzyme.class.getName()).isIndexed(),
                     getCfg().get(SampleEnzyme.class.getName()).getXpath(),
                     getCfg().get(SampleEnzyme.class.getName()).isIdMapped(),
                     getCfg().get(SampleEnzyme.class.getName()).getClazz()),
    //    Specificity(           "specificity",             true,       "/msms_pipeline_analysis/msms_run_summary/sample_enzyme/specificity",
    Specificity(getCfg().get(Specificity.class.getName()).getTagName(),
            getCfg().get(Specificity.class.getName()).isIndexed(),
            getCfg().get(Specificity.class.getName()).getXpath(),
            getCfg().get(Specificity.class.getName()).isIdMapped(),
            getCfg().get(Specificity.class.getName()).getClazz()),

//    SearchSummary(                  "search_summary",                    false,      "/msms_pipeline_analysis/msms_run_summary/search_summary",
    SearchSummary(getCfg().get(SearchSummary.class.getName()).getTagName(),
              getCfg().get(SearchSummary.class.getName()).isIndexed(),
              getCfg().get(SearchSummary.class.getName()).getXpath(),
              getCfg().get(SearchSummary.class.getName()).isIdMapped(),
              getCfg().get(SearchSummary.class.getName()).getClazz()),

//    SpectrumQuery(              "spectrum_query",                true,       "/msms_pipeline_analysis/msms_run_summary/spectrum_query",
    SpectrumQuery(getCfg().get(SpectrumQuery.class.getName()).getTagName(),
                  getCfg().get(SpectrumQuery.class.getName()).isIndexed(),
                  getCfg().get(SpectrumQuery.class.getName()).getXpath(),
                  getCfg().get(SpectrumQuery.class.getName()).isIdMapped(),
                  getCfg().get(SpectrumQuery.class.getName()).getClazz()),

//    AnalysisTimestamp(                         "analysis_timestamp",                           true,       "/msms_pipeline_analysis/msms_run_summary/analysis_timestamp",
    AnalysisTimestamp(getCfg().get(AnalysisTimestamp.class.getName()).getTagName(),
       getCfg().get(AnalysisTimestamp.class.getName()).isIndexed(),
       getCfg().get(AnalysisTimestamp.class.getName()).getXpath(),
       getCfg().get(AnalysisTimestamp.class.getName()).isIdMapped(),
       getCfg().get(AnalysisTimestamp.class.getName()).getClazz()),

    //    InteractSummary(                     "interact_summary",                       true,       "/msms_pipeline_analysis/analysis_summary/interact_summary",
    InteractSummary(getCfg().get(InteractSummary.class.getName()).getTagName(),
            getCfg().get(InteractSummary.class.getName()).isIndexed(),
            getCfg().get(InteractSummary.class.getName()).getXpath(),
            getCfg().get(InteractSummary.class.getName()).isIdMapped(),
            getCfg().get(InteractSummary.class.getName()).getClazz()),

//    PeptideprophetSummary(                     "peptideprophet_summary",                       true,       "/msms_pipeline_analysis/analysis_summary/peptideprophet_summary",
    PeptideprophetSummary(getCfg().get(PeptideprophetSummary.class.getName()).getTagName(),
           getCfg().get(PeptideprophetSummary.class.getName()).isIndexed(),
           getCfg().get(PeptideprophetSummary.class.getName()).getXpath(),
           getCfg().get(PeptideprophetSummary.class.getName()).isIdMapped(),
           getCfg().get(PeptideprophetSummary.class.getName()).getClazz()),

    //    MixtureModel(                       "mixture_model",                         true,       "/msms_pipeline_analysis/analysis_summary/peptideprophet_summary/mixture_model",
    MixtureModel(getCfg().get(MixtureModel.class.getName()).getTagName(),
            getCfg().get(MixtureModel.class.getName()).isIndexed(),
            getCfg().get(MixtureModel.class.getName()).getXpath(),
            getCfg().get(MixtureModel.class.getName()).isIdMapped(),
            getCfg().get(MixtureModel.class.getName()).getClazz()),

    //    MixturemodelDistribution(                 "mixturemodel_distribution",                   false,      "/msms_pipeline_analysis/analysis_summary/peptideprophet_summary/mixture_model/mixturemodel_distribution",
    MixturemodelDistribution(getCfg().get(MixturemodelDistribution.class.getName()).getTagName(),
            getCfg().get(MixturemodelDistribution.class.getName()).isIndexed(),
            getCfg().get(MixturemodelDistribution.class.getName()).getXpath(),
            getCfg().get(MixturemodelDistribution.class.getName()).isIdMapped(),
            getCfg().get(MixturemodelDistribution.class.getName()).getClazz()),

    //    Mixturemodel(                  "mixturemodel",                    true,       "/msms_pipeline_analysis/analysis_summary/peptideprophet_summary/mixture_model/mixturemodel",
    Mixturemodel(getCfg().get(Mixturemodelbase.class.getName()).getTagName(),
            getCfg().get(Mixturemodelbase.class.getName()).isIndexed(),
            getCfg().get(Mixturemodelbase.class.getName()).getXpath(),
            getCfg().get(Mixturemodelbase.class.getName()).isIdMapped(),
            getCfg().get(Mixturemodelbase.class.getName()).getClazz()),

    //    NegmodelDistribution(              "negmodel_distribution",                true,       "/msms_pipeline_analysis/analysis_summary/peptideprophet_summary/mixture_model/mixturemodel_distribution/negmodel_distribution",
    NegmodelDistribution(getCfg().get(NegmodelDistribution.class.getName()).getTagName(),
            getCfg().get(NegmodelDistribution.class.getName()).isIndexed(),
            getCfg().get(NegmodelDistribution.class.getName()).getXpath(),
            getCfg().get(NegmodelDistribution.class.getName()).isIdMapped(),
            getCfg().get(NegmodelDistribution.class.getName()).getClazz()),

    //    Point(           "point",             true,       "/msms_pipeline_analysis/analysis_summary/peptideprophet_summary/mixture_model/mixturemodel/point",
    Point(getCfg().get(MixturemodelPoint.class.getName()).getTagName(),
            getCfg().get(MixturemodelPoint.class.getName()).isIndexed(),
            getCfg().get(MixturemodelPoint.class.getName()).getXpath(),
            getCfg().get(MixturemodelPoint.class.getName()).isIdMapped(),
            getCfg().get(MixturemodelPoint.class.getName()).getClazz()),

    //    Product(                    "posmodel_distribution",                      true,       "/msms_pipeline_analysis/analysis_summary/peptideprophet_summary/mixture_model/mixturemodel_distribution/posmodel_distribution",
    PosmodelDistribution(getCfg().get(PosmodelDistribution.class.getName()).getTagName(),
            getCfg().get(PosmodelDistribution.class.getName()).isIndexed(),
            getCfg().get(PosmodelDistribution.class.getName()).getXpath(),
            getCfg().get(PosmodelDistribution.class.getName()).isIdMapped(),
            getCfg().get(PosmodelDistribution.class.getName()).getClazz()),


    //    DistributionPoint(                     "distribution_point",                       true,       "/msms_pipeline_analysis/analysis_summary/peptideprophet_summary/distribution_point",
    DistributionPoint(getCfg().get(DistributionPoint.class.getName()).getTagName(),
            getCfg().get(DistributionPoint.class.getName()).isIndexed(),
            getCfg().get(DistributionPoint.class.getName()).getXpath(),
            getCfg().get(DistributionPoint.class.getName()).isIdMapped(),
            getCfg().get(DistributionPoint.class.getName()).getClazz()),

//    DataFilter(                    "datafilter",                      false,      "/msms_pipeline_analysis/dataset_derivation/datafilter",
    DataFilter(getCfg().get(DataFilter.class.getName()).getTagName(),
            getCfg().get(DataFilter.class.getName()).isIndexed(),
            getCfg().get(DataFilter.class.getName()).getXpath(),
            getCfg().get(DataFilter.class.getName()).isIdMapped(),
            getCfg().get(DataFilter.class.getName()).getClazz()),

//    SearchHit(             "search_hit",               true,       "/msms_pipeline_analysis/msms_run_summary/spectrum_query/search_result/search_hit",
    SearchHit(getCfg().get(SearchHit.class.getName()).getTagName(),
                   getCfg().get(SearchHit.class.getName()).isIndexed(),
                   getCfg().get(SearchHit.class.getName()).getXpath(),
                   getCfg().get(SearchHit.class.getName()).isIdMapped(),
                   getCfg().get(SearchHit.class.getName()).getClazz()),

//    SearchDatabase(         "search_database",           true,       "/msms_pipeline_analysis/msms_run_summary/search_summary/search_database",
    SearchDatabase(getCfg().get(SearchDatabase.class.getName()).getTagName(),
                       getCfg().get(SearchDatabase.class.getName()).isIndexed(),
                       getCfg().get(SearchDatabase.class.getName()).getXpath(),
                       getCfg().get(SearchDatabase.class.getName()).isIdMapped(),
                       getCfg().get(SearchDatabase.class.getName()).getClazz()),

//    AminoacidModification(          "aminoacid_modification",            true,       "/msms_pipeline_analysis/msms_run_summary/search_summary/aminoacid_modification",
    AminoacidModification(getCfg().get(AminoacidModification.class.getName()).getTagName(),
                      getCfg().get(AminoacidModification.class.getName()).isIndexed(),
                      getCfg().get(AminoacidModification.class.getName()).getXpath(),
                      getCfg().get(AminoacidModification.class.getName()).isIdMapped(),
                      getCfg().get(AminoacidModification.class.getName()).getClazz()),

//    EnzymaticSearchConstraint(            "enzymatic_search_constraint",              true,       "/msms_pipeline_analysis/msms_run_summary/search_summary/enzymatic_search_constraint",
    EnzymaticSearchConstraint(getCfg().get(EnzymaticSearchConstraint.class.getName()).getTagName(),
                    getCfg().get(EnzymaticSearchConstraint.class.getName()).isIndexed(),
                    getCfg().get(EnzymaticSearchConstraint.class.getName()).getXpath(),
                    getCfg().get(EnzymaticSearchConstraint.class.getName()).isIdMapped(),
                    getCfg().get(EnzymaticSearchConstraint.class.getName()).getClazz()),

//    SequenceSearchConstraint(                      "sequence_search_constraint",                        true,       "/msms_pipeline_analysis/msms_run_summary/search_summary/sequence_search_constraint",
    SequenceSearchConstraint(getCfg().get(SequenceSearchConstraint.class.getName()).getTagName(),
          getCfg().get(SequenceSearchConstraint.class.getName()).isIndexed(),
          getCfg().get(SequenceSearchConstraint.class.getName()).getXpath(),
          getCfg().get(SequenceSearchConstraint.class.getName()).isIdMapped(),
          getCfg().get(SequenceSearchConstraint.class.getName()).getClazz()),

//    ModificationInfo(                "modification_info",                  true,       "/msms_pipeline_analysis/msms_run_summary/spectrum_query/search_result/search_hit/modification_info",
    ModificationInfo(getCfg().get(ModificationInfo.class.getName()).getTagName(),
                getCfg().get(ModificationInfo.class.getName()).isIndexed(),
                getCfg().get(ModificationInfo.class.getName()).getXpath(),
                getCfg().get(ModificationInfo.class.getName()).isIdMapped(),
                getCfg().get(ModificationInfo.class.getName()).getClazz()),

//    AlternativeProtein(                  "alternative_protein",                    true,       "/msms_pipeline_analysis/msms_run_summary/spectrum_query/search_result/search_hit/alternative_protein",
    AlternativeProtein(getCfg().get(AlternativeProtein.class.getName()).getTagName(),
              getCfg().get(AlternativeProtein.class.getName()).isIndexed(),
              getCfg().get(AlternativeProtein.class.getName()).getXpath(),
              getCfg().get(AlternativeProtein.class.getName()).isIdMapped(),
              getCfg().get(AlternativeProtein.class.getName()).getClazz()),

//    AnalysisResult(    "analysis_result",      true,       "/msms_pipeline_analysis/msms_run_summary/spectrum_query/search_result/search_hit/analysis_result",
    AnalysisResult(getCfg().get(AnalysisResult.class.getName()).getTagName(),
                            getCfg().get(AnalysisResult.class.getName()).isIndexed(),
                            getCfg().get(AnalysisResult.class.getName()).getXpath(),
                            getCfg().get(AnalysisResult.class.getName()).isIdMapped(),
                            getCfg().get(AnalysisResult.class.getName()).getClazz()),

//    ModAminoacidMass( "mod_aminoacid_mass",  true,       "/msms_pipeline_analysis/msms_run_summary/spectrum_query/search_result/search_hit/modification_info/mod_aminoacid_mass",
    ModAminoacidMass(getCfg().get(ModAminoacidMass.class.getName()).getTagName(),
                                getCfg().get(ModAminoacidMass.class.getName()).isIndexed(),
                                getCfg().get(ModAminoacidMass.class.getName()).getXpath(),
                                getCfg().get(ModAminoacidMass.class.getName()).isIdMapped(),
                                getCfg().get(ModAminoacidMass.class.getName()).getClazz()),






//    LibraSummary(                "libra_summary",                  true,       "/msms_pipeline_analysis/analysis_summary/libra_summary",
    LibraSummary(getCfg().get(LibraSummary.class.getName()).getTagName(),
                getCfg().get(LibraSummary.class.getName()).isIndexed(),
                getCfg().get(LibraSummary.class.getName()).getXpath(),
                getCfg().get(LibraSummary.class.getName()).isIdMapped(),
                getCfg().get(LibraSummary.class.getName()).getClazz()),

//    FragmentMasses(    "fragment_masses",      true,       "/msms_pipeline_analysis/analysis_summary/libra_summary/fragment_masses",
    FragmentMasses(getCfg().get(FragmentMasses.class.getName()).getTagName(),
                            getCfg().get(FragmentMasses.class.getName()).isIndexed(),
                            getCfg().get(FragmentMasses.class.getName()).getXpath(),
                            getCfg().get(FragmentMasses.class.getName()).isIdMapped(),
                            getCfg().get(FragmentMasses.class.getName()).getClazz()),

//    IsotopicContributions("isotopicContributions",  true,       "/msms_pipeline_analysis/analysis_summary/libra_summary/isotopicContributions",
    IsotopicContributions(getCfg().get(IsotopicContributions.class.getName()).getTagName(),
                                getCfg().get(IsotopicContributions.class.getName()).isIndexed(),
                                getCfg().get(IsotopicContributions.class.getName()).getXpath(),
                                getCfg().get(IsotopicContributions.class.getName()).isIdMapped(),
                                getCfg().get(IsotopicContributions.class.getName()).getClazz()),

//    ContributingChannel( "contributing_channel",   false,      "/msms_pipeline_analysis/analysis_summary/libra_summary/isotopicContributions/contributing_channel",
    ContributingChannel(getCfg().get(ContributingChannel.class.getName()).getTagName(),
                               getCfg().get(ContributingChannel.class.getName()).isIndexed(),
                               getCfg().get(ContributingChannel.class.getName()).getXpath(),
                               getCfg().get(ContributingChannel.class.getName()).isIdMapped(),
                               getCfg().get(ContributingChannel.class.getName()).getClazz()),

//    AffectedChannel(                        "affected_channel",                          true,       "/msms_pipeline_analysis/analysis_summary/libra_summary/isotopicContributions/contributing_channel/affected_channel",
    AffectedChannel(getCfg().get(AffectedChannel.class.getName()).getTagName(),
        getCfg().get(AffectedChannel.class.getName()).isIndexed(),
        getCfg().get(AffectedChannel.class.getName()).getXpath(),
        getCfg().get(AffectedChannel.class.getName()).isIdMapped(),
        getCfg().get(AffectedChannel.class.getName()).getClazz());



    private String tagName;
    private boolean indexed;
    private String xpath;
    private boolean idMapped;
    private Class clazz;




    /**
     * This should be called first in order to retrieve configuration from a file and populate cfgMap.
     */
    private <T extends pepXMLObject> pepXMLElement() {
        loadProperties();
    }

    private <T extends pepXMLObject> pepXMLElement(String tagName,
                                                   boolean indexed,
                                                   String xpath,
                                                   boolean idMapped,
                                                   Class<T> clazz) {
        this.tagName = tagName;
        this.indexed = indexed;
        this.xpath = xpath;
        this.idMapped = idMapped;
        this.clazz = clazz;
    }


    private static Map<String, pepXMLElementConfig> cfgMap;

    private static Map<String, pepXMLElementConfig> getCfg() {
        if (cfgMap == null) {
            cfgMap = new HashMap<String, pepXMLElementConfig>();
        }
        return cfgMap;
    }

    /**
     * Read the configuration info from the properties file. Note: this simply loads the information into a hashmap.
     * Actual setting of values is done through the constructors.
     */
    public static void loadProperties() {

        Logger logger = LoggerFactory.getLogger(pepXMLElement.class);

        //check to see if we have a project-specific configuration file
        URL xmlFileURL = pepXMLElement.class.getClassLoader().getResource("defaultpepXMLElement.cfg.xml");
        //ToDo
        // if not, use default config
        //if (xmlFileURL == null) {
        //    xmlFileURL = pepXMLElement.class.getClassLoader().getResource("defaultMzMLElement.cfg.xml");
        //}
        logger.warn("jpepxml Configuration file: " + xmlFileURL.toString());

        pepXMLElementProperties props = JAXB.unmarshal(xmlFileURL, pepXMLElementProperties.class);
        Map<String, pepXMLElementConfig> localCfg = getCfg();
        for (pepXMLElementConfig cfg : props.getConfigurations()) {
            Class clazz = cfg.getClazz();
            if (clazz != null) {
                localCfg.put(clazz.getName(), cfg);
            }
        }
    }


    public String getTagName() {
        return tagName;
    }

    public boolean isIndexed() {
        return indexed;
    }

    public String getXpath() {
        return xpath;
    }

    public boolean isIdMapped() {
        return idMapped;
    }

    @SuppressWarnings("unchecked")
    public <T extends pepXMLObject> Class<T> getClazz() {
        return clazz;
    }

    public static pepXMLElement getType(Class clazz) {
        for (pepXMLElement type : pepXMLElement.values()) {
            if (type.getClazz() == clazz) {
                return type;
            }
        }
        return null;
    }

    public static pepXMLElement getType(String xpath) {
        for (pepXMLElement type : pepXMLElement.values()) {
            if (type.getXpath() != null && type.getXpath().equals(xpath)) {
                return type;
            }
        }
        return null;
    }

    @SuppressWarnings("unchecked")

    @Override
    public String toString() {
        return "pepXMLElement{" +
                ", xpath='" + xpath + '\'' +
                ", clazz=" + clazz +
                '}';
    }
}
