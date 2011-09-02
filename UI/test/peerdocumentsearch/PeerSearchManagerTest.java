/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package peerdocumentsearch;

import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import querycreator.QuerySelectionAlgorithm;

/**
 *
 * @author Kasun
 */
public class PeerSearchManagerTest {
    
    public PeerSearchManagerTest() {
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
     * Test of getSuspiciousDocList method, of class PeerSearchManager.
     */
    @Test
    public void testGetSuspiciousDocList() {
        System.out.println("getSuspiciousDocList");
        String filePath = "";
        PeerSearchManager instance = null;
        HashMap expResult = null;
        HashMap result = instance.getSuspiciousDocList(filePath);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setQuerySelectionAlgorithm method, of class PeerSearchManager.
     */
    @Test
    public void testSetQuerySelectionAlgorithm() {
        System.out.println("setQuerySelectionAlgorithm");
        QuerySelectionAlgorithm selectionAlgo = null;
        PeerSearchManager instance = null;
        instance.setQuerySelectionAlgorithm(selectionAlgo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getQuerySelectionAlgorithm method, of class PeerSearchManager.
     */
    @Test
    public void testGetQuerySelectionAlgorithm() {
        System.out.println("getQuerySelectionAlgorithm");
        PeerSearchManager instance = null;
        QuerySelectionAlgorithm expResult = null;
        QuerySelectionAlgorithm result = instance.getQuerySelectionAlgorithm();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumOfSourcesPerDoc method, of class PeerSearchManager.
     */
    @Test
    public void testGetNumOfSourcesPerDoc() {
        System.out.println("getNumOfSourcesPerDoc");
        PeerSearchManager instance = null;
        int expResult = 0;
        int result = instance.getNumOfSourcesPerDoc();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNumOfSourcesPerDoc method, of class PeerSearchManager.
     */
    @Test
    public void testSetNumOfSourcesPerDoc() {
        System.out.println("setNumOfSourcesPerDoc");
        int numOfSources = 0;
        PeerSearchManager instance = null;
        instance.setNumOfSourcesPerDoc(numOfSources);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
