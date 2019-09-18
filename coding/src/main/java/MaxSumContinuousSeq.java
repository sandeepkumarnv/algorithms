public class MaxSumContinuousSeq {
    public static void main(String[] args){
        int[] input={-7,4,-2,5,3,-6,8,-9};
        //int[] input={-7,-4,-2,-5,-3,-6,-8,-9};
      //  Integer[]  resultList = findMaxSumCountOptimalKadane(input);

        findMaxSubArray(input);

//        for(Integer result : resultList){
//            if(result != null) System.out.println(result);
//        }
    }

    private static Integer[] findmMaxSumContinuousSubSeq(int[] input){
        Integer[] result = new Integer[input.length];
        result[0] = input[0];
        int sum =input[0];
        int j=0;
        for(int i=1;i<input.length;i++){
            if(input[i] > input[j] && input[i] < 0){
                result[j] = null;
                sum = sum -input[j];
                j++;
            }
            sum = sum+input[i];
            result[i] = input[i];
        }

        System.out.println("Sum is : "+sum);

        return result;
    }

    private static Integer[] findMaxSumCountOptimalKadane(int[] input){
        Integer[] result = new Integer[input.length];
        int size = input.length;
        int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;
        int max_start_index = 0;
        int startIndex = 0;
        int max_end_index = -1;
        for (int i = 0; i < size; i++)
        {

            if(0 > max_ending_here +input[i]) {
                startIndex = i+1;
                max_ending_here = 0;
            }
            else {
                max_ending_here += input[i];
            }

            if(max_ending_here > max_so_far) {
                max_so_far = max_ending_here;
                max_start_index = startIndex;
                max_end_index = i;
            }

        }
         System.out.println("max: "+ max_so_far+ " startIndex: "+startIndex+" endIndex: "+max_end_index+1);
        return result;
    }

    public static void findMaxSubArray(int[] inputArray){

        int maxStartIndex=0;
        int maxEndIndex=0;
        int maxSum = Integer.MIN_VALUE;

        int cumulativeSum= 0;
        int maxStartIndexUntilNow=0;

        for (int currentIndex = 0; currentIndex < inputArray.length; currentIndex++) {

            int eachArrayItem = inputArray[currentIndex];

            cumulativeSum+=eachArrayItem;

            if(cumulativeSum>maxSum){
                maxSum = cumulativeSum;
                maxStartIndex=maxStartIndexUntilNow;
                maxEndIndex = currentIndex;
            }
            else if (cumulativeSum<0){
                maxStartIndexUntilNow=currentIndex+1;
                cumulativeSum=0;
            }
        }

        System.out.println("Max sum         : "+maxSum);
        System.out.println("Max start index : "+maxStartIndex);
        System.out.println("Max end index   : "+maxEndIndex);
    }
}

