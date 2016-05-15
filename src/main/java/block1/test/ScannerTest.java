package block1.test;

import static block1.dfa.State.DFA_LALA;
import static block1.dfa.State.ID6_DFA;

import java.util.List;

import block1.dfa.MyScanner;
import org.junit.Assert;
import org.junit.Test;

import block1.dfa.Scanner;
import block1.dfa.State;

/** Test class for Scanner implementation. */
public class ScannerTest {
	private Scanner myGen = new MyScanner();

	@Test
	public void testID6() {
		this.dfa = ID6_DFA;
		yields("");
		yields("a12345", "a12345");
		yields("a12345AaBbCc", "a12345", "AaBbCc");
	}
	@Test
	public void DFA_LALA() {
		this.dfa = DFA_LALA;
		yields("LaLaLi", "LaLa");
		yields("LaLaLa", "LaLa", "La" );
		yields("LaaaaLaLaaaaLaaLi", "LaaaaLa", "LaaaaLaa");
		yields("Laaaa  Laaaaaaaaa   La  Li", "Laaaa  Laaaaaaaaa   La  Li");
	}

	private void yields(String word, String... tokens) {
		List<String> result = this.myGen.scan(this.dfa, word);
		if (result == null) {
			Assert.fail(String.format(
					"Word '%s' is erroneously rejected by %s", word, this.dfa));
		}
		Assert.assertEquals(tokens.length, result.size());
		for (int i = 0; i < tokens.length; i++) {
			Assert.assertEquals(tokens[i], result.get(i));
		}
	}

	private State dfa;
}
