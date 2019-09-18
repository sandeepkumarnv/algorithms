object ListCommon{

  def main(args : Array[String]){
    val input1 = List(1,2,3,4,5,6)
    val input2 = List(10,11,3,5,13,16)
    println(findComonElements(input1,input2).mkString(" "))
  }

  def findComonElements(input1 : List[Int],input2 : List[Int]):Array[Int]={
    val numSet = scala.collection.mutable.Set[Int]()
    val resultBuff = new scala.collection.mutable.ArrayBuffer[Int]()
    input1.foreach(inp=> numSet += inp)

    input2.foreach(inp=>{
        if(numSet.contains(inp)) resultBuff += inp
    })

    resultBuff.toArray

  }
}