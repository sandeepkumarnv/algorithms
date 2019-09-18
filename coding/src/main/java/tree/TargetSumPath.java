package tree;

import java.util.ArrayList;

public class TargetSumPath {

    public static void main(String[] args){

        TreeNode n7 = new TreeNode(7,null,null);
        TreeNode n2 = new TreeNode(2,null,null);
        TreeNode n1 = new TreeNode(1,null,null);

        TreeNode n11 = new TreeNode(11,n7,n2);
        TreeNode n13 = new TreeNode(13,null,null);
        TreeNode n4 = new TreeNode(4,null,n1);

        TreeNode n40 = new TreeNode(4,n11,null);
        TreeNode n8 = new TreeNode(8,n13,n4);

        TreeNode root = new TreeNode(5,n40,n8);

        int targetSum = 22;
        System.out.println(targetSum(root,targetSum));

        ArrayList<ArrayList<Integer>> resultList = new   ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> currentList = new ArrayList<Integer>();
        currentList.add(root.data);
        targetSumWithValues(root,targetSum-root.data,resultList,currentList);

        for(ArrayList<Integer> result: resultList){
            System.out.println();
            for(Integer value:result){
                System.out.print(value+ " ");
            }
        }
    }

    private static void targetSumWithValues(TreeNode node , int sum, ArrayList<ArrayList<Integer>> resultList , ArrayList<Integer> currentList){
        if(node.left == null && node.right == null && sum ==0) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.addAll(currentList);
            resultList.add(temp);
        }
        if(node.left != null){

            currentList.add(node.left.data);
            targetSumWithValues(node.left,sum-node.left.data,resultList,currentList);
            currentList.remove(currentList.size()-1);
        }

        if(node.right != null){
            currentList.add(node.right.data);
            targetSumWithValues(node.right,sum-node.right.data,resultList,currentList);
            currentList.remove(currentList.size()-1);
        }


    }

    private static boolean targetSum(TreeNode node , int sum){
       if(sum == 0) return true;
        if(node == null) return false;
        boolean hasLeftSum =  targetSum(node.left,sum-node.data);
        boolean hasRightSum = targetSum(node.right,sum-node.data);
        return hasLeftSum || hasRightSum;
    }

}

