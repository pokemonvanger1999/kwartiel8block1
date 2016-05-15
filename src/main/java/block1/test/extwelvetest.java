package block1.test;

import block1.extwelve;
import org.junit.Test;

/**
 * Created by Sharbel on 22-4-2016.
 */
public class extwelvetest {
    private static LexerTester tester = new LexerTester(extwelve.class);

    @Test
    public void succeedingTest() {
        tester.correct("d12345");
        tester.correct("d12345dakjdk");
        tester.wrong("whiledo done");
    }

    @Test
    public void spacesInKeywordTest() {
        // spaces in keywords are not in the rules
        tester.wrong("a 12344");
    }

    @Test
    public void yieldCountTest() {
        tester.yields("a12345", extwelve.WORD);
    }

    @Test
    public void noSpacesBetweenKeywordsTest() {
        // the following is perfectly fine, so claiming it's wrong will fail
        tester.yields("a12345a12345", extwelve.WORD, extwelve.WORD);
    }
}
