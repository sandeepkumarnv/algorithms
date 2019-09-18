package dynamic;

import java.util.ArrayList;

/*
https://www.youtube.com/watch?v=8LusJS5-AGo&t=12s

Find the items which can be selected such that weight is less than or equal to given weight and value is max

build dp matrix with 0 to max weight as columns and values corresponding to each items as rows
 - fill dp matrix as the max of (value without current weight and value with current weight)
 value without current weight => copy the same column from previous row
  value with current weight => This will be current weights value + value of remaining weight which can be retrieved from dp itself by doing dp[i-1][j-current weight]

Finding the items involved:
- go to bottom cornor of dp
  An item can be added to the result if
   - it is not derived from the previous row..
  traverse to reach an item which is involved ... then the next item to be checked will be dp[i-1][j-current weight]...
  keep on doing this until reach a cell with 0 value

 */

class Item{
    int weight;
    int value;
    public Item(int weight,int value){
        this.weight = weight;
        this.value = value;
    }
}
public class Knapsack {

    public static void main(String[] args){

        Item[] input = {
                new Item(1,1),
                new Item(3,4),
                new Item(4,5),
                new Item(5,7)};
        ArrayList<Item> result = knapSack(input,7);

        for(Item item:result){
            System.out.println(item.weight + " "+item.value);
        }

    }

    private static ArrayList<Item> knapSack(Item[] input,int maxWeight){
        int rows = input.length;
        int cols = maxWeight+1;
        int[][] dp = new int[rows][cols];
        for(int i=1; i<cols;i++){
            if(input[0].weight <= i) dp[0][i]=input[0].value;
        }

        for(int i=1 ; i < rows;i++){
            for(int j=1;j<cols;j++){
                if(input[i].weight > j)
                    dp[i][j]=dp[i-1][j];
                else{
                    int valueWithCurrent = input[i].value + dp[i-1][j-input[i].weight];
                    dp[i][j]=Math.max(valueWithCurrent,dp[i-1][j]);
                }
            }
        }

        System.out.println(dp[rows-1][cols-1]);
        ArrayList<Item> result = new ArrayList<Item>();
        int i = rows-1;
        int j= cols-1;
        while(i>0 && j > 0){
            while(i > 1 && dp[i][j] == dp[i-1][j]){
                i--;
            }
            result.add(input[i]);

            if(i <= 0) break;
            i = i--;
            j=j-input[i].weight;

        }
        return result;

    }
}
