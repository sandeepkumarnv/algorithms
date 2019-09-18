object ZeroShiftToEnd extends App{
	val updatedArray = zeroShift(Array(1,2,0,3,0,0,5,6,0))
	println(updatedArray.mkString(" "))

	def zeroShift(input : Array[Int] ) : Array[Int]={
		val inputBuff = input.toBuffer[Int]
		var zeroCount = 0
		for(i <- 0 to inputBuff.length-1){

			if(inputBuff(i) == 0) zeroCount += 1
			else{
				inputBuff(i-zeroCount) = inputBuff(i)
			}

		}

	   for(j <- inputBuff.length-zeroCount to inputBuff.length-1){
	   	inputBuff(j) = 0
	   	}
    inputBuff.toArray
	}
}