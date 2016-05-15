package block1.test;

import block1.pli;
import org.junit.Test;

/**
 * Created by Sharbel on 22-4-2016.
 */
public class plitest {
    private static LexerTester tester = new LexerTester(pli.class);

    @Test
    public void succeedingTest() {
        tester.correct("\"abc\"");
        tester.wrong("\" bla bla \" \" " );
        tester.correct("\" bla bla \"\" \"" );
    }

    @Test
    public void spacesInKeywordTest() {
        // spaces in keywords are not in the rules
        tester.correct("\" bla bla         \"\" \"" );
    }

    @Test
    public void yieldCountTest() {
        tester.yields("\" hoii \"", pli.WORD);
    }

    @Test
    public void noSpacesBetweenKeywordsTest() {
        // the following is perfectly fine, so claiming it's wrong will fail
        tester.yields("\" hoii \"\" hoii \"", pli.WORD);
    }
}
