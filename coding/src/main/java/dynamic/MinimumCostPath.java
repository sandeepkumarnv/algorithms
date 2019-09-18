package dynamic;

import java.util.ArrayList;

public class MinimumCostPath {

    public static void main(String[] args){
        int[][] input = {{1,3,5,8},
                {4,2,1,7},
                {4,3,2,3}};
        ArrayList<Integer> pathList = minimumCostPath(input);
        for(Integer path :pathList){
            System.out.println(path);
        }
    }

    private static ArrayList<Integer> minimumCostPath(int[][] input){
        int[][] dp = new int[input.length][input[0].length];
        dp[0][0] = input[0][0];
        for(int i=1;i<input[0].length;i++){
            dp[0][i]=dp[0][i-1]+input[0][i];
        }
        for(int i=1;i<input.length;i++){
            dp[i][0]=dp[i-1][0]+input[i][0];
        }

        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(input[0][0]);
        for(int i=1;i<input.length;i++){
            for(int j=1;j<input[0].length;j++){
                int min = Math.min(dp[i-1][j],dp[i][j-1]);
                dp[i][j] = min+input[i][j];
            }
        }
        int i=0;
        int j=0;
        while(i<input.length-1 && j< input[0].length-1){
            if(dp[i][j+1] < dp[i+1][j]){

                result.add(input[i][j+1]);
                j++;

            }else{

                result.add(input[i+1][j]);
                i++;
            }

        }

        result.add(input[input.length-1][input[0].length-1]);

        System.out.println("minimum cost path is : "+dp[input.length-1][input[0].length-1]);
        return result;
    }
}
