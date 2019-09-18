object ThreeSumClosest {

		def main(args : Array[String]){
			val result = addThreeNums(Array(1,2,-3,6,8,-10,16).sorted,10)
			println(result)
		}

		def addThreeNums(input : Array[Int] , target : Int):(Int,Int,Int)={
            var min = input.sum
            var result:(Int,Int,Int) = null
			for(i <- 0 to input.length-1){
				var start = i+1
				var end=input.length-1
            	while(start < end){
				val sum =input(start) + input(end) + input(i)
					if(sum == target) return (input(start),input(end),input(i))

					val diff = java.lang.Math.abs(sum-target)
					if(diff < min){
					   min = diff
					   result = (input(start),input(end),input(i))
					}
					if(sum > target) end -= 1 else start +=1
            	}
            }

            result
		}
}
