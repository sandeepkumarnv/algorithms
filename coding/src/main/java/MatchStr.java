public class MatchStr {

    public static void main(String[] args){
        String pattern = "a(3)b(2)cd";
        String input = "aaabb";

        System.out.println(isMatchStr(input,pattern));

    }

    private static boolean isMatchStr(String input,String pattern){
        boolean matchFound = true;

        int i=0;
        int j=0;
        char lastCh = pattern.charAt(0);
        while(i < input.length()){
            if(pattern.charAt(j) >= 'a' &&  pattern.charAt(0) <= 'z'){
                lastCh = pattern.charAt(j) ;
            }
            if(input.charAt(i) == pattern.charAt(j)){
                i++;
                j++;
                continue;
            }
            else if(pattern.charAt(j) == '('){
                String subStr = pattern.substring(j+1);
                int endIndex =  subStr.indexOf(')');
                 String numStr = pattern.substring(j+1,j+endIndex+1);
                int num = Integer.parseInt(pattern.substring(j+1,j+endIndex+1));
                j += numStr.length()+2;
                while(num > 1){
                    if(input.charAt(i) == lastCh){
                        i++;
                        if(i >= input.length()) break;

                    }
                    num--;

                }
            }else{
                return false;
            }
        }

        return matchFound;
    }
}
