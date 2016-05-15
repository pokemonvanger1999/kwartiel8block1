package block2.antlr;

import block2.*;
import org.antlr.v4.runtime.Lexer;

import block2.a.Sentence2;

public class SentenceConverter //
		extends SentenceBaseListener implements Parser {
	/** Factory needed to create terminals of the {@link Sentence2}
	 * grammar. See {@link block2.a.SentenceParser} for
	 * example usage. */
	private final SymbolFactory fact;

	public SentenceConverter() {
		this.fact = new SymbolFactory(Sentence2.class);
	}

	@Override
	public AST parse(Lexer lexer) throws ParseException {
		return null;// Fill in
	}
	
	// From here on overwrite the listener methods
	// Use an appropriate ParseTreeProperty to
	// store the correspondence from nodes to ASTs
}
