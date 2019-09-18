package dynamic;

import java.util.HashSet;
import java.util.Set;

/*
 * Classical word break problem.. given a word "leetcode" and a dictionary {"leet","code"}.. check whether a prper sentence can be formed and if yes print it..
 */

public class WordBreak {

    public static void main(String[] args) {
        Set<String> dict = new HashSet<>();
     dict.add("leet");
        dict.add("code");
          dict.add("i");
            dict.add("am");
             dict.add("ama");
            dict.add("a");
        dict.add("ace");
        String input = "iamace";
        System.out.println(checkWord(input, dict));
         System.out.println(wordBreak(input, dict));
          System.out.println(wordBreakOptimized(input, dict));
    }
/*
  Solution from Geek code.. but this inolves iterating thru dictionary which is not efficient
 */
    public static boolean wordBreak(String s, Set<String> dict) {
        boolean[] t = new boolean[s.length() + 1];
        t[0] = true; //set first to be true, why?
        //Because we need initial state
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            //should continue from match position
            if (!t[i])
                continue;

            for (String a : dict) {
                int len = a.length();
                int end = i + len;
                if (end > s.length())
                    continue;

                if (t[end]) continue;

                if (s.substring(i, end).equals(a)) {
                    if(sb.length() != 0) sb.append(" ") ;
                    sb.append(a);
                    t[end] = true;
                }
            }
        }
        System.out.println(sb.toString());
        return t[s.length()];
    }
/*
  My enhanced solution which doesnt loop thru doctionary.. and uses only 1D array
 */
    public static boolean wordBreakOptimized(String s, Set<String> dict) {
        boolean[] t = new boolean[s.length() + 1];
        t[0] = true; //set first to be true, why?
        //Because we need initial state
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            //should continue from match position
            if (!t[i])
                continue;
            int incFactor = 1;
            while(incFactor < s.length()-i+1 ){
              //  System.out.println(s.substring(i,i+incFactor));
                if(dict.contains(s.substring(i,i+incFactor))) {
                     t[i+incFactor] = true;
                      if(sb.length() != 0) sb.append(" ") ;
                    sb.append(s.substring(i,i+incFactor));
                    break;
                }
                incFactor++;
            }

        }
        System.out.println(sb.toString());
        return t[s.length()];
    }
/*
 Using 2D approach... Thushar Roy's from youtube... create a boolean matrix n*n and t[0][n-1] will give the answer

 */
    private static boolean checkWord(String input, Set<String> dictionary) {
        boolean[][] t = new boolean[input.length()][input.length()];
         StringBuilder sb = new StringBuilder();
        int incFactor = 0;
        while (incFactor < input.length()) {
            for (int i = 0; i + incFactor < input.length(); i++) {
                String partialStr = input.substring(i, i + incFactor + 1);
                if (dictionary.contains(partialStr) || checkSplit(input, t, dictionary, i, i + incFactor)) {
                    if (dictionary.contains(partialStr)) {
                        if (sb.length() != 0) sb.append(" ");
                        sb.append(partialStr);
                    }
                    t[i][i + incFactor] = true;
                }

            }
            incFactor++;
        }

         System.out.println(sb.toString());
        return t[0][input.length() - 1];
    }

    private static boolean checkSplit(String partialStr, boolean[][] t, Set<String> dictionary, int start, int end) {
        boolean wordPresent = false;
        for (int i = start; i <= end; i++) {
            if (t[start][i] && t[i + 1][end]) {
                wordPresent = true;
                break;
            }
        }

        return wordPresent;
    }
}
