
object DivideNumbers extends App{

	val result = divideNumbers(15,4)

    println(s"Q = ${result._1} R = ${result._2}")

    def divideNumbers(num : Int, divisor :  Int):(Int,Int) = {
      var divident = num
      var q = 0
      var r = 0
    	while(divident > 0){
    		divident = divident - divisor
    		q += 1
    	}

    	if(divident < 0){
           r = divident + divisor
           q -= 1
    	}

    	(q,r)
    }

}