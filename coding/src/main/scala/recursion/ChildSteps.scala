package recursion

object ChildSteps extends App{
  var memo = Array.fill[Long](31)(0L)
	val ways = countWays(5L)
	println(ways)

	def countWays(n : Long):Long={
		if(n <= 0L) return 0L
		if(n == 1L) return 1L
    if(memo(n.toInt) > 0L ) return memo(n.toInt)
		memo(n.toInt)  = countWays(n-1) + countWays(n-2) + countWays(n-3)

    memo(n.toInt)
	}
}
