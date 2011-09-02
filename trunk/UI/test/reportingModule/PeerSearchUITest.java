/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reportingModule;

import edu.uci.ics.jung.visualization.VisualizationViewer;
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
public class PeerSearchUITest {
    
    public PeerSearchUITest() {
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
     * Test of processResults method, of class PeerSearchUI.
     */
    @Test
    public void testProcessResults() {
        System.out.println("processResults");
        PeerSearchUI instance = new PeerSearchUI();
        instance.processResults();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setValuestoJLists method, of class PeerSearchUI.
     */
    @Test
    public void testSetValuestoJLists() {
        System.out.println("setValuestoJLists");
        ArrayList<String> contents = null;
        PeerSearchUI instance = new PeerSearchUI();
        instance.setValuestoJLists(contents);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFolder method, of class PeerSearchUI.
     */
    @Test
    public void testSetFolder() {
        System.out.println("setFolder");
        String sourceFolderName = "";
        PeerSearchUI instance = new PeerSearchUI();
        instance.setFolder(sourceFolderName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setResultDetails method, of class PeerSearchUI.
     */
    @Test
    public void testSetResultDetails() {
        System.out.println("setResultDetails");
        PeerSearchUI instance = new PeerSearchUI();
        instance.setResultDetails();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of generateFinalReport method, of class PeerSearchUI.
     */
    @Test
    public void testGenerateFinalReport() {
        System.out.println("generateFinalReport");
        PeerSearchUI instance = new PeerSearchUI();
        instance.generateFinalReport();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createReportDataSource method, of class PeerSearchUI.
     */
    @Test
    public void testCreateReportDataSource() {
        System.out.println("createReportDataSource");
        PeerSearchUI instance = new PeerSearchUI();
        JRDataSource expResult = null;
        JRDataSource result = instance.createReportDataSource();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of initializeBeanArray method, of class PeerSearchUI.
     */
    @Test
    public void testInitializeBeanArray() {
        System.out.println("initializeBeanArray");
        PeerSearchUI instance = new PeerSearchUI();
        ArrayList expResult = null;
        ArrayList result = instance.initializeBeanArray();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setData method, of class PeerSearchUI.
     */
    @Test
    public void testSetData() {
        System.out.println("setData");
        HashMap<String, HashMap<String, String[]>> peerFilesReportData = null;
        HashMap<String, HashMap<String, String[]>> internetFilesReportData = null;
        PeerSearchUI instance = new PeerSearchUI();
        instance.setData(peerFilesReportData, internetFilesReportData);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveGraph method, of class PeerSearchUI.
     */
    @Test
    public void testSaveGraph() {
        System.out.println("saveGraph");
        VisualizationViewer<Integer, CustomEdge> visualizationViewer = null;
        PeerSearchUI instance = new PeerSearchUI();
        instance.saveGraph(visualizationViewer);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class PeerSearchUI.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        PeerSearchUI.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
