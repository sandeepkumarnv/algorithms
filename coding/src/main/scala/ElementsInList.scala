object ElementsInList {

  def main(args : Array[String]) = {
   printMax( List(5,2,6,10,13,19,15))
    printMedian(List(1,2))
  }

  private def printMax(inputList : List[Int])={
    println(inputList.max)
    var max = 0
    inputList.foreach(x=>{
      max = if(max < x) x else max
    })

    println(s"max is : $max")
  }

  private def printMedian(inputListInt: List[Int])={

   }

}
