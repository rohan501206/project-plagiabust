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
public class KeywordManagerTest {
    
    public KeywordManagerTest() {
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
     * Test of getInstance method, of class KeywordManager.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        KeywordManager expResult = null;
        KeywordManager result = KeywordManager.getInstance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of arraylistToSting method, of class KeywordManager.
     */
    @Test
    public void testArraylistToSting() {
        System.out.println("arraylistToSting");
        ArrayList<String> token = null;
        KeywordManager instance = null;
        String expResult = "";
        String result = instance.arraylistToSting(token);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
