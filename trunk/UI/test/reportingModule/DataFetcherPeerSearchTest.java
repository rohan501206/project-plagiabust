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
public class DataFetcherPeerSearchTest {
    
    public DataFetcherPeerSearchTest() {
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
     * Test of getDocumentName method, of class DataFetcherPeerSearch.
     */
    @Test
    public void testGetDocumentName() {
        System.out.println("getDocumentName");
        DataFetcherPeerSearch instance = new DataFetcherPeerSearch();
        String expResult = "";
        String result = instance.getDocumentName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDocumentName method, of class DataFetcherPeerSearch.
     */
    @Test
    public void testSetDocumentName() {
        System.out.println("setDocumentName");
        String docName = "";
        DataFetcherPeerSearch instance = new DataFetcherPeerSearch();
        instance.setDocumentName(docName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPlagValue method, of class DataFetcherPeerSearch.
     */
    @Test
    public void testGetPlagValue() {
        System.out.println("getPlagValue");
        DataFetcherPeerSearch instance = new DataFetcherPeerSearch();
        String expResult = "";
        String result = instance.getPlagValue();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPlagValue method, of class DataFetcherPeerSearch.
     */
    @Test
    public void testSetPlagValue() {
        System.out.println("setPlagValue");
        String plagValue = "";
        DataFetcherPeerSearch instance = new DataFetcherPeerSearch();
        instance.setPlagValue(plagValue);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSuspectedDocName method, of class DataFetcherPeerSearch.
     */
    @Test
    public void testGetSuspectedDocName() {
        System.out.println("getSuspectedDocName");
        DataFetcherPeerSearch instance = new DataFetcherPeerSearch();
        String expResult = "";
        String result = instance.getSuspectedDocName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSuspectedDocName method, of class DataFetcherPeerSearch.
     */
    @Test
    public void testSetSuspectedDocName() {
        System.out.println("setSuspectedDocName");
        String suspectedDocName = "";
        DataFetcherPeerSearch instance = new DataFetcherPeerSearch();
        instance.setSuspectedDocName(suspectedDocName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
