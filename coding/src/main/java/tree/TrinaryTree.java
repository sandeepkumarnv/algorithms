package tree;


class TNode{
    int data;
    TNode left;
    TNode middle;
    TNode right;
    public TNode(int data){
        this.data = data;
    }
}
public class TrinaryTree {

    public TNode insertTernary(TNode node , int value){
        TNode newNode = new TNode(value);
        if(node == null){
            node =  newNode;
        }else{
            insert(node,newNode);
        }
        return node;
    }

    private void insert(TNode node, TNode newNode){
        if(node.data == newNode.data){
            if(node.right == null) node.middle = newNode;
            else insert(node.middle,newNode);

        }else if(node.data > newNode.data){
            if(node.left == null) node.left = newNode;
            else insert(node.left,newNode);
        }else{
            if(node.right == null) node.right = newNode;
            else insert(node.right,newNode);
        }
    }

    public TNode find(int value, TNode node){
        if(node == null) return null;
        if(node.data == value) return node;
        else if(node.data > value) return find(value,node.left);
        else return find(value,node.right);
    }


    public void delete(int value, TNode parent, TNode node, boolean isLeft){
        if(node.data == value){
            if(node.left == null && node.right == null){
                if(isLeft) parent.left = null;
                else parent.right = null;
            } else if(node.left == null){
                if(isLeft) parent.left = node.right;
                else parent.right = node.right;
            }else if(node.right == null){
                if(isLeft) parent.left = node.left;
                else parent.right = node.left;
            }else{
                TNode minNode = findMinumum(node.right);
                delete(minNode.data,node,node.right,false);
                if(isLeft)parent.left.data = minNode.data;
         else parent.right.data = minNode.data;
            }
        }else if(node.data > value) delete(value,node,node.left,true);
        else delete(value,node,node.right,false);
    }

    private TNode findMinumum(TNode node){
        while(node.left != null){
            node= node.left;
        }

        return node;
    }
}
