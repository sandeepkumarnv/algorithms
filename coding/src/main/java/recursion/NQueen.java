package recursion;

public class NQueen {

    public static void main(String[] args){
        int boardSize = 4;
        Position[] positions = new Position[boardSize];
        boolean result= findQueenPositions(positions,boardSize,0);
        for(Position position : positions){
            System.out.println(position.toString());
        }

    }

    private static boolean findQueenPositions(Position[] positions,int boardSize,int i){
        if(i >= boardSize){
            return true;
        }
        boolean canPlace = false;
        for(int j=0;j<boardSize;j++){
            if(!canPlaceQueen(positions,i,j)) continue;
            positions[i] = new Position(i,j);
            if(i < boardSize) {
                canPlace = findQueenPositions(positions,boardSize,i+1);
                if(canPlace) return true;
                positions[i] = null;
            }
        }
        return canPlace;
    }

    private static boolean canPlaceQueen(Position[] positions,int row,int col){
       for(Position position:positions){
            if(position == null) return true;
            if(position.x == row || position.y == col || position.x+position.y == row+col || position.x-position.y == row-col){
                return false;
            }

        }

        return true;
    }
}


class Position{
    int x;
    int y;
    public Position(int x, int y){
        this.x = x;
        this.y=y;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("(").append(x).append(",").append(y).append(")");
        return sb.toString();
    }

}
