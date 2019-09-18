//Rotate elements of array
object ArrayFold {

    def main(args: Array[String]) {
        val sc = new java.util.Scanner (System.in);
        var n = 5
        var k = 4
        var a = Array(1,2,3,4,5)
        val output = arrayFold(a,n,k)
        println(output.mkString(" "))
    }
    private def arrayFold(inputArray : Array[Int] , n : Int, k : Int)={
        val inputBuff = new scala.collection.mutable.ArrayBuffer[Int]
        inputBuff.appendAll(inputArray)
        for(i <- 0 to 1){
            inputArray.foreach(element=>inputBuff += element)
        }
        inputBuff.slice(k,n+k).toArray
    }
}
