package trie;
import java.util.*;
class TrieTest{

    Map<Character,TrieTest> children = new HashMap<>();
    boolean isCompleted = false;

    public void addString(String str){
        addToTrie(str,0);
    }


    public void addToTrie(String str,int index){
        if(index >= str.length()){
            isCompleted = true;
            return;
        }

        TrieTest node = children.get(str.charAt(index));
        if(node == null){
            node = new TrieTest();
            children.put(str.charAt(index),node);
        }
        node.addToTrie(str,index+1);

    }

    public boolean parse(String parseStr){
        if(parseStr.isEmpty()){
            if(this.isCompleted)  return true;
            else return false;
        }
        if(parseStr.charAt(0) != '?' && children.get(parseStr.charAt(0)) == null){
            return false;
        }else{
            if(parseStr.charAt(0) == '?'){
                for(Character key : children.keySet()){
                    if(children.get(key).parse(parseStr.substring(1))){
                        return true;
                    }
                }

            }else {
                return children.get(parseStr.charAt(0)).parse(parseStr.substring(1));
            }
        }
        return false;
    }

    public static void main(String[] args){
        TrieTest trie = new TrieTest();
        String[] inputStr={"mat","pat","cat","sat","hello","an"};
        for(String input : inputStr){
            trie.addString(input);
        }
        System.out.println(trie.parse("??"));
    }

}