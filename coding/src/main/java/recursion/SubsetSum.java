package recursion;

public class SubsetSum {
    // Returns true if there is a subset of set[] with sum
    // equal to given sum
    static boolean isSubsetSum(int set[], int n, int sum,String ind)
    {
         System.out.println(n + " "+ sum + " " + ind );
        // Base Cases
        if (sum == 0)
            return true;
        if (n == 0 && sum != 0)
            return false;

        // If last element is greater than sum, then ignore it
        if (set[n-1] > sum)
            return isSubsetSum(set, n-1, sum, "exclude");

       /* else, check if sum can be obtained by any of the following
          (a) including the last element
          (b) excluding the last element   */
        boolean exclude =  isSubsetSum(set, n-1, sum,"exclude");
        boolean include =  isSubsetSum(set, n-1, sum-set[n-1],"include");

        return exclude || include;
    }
    /* Driver program to test above function */
    public static void main (String args[])
    {
        //int set[] = {3, 34, 4, 12, 5, 2};
        int set[] = {5,2,3,2,8};
        int sum = 9;
        int n = set.length;
        if (isSubsetSum(set, n, sum, " ") == true)
            System.out.println("Found a subset with given sum");
        else
            System.out.println("No subset with given sum");
    }
}
