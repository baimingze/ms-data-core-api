package uk.ac.ebi.pride.utilities.data.exporters;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import uk.ac.ebi.pride.jmztab.model.MZTabFile;
import uk.ac.ebi.pride.jmztab.utils.MZTabFileConverter;
import uk.ac.ebi.pride.utilities.data.controller.impl.ControllerImpl.PrideXmlControllerImpl;

import java.io.*;
import java.net.URL;

import static org.junit.Assert.assertTrue;

public class MzTabPRIDEConverterTest {

    private PrideXmlControllerImpl prideController = null;


    @Before
    public void setUp() throws Exception {
        URL url = MzTabPRIDEConverterTest.class.getClassLoader().getResource("test-pride.xml");
        if (url == null) {
            throw new IllegalStateException("No file for input found!");
        }
        File inputFile = new File(url.toURI());
        prideController = new PrideXmlControllerImpl(inputFile);
    }

    @Test
    public void convertPrideToMzTab() throws IOException {
        AbstractMzTabConverter mzTabconverter = new PRIDEMzTabConverter(prideController);
        MZTabFile mzTabFile = mzTabconverter.getMZTabFile();
        OutputStream out = null;
        out = new BufferedOutputStream(new FileOutputStream(new File("temp", "test-pride.mztab.msdatacore")));
        mzTabFile.printMZTab(out);

        MZTabFileConverter checker = new MZTabFileConverter();
        checker.check(mzTabFile);
        assertTrue("No errors reported during the conversion from PRIDE XML to MzTab", checker.getErrorList().size() == 0);
        out.close();

    }

    @After
    public void tearDown() throws Exception {

    }
}
