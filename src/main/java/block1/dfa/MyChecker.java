package block1.dfa;

/**
 * Created by Sharbel on 20-4-2016.
 */
public class MyChecker implements Checker {

    public boolean accepts(State start, String word){
        boolean result = false;
        if(word.length() > 0 && start.hasNext(word.charAt(0))){
            result = accepts(start.getNext(word.charAt(0)), word.substring(1));
        }
        if(start.isAccepting() && word.length() == 0){
            result = true;
        }
        return result;
    }
}
