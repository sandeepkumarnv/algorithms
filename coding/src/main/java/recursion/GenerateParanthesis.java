package recursion;

import java.util.ArrayList;
import java.util.List;

/*
Generate alla possible valid n matched paranthesis
if n=1 ()
 n=2 ()() (())

 */
public class GenerateParanthesis {

    public static void main(String[] args){
        int n=2;
        char[] str = new char[n*2];
        List<String> result = new ArrayList<String>();
        addParanthesis(result,n,n,str,0);

        for(String s : result){
            System.out.println(s);
        }
    }
    private static void addParanthesis(List<String> list,int leftRem, int rightRem, char[] chArray,int count){
        if(leftRem < 0 || rightRem < leftRem) return;
        if(leftRem ==0 && rightRem == 0){
            list.add(String.copyValueOf(chArray));
        }else{
            if(leftRem > 0){
                chArray[count] ='(';
                addParanthesis(list,leftRem-1,rightRem,chArray,count+1);
            }
            if(rightRem > leftRem){
                chArray[count] =')';
                addParanthesis(list,leftRem,rightRem-1,chArray,count+1);
            }
        }
    }
}
