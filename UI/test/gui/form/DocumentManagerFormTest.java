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

/**
 *
 * @author Kasun
 */
public class DocumentManagerFormTest {
    
    public DocumentManagerFormTest() {
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
     * Test of getInstance method, of class DocumentManagerForm.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        DocumentManagerForm expResult = null;
        DocumentManagerForm result = DocumentManagerForm.getInstance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
