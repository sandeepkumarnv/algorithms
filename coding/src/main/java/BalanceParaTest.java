import java.util.Stack;
public class BalanceParaTest{
    public static void main(String[] args){
        String input= "a()bc(def(((gh)ijk)))())(l";
        System.out.println(isBalancedOptimized(input));
    }

    private static boolean isBalanced(String input){
        Stack<Character> paraStack = new Stack<>();
        for(int i=0;i<input.length();i++){
            Character ch = Character.valueOf(input.charAt(i));
            if(ch == '('){
                paraStack.push(ch);
            }else if(ch == ')'){
                if(paraStack.isEmpty()) return false;
                paraStack.pop();
            }
        }

        if(paraStack.isEmpty()) return true ;
        else return false;

    }

    private static boolean isBalancedOptimized(String input){
        int count = 0;
        for(int i=0;i<input.length();i++){
            char ch = input.charAt(i);
            if(ch == '('){
                count++;
            }else if(ch == ')'){
                count--;
                if(count < 0) return false;
            }

        }

        if(count == 0) return true;
        else return false;
    }

}