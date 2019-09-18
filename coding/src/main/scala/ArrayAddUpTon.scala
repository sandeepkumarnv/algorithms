//Check whether cosecutive numbers in an array adds up to n
object ArrayAddUpToANumber{
	def main(args : Array[String])={
		val numberArray = Array(6,1,2,4,3,7,5)
        val n = 8
		val result = isArrayAddUpToNOptimal(numberArray,n)
		println(result)
	}
    private def isArrayAddUpToN(numberArray : Array[Int],n : Int)={
     	var i = 0
     	var sum = 0
     	while(i < numberArray.length && sum != n){
     	   var j=i
         sum=0
     	   while(sum < n && j < numberArray.length){
     		sum = sum + numberArray(j)
     		 j += 1

     	   }
        i += 1
		}
		sum == n
    }

    private def isArrayAddUpToNOptimal(numberArray : Array[Int],n : Int)={
    	var i = 0
    	var sum=0
    	var j=0
    	while(i < numberArray.length && sum != n){

    	  sum = sum+numberArray(i)
    	  while(sum > n){
    	  	sum -= numberArray(j)
    	  	j+=1
    	  }
    	  i+=1
    	}
      sum == n
    }
}