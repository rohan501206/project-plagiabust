/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package querycreator;

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
public class AbbreviationListTest {
    
    public AbbreviationListTest() {
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
     * Test of getAbbreviationList method, of class AbbreviationList.
     */
    @Test
    public void testGetAbbreviationList() {
        System.out.println("getAbbreviationList");
        ArrayList expResult = null;
        ArrayList result = AbbreviationList.getAbbreviationList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
