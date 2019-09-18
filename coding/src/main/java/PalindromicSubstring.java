import java.util.ArrayList;
import java.util.List;

public class PalindromicSubstring {

    public static void main(String[] args){
        String input = "aacbbcaab";
        List<String> result = findPalindromes(input);
        for(String subStr : result){
            System.out.println(subStr);
        }

          System.out.println(longestPalindrome(input));

    }


  public static List<String> findPalindromes(String input){
     List<String> palindromes = new ArrayList<>();
     for(int i=0 ; i < input.length();i++){
         findPalindromeSubStr(input,i,i,palindromes);
         findPalindromeSubStr(input,i,i+1,palindromes);
     }
     return palindromes;
  }

  private static void findPalindromeSubStr(String s,int left, int right,List<String>  palindromes){
    while(left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)){
      palindromes.add(s.substring(left,right+1));
      left--;
      right++;

    }
  }


  public static String longestPalindrome(String s) {
        if(s == null || s.length() == 0) return null;
        String longestPalindrome = null;

        for(int i=0 ; i<s.length() ; i++){
            longestPalindrome = longestPalindromeSubStr(s,i,i,longestPalindrome);
            longestPalindrome = longestPalindromeSubStr(s,i,i+1,longestPalindrome);

        }

        return longestPalindrome;
    }

    private static String longestPalindromeSubStr(String s,int left,int right,String longestPalindrome){

        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;

        }

        if(longestPalindrome == null || right-left-1 > longestPalindrome.length()){
                longestPalindrome = s.substring(left+1,right);
         }
        return longestPalindrome;
    }

}
