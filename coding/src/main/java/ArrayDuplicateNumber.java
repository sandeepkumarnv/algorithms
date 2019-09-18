public class ArrayDuplicateNumber {

    public static void main(String args[]){
        int[] input = {8,7,3,4,5,6,2,5,1};
        System.out.println(findDuplicate(input));
    }
    private static int findDuplicate(int[] nums) {
        if (nums != null && nums.length > 1) {
            int slow = nums[0];
            int fast = nums[nums[0]];

            while (slow != fast) {
                slow = nums[slow];
                fast = nums[nums[fast]];
            }

            fast = 0;
            while (fast != slow) {
                slow = nums[slow];
                fast = nums[fast];
            }

            return slow;
        }

        return -1;
    }
}
