public class BinarySearch {

    public static void main(String[] args){
        Integer[] input = {2,5,7,9,10,15,20};
        int n = 11;
        System.out.println(binarySearch(input,n));
        System.out.println(binarySearchRec(input,n,0,input.length-1));
    }

    private static boolean binarySearch(Integer[] input, int n){
        int start = 0;
        int end = input.length-1;
        while(start <= end){
            int mid = (start+end)/2;
            if(input[mid] == n){
                return true;
            }else if(input[mid] > n){
                end = mid-1;
            }else {
                start = mid+1;
            }
        }
        return false;
    }

    private static boolean binarySearchRec(Integer[] input,int n,int start,int end){
        if(start > end) return false;
        int mid= (start+end)/2;
        if(input[mid] == n) return true;
        else if(input[mid] > n) return  binarySearchRec(input,n,start,mid-1);
        else  return binarySearchRec(input,n,mid+1,end);
     }
}
