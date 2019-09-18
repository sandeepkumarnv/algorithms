package recursion

object FibonacciDynamic extends App {

  val input =2
  val memo = Array.fill[Int](input)(0)

  print(fibSum(input,""))
  //print(fib(5))


	def fibSum(n : Int, sb : String):Int= {

    val newsb = sb+"-"
      println(newsb,n)
      if(n == 0) return 0
      if(n == 1) return 1
      if(memo(n) > 0)  return memo(n)
     println(s"about to do recursion on $n")
     memo(n) = fibSum(n-1,newsb) + fibSum(n-2,newsb)
     memo(n)

  }
}
