
package uk.ac.ebi.pride.utilities.data.Unmarshallers.pepXML.xml.jaxb.unmarshaller.cache;


import uk.ac.ebi.pride.utilities.data.Unmarshallers.pepXML.model.pepxml.interfaces.pepXMLObject;

import java.util.HashMap;
import java.util.Map;

public class AdapterObjectCache {

    //todo
    //configure caching levels so that individual object classes are/aren't cached
    //at runtime
    private Map<Class, Map<String, pepXMLObject>> cache = new HashMap<Class, Map<String, pepXMLObject>>();

    public void putInCache(String id, pepXMLObject object) {
        Class cls = object.getClass();
        Map<String, pepXMLObject> classCache = cache.get(cls);
        if (classCache == null) {
            classCache = new HashMap<String, pepXMLObject>();
            cache.put(cls, classCache);
        }
        classCache.put(id, object);
    }

    public pepXMLObject getCachedObject(String id, Class cls) {
        Map<String, pepXMLObject> classCache = cache.get(cls);
        if (classCache == null) {
            return null;
        }
        return classCache.get(id);
    }
}