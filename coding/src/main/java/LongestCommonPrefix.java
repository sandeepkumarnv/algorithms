import java.util.HashMap;
import java.util.Map;

public class LongestCommonPrefix {

    public static void main(String[] args) {

        String[] input = {"abc", "abcdefg", "abcdef", "abcd"};
        System.out.print(longestCommonPrefixOptimum(input));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return null;
        StringBuilder sb = new StringBuilder("");
        int i = 0;
        boolean endNotReached = true;
        while (endNotReached) {
            char ch = 0;
            for (String str : strs) {
                if (i >= str.length() || (ch != 0 && str.charAt(i) != ch)) {

                    endNotReached = false;
                    break;
                }

                ch = str.charAt(i);

            }
            if (endNotReached && ch != 0) {
                sb.append(ch);
                i++;
            }
        }

        return sb.toString();
    }

    public static String longestCommonPrefixOptimum(String[] strs) {
    if(strs == null || strs.length == 0)    return "";
    String pre = strs[0];
    int i = 1;
    while(i < strs.length){
        while(strs[i].indexOf(pre) != 0)
            pre = pre.substring(0,pre.length()-1);
        i++;
    }
    return pre;
}
}
