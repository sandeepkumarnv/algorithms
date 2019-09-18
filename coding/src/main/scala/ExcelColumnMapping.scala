object ExcelColumnMapping{
	def main(args :Array[String]){
		val inputNum = 28903
		val colName = findColumnMapping(inputNum)
		println(colName)
	}

	def findColumnMapping(inputNum : Int):String={
		val columnsArray = scala.collection.mutable.ArrayBuffer[Int]()
		var num = inputNum
		while(num > 0){
		   val remainder = num % 26
		   columnsArray += remainder
		   num = num/26
		}

       val outputSb = new scala.collection.mutable.StringBuilder
       for(i <- columnsArray.length-1 to 0 by -1){
       	  outputSb.append((columnsArray(i)+'A'-1).toChar)
       }
      outputSb.toString


	}
}