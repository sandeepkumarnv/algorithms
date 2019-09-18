package dynamic;

public class MinimumDenomination {

    public int[] minDenomination(int[] denominations, int target){
        int[] dp = new int[target+1];
        int[] sourceIndex = new int[target+1];

        for(int i=1;i<target+1;i++) dp[i] = Integer.MAX_VALUE;
        for(int i=0;i<target+1;i++) dp[i] = -1;
        dp[0] = 0;
        for(int i=0;i<denominations.length;i++){
            for(int j=0; j < target+1;j++){
                dp[j] = Math.min(dp[j],1+dp[j-denominations[i]]);
                if(dp[j] > 1+dp[j-denominations[i]]) sourceIndex[j] = i;
            }
        }


      return dp;

    }
}
