
//convert all elements in a row to 0 if any of the element in that row is 0
import scala.collection.mutable.ArrayBuffer

object MatrixZeroifyRows{
  def main(args : Array[String])={
    val inputMatrix = ArrayBuffer(ArrayBuffer(1,2,3,4),
                            ArrayBuffer(10,0,3,4),
                            ArrayBuffer(5,2,73,0),
                            ArrayBuffer(19,72,63,40))
    zeroify(inputMatrix)
  }

  private def  zeroify(matrix : ArrayBuffer[ArrayBuffer[Int]])={
   
  	for(row <- 0 to matrix.length-1){
  		var zeroFound = false
  		util.control.Breaks.breakable {for(col <- 0 to matrix(0).length -1){
  			if(matrix(row)(col) == 0) {
  				zeroFound = true
  				util.control.Breaks.break
  			}
  		}}
        if(zeroFound) zeroifyRow(matrix, row)
  	}
    
    for(row <- 0 to matrix.length-1){
       for(col <- 0 to matrix(0).length -1){
         print(s"${matrix(row)(col)}  ")
       }
       println
    }

  }

  private def zeroifyRow(matrix : ArrayBuffer[ArrayBuffer[Int]], row : Int) = {
    for(col <- 0 to matrix(0).length-1){
      matrix(row)(col) = 0
     }
  }

	
}