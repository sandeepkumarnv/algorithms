object SecondMostCharacterOccurance{
	def main(args : Array[String]){
		val input = "abbcdeefghhhhijjkkklllll"
		val result = findSecondMostOccurance(input)
		println(result)
	}

	def findSecondMostOccurance(inp : String):(Char,Int)={
		val lookUp =  scala.collection.mutable.ArrayBuffer.fill[Int](256)(0)
		var maxOccurance = 0
		var secondMaxOccurance = 0
    var maxOcurranceStr:Char = 'z'
		var secondMaxOcurranceStr:Char = 'z'
        for(i <-0 to inp.length-1){
            val ind= inp(i).toInt
        	lookUp(ind)  += 1
        	if(maxOccurance < lookUp(ind)) {
        	    secondMaxOccurance = maxOccurance
        	    secondMaxOcurranceStr = maxOcurranceStr
        		maxOccurance = lookUp(ind)
            maxOcurranceStr=ind.toChar

        	}
        }
        (secondMaxOcurranceStr,secondMaxOccurance)

	}
}