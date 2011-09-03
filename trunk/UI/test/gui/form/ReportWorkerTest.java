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
import reportingModule.ReportingModule;

/**
 *
 * @author Kasun
 */
public class ReportWorkerTest {
    
    public ReportWorkerTest() {
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
     * Test of doInBackground method, of class ReportWorker.
     */
    @Test
    public void testDoInBackground() throws Exception {
        System.out.println("doInBackground");
        ReportWorker instance = null;
        ReportingModule expResult = null;
        ReportingModule result = instance.doInBackground();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
