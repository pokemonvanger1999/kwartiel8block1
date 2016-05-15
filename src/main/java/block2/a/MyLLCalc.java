package block2.a;

import block2.NonTerm;
import block2.Symbol;
import block2.Term;

import java.util.Map;
import java.util.Set;

/**
 * Created by Sharbel on 25-4-2016.
 */
public class MyLLCalc implements LLCalc{
    public MyLLCalc(Object o){

    }

    @Override
    public Map<Symbol, Set<Term>> getFirst() {
        return null;
    }

    @Override
    public Map<NonTerm, Set<Term>> getFollow() {
        return null;
    }

    @Override
    public Map<Rule, Set<Term>> getFirstp() {
        return null;
    }

    @Override
    public boolean isLL1() {
        return false;
    }
}
