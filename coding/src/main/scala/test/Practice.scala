object DecodeWaystest{
	def main(args : Array[String]){
		val input = "122345"
		println(decodeWays(input))
	}

	def decodeWays(inputStr : String):Int={
		if(inputStr == null || inputStr.length == 0) return 0
		val decodeCounts =  scala.collection.mutable.ArrayBuffer.fill[Int](inputStr.length+1)(0)
		 decodeCounts(0) =  1
		 decodeCounts(1) = if(inputStr(0) == '0') 0 else 1
		 var i = 2
		 while(i <= inputStr.length){
		 	val single = inputStr(i-1).asDigit
		 	val double = inputStr.substring(i-2,i).toInt
		 	if(single != 0 ) decodeCounts(i) +=  decodeCounts(i-1)
		 	if(double >= 10 && double <=26) decodeCounts(i)  += decodeCounts(i-2)
			i +=1
		 }

        decodeCounts(inputStr.length)

 	}
}