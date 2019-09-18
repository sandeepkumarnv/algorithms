package trie;

import java.util.HashMap;
import java.util.Map;

public class TrieNodeOperations{

  public static void main(String[] args){
    String[] input = {"cat","cattle","camel","bat","battle","bath","ball","box"};
    TrieNode trie = new TrieNode();
    for(String str : input){
      trie.addString(str);
    }

    System.out.println(trie.parse("cat"));


    System.out.println("end");
  }

}
class TrieNode{
  Map<Character,TrieNode> children = new HashMap<>();
  boolean isCompleteWord = false;

  public void addString(String str){
    addString(str,0);
  }

  private void addString(String str, int index){
    if(index == str.length()) {this.isCompleteWord=true; return;}
    TrieNode node = children.get(str.charAt(index));
    if(node == null){
        node = new TrieNode();
       this.children.put(str.charAt(index),node);
    }
    node.addString(str,index+1);

  }

  public String parse(String str){
    if(str.equals("")) return "";
    TrieNode node = children.get(str.charAt(0));
    String out = "";
    if(node != null) out = str.charAt(0) + node.parse(str.substring(1));
    return out;
  }
}