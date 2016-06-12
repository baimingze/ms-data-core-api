package uk.ac.ebi.pride.utilities.data.Unmarshallers.pepXML.xml.io;

/**
 * Author: Zhe Sang, Luo Yang, Miao Hao
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.InputSource;
import psidev.psi.tools.xxindex.index.IndexElement;
import uk.ac.ebi.pride.utilities.data.Unmarshallers.pepXML.model.pepxml.*;
import uk.ac.ebi.pride.utilities.data.Unmarshallers.pepXML.pepXMLElement;
import uk.ac.ebi.pride.utilities.data.Unmarshallers.pepXML.xml.jaxb.unmarshaller.UnmarshallerFactory;
import uk.ac.ebi.pride.utilities.data.Unmarshallers.pepXML.xml.jaxb.unmarshaller.filters.pepXMLNamespaceFilter;
import uk.ac.ebi.pride.utilities.data.Unmarshallers.pepXML.xml.util.EscapingXMLUtilities;
import uk.ac.ebi.pride.utilities.data.Unmarshallers.pepXML.xml.xxindex.pepXMLIndexer;
import uk.ac.ebi.pride.utilities.data.Unmarshallers.pepXML.xml.xxindex.pepXMLIndexerFactory;
import uk.ac.ebi.pride.utilities.data.Unmarshallers.pepXML.xml.xxindex.FileUtils;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.sax.SAXSource;
import java.io.*;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class pepXMLUnmarshaller {

    private static final Logger logger = LoggerFactory.getLogger(pepXMLUnmarshaller.class);

    private final File pepXMLFile;
    private final pepXMLIndexer index;
    private final boolean useSpectrumCache;
    //    private final AdapterObjectCache cache = new AdapterObjectCache();
    private final pepXMLObjectCache cache;

//    private boolean fileCorrupted = false;

    private static final Pattern XML_ATT_PATTERN = Pattern.compile("\\s+([A-Za-z:]+)\\s*=\\s*[\"']([^\"'>]+?)[\"']", Pattern.DOTALL);

    /**
     * Creates a new pepXMLUnmarshaller object from a URL
     *
     * @param pepXMLFileURL the URL to unmarshall
     */
    public pepXMLUnmarshaller(URL pepXMLFileURL) {
        this(pepXMLFileURL, true);
    }

    /**
     * Creates a new pepXMLUnmarshaller object from a file
     *
     * @param pepXMLFile the file to unmarshall
     */
    public pepXMLUnmarshaller(File pepXMLFile) {
        this(pepXMLFile, true, null);
    }

    /**
     * Creates a new pepXMLUnmarshaller object from a URL
     *
     * @param pepXMLFileURL       the URL to unmarshall
     * @param aUseSpectrumCache if true the spectra are cached
     */
    public pepXMLUnmarshaller(URL pepXMLFileURL, boolean aUseSpectrumCache) {
        this(FileUtils.getFileFromURL(pepXMLFileURL), aUseSpectrumCache, null);
    }

    /**
     * Creates a new pepXMLUnmarshaller object from a file
     *
     * @param pepXMLFile          the file to unmarshall
     * @param aUseSpectrumCache if true the spectra are cached
     */
    public pepXMLUnmarshaller(File pepXMLFile, boolean aUseSpectrumCache, pepXMLObjectCache cache) {
        this.pepXMLFile = pepXMLFile;
        index = pepXMLIndexerFactory.getInstance().buildIndex(pepXMLFile);
        useSpectrumCache = aUseSpectrumCache;
        this.cache = cache;
    }

    /**
     * USE WITH CAUTION - This will unmarshall a complete MsmsPipelineAnalysis object and
     * will likely cause an OutOfMemoryError for very large files.
     *
     * @return an MsmsPipelineAnalysis object
     */
    public MsmsPipelineAnalysis unmarshall() {
        return unmarshalFromXpath("", MsmsPipelineAnalysis.class);
    }



    public Map<String, String> getSingleElementAttributes(String xpath) {
        Map<String, String> attributes = new HashMap<String, String>();
        // retrieve the start tag of the corresponding XML element
        //single Element should appear once in the file
        String tag = index.getStartTag(xpath);
        if (tag == null) {
            return null;
        }

        // parse the tag for attributes
        Matcher match = XML_ATT_PATTERN.matcher(tag);
        while (match.find()) {
            if (match.groupCount() == 2) {
                // found name - value pair
                String name = match.group(1);
                String value = match.group(2);
                // stick the found attributes in the map
                attributes.put(name, value);
            } else {
                // not a name - value pair, something is wrong!
                System.out.println("Unexpected number of groups for XML attribute: " + match.groupCount() + " in tag: " + tag);
            }

        }
        return attributes;
    }

    /**
     * Method to retrieve attribute name-value pairs for a XML element
     * defined by it's id and Class.
     *
     * @param id    the value of the 'id' attribute of the XML element.
     * @param clazz the Class representing the XML element.
     * @return A map of all the found name-value attribute pairs or
     *         null if no element with the specified id was found.
     */
    public Map<String, String> getElementAttributes(String id, Class clazz) {
        Map<String, String> attributes = new HashMap<String, String>();
        // retrieve the start tag of the corresponding XML element
        String tag = index.getStartTag(id, clazz);
        if (tag == null) {
            return null;
        }

        // parse the tag for attributes
        Matcher match = XML_ATT_PATTERN.matcher(tag);
        while (match.find()) {
            if (match.groupCount() == 2) {
                // found name - value pair
                String name = match.group(1);
                String value = match.group(2);
                // stick the found attributes in the map
                attributes.put(name, value);
            } else {
                // not a name - value pair, something is wrong!
                // ToDo: proper handling! exception
                System.out.println("Unexpected number of groups for XML attribute: " + match.groupCount() + " in tag: " + tag);
            }

        }
        return attributes;
    }


    /**
     * Returns the number of elements for a given path.
     *
     * @param xpath the path to look up
     * @return the number of elements for a given path
     */
    public int getObjectCountForXpath(String xpath) {
        return index.getCount(xpath);
    }

    /**
     * Retrieves the list of elements of the given class at the selected path.
     * <p/>
     * Exp.: MsmsPipelineAnalysis pipelineAnylysis = unmarshaller.unmarshallFromXPath("/msms_pipeline_analysis", MsmsPipelineAnalysis.class);
     * Retrieves the MsmsPipelineAnalysis from element of the jpepxml file, given it's XPath
     *
     * @param <T>
     * @param xpath the path to search
     * @param cls   the class type to retrieve
     * @return the list of elements of the given class at the selected path
     */
    public <T extends pepXMLObject> T unmarshalFromXpath(String xpath, Class cls) {
        // ToDo: only unmarshalls first element in xxindex!! Document this!
        T retval = null;
        try {
            //we want to unmarshal the whole file
            if (xpath.equals("")) {
                xpath = pepXMLElement.MsmsPipeLineAnalysis.getXpath();
            //    if (isIndexedpepXML()) {
              //      xpath = pepXMLElement.IndexedpepXML.getXpath().concat(xpath);
               // }

            }
            Iterator<String> xpathIter = index.getXmlStringIterator(xpath);

            if (xpathIter.hasNext()) {

                String xmlSt = xpathIter.next();

                //need to clean up XML to ensure that there are no weird control characters
                String cleanXML = EscapingXMLUtilities.escapeCharacters(xmlSt);

                if (logger.isDebugEnabled()) {
                    logger.trace("XML to unmarshal: " + cleanXML);
                }

                //required for the addition of namespaces to top-level objects
                pepXMLNamespaceFilter xmlFilter = new pepXMLNamespaceFilter();
                //initializeUnmarshaller will assign the proper reader to the xmlFilter
                Unmarshaller unmarshaller = UnmarshallerFactory.getInstance().initializeUnmarshaller(index, xmlFilter, cache, useSpectrumCache);
                //unmarshall the desired object
                JAXBElement<T> holder = unmarshaller.unmarshal(new SAXSource(xmlFilter, new InputSource(new StringReader(cleanXML))), cls);
                retval = holder.getValue();

                if (logger.isDebugEnabled()) {
                    logger.debug("unmarshalled object = " + retval);
                }
            }

        } catch (JAXBException e) {
            logger.error("pepXMLUnmarshaller.unmarshalFromXpath", e);
            throw new IllegalStateException("Could not unmarshal object at xpath:" + xpath);
        }

        return retval;
    }

    /**
     * Retrieves a collection of elements of the given class at the selected path
     *
     * @param <T>
     * @param xpath the path to search
     * @param cls   the class type to retrieve
     * @return the collection of elements of the given class at the selected path
     */
    public <T extends pepXMLObject> pepXMLObjectIterator<T> unmarshalCollectionFromXpath(String xpath, Class cls) {
        return new pepXMLObjectIterator<T>(xpath, cls, index, cache, useSpectrumCache);
    }

    public Iterator<SampleEnzyme> getSampleEnzymes(){
        String xpath = pepXMLElement.SampleEnzyme.getXpath();
        Iterator<SampleEnzyme> enzymes = unmarshalCollectionFromXpath(xpath,SampleEnzyme.class);
        return enzymes;
    }

    public PeptideprophetSummary getPeptideprophetSummary(){
        String xpath = pepXMLElement.PeptideprophetSummary.getXpath();
        PeptideprophetSummary result = unmarshalFromXpath(xpath,PeptideprophetSummary.class);
        return result;
    }

    public InteractSummary getInteractSummary(){
        String xpath = pepXMLElement.InteractSummary.getXpath();
        InteractSummary result = unmarshalFromXpath(xpath,InteractSummary.class);
        return result;
    }

    public MsmsRunSummary getMsmsRunsummaryById(String aID) throws pepXMLUnmarshallerException{
        MsmsRunSummary result = null;
        String xml = index.getXmlString(aID,MsmsRunSummary.class);
        try {
            //need to clean up XML to ensure that there are no weird control characters
            String cleanXML = EscapingXMLUtilities.escapeCharacters(xml);
            //required for the addition of namespaces to top-level objects
            pepXMLNamespaceFilter xmlFilter = new pepXMLNamespaceFilter();
            //initializeUnmarshaller will assign the proper reader to the xmlFilter
            Unmarshaller unmarshaller = UnmarshallerFactory.getInstance().initializeUnmarshaller(index, xmlFilter, cache, useSpectrumCache);
            //unmarshall the desired object
            JAXBElement<MsmsRunSummary> holder = unmarshaller.unmarshal(new SAXSource(xmlFilter, new InputSource(new StringReader(cleanXML))), MsmsRunSummary.class);
            result = holder.getValue();
            } catch (JAXBException je) {
                logger.error("pepXMLUnmarshaller.getMsmsRunSummaryByID", je);
                throw new IllegalStateException("Could not unmarshal msms_run_summary with ID: " + aID);
            }
            return result;
        }
    /**
     * Returns the SpectrumQuery corresponding to the provided spectrum .
     *
     * @param aID the spectrum of the SpectrumQuery to get
     * @return the spectrumquery corresponding to the provided spectrum , null if no matching spectrum is found
     * @throws pepXMLUnmarshallerException
     */
    public SpectrumQuery getSpectrumById(String aID) throws pepXMLUnmarshallerException {
        SpectrumQuery result = null;
        String xml = index.getXmlString(aID, SpectrumQuery.class);
        try {
            //need to clean up XML to ensure that there are no weird control characters
            String cleanXML = EscapingXMLUtilities.escapeCharacters(xml);
            //required for the addition of namespaces to top-level objects
            pepXMLNamespaceFilter xmlFilter = new pepXMLNamespaceFilter();
            //initializeUnmarshaller will assign the proper reader to the xmlFilter
            Unmarshaller unmarshaller = UnmarshallerFactory.getInstance().initializeUnmarshaller(index, xmlFilter, cache, useSpectrumCache);
            //unmarshall the desired object
            JAXBElement<SpectrumQuery> holder = unmarshaller.unmarshal(new SAXSource(xmlFilter, new InputSource(new StringReader(cleanXML))), SpectrumQuery.class);
            result = holder.getValue();
        } catch (JAXBException je) {
            logger.error("pepXMLUnmarshaller.getSpectrumByID", je);
            throw new IllegalStateException("Could not unmarshal spectrum with ID: " + aID);
        }
        return result;
    }

    public SpectrumQuery getSpectrumByIndex(int aIndex) throws pepXMLUnmarshallerException{
        SpectrumQuery result = null;
        String aID = getSpectrumIDFromSpectrumIndex(aIndex);
        return getSpectrumById(aID);
    }

    /**
     * Returns the SearchSummary corresponding to the provided search_summary base_name.
     *
     * @param aID the basename of the SearchSummary to get
     * @return the searchsummary corresponding to the provided search_summary base_name, null if no matching searchsummaray is found
     * @throws pepXMLUnmarshallerException
     */
    public SearchSummary getSearchSummaryById(String aID) throws pepXMLUnmarshallerException {
        SearchSummary result = null;
        String xml = index.getXmlString(aID, SearchSummary.class);
        try {
            //need to clean up XML to ensure that there are no weird control characters
            String cleanXML = EscapingXMLUtilities.escapeCharacters(xml);
            //required for the addition of namespaces to top-level objects
            pepXMLNamespaceFilter xmlFilter = new pepXMLNamespaceFilter();
            //initializeUnmarshaller will assign the proper reader to the xmlFilter
            Unmarshaller unmarshaller = UnmarshallerFactory.getInstance().initializeUnmarshaller(index, xmlFilter, cache, useSpectrumCache);
            //unmarshall the desired object
            JAXBElement<SearchSummary> holder = unmarshaller.unmarshal(new SAXSource(xmlFilter, new InputSource(new StringReader(cleanXML))), SearchSummary.class);
            result = holder.getValue();
        } catch (JAXBException je) {
            logger.error("pepXMLUnmarshaller.getSearchSummaryByID", je);
            throw new IllegalStateException("Could not unmarshal searchsummary with ID: " + aID);
        }
        return result;
    }


    /**
     * Return a set containing all msmsRunSummary IDs
     *
     * @return a set containing all msmsRunSummary IDs
     */
    public Set<String> getMsmsRunsummaryIDs() {
        return this.index.getMsmsRunsummaryIDs();
    }
    /**
     * Returns a set containing all spectrum IDs
     *
     * @return a set containing all spectrum IDs
     */
    public Set<String> getSpectrumIDs() {
        return this.index.getSpectrumIDs();
    }

    /**
     * Returns a set containing all spectrum indexes
     *
     * @return a set containing all spectrum indexes
     */
    public Set<Integer> getSpectrumIndexes() {
        return this.index.getSpectrumIndexes();
    }

    /**
     * This method returns the spectrum ID for a given spectrum index, or 'null'
     * if the specified index could not be found.
     *
     * @param aIndex Integer with the spectrum index to retrieve
     *               the spectrum ID for
     * @return String  with the spectrum ID, or 'null' if the index could not be found.
     */
    public String getSpectrumIDFromSpectrumIndex(Integer aIndex) {
        return index.getSpectrumIDFromSpectrumIndex(aIndex);
    }

    /**
     * Returns a set containing all chromatogram IDs
     *
     * @return a set containing all chromatogram IDs
     */
    public Set<String> getSearchSummaryIDs() {
        return this.index.getSearchSummaryIDs();
    }


    /**
     * TODO: Javadoc missing
     *
     * @param <T>
     * @param element
     * @return
     * @throws pepXMLUnmarshallerException
     */
    public <T extends pepXMLObject> T unmarshalFromIndexElement(IndexElement element, Class cls) throws pepXMLUnmarshallerException {

        // now that we have the xpath to use for the requested element, check if the xxindex
        // contains an element start position that matches the offset of the desired element
        String xmlSnippet = index.getXmlString(element);

        T retval;
        try {
            // ToDo: check this!! try to replace with standard unmarshaller!
            String cleanXML = EscapingXMLUtilities.escapeCharacters(xmlSnippet);
            pepXMLNamespaceFilter xmlFilter = new pepXMLNamespaceFilter();
            // initializeUnmarshaller will assign the proper reader to the xmlFilter
            Unmarshaller unmarshaller = UnmarshallerFactory.getInstance().initializeUnmarshaller(index, xmlFilter, cache, useSpectrumCache);
            // unmarshall the desired object
            JAXBElement<T> holder = unmarshaller.unmarshal(new SAXSource(xmlFilter, new InputSource(new StringReader(cleanXML))), cls);
            retval = holder.getValue();
        } catch (JAXBException e) {
            logger.error("pepXMLUnmarshaller.getObjectFromXml", e);
            throw new IllegalStateException("Could not unmarshal object from XML string:" + xmlSnippet);
        }

        return retval;
    }

    /**
     * Returns the jpepxml XXIndex Wrapper for raw access. This is usually a developer-level method.
     *
     * @return the jpepxml XXIndex Wrapper for raw acces
     */
    public pepXMLIndexer getpepXMLIndexer() {
        return index;
    }
}
