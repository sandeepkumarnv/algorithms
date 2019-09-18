import java.util.HashMap;
import java.util.Map;
/*
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,

Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4].
Return its length: 4.

Your algorithm should run in O(n) complexity.
 */
public class LongestConsecutiveSeq{
  public static void main(String[] args){
    Integer[] inputArray = { 100,4,200,1,3,2,5,102,106,103,104,105,101};
    System.out.println(findLongCosecutiveLength(inputArray));
  }

  private static int findLongCosecutiveLength(Integer[] inpArray){
    int maxLength =0;

    Map<Integer,Boolean> numberVisitedMap = createNumMap(inpArray);

    for(Integer inp : inpArray){
      int len = 0;
      len += consecutiveNumlength(inp,numberVisitedMap,1);
      len += consecutiveNumlength(inp,numberVisitedMap,-1);
      if(len > maxLength) maxLength = len;
    }
    return maxLength;
  }

  private static int consecutiveNumlength(Integer inp,Map<Integer,Boolean> numberVisitedMap,int factor){
    int length = 0;
    if(factor == 1){
      inp++;
    }
    while(numberVisitedMap.containsKey(inp) && !numberVisitedMap.get(inp)){
      numberVisitedMap.put(inp,true);
      inp += factor;
      length ++;
    }

    return length;
  }

  private static  Map<Integer,Boolean> createNumMap(Integer[] inpArray){
    Map<Integer,Boolean> numberVisitedMap = new HashMap<>();
    for(Integer inp : inpArray){
      numberVisitedMap.put(inp,false);
    }

    return numberVisitedMap;
  }
}