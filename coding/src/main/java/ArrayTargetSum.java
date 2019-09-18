import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class ArrayTargetSum {

    public static void main(String[] args){
        Integer[] a = {1,2,3,3};
        Integer[] b = {2,3,3,4};
        Integer[] c = {1,2,2,2};
        int target =7 ;
        List<Integer[]> result = arraySumTarget(a,b,c,target);
        for(Integer[] intArray : result){
            for(Integer num : intArray){
                System.out.print(num+ " ");
            }
            System.out.println();
        }
    }

    private static List<Integer[]> arraySumTarget(Integer[] a, Integer[] b, Integer[] c, int target) {
        List<Integer[]> result = new ArrayList<>();
        Map<Integer, List<Integer>> numMap = new HashMap();
        for (int i = 0; i < c.length; i++) {
            List<Integer> inedexList = numMap.get(c[i]);
            if (inedexList == null) {
                inedexList = new ArrayList<Integer>();
            }
            inedexList.add(i);
            numMap.put(c[i], inedexList);
        }


        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                int sum = a[i] + b[j];
                List<Integer> inedexList = numMap.get(target - sum);
                int k = 0;
                while (inedexList != null && k < inedexList.size()) {
                    Integer[] intArray = new Integer[3];
                    intArray[0] = a[i];
                    intArray[1] = b[j];
                    intArray[2] = c[inedexList.get(k)];
                    result.add(intArray);
                    k++;

                }

            }
        }

        return result;


    }


    private static List<Integer[]> arraySumTargetBinarySearch(Integer[] a, Integer[] b, Integer[] c, int target) {
        List<Integer[]> result = new ArrayList<>();

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                int numberTobeSearched  = target - a[i] - b[j];
                List<Integer> inedexList = binarySearchIndices(numberTobeSearched,c);
                int k = 0;
                while (inedexList != null && k < inedexList.size()) {
                    Integer[] intArray = new Integer[3];
                    intArray[0] = a[i];
                    intArray[1] = b[j];
                    intArray[2] = c[inedexList.get(k)];
                    result.add(intArray);
                    k++;

                }

            }
        }

        return result;


    }
    private static List<Integer> binarySearchIndices(int numberTobeSearched,Integer[] c){
        List<Integer>  intList = new ArrayList<Integer>();
        int end = c.length-1;
        int start =0;
        while(start < end){
            int mid = (start+end)/2;
            if(numberTobeSearched == c[mid]){
                int i = mid;
                while(i < c.length && c[i] ==  numberTobeSearched){
                    intList.add(i);
                    i++;
                }
                i = mid-1;
                while(i > 0 && c[i] ==  numberTobeSearched){
                    intList.add(i);
                    i--;
                }
            }else if(c[mid] > numberTobeSearched){
               end = mid;
            }else {
                start = mid;
            }
        }


        return intList;

    }
}
