package recursion;
import java.util.*;
public class NestedIntegerTest {

    /**
     * Given a nested list of integers, returns the sum of all integers in the list weighted by their reversed depth.
     * For example, given the list {{1,1},2,{1,1}} the deepest level is 2. Thus the function should return 8 (four 1's with weight 1, one 2 with weight 2)
     * Given the list {1,{4,{6}}} the function should return 17 (one 1 with weight 3, one 4 with weight 2, and one 6 with weight 1)
     * <p>
     * <p>
     * {1, {4,{6}}, {1, {2, {4}}}}
     * <p>
     * 1
     * 4 1
     * 6 2
     * 4
     */
    public int reverseDepthSum(List<NestedInteger> input) {
        return reverseDepthSumWithWeight(input, 0);
    }

    public int reverseDepthSumWithWeight(List<NestedInteger> input, int weight) {
        int sum = 0;
        for (NestedInteger nestedInt : input) {
            if (!nestedInt.isInteger()) {
                sum = sum + weight * reverseDepthSumWithWeight(nestedInt.getList(), getCurrentWeight(input,  weight));
            } else {
                sum = sum + weight * nestedInt.getInteger();
            }
        }
        return sum;
    }

    public int getCurrentWeight(List<NestedInteger> input, int weight){
        return 1;
    }
}
/**
 * This is the interface that represents nested lists.
 * You should not implement it, or speculate about its implementation.
 */
 interface NestedInteger
{
    /** @return true if this NestedInteger holds a single integer, rather than a nested list */
    boolean isInteger();

    /** @return the single integer that this NestedInteger holds, if it holds a single integer
     * Return null if this NestedInteger holds a nested list */
    Integer getInteger();

    /** @return the nested list that this NestedInteger holds, if it holds a nested list
     * Return null if this NestedInteger holds a single integer */
    List<NestedInteger> getList();
}

