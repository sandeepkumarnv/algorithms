/*
Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321
The input is assumed to be a 32-bit signed integer. Your function should return 0 when the reversed integer overflows.


 */
public class ReverseInteger {

    public static void main(String[] args){
        int input = -1234;
        System.out.println(reverse(-1234));
    }

    public static int reverse(int x) {
        int result = 0;
        while(x != 0){
            int newResult = result*10 + x%10;
            if((newResult-x%10)/10 != result) return 0;
            result = newResult;
            x= x/10;
        }
        return result;
    }


}
