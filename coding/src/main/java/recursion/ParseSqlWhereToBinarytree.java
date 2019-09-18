package recursion;


// package whatever; // don't place package name!

/*

Parse a where clause into a binary tree

Example: A=1 and B=2 or C=3 and D=4
        A=1 and (B=2 or (C=3 and D=4))

                    and
            A=1            or
                        B=2    and
                              C=3  D=4

        (A=1 and B=2) or (C=3 and D=4)

input: String[] {"A=1", "and", "(", "B=2", "or",
            "(", "C=3", "and", "D=4", ")", ")"}


*/

class SqlNode{
    String data;
    SqlNode left;
    SqlNode right;
    public SqlNode(String data){
        this.data = data;
    }

}


public class ParseSqlWhereToBinarytree
{
    public static void main (String[] args) throws java.lang.Exception
    {
        String[] inputstr = {"A=1", "and", "(", "B=2", "or",
                "(", "C=3", "and", "D=4", ")", ")"};

        SqlNode root = createBinaryTree(inputstr,0,inputstr.length-1);

        System.out.println("end");
    }

    private static SqlNode createBinaryTree(String[] inputStr,int start,int end){
        if(start == end){
            return new SqlNode(inputStr[start]);
        }
        SqlNode root = null;
        int i = start;
        if(inputStr[start].equals("(")){
            int bracketCount = 0;
            while(i==start || bracketCount > 0){
                if(inputStr[i].equals("(")){
                    bracketCount++;
                }else if(inputStr[i].equals(")")){
                    bracketCount--;
                }
                i++;
            }

        }
        root = new SqlNode(inputStr[i+1]);
        int leftStart = start;
        int leftEnd = i;
        int rightStart = i+2;
        int rightEnd = end;
        if(inputStr[leftStart].equals("(")) leftStart++;
        if(inputStr[leftEnd].equals(")")) leftEnd--;
        if(inputStr[rightStart].equals("(")) rightStart++;
        if(inputStr[rightEnd].equals(")")) rightEnd--;
        root.left = createBinaryTree(inputStr,leftStart,leftEnd);
        root.right = createBinaryTree(inputStr,rightStart,rightEnd);

        return root;

    }
}
