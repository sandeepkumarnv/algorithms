package recursion

object Fibonacci extends App {
	print(fibSum(5,""))
  //print(fib(5))

	def fibSum(n : Int, sb : String):Int= {
    val newsb = sb+"-"
      println(newsb,n)
      if(n == 0) return 0
      if(n == 1) return 1
     fibSum(n-1,newsb) + fibSum(n-2,newsb)


  }
}
