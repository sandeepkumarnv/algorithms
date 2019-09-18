package recursion

object Sum extends App{

  print(findSum(5))

  def findSum(n : Int): Int={
   if(n == 0 ) return 0
   n+findSum(n -1)
  }
}


