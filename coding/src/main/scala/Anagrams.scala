//Check WHether 2 strings are anagrams or not
object Anagrams{
	def main(args : Array[String])={
		val input1 = "anagram"
		val input2 = "nagaram"
		checkAnagram(input1,input2)
	}

	private def checkAnagram(str1 : String, str2 : String)={
		val anagramMap =  scala.collection.mutable.Map[Char,Int]()
    		//val anagramMap =  new scala.collection.mutable.HashMap[Char,Int]
        addStringCharsToMap(anagramMap,str1,1)
        addStringCharsToMap(anagramMap,str2,-1)

        println(s"anagram boolean : ${checkAnagramInMap(anagramMap)}")
	}

	private def addStringCharsToMap(anagramMap : scala.collection.mutable.Map[Char,Int], str : String , changeFactor : Int) ={
		for(i <- 0 to str.length-1){
			var count = anagramMap.getOrElse(str.charAt(i),0)
      count = count + changeFactor
      anagramMap += (str.charAt(i) -> count)
		} 
	}

	private def checkAnagramInMap(anagramMap : scala.collection.mutable.Map[Char,Int]) : Boolean={
		
    anagramMap.values.filter(count => (count != 0)).size == 0
	}
}