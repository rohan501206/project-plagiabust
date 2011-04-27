/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dataExtraction;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Compaq
 */
public class DocumentReaderTest {

    public DocumentReaderTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    /**
     * Test of processFileAndGetText method, of class DocumentReader.
     */
    @Test
    public void testProcessFileAndGetText() {
        System.out.println("processFileAndGetText");
        String fileName = "";
        DocumentReader instance = new DocumentReader();
        String expResult = "";
        String result = instance.processFileAndGetText(fileName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getpreprocessingError method, of class DocumentReader.
     */
    @Test
    public void testGetpreprocessingError() {
        System.out.println("getpreprocessingError");
        DocumentReader instance = new DocumentReader();
        PreprocessingError expResult = null;
        PreprocessingError result = instance.getpreprocessingError();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}