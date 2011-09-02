/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reportingModule;

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
public class DataFetcherSingleSearchTest {
    
    public DataFetcherSingleSearchTest() {
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
     * Test of getDocumentName method, of class DataFetcherSingleSearch.
     */
    @Test
    public void testGetDocumentName() {
        System.out.println("getDocumentName");
        DataFetcherSingleSearch instance = new DataFetcherSingleSearch();
        String expResult = "";
        String result = instance.getDocumentName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDocumentName method, of class DataFetcherSingleSearch.
     */
    @Test
    public void testSetDocumentName() {
        System.out.println("setDocumentName");
        String docName = "";
        DataFetcherSingleSearch instance = new DataFetcherSingleSearch();
        instance.setDocumentName(docName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPlagValue method, of class DataFetcherSingleSearch.
     */
    @Test
    public void testGetPlagValue() {
        System.out.println("getPlagValue");
        DataFetcherSingleSearch instance = new DataFetcherSingleSearch();
        String expResult = "";
        String result = instance.getPlagValue();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPlagValue method, of class DataFetcherSingleSearch.
     */
    @Test
    public void testSetPlagValue() {
        System.out.println("setPlagValue");
        String plagValue = "";
        DataFetcherSingleSearch instance = new DataFetcherSingleSearch();
        instance.setPlagValue(plagValue);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInternetSource method, of class DataFetcherSingleSearch.
     */
    @Test
    public void testGetInternetSource() {
        System.out.println("getInternetSource");
        DataFetcherSingleSearch instance = new DataFetcherSingleSearch();
        ArrayList expResult = null;
        ArrayList result = instance.getInternetSource();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setInternetSource method, of class DataFetcherSingleSearch.
     */
    @Test
    public void testSetInternetSource() {
        System.out.println("setInternetSource");
        ArrayList<InternetSourceStore> internetSource = null;
        DataFetcherSingleSearch instance = new DataFetcherSingleSearch();
        instance.setInternetSource(internetSource);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
