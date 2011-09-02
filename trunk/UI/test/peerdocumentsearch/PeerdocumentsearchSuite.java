/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package peerdocumentsearch;

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
@Suite.SuiteClasses({peerdocumentsearch.testTest.class, peerdocumentsearch.PeerSearchManagerTest.class, peerdocumentsearch.TextFileIndexerTest.class, peerdocumentsearch.IndexSearchTest.class})
public class PeerdocumentsearchSuite {

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
