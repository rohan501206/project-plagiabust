/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reportingModule;

import edu.uci.ics.jung.visualization.VisualizationViewer;
import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import net.sf.jasperreports.engine.JRDataSource;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kasun
 */
public class ReportingModuleTest {
    
    public ReportingModuleTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of deleteDir method, of class ReportingModule.
     */
    @Test
    public void testDeleteDir() {
        System.out.println("deleteDir");
        File dir = null;
        boolean expResult = false;
        boolean result = ReportingModule.deleteDir(dir);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setData method, of class ReportingModule.
     */
    @Test
    public void testSetData() {
        System.out.println("setData");
        File projectFolderTemp = null;
        boolean deleteFolderTemp = false;
        ReportingModule instance = new ReportingModule();
        instance.setData(projectFolderTemp, deleteFolderTemp);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIndexDetails method, of class ReportingModule.
     */
    @Test
    public void testSetIndexDetails() {
        System.out.println("setIndexDetails");
        String fileName = "";
        ReportingModule instance = new ReportingModule();
        instance.setIndexDetails(fileName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of highlighterDetails method, of class ReportingModule.
     */
    @Test
    public void testHighlighterDetails() {
        System.out.println("highlighterDetails");
        String queryTemp = "";
        String filename = "";
        ReportingModule instance = new ReportingModule();
        instance.highlighterDetails(queryTemp, filename);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFilesToFileSelector method, of class ReportingModule.
     */
    @Test
    public void testSetFilesToFileSelector() {
        System.out.println("setFilesToFileSelector");
        ReportingModule instance = new ReportingModule();
        instance.setFilesToFileSelector();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of texthighlighterOnScreenView method, of class ReportingModule.
     */
    @Test
    public void testTexthighlighterOnScreenView() {
        System.out.println("texthighlighterOnScreenView");
        ReportingModule instance = new ReportingModule();
        instance.texthighlighterOnScreenView();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of highlighter method, of class ReportingModule.
     */
    @Test
    public void testHighlighter() {
        System.out.println("highlighter");
        String queryTemp = "";
        String paraphrasedFirstPhraseTemp = "";
        String paraphrasedSecondPhraseTemp = "";
        ReportingModule instance = new ReportingModule();
        instance.highlighter(queryTemp, paraphrasedFirstPhraseTemp, paraphrasedSecondPhraseTemp);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHighlighterToBothTextFiles method, of class ReportingModule.
     */
    @Test
    public void testSetHighlighterToBothTextFiles() {
        System.out.println("setHighlighterToBothTextFiles");
        String[] queryArray = null;
        String contentTemp = "";
        String content2Temp = "";
        ArrayList<Color> colourArrayTemp = null;
        ReportingModule instance = new ReportingModule();
        instance.setHighlighterToBothTextFiles(queryArray, contentTemp, content2Temp, colourArrayTemp);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHighlighterToFirstTextFile method, of class ReportingModule.
     */
    @Test
    public void testSetHighlighterToFirstTextFile() {
        System.out.println("setHighlighterToFirstTextFile");
        String[] queryArray = null;
        String contentTemp = "";
        String content2Temp = "";
        ArrayList<Color> colourArrayTemp = null;
        ReportingModule instance = new ReportingModule();
        instance.setHighlighterToFirstTextFile(queryArray, contentTemp, content2Temp, colourArrayTemp);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHighlighterToSecondTextFile method, of class ReportingModule.
     */
    @Test
    public void testSetHighlighterToSecondTextFile() {
        System.out.println("setHighlighterToSecondTextFile");
        String[] queryArray = null;
        String contentTemp = "";
        String content2Temp = "";
        ArrayList<Color> colourArrayTemp = null;
        ReportingModule instance = new ReportingModule();
        instance.setHighlighterToSecondTextFile(queryArray, contentTemp, content2Temp, colourArrayTemp);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of generateFinalReport method, of class ReportingModule.
     */
    @Test
    public void testGenerateFinalReport() {
        System.out.println("generateFinalReport");
        ReportingModule instance = new ReportingModule();
        instance.generateFinalReport();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createReportDataSource method, of class ReportingModule.
     */
    @Test
    public void testCreateReportDataSource() {
        System.out.println("createReportDataSource");
        ReportingModule instance = new ReportingModule();
        JRDataSource expResult = null;
        JRDataSource result = instance.createReportDataSource();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of initializeBeanArray method, of class ReportingModule.
     */
    @Test
    public void testInitializeBeanArray() {
        System.out.println("initializeBeanArray");
        ReportingModule instance = new ReportingModule();
        DataFetcherSingleSearch[] expResult = null;
        DataFetcherSingleSearch[] result = instance.initializeBeanArray();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of generateGraph method, of class ReportingModule.
     */
    @Test
    public void testGenerateGraph() {
        System.out.println("generateGraph");
        ReportingModule instance = new ReportingModule();
        instance.generateGraph();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMap method, of class ReportingModule.
     */
    @Test
    public void testSetMap() {
        System.out.println("setMap");
        HashMap<String, String> fileUrlMap = null;
        ReportingModule instance = new ReportingModule();
        instance.setMap(fileUrlMap);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTemp method, of class ReportingModule.
     */
    @Test
    public void testSetTemp() {
        System.out.println("setTemp");
        HashMap<String, String[]> tempa = null;
        ReportingModule instance = new ReportingModule();
        instance.setTemp(tempa);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDocument method, of class ReportingModule.
     */
    @Test
    public void testSetDocument() {
        System.out.println("setDocument");
        String doc = "";
        ReportingModule instance = new ReportingModule();
        instance.setDocument(doc);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUrl method, of class ReportingModule.
     */
    @Test
    public void testSetUrl() {
        System.out.println("setUrl");
        ArrayList<String> urlList = null;
        ReportingModule instance = new ReportingModule();
        instance.setUrl(urlList);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveGraph method, of class ReportingModule.
     */
    @Test
    public void testSaveGraph() {
        System.out.println("saveGraph");
        VisualizationViewer<Integer, CustomEdge> visualizationViewer = null;
        ReportingModule instance = new ReportingModule();
        instance.saveGraph(visualizationViewer);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class ReportingModule.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        ReportingModule.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
