/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.form;

import java.util.HashMap;
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
public class WorkerTest {
    
    public WorkerTest() {
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
     * Test of doInBackground method, of class Worker.
     */
    @Test
    public void testDoInBackground() throws Exception {
        System.out.println("doInBackground");
        Worker instance = null;
        ReportData expResult = null;
        ReportData result = instance.doInBackground();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOutPut method, of class Worker.
     */
    @Test
    public void testGetOutPut() {
        System.out.println("getOutPut");
        Worker instance = null;
        HashMap expResult = null;
        HashMap result = instance.getOutPut();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of done method, of class Worker.
     */
    @Test
    public void testDone() {
        System.out.println("done");
        Worker instance = null;
        instance.done();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
