package dynamic;

import java.util.ArrayList;

public class MaximumNonAdjacentSum {

   public static void main(String[] args){
       int[] input={4,1,1,4,2,1};
       ArrayList<Integer> result = maxNonAdjacentSum(input);

       for(Integer value : result){
           System.out.println(value);
       }

   }
    private static ArrayList<Integer> maxNonAdjacentSum(int[] input){
        int incl = input[0];
        int excl = 0;
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=1 ; i < input.length;i++){
            int temp = incl;
            if(excl+input[i] > incl) result.add(input[i]);
            incl= Math.max(excl+input[i],incl);

            excl=temp;

        }

        System.out.println("non adj sum is : " + Math.max(incl,excl));

        return result;

    }

}


