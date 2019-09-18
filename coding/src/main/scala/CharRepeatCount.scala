//Convert aabbbcccccdabbccba to a2b3c5d1a1b2c2b1a1
object CharRepeatCount{
	def main(args : Array[String]) = {
	  val inputStr = "aabbbcccccdabbccba"
	  charsWithRepeatCount(inputStr)
	}

	private def charsWithRepeatCount(str : String)={
	  var i=0
	  val outBuff = new StringBuilder()
	  while(i < str.length){
	  	val currentChar = str.charAt(i)
	  	var charCount = 1
	  	i = i+1
	  	while(i < str.length && currentChar == str.charAt(i)){
	  		i = i+1
	  		charCount = charCount +1
	  	}
        outBuff.append(currentChar).append(charCount)
	  }

	  println(s"repeat count : ${outBuff.toString}")
	}
}