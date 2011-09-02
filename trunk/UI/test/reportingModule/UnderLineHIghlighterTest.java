/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reportingModule;

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
public class UnderLineHIghlighterTest {
    
    public UnderLineHIghlighterTest() {
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
     * Test of addHighlight method, of class UnderLineHIghlighter.
     */
    @Test
    public void testAddHighlight() throws Exception {
        System.out.println("addHighlight");
        int p0 = 0;
        int p1 = 0;
        UnderLineHIghlighter instance = null;
        Object expResult = null;
        Object result = instance.addHighlight(p0, p1);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDrawsLayeredHighlights method, of class UnderLineHIghlighter.
     */
    @Test
    public void testSetDrawsLayeredHighlights() {
        System.out.println("setDrawsLayeredHighlights");
        boolean newValue = false;
        UnderLineHIghlighter instance = null;
        instance.setDrawsLayeredHighlights(newValue);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
