package recursion;

import java.util.ArrayList;

public class CoinNumberOfWays {

    public static void main(String[] args){
        int[] coins = {3,4,6,7,9};
        System.out.println(numberOfWays(coins,15,new ArrayList<>(),0));
    }

    public static int numberOfWays(int[] coins, int sum, ArrayList<Integer> resultList,int pos){

        if(sum == 0){
            for(Integer result : resultList){
                System.out.print("*"+result+"*");
            }
            System.out.println();
            return 1;
        }
        if(sum < 0) {
            return 0;

        }
        int count =0;
        for(int i=pos;i<coins.length;i++){
            resultList.add(coins[i]);
            int resultCount = numberOfWays(coins,sum-coins[i],resultList,i);
            resultList.remove(resultList.size()-1);
            count+= resultCount;
        }

        return count;
    }
}
