/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package internetsearch;

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
public class InternetSearchAPITest {
    
    public InternetSearchAPITest() {
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
     * Test of searchInternet method, of class InternetSearchAPI.
     */
    @Test
    public void testSearchInternet() {
        System.out.println("searchInternet");
        String query = "";
        InternetSearchAPI instance = null;
        ArrayList expResult = null;
        ArrayList result = instance.searchInternet(query);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class InternetSearchAPIImpl extends InternetSearchAPI {

        public InternetSearchAPIImpl() {
            super("");
        }

        public ArrayList<ResponseResult> searchInternet(String query) {
            return null;
        }
    }
}
