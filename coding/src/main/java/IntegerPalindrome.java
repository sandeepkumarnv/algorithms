public class IntegerPalindrome {

    public static void main(String[] arg){
        System.out.println(isPalindrome1(121));
    }
    public static boolean isPalindrome1(int x) {
        if(x < 0 || (x != 0 && x%10 ==0)) return false;
        int reverse = 0;
        int len = 0 ;
        while(x > reverse){
            reverse =  reverse*10 + x%10;
            x=x/10;
            len ++;
        }

        return (reverse== x || reverse/10 == x);
    }

    public static boolean isPalindrome(int x) {
    if (x<0 || (x!=0 && x%10==0)) return false;
    int rev = 0;
    while (x>rev){
    	rev = rev*10 + x%10;
    	x = x/10;
    }
    return (x==rev || x==rev/10);
}
}
