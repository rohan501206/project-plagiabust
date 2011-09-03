/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package querycreator;

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
public class FleshKincaidLogicTest {
    
    public FleshKincaidLogicTest() {
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
     * Test of getWordsInFile method, of class FleshKincaidLogic.
     */
    @Test
    public void testGetWordsInFile() {
        FleshKincaidLogic instance = new FleshKincaidLogic();
        instance.processString("This is a test.");
        int expResult = 4;
        int result = instance.getWordsInFile();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSentencesInFile method, of class FleshKincaidLogic.
     */
    @Test
    public void testGetSentencesInFile() {
        FleshKincaidLogic instance = new FleshKincaidLogic();
        instance.processString("This is a test,!? or not.");
        int expResult = 2;
        int result = instance.getSentencesInFile();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSyllablesInFile method, of class FleshKincaidLogic.
     */
    @Test
    public void testGetSyllablesInFile() {
        FleshKincaidLogic instance = new FleshKincaidLogic();
        instance.processString("He is confident of the results.");
        int expResult = 9;
        int result = instance.getSyllablesInFile();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFleschKincaidGradeLevel method, of class FleshKincaidLogic.
     */
    @Test
    public void testGetFleschKincaidGradeLevel() {
        FleshKincaidLogic instance = new FleshKincaidLogic();
        instance.processString("The use of electronic documents became increasingly popular and nowadays almost every academic institute uses online submission of assignments, projects, reports, etc.");
        double expResult = 19.808181818181826;
        double result = instance.getFleschKincaidGradeLevel();
        assertEquals(expResult, result, 0.0);
    }
}
