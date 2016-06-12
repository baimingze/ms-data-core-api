package uk.ac.ebi.pride.utilities.data.Unmarshallers.pepXML;

import junit.framework.TestCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.ac.ebi.pride.utilities.data.Unmarshallers.pepXML.model.pepxml.*;
import uk.ac.ebi.pride.utilities.data.Unmarshallers.pepXML.xml.io.pepXMLUnmarshaller;
import uk.ac.ebi.pride.utilities.data.Unmarshallers.pepXML.xml.io.pepXMLUnmarshallerException;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Iterator;
import java.util.Set;


/**
 * Created by sangzhe on 16/5/24.
 */
public class JpepxmlUnmarshallMarshallTest extends TestCase {
    private static final Logger logger = LoggerFactory.getLogger(JpepxmlUnmarshallMarshallTest.class);

    private File pepXMLFile;
    @Override
    protected void setUp() throws Exception {
        URL aUrl = this.getClass().getClassLoader().getResource("interact-highprob.pep.xml");
        assertNotNull(aUrl);

        try {
            pepXMLFile = new File(aUrl.toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
            throw new IllegalStateException("Could not create file from URL: " + aUrl );
        }
        assertTrue("jpepxml instance file '" + pepXMLFile.getAbsolutePath() + "' does not exist.", pepXMLFile.exists());
    }



    public void testSpectrumIteration() {
//        assertTrue(isValidpepXML(pepXMLFile));

        pepXMLUnmarshaller um = new pepXMLUnmarshaller(pepXMLFile);

        String path = pepXMLElement.SpectrumQuery.getXpath();


        Iterator<SpectrumQuery> iterator = um.unmarshalCollectionFromXpath(pepXMLElement.SpectrumQuery.getXpath(), SpectrumQuery.class);

        // count the number of spectra we are iterating over
        logger.debug("Iterating over all spectra...");
        int spectrumCnt = 0;
        while (iterator.hasNext()) {
            SpectrumQuery spectrum = iterator.next();
            if (logger.isDebugEnabled()) {
                logger.debug("Spectrum: " + spectrum.getSpectrum());
            }
            spectrumCnt++;
        }

        // get the number of spectra entries in the index
        int spectrumNo = um.getObjectCountForXpath(pepXMLElement.SpectrumQuery.getXpath());
        // compare the two spectra counts
        assertEquals(spectrumNo, spectrumCnt);


        String spectrumId = null;
        String a = null;
        try {
            spectrumId = um.getSpectrumIDs().iterator().next();
            SpectrumQuery testSpectrum = um.getSpectrumById(spectrumId);
            assertEquals(testSpectrum.getIndex(),testSpectrum.getIndex());

            SpectrumQuery testSpectrumIndex = um.getSpectrumByIndex(2);
            assertEquals(3641,testSpectrumIndex.getStartScan());
        } catch (pepXMLUnmarshallerException e) {
            logger.error("Error reading index for spectrum " + spectrumId, e);
        }


    }

    public void testProphetSummary(){
        pepXMLUnmarshaller um = new pepXMLUnmarshaller(pepXMLFile);
        PeptideprophetSummary peptideprophet = um.getPeptideprophetSummary();

        if (logger.isDebugEnabled()) {
            logger.debug("peptideprophet version: " + peptideprophet.getVersion());
        }

        InteractSummary interactsummary = um.getInteractSummary();

        if (logger.isDebugEnabled()) {
            logger.debug("interactsummary base_name: " + interactsummary.getFilename());
        }

    }
    public void testgetSearchSummarybyID() {
//        assertTrue(isValidpepXML(pepXMLFile));

        pepXMLUnmarshaller um = new pepXMLUnmarshaller(pepXMLFile);
        try {
            SearchSummary searchsummary = um.getSearchSummaryById("/regis/sbeams/archive/wyan/HIVHuCell/HIV_S100/HsIPI_v3.21plus/hivs100_17_2");
            String databaseLocalpath = searchsummary.getSearchDatabase().getLocalPath();
            assertEquals("/dbase/users/sbeams/ipi.HUMAN.v3.21plus.fasta",databaseLocalpath);
            String enzyme = searchsummary.getEnzymaticSearchConstraint().getEnzyme();
            assertEquals("Trypsin",enzyme);
            String searchengine = searchsummary.getSearchEngine().value();
            assertEquals("SEQUEST",searchengine);
        }catch (pepXMLUnmarshallerException ex){
            ex.printStackTrace();
        }
    }

    public void testgetMsmsRunSummay(){
        pepXMLUnmarshaller um = new pepXMLUnmarshaller(pepXMLFile);
        Set<String> msms_run_summaryName = um.getMsmsRunsummaryIDs();
        if (logger.isDebugEnabled()) {
            logger.debug("MsmsRunSummary basename: " + msms_run_summaryName);
        }
        try{
            MsmsRunSummary runsummary = um.getMsmsRunsummaryById("/regis/sbeams/archive/wyan/HIVHuCell/HIV_S100/HsIPI_v3.21plus/hivs100_14_1");
            assertEquals("ThermoFinnigan",runsummary.getMsManufacturer());
        } catch (pepXMLUnmarshallerException ex){
            ex.printStackTrace();
        }
    }

    public void testgetEnzymes(){
        pepXMLUnmarshaller um = new pepXMLUnmarshaller(pepXMLFile);
        Iterator<SampleEnzyme> enzymes = um.getSampleEnzymes();
        while(enzymes.hasNext()){
            SampleEnzyme enzyme = enzymes.next();
            if (logger.isDebugEnabled()) {
                logger.debug("Sample Enzyme: " + enzyme.getName());
            }
        }
    }



}
