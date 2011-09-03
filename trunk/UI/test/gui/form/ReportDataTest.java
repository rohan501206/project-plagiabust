/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.form;

import java.util.ArrayList;
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
public class ReportDataTest {
    
    public ReportDataTest() {
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
     * Test of getUrlList method, of class ReportData.
     */
    @Test
    public void testGetUrlList() {
        System.out.println("getUrlList");
        ReportData instance = null;
        ArrayList expResult = null;
        ArrayList result = instance.getUrlList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFolder method, of class ReportData.
     */
    @Test
    public void testGetFolder() {
        System.out.println("getFolder");
        ReportData instance = null;
        HashMap expResult = null;
        HashMap result = instance.getFolder();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFileUrlMap method, of class ReportData.
     */
    @Test
    public void testGetFileUrlMap() {
        System.out.println("getFileUrlMap");
        ReportData instance = null;
        HashMap expResult = null;
        HashMap result = instance.getFileUrlMap();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
