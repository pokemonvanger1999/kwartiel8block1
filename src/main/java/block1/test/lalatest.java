package block1.test;

import block1.lala;
import org.junit.Test;

/**
 * Created by Sharbel on 22-4-2016.
 */
public class lalatest {
    private static LexerTester tester = new LexerTester(lala.class);

    @Test
    public void succeedingTest() {
        tester.correct("Laaaa");
        tester.wrong("LaLaaaLi" );
        tester.correct("LaaaLaaaLaaaaLi" );
    }

    @Test
    public void spacesInKeywordTest() {
        // spaces in keywords are not in the rules
        tester.correct("Laaa Laaa    Laaaa  Li" );
    }

    @Test
    public void yieldCountTest() {
        tester.yields("LaLaLaLaLaLaLaLa", lala.EXPRESSION);
    }

    @Test
    public void noSpacesBetweenKeywordsTest() {
        // the following is perfectly fine, so claiming it's wrong will fail
        tester.yields("LaLaLaLaLaaaLi", lala.EXPRESSION);
    }
}
