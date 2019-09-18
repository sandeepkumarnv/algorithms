
object TwoNumbersSumWithPointers  {

		def main(args : Array[String]){
			val result = addTwoNums(Array(1,2,3,6,9,10,16),9)
      result match {
        case Some(r) => println(r)
        case None => println("No pair found")
      }
		}

		def addTwoNums(input : Array[Int] , target : Int):Option[(Int,Int)]={
			var start = 0
			var end=input.length-1

			while(start < end){
			val sum =input(start) + input(end)
				if(sum == target) return Some(input(start),input(end))
				if(sum > target) end -= 1 else start +=1
            }
      None
		}
}