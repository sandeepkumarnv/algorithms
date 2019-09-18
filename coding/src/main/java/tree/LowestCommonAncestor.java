package tree;

class Node{
    int data;
    Node left;
    Node right;
}
public class LowestCommonAncestor {

    private static Node lcaBinary(Node node , Node n1,Node n2){
        if(node == null) return null;
        if(node == n1 || node ==n2) return node;
        Node nodeLeft = lcaBinary(node.left,n1,n2);
        Node nodeRight = lcaBinary(node.right,n1,n2);
        Node resultNode = null;
        if(nodeLeft !=null && nodeRight != null ) resultNode = node;
        else if(nodeLeft == null && nodeRight != null) resultNode = nodeRight;
        else if(nodeLeft != null && nodeRight == null) resultNode = nodeLeft;

        return resultNode;
    }

    private static Node lcaBst(Node node , Node node1,Node node2){
        if(node == null) return null;
        if(node1 == null || node2 == null) return null;

        if(node.data > node1.data && node.data > node2.data) return lcaBst(node.left,node1,node2);
        else if(node.data < node1.data && node.data < node2.data) return lcaBst(node.right,node1,node2);
        else return node;
    }


}

