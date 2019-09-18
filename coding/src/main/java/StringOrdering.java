import java.util.HashSet;
import java.util.Set;

/*
Given an input string and ordering string, need to return true if the ordering string is present in Input string.

input = "hello world!"
ordering = "hlo!"
result = FALSE (all Ls are not before all Os)

input = "hello world!"
ordering = "!od"
result = FALSE (the input has '!' coming after 'o' and after 'd', but the pattern needs it to come before 'o' and 'd')

input = "hello world!"
ordering = "he!"
result = TRUE

input = "aaaabbbcccc"
ordering = "ac"
result = TRUE


 */
public class StringOrdering {
    public static void main(String[] args) {
        String input = "hello world";
        String orderStr = "hewrd";
        System.out.println(isOrdered(input, orderStr));
    }

    private static boolean isOrdered(String input, String orderStr) {
        Set<Character> badSet = new HashSet<>();
        for (int k = 2; k < orderStr.length(); k++) {
            badSet.add(orderStr.charAt(k));
        }
        Character first = orderStr.charAt(0);
        Character second = orderStr.charAt(1);
        int j = 2;
        int i = 0;
        for (; i < input.length(); i++) {
            if (badSet.contains(input.charAt(i))) return false;
            if (input.charAt(i) == second && j < orderStr.length()) {
                badSet.add(first);
                first = second;
                second = orderStr.charAt(j);
                badSet.remove(second);
                j++;

            }

        }

        if (j < orderStr.length() || i < input.length()) return false;

        return true;

    }

}