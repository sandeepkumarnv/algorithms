package dynamic;
/*
  Create dp with values corresponding to s1 at rows and s2 at columns.. values of dp denotes the max ppossible length oof a common subsequence at that point.
  https://www.youtube.com/watch?v=NnD96abizww
  initialize dp with 0 at  first row and columns


 */
public class LongestSubSequence {

    public static void main(String[] args){
        System.out.println(longestSubSequence("abcde","acfdef"));
    }

    private static String longestSubSequence(String s1, String s2){
        if(s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0) return "";

        int d[][] = new int[s1.length()+1][s2.length()+1];
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<= s1.length();i++){
            for(int j=1;j<= s2.length();j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    d[i][j] = d[i-1][j-1] +1;
                    sb.append(s1.charAt(i-1));
                }else{
                    d[i][j] = Math.max(d[i-1][j],d[i][j-1]);
                }
            }
        }

        System.out.println(d[s1.length()][s2.length()]);
        return sb.toString();
    }
}
