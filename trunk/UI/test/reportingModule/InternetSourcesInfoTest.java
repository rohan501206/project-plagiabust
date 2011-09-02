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
public class InternetSourcesInfoTest {
    
    public InternetSourcesInfoTest() {
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
     * Test of getUrlName method, of class InternetSourcesInfo.
     */
    @Test
    public void testGetUrlName() {
        System.out.println("getUrlName");
        InternetSourcesInfo instance = new InternetSourcesInfo();
        String expResult = "";
        String result = instance.getUrlName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUrlName method, of class InternetSourcesInfo.
     */
    @Test
    public void testSetUrlName() {
        System.out.println("setUrlName");
        String urlname = "";
        InternetSourcesInfo instance = new InternetSourcesInfo();
        instance.setUrlName(urlname);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
