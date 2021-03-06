package block2.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import block2.NonTerm;
import block2.Symbol;
import block2.Term;
import block2.a.Grammar;
import block2.a.Grammars;
import block2.If;
import block2.Sentence2;
import block2.a.LLCalc;
import block2.a.Rule;

public class LLCalcTest {
	/** Tests the LL-calculator for the Sentence grammar. */
	@Test
	public void testSentenceOrig() {
		Grammar g = Grammars.makeSentence();
		// Without the last (recursive) rule, the grammar is LL-1
		assertTrue(createCalc(g).isLL1());
	}

	@Test
	public void testSentenceExtended() {
		Grammar g = Grammars.makeSentence();
		// Without the last (recursive) rule, the grammar is LL-1
		assertTrue(createCalc(g).isLL1());
		// Now add the last rule, causing the grammar to fail
		// Define the non-terminals
		NonTerm subj = g.getNonterminal("Subject");
		NonTerm obj = g.getNonterminal("Object");
		NonTerm sent = g.getNonterminal("Sentence");
		NonTerm mod = g.getNonterminal("Modifier");
		g.addRule(mod, mod, mod);
		// Define the terminals
		Term adj = g.getTerminal(Sentence2.ADJECTIVE);
		Term noun = g.getTerminal(Sentence2.NOUN);
		Term verb = g.getTerminal(Sentence2.VERB);
		Term end = g.getTerminal(Sentence2.ENDMARK);
		LLCalc calc = createCalc(g);
		// FIRST sets
		Map<Symbol, Set<Term>> first = calc.getFirst();
		assertEquals(set(adj, noun), first.get(sent));
		assertEquals(set(adj, noun), first.get(subj));
		assertEquals(set(adj, noun), first.get(obj));
		assertEquals(set(adj), first.get(mod));
		// FOLLOW sets
		Map<NonTerm, Set<Term>> follow = calc.getFollow();
		assertEquals(set(Symbol.EOF), follow.get(sent));
		assertEquals(set(verb), follow.get(subj));
		assertEquals(set(end), follow.get(obj));
		assertEquals(set(noun, adj), follow.get(mod));
		// FIRST+ sets: test per rule
		Map<Rule, Set<Term>> firstp = calc.getFirstp();
		List<Rule> subjRules = g.getRules(subj);
		assertEquals(set(noun), firstp.get(subjRules.get(0)));
		assertEquals(set(adj), firstp.get(subjRules.get(1)));
		// is-LL1-test
		assertFalse(calc.isLL1());
	}

	/** Creates an LL1-calculator for a given grammar. */
	private LLCalc createCalc(Grammar g) {
		return null;// your implementation of LLCalc (Ex. 2-CC.5)
	}

	@SuppressWarnings("unchecked")
	private <T> Set<T> set(T... elements) {
		return new HashSet<>(Arrays.asList(elements));
	}
}
