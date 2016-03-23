package uk.ac.ebi.pride.utilities.data.Unmarshallers.pepXML.xml.io;

import uk.ac.ebi.pride.utilities.data.Unmarshallers.pepXML.model.pepxml.pepXMLObject;

import java.util.List;

/**
 * @author Florian Reisinger
 *         Date: 11-Nov-2010
 * @since 1.0
 */
public interface pepXMLObjectCache {

    // ToDo: change to only handle MzMLObjects
    // ToDo: that would also mean we can not cache CvParams or UserParams, etc
    // that way we make sure that the objects have an ID which identifies them!

    public void putInCache(String id, pepXMLObject object);

    public void putInCache(pepXMLObject element);

    public <T extends pepXMLObject> T getCachedObject(String id, Class<T> cls);

    public <T extends pepXMLObject> boolean hasEntry(Class<T> clazz);

    public <T extends pepXMLObject> List<T> getEntries(Class<T> clazz);

}
