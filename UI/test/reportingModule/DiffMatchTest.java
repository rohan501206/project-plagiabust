/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reportingModule;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import reportingModule.DiffMatch.Diff;
import reportingModule.DiffMatch.LinesToCharsResult;
import reportingModule.DiffMatch.Patch;

/**
 *
 * @author Kasun
 */
public class DiffMatchTest {
    
    public DiffMatchTest() {
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
     * Test of diff_main method, of class DiffMatch.
     */
    @Test
    public void testDiff_main_String_String() {
        System.out.println("diff_main");
        String text1 = "";
        String text2 = "";
        DiffMatch instance = new DiffMatch();
        LinkedList expResult = null;
        LinkedList result = instance.diff_main(text1, text2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of diff_main method, of class DiffMatch.
     */
    @Test
    public void testDiff_main_3args() {
        System.out.println("diff_main");
        String text1 = "";
        String text2 = "";
        boolean checklines = false;
        DiffMatch instance = new DiffMatch();
        LinkedList expResult = null;
        LinkedList result = instance.diff_main(text1, text2, checklines);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of diff_bisect method, of class DiffMatch.
     */
    @Test
    public void testDiff_bisect() {
        System.out.println("diff_bisect");
        String text1 = "";
        String text2 = "";
        long deadline = 0L;
        DiffMatch instance = new DiffMatch();
        LinkedList expResult = null;
        LinkedList result = instance.diff_bisect(text1, text2, deadline);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of diff_linesToChars method, of class DiffMatch.
     */
    @Test
    public void testDiff_linesToChars() {
        System.out.println("diff_linesToChars");
        String text1 = "";
        String text2 = "";
        DiffMatch instance = new DiffMatch();
        LinesToCharsResult expResult = null;
        LinesToCharsResult result = instance.diff_linesToChars(text1, text2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of diff_charsToLines method, of class DiffMatch.
     */
    @Test
    public void testDiff_charsToLines() {
        System.out.println("diff_charsToLines");
        LinkedList<Diff> diffs = null;
        List<String> lineArray = null;
        DiffMatch instance = new DiffMatch();
        instance.diff_charsToLines(diffs, lineArray);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of diff_commonPrefix method, of class DiffMatch.
     */
    @Test
    public void testDiff_commonPrefix() {
        System.out.println("diff_commonPrefix");
        String text1 = "";
        String text2 = "";
        DiffMatch instance = new DiffMatch();
        int expResult = 0;
        int result = instance.diff_commonPrefix(text1, text2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of diff_commonSuffix method, of class DiffMatch.
     */
    @Test
    public void testDiff_commonSuffix() {
        System.out.println("diff_commonSuffix");
        String text1 = "";
        String text2 = "";
        DiffMatch instance = new DiffMatch();
        int expResult = 0;
        int result = instance.diff_commonSuffix(text1, text2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of diff_commonOverlap method, of class DiffMatch.
     */
    @Test
    public void testDiff_commonOverlap() {
        System.out.println("diff_commonOverlap");
        String text1 = "";
        String text2 = "";
        DiffMatch instance = new DiffMatch();
        int expResult = 0;
        int result = instance.diff_commonOverlap(text1, text2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of diff_halfMatch method, of class DiffMatch.
     */
    @Test
    public void testDiff_halfMatch() {
        System.out.println("diff_halfMatch");
        String text1 = "";
        String text2 = "";
        DiffMatch instance = new DiffMatch();
        String[] expResult = null;
        String[] result = instance.diff_halfMatch(text1, text2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of diff_cleanupSemantic method, of class DiffMatch.
     */
    @Test
    public void testDiff_cleanupSemantic() {
        System.out.println("diff_cleanupSemantic");
        LinkedList<Diff> diffs = null;
        DiffMatch instance = new DiffMatch();
        instance.diff_cleanupSemantic(diffs);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of diff_cleanupSemanticLossless method, of class DiffMatch.
     */
    @Test
    public void testDiff_cleanupSemanticLossless() {
        System.out.println("diff_cleanupSemanticLossless");
        LinkedList<Diff> diffs = null;
        DiffMatch instance = new DiffMatch();
        instance.diff_cleanupSemanticLossless(diffs);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of diff_cleanupEfficiency method, of class DiffMatch.
     */
    @Test
    public void testDiff_cleanupEfficiency() {
        System.out.println("diff_cleanupEfficiency");
        LinkedList<Diff> diffs = null;
        DiffMatch instance = new DiffMatch();
        instance.diff_cleanupEfficiency(diffs);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of diff_cleanupMerge method, of class DiffMatch.
     */
    @Test
    public void testDiff_cleanupMerge() {
        System.out.println("diff_cleanupMerge");
        LinkedList<Diff> diffs = null;
        DiffMatch instance = new DiffMatch();
        instance.diff_cleanupMerge(diffs);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of diff_xIndex method, of class DiffMatch.
     */
    @Test
    public void testDiff_xIndex() {
        System.out.println("diff_xIndex");
        LinkedList<Diff> diffs = null;
        int loc = 0;
        DiffMatch instance = new DiffMatch();
        int expResult = 0;
        int result = instance.diff_xIndex(diffs, loc);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of diff_prettyHtml method, of class DiffMatch.
     */
    @Test
    public void testDiff_prettyHtml() {
        System.out.println("diff_prettyHtml");
        LinkedList<Diff> diffs = null;
        DiffMatch instance = new DiffMatch();
        String expResult = "";
        String result = instance.diff_prettyHtml(diffs);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of diff_text1 method, of class DiffMatch.
     */
    @Test
    public void testDiff_text1() {
        System.out.println("diff_text1");
        LinkedList<Diff> diffs = null;
        DiffMatch instance = new DiffMatch();
        String expResult = "";
        String result = instance.diff_text1(diffs);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of diff_text2 method, of class DiffMatch.
     */
    @Test
    public void testDiff_text2() {
        System.out.println("diff_text2");
        LinkedList<Diff> diffs = null;
        DiffMatch instance = new DiffMatch();
        String expResult = "";
        String result = instance.diff_text2(diffs);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of diff_levenshtein method, of class DiffMatch.
     */
    @Test
    public void testDiff_levenshtein() {
        System.out.println("diff_levenshtein");
        LinkedList<Diff> diffs = null;
        DiffMatch instance = new DiffMatch();
        int expResult = 0;
        int result = instance.diff_levenshtein(diffs);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of diff_toDelta method, of class DiffMatch.
     */
    @Test
    public void testDiff_toDelta() {
        System.out.println("diff_toDelta");
        LinkedList<Diff> diffs = null;
        DiffMatch instance = new DiffMatch();
        String expResult = "";
        String result = instance.diff_toDelta(diffs);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of diff_fromDelta method, of class DiffMatch.
     */
    @Test
    public void testDiff_fromDelta() {
        System.out.println("diff_fromDelta");
        String text1 = "";
        String delta = "";
        DiffMatch instance = new DiffMatch();
        LinkedList expResult = null;
        LinkedList result = instance.diff_fromDelta(text1, delta);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of match_main method, of class DiffMatch.
     */
    @Test
    public void testMatch_main() {
        System.out.println("match_main");
        String text = "";
        String pattern = "";
        int loc = 0;
        DiffMatch instance = new DiffMatch();
        int expResult = 0;
        int result = instance.match_main(text, pattern, loc);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of match_bitap method, of class DiffMatch.
     */
    @Test
    public void testMatch_bitap() {
        System.out.println("match_bitap");
        String text = "";
        String pattern = "";
        int loc = 0;
        DiffMatch instance = new DiffMatch();
        int expResult = 0;
        int result = instance.match_bitap(text, pattern, loc);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of match_alphabet method, of class DiffMatch.
     */
    @Test
    public void testMatch_alphabet() {
        System.out.println("match_alphabet");
        String pattern = "";
        DiffMatch instance = new DiffMatch();
        Map expResult = null;
        Map result = instance.match_alphabet(pattern);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of patch_addContext method, of class DiffMatch.
     */
    @Test
    public void testPatch_addContext() {
        System.out.println("patch_addContext");
        Patch patch = null;
        String text = "";
        DiffMatch instance = new DiffMatch();
        instance.patch_addContext(patch, text);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of patch_make method, of class DiffMatch.
     */
    @Test
    public void testPatch_make_String_String() {
        System.out.println("patch_make");
        String text1 = "";
        String text2 = "";
        DiffMatch instance = new DiffMatch();
        LinkedList expResult = null;
        LinkedList result = instance.patch_make(text1, text2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of patch_make method, of class DiffMatch.
     */
    @Test
    public void testPatch_make_LinkedList() {
        System.out.println("patch_make");
        LinkedList<Diff> diffs = null;
        DiffMatch instance = new DiffMatch();
        LinkedList expResult = null;
        LinkedList result = instance.patch_make(diffs);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of patch_make method, of class DiffMatch.
     */
    @Test
    public void testPatch_make_3args() {
        System.out.println("patch_make");
        String text1 = "";
        String text2 = "";
        LinkedList<Diff> diffs = null;
        DiffMatch instance = new DiffMatch();
        LinkedList expResult = null;
        LinkedList result = instance.patch_make(text1, text2, diffs);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of patch_make method, of class DiffMatch.
     */
    @Test
    public void testPatch_make_String_LinkedList() {
        System.out.println("patch_make");
        String text1 = "";
        LinkedList<Diff> diffs = null;
        DiffMatch instance = new DiffMatch();
        LinkedList expResult = null;
        LinkedList result = instance.patch_make(text1, diffs);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of patch_deepCopy method, of class DiffMatch.
     */
    @Test
    public void testPatch_deepCopy() {
        System.out.println("patch_deepCopy");
        LinkedList<Patch> patches = null;
        DiffMatch instance = new DiffMatch();
        LinkedList expResult = null;
        LinkedList result = instance.patch_deepCopy(patches);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of patch_apply method, of class DiffMatch.
     */
    @Test
    public void testPatch_apply() {
        System.out.println("patch_apply");
        LinkedList<Patch> patches = null;
        String text = "";
        DiffMatch instance = new DiffMatch();
        Object[] expResult = null;
        Object[] result = instance.patch_apply(patches, text);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of patch_addPadding method, of class DiffMatch.
     */
    @Test
    public void testPatch_addPadding() {
        System.out.println("patch_addPadding");
        LinkedList<Patch> patches = null;
        DiffMatch instance = new DiffMatch();
        String expResult = "";
        String result = instance.patch_addPadding(patches);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of patch_splitMax method, of class DiffMatch.
     */
    @Test
    public void testPatch_splitMax() {
        System.out.println("patch_splitMax");
        LinkedList<Patch> patches = null;
        DiffMatch instance = new DiffMatch();
        instance.patch_splitMax(patches);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of patch_toText method, of class DiffMatch.
     */
    @Test
    public void testPatch_toText() {
        System.out.println("patch_toText");
        List<Patch> patches = null;
        DiffMatch instance = new DiffMatch();
        String expResult = "";
        String result = instance.patch_toText(patches);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of patch_fromText method, of class DiffMatch.
     */
    @Test
    public void testPatch_fromText() {
        System.out.println("patch_fromText");
        String textline = "";
        DiffMatch instance = new DiffMatch();
        List expResult = null;
        List result = instance.patch_fromText(textline);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
