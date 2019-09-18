package dynamic;

class StringDistance{

    public static void main(String[] args){
        String input1 = "horse";
        String input2 = "ros";
        System.out.println(isAtOneDistance(input1,input2));
    }

    private static boolean isAtOneDistance(String input1,String input2){
        int l1 = input1.length();
        int l2 = input2.length();

        int[][] dp = new int[l1+1][l2+1];

        for(int i=0;i<=l1;i++){
            dp[i][0] = i;
        }

        for(int i=0;i<=l2;i++){
            dp[0][i] = i;
        }

        for(int i=1;i<=l1;i++){
            for(int j=1;j<=l2;j++){
                if(input1.charAt(i-1) == input2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = 1+ Math.min(Math.min(dp[i-1][j],dp[i-1][j-1]),dp[i][j-1]);
                }
            }
        }

        System.out.println(dp[l1][l2]);
        if(dp[l1][l2] > 1) return false;
        else return true;
    }

}