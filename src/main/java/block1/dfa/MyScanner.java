package block1.dfa;


import java.util.LinkedList;
import java.util.List;

/**
 * Created by Sharbel on 20-4-2016.
 */
public class MyScanner implements Scanner {
    public List<String> scan(State dfa, String text){
        State initial = dfa;
        String temp = "";
        String acceptedword = "";
        int backtrackcount = 0;
        List<String> result = new LinkedList<>();
        for(int i = 0; i < text.length(); i++) {
            if (dfa.hasNext(text.charAt(i))) {
                temp += text.charAt(i);
                dfa = dfa.getNext(text.charAt(i));
            } else if (acceptedword.length() != 0){
                result.add(acceptedword);
                for(String s: result){
                    backtrackcount += s.length();
                }
                i = backtrackcount-1;
                backtrackcount = 0;
                acceptedword = "";
                temp = "";
                dfa = initial;
            }


            if(dfa.isAccepting()){
                acceptedword = temp;
                if(text.length() -1 == i){
                    result.add(acceptedword);
                    temp = "";
                    dfa = initial;
                }
            } else if(text.length() - 1 == i && acceptedword.length() != 0 ) {
                result.add(acceptedword);
                for(String s: result){
                    backtrackcount += s.length();
                }
                i = backtrackcount-1;
                backtrackcount = 0;
                acceptedword = "";
                temp = "";
                dfa = initial;

            }


        }
        return result;
    }

}

