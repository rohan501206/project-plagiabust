/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package preprocess;

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
public class StemmerTest {
    
    public StemmerTest() {
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
     * Test of add method, of class Stemmer.
     */
    @Test
    public void testAdd_char() {
        System.out.println("add");
        char ch = ' ';
        Stemmer instance = new Stemmer();
        instance.add(ch);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class Stemmer.
     */
    @Test
    public void testAdd_charArr_int() {
        System.out.println("add");
        char[] w = null;
        int wLen = 0;
        Stemmer instance = new Stemmer();
        instance.add(w, wLen);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Stemmer.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Stemmer instance = new Stemmer();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getResultLength method, of class Stemmer.
     */
    @Test
    public void testGetResultLength() {
        System.out.println("getResultLength");
        Stemmer instance = new Stemmer();
        int expResult = 0;
        int result = instance.getResultLength();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getResultBuffer method, of class Stemmer.
     */
    @Test
    public void testGetResultBuffer() {
        System.out.println("getResultBuffer");
        Stemmer instance = new Stemmer();
        char[] expResult = null;
        char[] result = instance.getResultBuffer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of stem method, of class Stemmer.
     */
    @Test
    public void testStem() {
        System.out.println("stem");
        Stemmer instance = new Stemmer();
        instance.stem();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of analyze method, of class Stemmer.
     */
    @Test
    public void testAnalyze() throws Exception {
        System.out.println("analyze");
        String text = "";
        Stemmer instance = new Stemmer();
        ArrayList expResult = null;
        ArrayList result = instance.analyze(text);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
