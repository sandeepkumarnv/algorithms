object SumPrime1 extends App{
	var number = 19
	val result = checkPrime(number)
	println(s"$number prime : $result")

	number = 27
    val res = primeSum(number)
    println(res)


	def checkPrime(num : Int):Boolean={
    var i = 2
		while(i*i < num){
			if(num % i == 0) return false
      i += 1
		}
		true
	}

	def primeSum(n : Int) : Int={
    	val primeBuff = new scala.collection.mutable.ArrayBuffer[Boolean](number)
  for(i <- 0 to number) primeBuff  += true
	  var i=2
     while(i*i < n){
         if(primeBuff(i)){
           var  j = i*i
         	while(j < n){
         	   primeBuff(j) = false
         	   j += i
         	}
         }
       i += 1
       }
       var sum = 0
       for(i <- 0 to n){
       		if(primeBuff(i)) sum += i
       }

       sum
	}
}