public class RansomNote{
    public static void main(String[] args){
        String input= "aabc";
        String magazine = "aabbbbaaaddewqcss";
        System.out.println(isRansomPossible(input,magazine));
    }

    private static boolean isRansomPossible(String input, String magazine){

        int[] charMap = new int[26];
        for(int i=0;i<magazine.length();i++){
            char ch = magazine.charAt(i);
            charMap[ch-'a']++;
        }

        for(int i=0;i<input.length();i++){
            char ch = input.charAt(i);
            if(--charMap[ch-'a'] <0){
                return false;
            }
        }

        return true;
    }
}