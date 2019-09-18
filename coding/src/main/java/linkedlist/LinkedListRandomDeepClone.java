/*
1 -> 2 -> 3 -> 4
1.r -> 3
4.r -> 2
3.r -> 1
2.r -> 1

1p -> 2p -> 3p
1p.r -> 3p
 */

package linkedlist;

import java.util.HashMap;
import java.util.Map;

public class LinkedListRandomDeepClone {

    public LinkNode cloneList(LinkNode head) {
        Map<LinkNode, LinkNode> cloneMap = new HashMap<LinkNode,LinkNode>();
        LinkNode current = head;
        LinkNode resultHead = null;
        while (current != null) {
            LinkNode clonedNode = cloneNode(cloneMap,current);
            LinkNode clonedNext = cloneNode(cloneMap,current.n);
            LinkNode clonedRandom = cloneNode(cloneMap,current.r);
            clonedNode.r = clonedRandom;
            clonedNode.n = clonedNext;
            if(current == head) resultHead = clonedNode;
            current = current.n;
        }

      return resultHead;
    }
    private LinkNode cloneNode(Map<LinkNode, LinkNode> cloneMap,LinkNode node){
        LinkNode clonedNode = cloneMap.get(node);
            if (clonedNode == null) {
                clonedNode = new LinkNode();
                clonedNode.data = node.data;
            }
            cloneMap.put(node, clonedNode);

            return clonedNode;
    }
}
class LinkNode{
    int data;
    linkedlist.LinkNode r;
    linkedlist.LinkNode n;
}



