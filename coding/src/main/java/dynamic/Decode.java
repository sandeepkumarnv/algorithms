package dynamic;

public class Decode {
    public static void main(String[] args){
       System.out.print(decodeWays("1224"));
    }

    private static int decodeWays(String numStr){
        if(numStr == null || numStr.length() ==0) return 0;

        int[] dp = new int[numStr.length()+1];
        dp[0]=1;
        for(int i = 1; i <= numStr.length();i++){
            int ones = Character.getNumericValue(numStr.charAt(i-1));
            int twos=0;
            if(i >1){
                twos= Integer.parseInt(numStr.substring(i-2,i));
            }
            dp[i]= dp[i-1];
            if(twos >=10 && twos <= 26) dp[i]++;
        }
        return dp[numStr.length()];

    }
}
