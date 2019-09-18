/*
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 */
object StringNumericEncode{
	def main(args : Array[String])={
		val inputMap =scala.collection.immutable.Map('A' -> 1,
		'B' -> 2,
		'C' -> 3,
		'D' -> 4,
		'E' -> 5,
		'F' -> 6,
		'G' -> 7,
		'H' -> 8,
		'I' -> 9,
		'J' -> 10,
		'K' -> 11,
         'L' -> 12,
		'M' -> 13,
        'N' -> 14,
		'O' -> 15,
		'P' -> 16,
		'Q' -> 17,
		'R' -> 18,
		'S' -> 19,
		'T' -> 20,
		'U' -> 21,
        'V' -> 22,
		'W' -> 23,
		'X' -> 24,
		'Y' -> 25,
		'Z' -> 26)

		val decodedArray = decodeToString(12345,inputMap)
		println(s"decodedArray is : ${decodedArray.mkString(" ")}")
	}

	private def decodeToString(encoded : Int , inputMap : Map[Char,Int])={
		val reverseMap = createReverseMap(inputMap)
		val sb = new StringBuilder
		encoded.toString.foreach(digitChar=>{
				sb.append(reverseMap.get(digitChar.asDigit).get)
		})



        val numBuff = new scala.collection.mutable.ArrayBuffer[Int]()
        sb.toString.sliding(2,1).foreach(pairStr=>{
          val num = inputMap.get(pairStr(0)).get * 10 + inputMap.get(pairStr(1)).get
          numBuff += num
        })

        val strBuff = new scala.collection.mutable.ArrayBuffer[String]()
        var charCodeFound = true
        numBuff.foreach(num=>{
           val charCode = reverseMap.get(num)
           if(!charCode.isDefined) charCodeFound=false
           else{
           strBuff += charCode.get.toString}

        })

        if(charCodeFound) sb.append(" ").append(strBuff.mkString(" "))

         sb.toString



	}

	private def createReverseMap(inputMap : Map[Char,Int])={
        val reverseMap = scala.collection.mutable.Map[Int,Char]()
        inputMap.foreach(elem=>{
           reverseMap += (elem._2 -> elem._1)
        })
    reverseMap
	}

}