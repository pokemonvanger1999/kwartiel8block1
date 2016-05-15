/**
 * 
 */
package block2.a;

import java.util.Arrays;
import java.util.List;

import block2.NonTerm;
import block2.Symbol;

/**
 * Rule in a grammar.
 * A rule consists of a left hand side (LHS, a {@link NonTerm}) 
 * and a right hand side (RHS, a string of {@link Symbol}s).
 * @author Arend Rensink
 */
public class Rule {
	/** Constructs a rule from a given lhs and rhs. */
	public Rule(NonTerm lhs, List<Symbol> rhs) {
		this.lhs = lhs;
		this.rhs = rhs;
	}

	/** Constructs a rule from a given lhs and rhs. */
	public Rule(NonTerm lhs, Symbol... rhs) {
		this(lhs, Arrays.asList(rhs));
	}

	/** Returns the LHS of this rule. */
	public NonTerm getLHS() {
		return this.lhs;
	}
	private final NonTerm lhs;

	/** Returns the right hand side of this rule. */
	public List<Symbol> getRHS() {
		return this.rhs;
	}
	private final List<Symbol> rhs;

	@Override
	public String toString() {
		return this.lhs.getName() + "->" + this.rhs;
	}
}
