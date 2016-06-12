package uk.ac.ebi.pride.utilities.data.Unmarshallers.pepXML.model.pepxml.utilities;



public class pepXMLElementConfig {

    private String tagName;
    private boolean indexed;
    private String xpath;
    private boolean idMapped;
    private Class clazz;



    public String getTagName() {return tagName;}

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public boolean isIndexed() {
        return indexed;
    }

    public void setIndexed(boolean indexed) {
        this.indexed = indexed;
    }

    public String getXpath() {
        return xpath;
    }

    public void setXpath(String xpath) {
        this.xpath = xpath;
    }

    public boolean isIdMapped() {
        return idMapped;
    }

    public void setIdMapped(boolean idMapped) {
        this.idMapped = idMapped;
    }

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }


}
