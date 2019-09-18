package recursion

object StringCombination extends App{
	val input = "abc"
	val combinations = strComb(input)
	println(combinations.mkString(" "))

	def strComb(str : String):scala.collection.mutable.ArrayBuffer[String]={
		if(str == null) return null
        val permutations = new scala.collection.mutable.ArrayBuffer[String]()
		if(str.length == 0){
			permutations += ("")
			return permutations
		}
		val ch = str(0)

		val wordsList = strComb(str.substring(1))

		wordsList.foreach(word=>{
			for(i <- 0 to word.length){
				val newWord =  word.substring(0,i)+ch+word.substring(i)
				permutations += newWord
			}
		})

		return permutations


	}

}
