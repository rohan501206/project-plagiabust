/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.form;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import ui.peerSearchReportData;

/**
 *
 * @author Kasun
 */
public class PeerSearchWorkerTest {
    
    public PeerSearchWorkerTest() {
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
     * Test of doInBackground method, of class PeerSearchWorker.
     */
    @Test
    public void testDoInBackground() throws Exception {
        System.out.println("doInBackground");
        PeerSearchWorker instance = null;
        peerSearchReportData expResult = null;
        peerSearchReportData result = instance.doInBackground();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOutPut method, of class PeerSearchWorker.
     */
    @Test
    public void testGetOutPut() {
        System.out.println("getOutPut");
        PeerSearchWorker instance = null;
        peerSearchReportData expResult = null;
        peerSearchReportData result = instance.getOutPut();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
