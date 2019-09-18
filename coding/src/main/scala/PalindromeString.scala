object PalindromeString{
	def main(args : Array[String]){
		val isPalindrome = checkPalindrome("malayalam")
		println(isPalindrome)
	}

	def checkPalindrome(input : String):Boolean={

		val mid = input.length/2

		val incFactor = if(input.length % 2 == 0) 0 else 1

		var i=0
		var j = input.length-1
		while(i < mid && j >= mid+incFactor){
		   if(input(i) != input(j)) return false
           i += 1
           j -= 1
        }

           return true
	}
}