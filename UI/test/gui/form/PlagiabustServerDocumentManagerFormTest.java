/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.form;

import java.util.ArrayList;
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
public class PlagiabustServerDocumentManagerFormTest {
    
    public PlagiabustServerDocumentManagerFormTest() {
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
     * Test of getDocumentList method, of class PlagiabustServerDocumentManagerForm.
     */
    @Test
    public void testGetDocumentList() {
        System.out.println("getDocumentList");
        PlagiabustServerDocumentManagerForm instance = new PlagiabustServerDocumentManagerForm();
        ArrayList expResult = null;
        ArrayList result = instance.getDocumentList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
