package uk.ac.ebi.pride.utilities.data.Unmarshallers.pepXML.xml.xxindex;

import psidev.psi.tools.xxindex.index.IndexElement;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public interface pepXMLIndexer {

    public Iterator<String> getXmlStringIterator(String xpathExpression);

    public String getXmlString(String ID, Class clazz);

    public String getXmlString(IndexElement indexElement);

    public int getCount(String xpathExpression);

    public List<IndexElement> getIndexElements(String xpathExpression);

    public Set<String> getXpath();

    public Set<String> getMsmsRunsummaryIDs();

    public Set<String> getSpectrumIDs();

    public Set<Integer> getSpectrumIndexes();

    public String getSpectrumIDFromSpectrumIndex(Integer index);

    public Set<String> getSearchSummaryIDs();


    public String getStartTag(String xpath);

    /**
     * @param id    the unique ID (from the id attribute) of an XML element.
     * @param clazz the Java Class representing the element.
     * @return the complete start tag for the XML element with all specified attributes.
     */
    public String getStartTag(String id, Class clazz);

}
