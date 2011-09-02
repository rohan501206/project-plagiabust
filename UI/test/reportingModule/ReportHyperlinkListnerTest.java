/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reportingModule;

import net.sf.jasperreports.engine.JRPrintHyperlink;
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
public class ReportHyperlinkListnerTest {
    
    public ReportHyperlinkListnerTest() {
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
     * Test of gotoHyperlink method, of class ReportHyperlinkListner.
     */
    @Test
    public void testGotoHyperlink() throws Exception {
        System.out.println("gotoHyperlink");
        JRPrintHyperlink jrph = null;
        ReportHyperlinkListner instance = new ReportHyperlinkListner();
        instance.gotoHyperlink(jrph);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
