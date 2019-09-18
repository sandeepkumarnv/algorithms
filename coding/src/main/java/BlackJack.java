import java.util.HashMap;

public class BlackJack {

    public static void main(String[] args){
        String input="AA81";
        HashMap<Character,Integer> blackjackMap = new HashMap<Character,Integer>();
        blackjackMap.put('J',10);
        blackjackMap.put('Q',11);
        blackjackMap.put('K',12);
        blackjackMap.put('A',10);
        int result =  findBlackJackValue(input,blackjackMap);
        System.out.println(result);
    }

    private static int findBlackJackValue(String input,HashMap<Character,Integer> blackjackMap){

        int sum = 0;
        int target = 21;
        int aCount=0;
        for(int i=0;i<input.length();i++){
            char ch = input.charAt(i);
            if(ch == 'K' || ch == 'Q' || ch == 'J' || ch == 'A'){
                sum +=blackjackMap.get(Character.valueOf(ch));
            }else{
                sum +=Character.getNumericValue(ch);
            }
            if(ch == 'A') aCount++;
        }

        if(sum >=21){
            while(aCount > 0){
                sum -=9;
                if(sum < 21) break;
                aCount--;
            }
        }

        return sum;
    }
}
