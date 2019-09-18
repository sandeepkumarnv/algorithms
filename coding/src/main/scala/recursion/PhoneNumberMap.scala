package recursion

object PhoneNumberMap extends App{

	val input = "12337"
	val phoneMap = Map(('1' -> "abc"),
	('2' -> "def"),
	('3' -> "hij"),
	('4' -> "klm"),
	('5' -> "nop"),
	('6' -> "qrs"),
	('7' -> "tuv"),
	('8' -> "wxy"),
	('9' -> "z")
	)

     // val result = new scala.collection.mutable.ArrayBuffer[String]()
     val result = phoneCombination(input)
     println(result.mkString(" "))

   def phoneCombination(input : String):scala.collection.mutable.ArrayBuffer[String]={
   		if(input == "") {
        val comb =  new scala.collection.mutable.ArrayBuffer[String]()
        comb.append("")
        return comb
      }

       val combArray = phoneCombination(input.substring(1))
       val newCombArray = new scala.collection.mutable.ArrayBuffer[String]()


        val currentMapStr = phoneMap(input(0))

        currentMapStr.foreach(ch=>{
           combArray.foreach(c=>{
                val newStr = ch+c
           		newCombArray += newStr
           })
        })

        return newCombArray


   }

}
