package recursion


object PowerSet{
	def main(args: Array[String]){
	  val input = "abcdef"
	  val result = generatePowerSet(input)

	  println(s"{${result.map("{"+_+"}").mkString(",")}}")
	}

	def generatePowerSet(str : String) : scala.collection.mutable.Set[String]={
		if(str == null || str.isEmpty){
			val nullSet = scala.collection.mutable.Set[String]()
			nullSet += ""
			return nullSet
		}

        val subSet = generatePowerSet(str.substring(1))
        val powerSet = scala.collection.mutable.Set[String]()
        powerSet ++= subSet
        subSet.foreach(element=>{
          val newStr = str(0)+element
        	powerSet += newStr
        })

        powerSet

	}
}