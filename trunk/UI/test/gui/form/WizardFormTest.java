/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.form;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import ui.peerSearchReportData;

/**
 *
 * @author Kasun
 */
public class WizardFormTest {
    
    public WizardFormTest() {
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
     * Test of isTabDataValid method, of class WizardForm.
     */
    @Test
    public void testIsTabDataValid() {
        System.out.println("isTabDataValid");
        int selectedTabIndex = 0;
        WizardForm instance = new WizardForm();
        boolean expResult = false;
        boolean result = instance.isTabDataValid(selectedTabIndex);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isValidFileName method, of class WizardForm.
     */
    @Test
    public void testIsValidFileName() {
        System.out.println("isValidFileName");
        String fileName = "";
        WizardForm instance = new WizardForm();
        boolean expResult = false;
        boolean result = instance.isValidFileName(fileName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDescriptionInformation method, of class WizardForm.
     */
    @Test
    public void testSetDescriptionInformation() {
        System.out.println("setDescriptionInformation");
        int selectedTabIndex = 0;
        WizardForm instance = new WizardForm();
        instance.setDescriptionInformation(selectedTabIndex);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setup method, of class WizardForm.
     */
    @Test
    public void testSetup() {
        System.out.println("setup");
        WizardForm instance = new WizardForm();
        instance.setup();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of fileNameConverter method, of class WizardForm.
     */
    @Test
    public void testFileNameConverter() {
        System.out.println("fileNameConverter");
        String fName = "";
        WizardForm instance = new WizardForm();
        String expResult = "";
        String result = instance.fileNameConverter(fName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of peerSetup method, of class WizardForm.
     */
    @Test
    public void testPeerSetup() {
        System.out.println("peerSetup");
        WizardForm instance = new WizardForm();
        instance.peerSetup();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printTemp method, of class WizardForm.
     */
    @Test
    public void testPrintTemp_peerSearchReportData() {
        System.out.println("printTemp");
        peerSearchReportData temp = null;
        WizardForm instance = new WizardForm();
        instance.printTemp(temp);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTempArray method, of class WizardForm.
     */
    @Test
    public void testSetTempArray() {
        System.out.println("setTempArray");
        ReportData temp = null;
        WizardForm instance = new WizardForm();
        instance.setTempArray(temp);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printTemp method, of class WizardForm.
     */
    @Test
    public void testPrintTemp_StringArrArr() {
        System.out.println("printTemp");
        String[][] temp = null;
        WizardForm instance = new WizardForm();
        instance.printTemp(temp);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of close method, of class WizardForm.
     */
    @Test
    public void testClose() {
        System.out.println("close");
        WizardForm instance = new WizardForm();
        instance.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
