/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package internetsearch;

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
public class ResponseResultTest {
    
    public ResponseResultTest() {
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
     * Test of getDisplayUrl method, of class ResponseResult.
     */
    @Test
    public void testGetDisplayUrl() {
        System.out.println("getDisplayUrl");
        ResponseResult instance = new ResponseResult();
        String expResult = "";
        String result = instance.getDisplayUrl();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDisplayUrl method, of class ResponseResult.
     */
    @Test
    public void testSetDisplayUrl() {
        System.out.println("setDisplayUrl");
        String DisplayUrl = "";
        ResponseResult instance = new ResponseResult();
        instance.setDisplayUrl(DisplayUrl);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLastCrawledDate method, of class ResponseResult.
     */
    @Test
    public void testGetLastCrawledDate() {
        System.out.println("getLastCrawledDate");
        ResponseResult instance = new ResponseResult();
        String expResult = "";
        String result = instance.getLastCrawledDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLastCrawledDate method, of class ResponseResult.
     */
    @Test
    public void testSetLastCrawledDate() {
        System.out.println("setLastCrawledDate");
        String LastCrawledDate = "";
        ResponseResult instance = new ResponseResult();
        instance.setLastCrawledDate(LastCrawledDate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTitle method, of class ResponseResult.
     */
    @Test
    public void testGetTitle() {
        System.out.println("getTitle");
        ResponseResult instance = new ResponseResult();
        String expResult = "";
        String result = instance.getTitle();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTitle method, of class ResponseResult.
     */
    @Test
    public void testSetTitle() {
        System.out.println("setTitle");
        String Title = "";
        ResponseResult instance = new ResponseResult();
        instance.setTitle(Title);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDescription method, of class ResponseResult.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        ResponseResult instance = new ResponseResult();
        String expResult = "";
        String result = instance.getDescription();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDescription method, of class ResponseResult.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String Description = "";
        ResponseResult instance = new ResponseResult();
        instance.setDescription(Description);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUrl method, of class ResponseResult.
     */
    @Test
    public void testGetUrl() {
        System.out.println("getUrl");
        ResponseResult instance = new ResponseResult();
        String expResult = "";
        String result = instance.getUrl();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUrl method, of class ResponseResult.
     */
    @Test
    public void testSetUrl() {
        System.out.println("setUrl");
        String Url = "";
        ResponseResult instance = new ResponseResult();
        instance.setUrl(Url);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
