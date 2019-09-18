/*
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
	For example,
	Given [100, 4, 200, 1, 3, 2],
	The longest consecutive elements sequence is [1, 2, 3, 4].
	Return its length: 4.
	Your algorithm should run in O(n) complexity.
 */

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSubSeq {

    public int longestConsecutive(int[] nums) {
        Map<Integer,Boolean> numMap = new HashMap<>(nums.length);
        loadNumMap(numMap,nums);
        int maxCount = 0;
        for(int numPrimitive : nums){
            Integer num = Integer.valueOf(numPrimitive);
            if(!numMap.get(num)){
                int forwardCount = counsecutiveCount(num,numMap,1);
                int backwardCount = counsecutiveCount(num,numMap,-1);
                int consecLength = forwardCount+backwardCount+1;
                if(consecLength > maxCount){
                        maxCount = consecLength;
                }
            }
        }

        return maxCount;
    }

    private int counsecutiveCount(Integer num,Map<Integer,Boolean> numMap,int changeFactor){
        int consecCount = 0;
        while(numMap.containsKey(num)){
            numMap.put(num,true);
            num += changeFactor;
            consecCount ++;
        }
        return consecCount-1;
    }

    private void loadNumMap(Map<Integer,Boolean> numMap,int[] nums){
        for(int num : nums){
            numMap.put(Integer.valueOf(num),false);
        }
    }
}
