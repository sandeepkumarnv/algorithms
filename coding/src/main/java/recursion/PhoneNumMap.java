package recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneNumMap{
   static Map<Character,String> phoneMap = createMap();
   public static void main(String[] args){
      String input = "1234";
      List<String> resultList = mapPhoneNumber(input);


      for(String item : resultList){
        System.out.println(item);
      }

   }

   private static List<String>  mapPhoneNumber(String input){
      if(input.isEmpty()) {
          List<String> blankList = new ArrayList<String>();
          blankList.add("");
          return blankList;
      }

      List<String>  resultList = mapPhoneNumber(input.substring(1));
      String mappedString = phoneMap.get(input.charAt(0));

      List<String> updatedResult = new ArrayList<String>();
      for(String item :resultList){
       for(int j=0;j<mappedString.length();j++){
          updatedResult.add(mappedString.charAt(j)+item);
       }

      }

      return updatedResult;


   }

   private static Map<Character,String> createMap(){
       Map<Character,String> phoneMap =  new HashMap<Character,String>();
       phoneMap.put('0',"abc");
       phoneMap.put('1',"def");
       phoneMap.put('2',"ghi");
       phoneMap.put('3',"jkl");
       phoneMap.put('4',"mno");
       phoneMap.put('5',"pqr");
       phoneMap.put('6',"stu");
       phoneMap.put('7',"vwx");
        phoneMap.put('8',"yz");
       return phoneMap;
   }

}