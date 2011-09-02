/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package querycreator;

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
public class QuerySelectionAlgorithmTest {
    
    public QuerySelectionAlgorithmTest() {
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
     * Test of values method, of class QuerySelectionAlgorithm.
     */
    @Test
    public void testValues() {
        System.out.println("values");
        QuerySelectionAlgorithm[] expResult = null;
        QuerySelectionAlgorithm[] result = QuerySelectionAlgorithm.values();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of valueOf method, of class QuerySelectionAlgorithm.
     */
    @Test
    public void testValueOf() {
        System.out.println("valueOf");
        String name = "";
        QuerySelectionAlgorithm expResult = null;
        QuerySelectionAlgorithm result = QuerySelectionAlgorithm.valueOf(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
