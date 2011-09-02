/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package plagiabustwebserver;

import java.util.Date;
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
public class PlagiabustServerResponseTest {
    
    public PlagiabustServerResponseTest() {
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
     * Test of getID method, of class PlagiabustServerResponse.
     */
    @Test
    public void testGetID() {
        System.out.println("getID");
        PlagiabustServerResponse instance = new PlagiabustServerResponse();
        String expResult = "";
        String result = instance.getID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setID method, of class PlagiabustServerResponse.
     */
    @Test
    public void testSetID() {
        System.out.println("setID");
        String ID = "";
        PlagiabustServerResponse instance = new PlagiabustServerResponse();
        instance.setID(ID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getContent method, of class PlagiabustServerResponse.
     */
    @Test
    public void testGetContent() {
        System.out.println("getContent");
        PlagiabustServerResponse instance = new PlagiabustServerResponse();
        String expResult = "";
        String result = instance.getContent();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setContent method, of class PlagiabustServerResponse.
     */
    @Test
    public void testSetContent() {
        System.out.println("setContent");
        String Content = "";
        PlagiabustServerResponse instance = new PlagiabustServerResponse();
        instance.setContent(Content);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLastModified method, of class PlagiabustServerResponse.
     */
    @Test
    public void testGetLastModified() {
        System.out.println("getLastModified");
        PlagiabustServerResponse instance = new PlagiabustServerResponse();
        Date expResult = null;
        Date result = instance.getLastModified();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLastModified method, of class PlagiabustServerResponse.
     */
    @Test
    public void testSetLastModified() {
        System.out.println("setLastModified");
        Date LastModified = null;
        PlagiabustServerResponse instance = new PlagiabustServerResponse();
        instance.setLastModified(LastModified);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTitle method, of class PlagiabustServerResponse.
     */
    @Test
    public void testGetTitle() {
        System.out.println("getTitle");
        PlagiabustServerResponse instance = new PlagiabustServerResponse();
        String expResult = "";
        String result = instance.getTitle();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTitle method, of class PlagiabustServerResponse.
     */
    @Test
    public void testSetTitle() {
        System.out.println("setTitle");
        String Title = "";
        PlagiabustServerResponse instance = new PlagiabustServerResponse();
        instance.setTitle(Title);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUrl method, of class PlagiabustServerResponse.
     */
    @Test
    public void testGetUrl() {
        System.out.println("getUrl");
        PlagiabustServerResponse instance = new PlagiabustServerResponse();
        String expResult = "";
        String result = instance.getUrl();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUrl method, of class PlagiabustServerResponse.
     */
    @Test
    public void testSetUrl() {
        System.out.println("setUrl");
        String Url = "";
        PlagiabustServerResponse instance = new PlagiabustServerResponse();
        instance.setUrl(Url);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
