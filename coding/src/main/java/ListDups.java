import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ListDups{

  public static void main(String[] args){
    Integer[] input1 = {1,2,3,4,5,6};
    Integer[] input2 = {10,11,3,5,13,16};

    ArrayList<Integer> result = findComonElements(input1,input2);

    for(int i=0;i<result.size();i++){
      System.out.println(result.get(i));
    }

  }

  private static ArrayList<Integer> findComonElements(Integer[] input1, Integer[] input2){
    Set<Integer> numSet = new HashSet<>();
    ArrayList<Integer> result = new ArrayList<Integer>();
    for(int i=0;i<input1.length;i++){
      numSet.add(input1[i]);
    }

     for(int i=0;i<input2.length;i++){
       if(numSet.contains(input2[i])) result.add(input2[i]);
    }

    return result;

  }
}
