public class BalancePara {

      public static void main(String[] args){
  //  String input = "a(bc((d)e)(fg()hi";
    String input = "()(";
    String result = balanceParanthesis(input);
    System.out.println(result);
  }

  private static String balanceParanthesis(String inp){
    java.util.Stack<ParaIndex> paraStack = new java.util.Stack<ParaIndex>();

    StringBuilder result = new StringBuilder();
    for(int i=0;i<inp.length();i++){
      if(inp.charAt(i) == '(') {
          paraStack.push(new ParaIndex(inp.charAt(i) ,i));
      }else if(inp.charAt(i) == ')'){
         if(paraStack.peek().getPara() == '(') paraStack.pop();
         else paraStack.push(new ParaIndex(inp.charAt(i) ,i));
      }
      result.append(inp.charAt(i));
    }
    int offset =0 ;
    for(ParaIndex paraIndex : paraStack){
        result.deleteCharAt(paraIndex.getIndex()-offset);
        offset++;
    }
    return result.toString();

  }
}

class ParaIndex{
  Character para = null;
  Integer index = null;

  public ParaIndex(Character p, Integer i){
    para = p;
    index = i;
  }

  public Character getPara(){
    return para;
  }

  public void setPara(Character p){
    para = p;
  }

  public Integer getIndex(){
    return index;
  }

  public void setIndex(Integer ind){
    index = ind;
  }
}

