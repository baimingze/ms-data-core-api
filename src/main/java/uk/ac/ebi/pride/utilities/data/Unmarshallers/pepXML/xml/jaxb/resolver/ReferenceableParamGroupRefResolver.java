package uk.ac.ebi.pride.utilities.data.Unmarshallers.pepXML.xml.jaxb.resolver;

//import uk.ac.ebi.jmzml.MzMLElement;
import uk.ac.ebi.pride.utilities.data.Unmarshallers.pepXML.pepXMLElement;
//import uk.ac.ebi.jmzml.model.mzml.DataProcessing;
import uk.ac.ebi.pride.utilities.data.Unmarshallers.pepXML.model.pepxml.DataProcessing;
//import uk.ac.ebi.jmzml.model.mzml.ReferenceableParamGroup;
import uk.ac.ebi.pride.utilities.data.Unmarshallers.pepXML.model.pepxml.ReferenceableParamGroup;
//import uk.ac.ebi.jmzml.model.mzml.ReferenceableParamGroupRef;
import uk.ac.ebi.pride.utilities.data.Unmarshallers.pepXML.model.pepxml.ReferenceableParamGroupRef;
//import uk.ac.ebi.jmzml.xml.io.MzMLObjectCache;
import uk.ac.ebi.pride.utilities.data.Unmarshallers.pepXML.xml.io.pepXMLObjectCache;
//import uk.ac.ebi.jmzml.xml.xxindex.MzMLIndexer;
import uk.ac.ebi.pride.utilities.data.Unmarshallers.pepXML.xml.xxindex.pepXMLIndexer;

/**
 * Created by IntelliJ IDEA.
 * User: dani
 * Date: 21-Feb-2011
 * Time: 11:42:46
 * To change this template use File | Settings | File Templates.
 */
public class ReferenceableParamGroupRefResolver extends AbstractReferenceResolver<ReferenceableParamGroupRef> {
    public ReferenceableParamGroupRefResolver(pepXMLIndexer index, pepXMLObjectCache cache) {
        super(index, cache);
    }

    @Override
    public void updateObject(ReferenceableParamGroupRef object) {
        // if we automatically resolve the references, then update the object with the referenced object
        if (pepXMLElement.ReferenceableParamGroupRef.isAutoRefResolving()) {
            // add objects for the refID
            String ref = object.getRef();
            if (ref != null) {
                ReferenceableParamGroup refObject = this.unmarshal(ref, ReferenceableParamGroup.class);
                object.setReferenceableParamGroup(refObject);
            }
        }
    }

    /**
     * A method to be called before the marshall process.
     * Whenever a referenced object is set, its refID should be updated
     * automatically, so that the refID and the ID of the object are
     * always in sync. Here we check that this is the case.
     *
     * @param object The Object to check for reference ID integrity.
     */
    @Override
    public void checkRefID(ReferenceableParamGroupRef object) {
        // if there is a referenced object and its ID does not correspond to the refID, then there is something wrong
        if (object.getReferenceableParamGroup() != null && !object.getRef().equals(object.getReferenceableParamGroup().getId())) {
            throw new IllegalStateException("Reference ID and referenced object ID do not match!");
        }
    }

    /**
     * Method to perform the afterUnmarshal operation if the resolver
     * applies to the specified object.
     *
     * @param target the object to modify after unmarshalling.
     * @param parent object referencing the target. Null if target is root element.
     */
    @Override
    public void afterUnmarshal(Object target, Object parent) {
        if (ReferenceableParamGroupRef.class.isInstance(target)) {
            updateObject((ReferenceableParamGroupRef) target);
        } // else, not business of this resolver
    }

}
