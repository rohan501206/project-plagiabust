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
public class FileMarkerGraphTest {
    
    public FileMarkerGraphTest() {
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
     * Test of getFilename method, of class FileMarkerGraph.
     */
    @Test
    public void testGetFilename() {
        System.out.println("getFilename");
        FileMarkerGraph instance = new FileMarkerGraph();
        String expResult = "";
        String result = instance.getFilename();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFilename method, of class FileMarkerGraph.
     */
    @Test
    public void testSetFilename() {
        System.out.println("setFilename");
        String filename = "";
        FileMarkerGraph instance = new FileMarkerGraph();
        instance.setFilename(filename);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
