import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnagramJava{
  public static void main(String[] args){
    System.out.println(checkAnagram("abcdef","fedazc"));
  }

  private static Boolean checkAnagram(String inp1, String inp2){

     Map<Character,Integer> anagramMap = new HashMap();

     updateMap(anagramMap,inp1,1);
     updateMap(anagramMap,inp2,-1);

     List<Integer> anagramValues = new ArrayList<Integer>(anagramMap.values());

     Boolean isAnagram = true;
     
     for(int i=0; i<anagramValues.size();i++){
        if(anagramValues.get(i) != 0) {isAnagram = false;break;}
     }
     return isAnagram;

  }

  private static void updateMap( Map<Character,Integer> anagramMap ,String inp,Integer changeFactor){
      for(int i=0; i <  inp.length();i++){
         Integer count = anagramMap.get(inp.charAt(i));
         if(count == null) count = 0;
         count += changeFactor;
         anagramMap.put(inp.charAt(i),count);
      }
  }
}