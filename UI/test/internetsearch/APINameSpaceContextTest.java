/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package internetsearch;

import java.util.Iterator;
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
public class APINameSpaceContextTest {
    
    public APINameSpaceContextTest() {
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
     * Test of getNamespaceURI method, of class APINameSpaceContext.
     */
    @Test
    public void testGetNamespaceURI() {
        System.out.println("getNamespaceURI");
        String prefix = "";
        APINameSpaceContext instance = new APINameSpaceContext();
        String expResult = "";
        String result = instance.getNamespaceURI(prefix);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPrefix method, of class APINameSpaceContext.
     */
    @Test
    public void testGetPrefix() {
        System.out.println("getPrefix");
        String uri = "";
        APINameSpaceContext instance = new APINameSpaceContext();
        String expResult = "";
        String result = instance.getPrefix(uri);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPrefixes method, of class APINameSpaceContext.
     */
    @Test
    public void testGetPrefixes() {
        System.out.println("getPrefixes");
        String arg0 = "";
        APINameSpaceContext instance = new APINameSpaceContext();
        Iterator expResult = null;
        Iterator result = instance.getPrefixes(arg0);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
