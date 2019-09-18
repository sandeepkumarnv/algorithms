public class ZigZagConvert {

    public static void main(String[] args){
       System.out.println(convert("paypalishiring",10));
    }

    private static String convert(String s, int numRows) {
        if(s == null || s.length() <= numRows)return s;
        int numColumns = (s.length()/numRows)*2;
        char[][] result = new char[numRows][numColumns] ;
        int[] dirRows={1,-1};
        int[] dirCols={0,1};
        int drIndex = 0;
        int row = 0;
        int column=0;
        for(int i=0;i < s.length();i++){
            result[row][column] = s.charAt(i);
            if(row+dirRows[drIndex] >= numRows || row+dirRows[drIndex] <0 ){
                drIndex = (drIndex+1)%2;
            }
            row = row+dirRows[drIndex];
            column = column+dirCols[drIndex];
         }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<numRows;i++){
            for(int j=0;j<numColumns;j++){
                if((result[i][j] >= 'a' && result[i][j] <= 'z') || (result[i][j] >= 'A' && result[i][j] <= 'Z'))
                sb.append(result[i][j]);
            }
        }
        return sb.toString();
    }

}
