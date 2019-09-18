class BiggestIslandMatrix{
    public static void main(String[] args){
        int[][] input = {{0,0,0,1,1,0,0},
                {0,1,0,0,1,1,0},
                {1,1,0,1,0,0,1},
                {0,0,0,0,0,1,0},
                {1,1,0,0,0,0,0},
                {0,0,0,1,0,0,0}};

        System.out.println(longestIsland(input));
    }

    private static int longestIsland(int[][] matrix){
        int longest =0;
        if(matrix.length <= 0) return 0;
        int rowSize = matrix.length;
        int colSize = matrix.length;
        int count=0;
        for(int row = 0; row < rowSize; row++){
            for(int col = 0; col < colSize; col++){
                if(matrix[row][col] == 1){
                    longest = Math.max(longest,getIslandSize(matrix,row,col,rowSize,colSize));
                    count++;
                }
            }
        }
        System.out.println(count);
        return longest;
    }

    private static int getIslandSize(int[][] matrix, int row, int col, int rowSize, int colSize){
        if(row >= rowSize || row < 0 || col >= colSize || col < 0) return 0;
        if(matrix[row][col] == 0) return 0;
        int size =1;
        matrix[row][col] =0;
        for(int r= row-1;r<= row+1;r++){
            for(int c= col-1;c<=col+1;c++){
                if(r != row || c != col){
                    size += getIslandSize(matrix,r,c,rowSize,colSize);

                }
            }
        }

        return size;
    }

}