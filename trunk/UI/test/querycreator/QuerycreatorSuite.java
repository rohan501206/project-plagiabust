/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package querycreator;

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
@Suite.SuiteClasses({querycreator.WordListTest.class, querycreator.QueryBuilderTest.class, querycreator.QuerySelectionAlgorithmTest.class, querycreator.QueryCreatorTest.class, querycreator.AbbreviationListTest.class, querycreator.RandomSelectionTest.class, querycreator.CommonMistakesTest.class, querycreator.FleshKincaidLogicTest.class, querycreator.SentenceResultTest.class})
public class QuerycreatorSuite {

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
