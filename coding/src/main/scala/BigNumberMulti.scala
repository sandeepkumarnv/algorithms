object BigNumberMulti {
  def main(args: Array[String]): Unit = {
   println(multiply("123", "23"))
  }

  def multiply(x: String, y: String): String = {
    var result = ""
   for(i <- y.length-1 to 0 by -1) {
      val digit = Character.getNumericValue(y.charAt(i))
      val partial = multiplyPartial(x, digit)
      val partialWithZero = addZeros(partial, y.length - 1 - i)
      result = addPartials(partialWithZero, result)
   }
    result
  }

  private def multiplyPartial(x: String, digit: Int) = {
    var carry = 0
    val sb = new StringBuilder
    for(i <- x.length-1 to 0 by -1) {
      val xDigit = x(i).asDigit
      val resultPartialInt = (xDigit * digit + carry) % 10
      carry = xDigit * digit / 10
      sb.append(resultPartialInt)
    }
    sb.append(carry).reverse.toString()
  }

  private def addZeros(x: String, numberOfZeros: Int) = {
    val sb = new StringBuilder(x)
    for(i <- 1 to numberOfZeros) {
      sb.append("0")
    }
    sb.toString
  }

  private def addPartials(partial: String, result: String):String = {
    if (result == "")  return partial
    var carry = 0
    var i = result.length - 1
    var j = partial.length - 1
    val sb = new StringBuilder
    for((i,j) <-  (result.length - 1 to 0 by -1)zip(partial.length - 1 to 0 by -1) ) {
      val resultDigit = result(i).asDigit
      val partialDigit = partial(j).asDigit
      val r = (resultDigit + partialDigit + carry) % 10
      carry = carry / 10
      sb.append(r)
    }
    sb.append(carry).reverse.toString
  }
}