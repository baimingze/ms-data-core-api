package uk.ac.ebi.pride.utilities.data.Unmarshallers.pepXML.model.pepxml;

import javax.xml.bind.annotation.XmlTransient;

/**
 * Created by IntelliJ IDEA.
 * User: dani
 * Date: 18-Feb-2011
 * Time: 11:12:45
 * To change this template use File | Settings | File Templates.
 */
@XmlTransient
public abstract class pepXMLObject {

    @XmlTransient
    protected long hid;

    public long getHid(){
        return hid;
    }
}
