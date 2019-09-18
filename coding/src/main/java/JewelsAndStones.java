/*
You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.

The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".

Example 1:

Input: J = "aA", S = "aAAbbbb"
Output: 3
Example 2:

Input: J = "z", S = "ZZ"
Output: 0
Note:

S and J will consist of letters and have length at most 50.
The characters in J are distinct.
 */
public class JewelsAndStones {

    public static void main(String[] s){
        System.out.println(numJewelsInStones("ab","cabccabca"));
    }

    public static int numJewelsInStones(String J, String S) {
        if(J == null || J.trim().length() == 0 || S == null || S.trim().length() == 0){
            return 0;
        }
        int result = 0;
        boolean[] lookUp = new boolean[256];
        for(int i=0 ; i < J.length();i++){
            lookUp[J.charAt(i)] = true;
        }

        for(int j=0; j< S.length();j++){
            if(lookUp[S.charAt(j)]){
                result++;
            }
        }

        return result;
    }
}
