/**
 * 
 */
package block2.a;

import block2.NonTerm;
import block2.SymbolFactory;
import block2.Term;

/**
 * Class containing some example grammars.
 * @author Arend Rensink
 *
 */
public class Grammars {
	/** Returns a grammar for simple English sentences. */
	public static Grammar makeSentence() {
		// Define the non-terminals
		NonTerm sent = new NonTerm("Sentence");
		NonTerm subj = new NonTerm("Subject");
		NonTerm obj = new NonTerm("Object");
		NonTerm mod = new NonTerm("Modifier");
		// Define the terminals, using the Sentence2.g4 lexer grammar
		SymbolFactory fact = new SymbolFactory(Sentence2.class);
		Term noun = fact.getTerminal(Sentence2.NOUN);
		Term verb = fact.getTerminal(Sentence2.VERB);
		Term adj = fact.getTerminal(Sentence2.ADJECTIVE);
		Term end = fact.getTerminal(Sentence2.ENDMARK);
		// Build the context free grammar
		Grammar g = new Grammar(sent);
		g.addRule(sent, subj, verb, obj, end);
		g.addRule(subj, noun);
		g.addRule(subj, mod, subj);
		g.addRule(obj, noun);
		g.addRule(obj, mod, obj);
		g.addRule(mod, adj);
		return g;
	}
}
