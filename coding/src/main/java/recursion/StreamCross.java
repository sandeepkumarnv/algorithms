package recursion;

public class StreamCross {

    public static void main(String[] args){
        int[] input = {1,0,1,0,0,0,0,1};
        //System.out.println(streamCross(input,1,0));
        System.out.println(crossStream(input,1,0));
    }

    public static boolean crossStream(int[] input,int k, int start){
        if(start >= input.length || input[start] == 0) return false;
        if(start == input.length-1) return true;
        k = k*2;
        boolean result = false;
        for(int i=1;i<= k;i++){
            result = crossStream(input,i,start+i);
            if(result) break;
        }
        return result;
    }
}
