/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package peerdocumentsearch;

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
public class IndexSearchTest {
    
    public IndexSearchTest() {
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
     * Test of searchIndex method, of class IndexSearch.
     */
    @Test
    public void testSearchIndex() throws Exception {
        System.out.println("searchIndex");
        String qStr = "";
        IndexSearch instance = null;
        ArrayList expResult = null;
        ArrayList result = instance.searchIndex(qStr);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIndexPath method, of class IndexSearch.
     */
    @Test
    public void testGetIndexPath() {
        System.out.println("getIndexPath");
        IndexSearch instance = null;
        String expResult = "";
        String result = instance.getIndexPath();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIndexPath method, of class IndexSearch.
     */
    @Test
    public void testSetIndexPath() {
        System.out.println("setIndexPath");
        String indexPath = "";
        IndexSearch instance = null;
        instance.setIndexPath(indexPath);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumOfSourcesPerSearch method, of class IndexSearch.
     */
    @Test
    public void testGetNumOfSourcesPerSearch() {
        System.out.println("getNumOfSourcesPerSearch");
        IndexSearch instance = null;
        int expResult = 0;
        int result = instance.getNumOfSourcesPerSearch();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNumOfSourcesPerSearch method, of class IndexSearch.
     */
    @Test
    public void testSetNumOfSourcesPerSearch() {
        System.out.println("setNumOfSourcesPerSearch");
        int numOfSources = 0;
        IndexSearch instance = null;
        instance.setNumOfSourcesPerSearch(numOfSources);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
