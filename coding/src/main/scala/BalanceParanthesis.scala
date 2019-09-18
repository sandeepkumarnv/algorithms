//remve unbalanced paranthesis  (ab((d) shuld give back ab(d)
object BalanceParanthesis extends App{

	val balancedStr = balance("(ab((d)")
	println(balancedStr)

	def balance(input : String):String={
        val paranthesisStack = new scala.collection.mutable.Stack[(Char,Int)]()
        val result = new scala.collection.mutable.StringBuilder
		for(i <- 0 to input.length-1){
			if(input(i) == '(') paranthesisStack.push((input(i),i))
			if(input(i) == ')' ) {
        if (!paranthesisStack.isEmpty && paranthesisStack.top._1 == '(') paranthesisStack.pop
        else paranthesisStack.push((input(i), i))

      }
			result += input(i)
		}

		paranthesisStack.foreach(paraIndex=>{
		    result.deleteCharAt(paraIndex._2)
		})

		result.toString()

	}
}
