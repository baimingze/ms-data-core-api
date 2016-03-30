/*
 * Date: 22/7/2008
 * Author: rcote
 * File: uk.ac.ebi.jmzml.xml.jaxb.unmarshaller.cache.AdapterObjectCache
 *
 * jmzml is Copyright 2008 The European Bioinformatics Institute
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 *
 *
 */

package uk.ac.ebi.pride.utilities.data.Unmarshallers.pepXML.xml.jaxb.unmarshaller.cache;

//import uk.ac.ebi.jmzml.model.mzml.interfaces.MzMLObject;
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