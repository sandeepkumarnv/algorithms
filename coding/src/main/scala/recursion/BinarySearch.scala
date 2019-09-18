package recursion

object BinarySearch extends App{
	val input = Array(2,5,6,9,10,18,20,30,45,67,70)
	val number = 70
	println(search(0,input.length-1))

	def search(start : Int,end : Int):Boolean={
		if(start > end) return false
		val mid = (start + end)/2
    if(input(mid) == number) return true
    return if(input(mid) > number) search(start, mid-1) else search(mid+1, end)

  }
}
