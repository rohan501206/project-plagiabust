/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package internetsearch;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Kasun
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({internetsearch.DownloadWebPageTest.class, internetsearch.InternetSearchManagerTest.class, internetsearch.ResponseResultTest.class, internetsearch.APINameSpaceContextTest.class, internetsearch.BingSearchTest.class, internetsearch.GoogleSearchTest.class, internetsearch.SearchErrorTest.class, internetsearch.InternetSearchAPITest.class})
public class InternetsearchSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
