object SecondLargest{
	def main(args : Array[String]){
		val input = Array(8,2,4,0,10,3,15,1)
		val secondLargest = findSecondLargest(input)
		println(secondLargest)
	}

	def findSecondLargest(inp : Array[Int]):Int={
		var largest  = inp(0)
		var secondLargest = inp(0)

		for(i <- 1 to inp.length-1){
			if(inp(i) > largest){
				secondLargest = largest
				largest = inp(i)
			}
		}
		secondLargest
	}
}