import java.util.HashSet;
import java.util.Set;

public class StringRemoveDupsReverse{
  public static void main(String[] args){
      System.out.println(removeDups("aaaabbcdddccbbdaaee"));
  }
  private static String removeDups(String input){
    Set<Character> charSet = new HashSet<>();
    StringBuilder sb = new StringBuilder();
    for(int i=input.length()-1; i >= 0;i--){
        Character ch = input.charAt(i);
      if(!charSet.contains(ch)) {
           sb.append(ch);
          charSet.add(ch);
      }
    }


    return sb.toString();
  }
}