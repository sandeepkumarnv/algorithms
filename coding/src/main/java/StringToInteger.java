public class StringToInteger {

    public static void main(String[] args){
        System.out.println(stringToInt("1234"));
    }

    private static int stringToInt(String str){
        int result =  0;
        boolean isNegative = false;
        for(int i=0 ;i < str.length();i++){
            if(str.charAt(i) == '-') {
                isNegative = true;
                continue;
            }
            result = result*10 + str.charAt(i)-'0';
        }
        if(isNegative) result = 0-result;
        return result;
    }

}


