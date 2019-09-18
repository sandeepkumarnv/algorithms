import scala.collection.mutable.ArrayBuffer

object ProductOf2BigNumbers {

  def main(args: Array[String]): Unit = {
    multiply2Numbers("1234", "16")
  }

  private def multiply2Numbers(num1: String, num2: String): Unit = {
    val length1 = num1.length - 1
    val length2 = num2.length - 1
    val totalLength = length1 + length2

    val productArr = Array.ofDim[Int](length2, totalLength)
    for (i <- length2 to 0 by -1) {
      val digit1 = num2.charAt(i).asDigit
      for (j <- length1 to 0 by -1) {
        val digit2 = num1.charAt(j).asDigit
        productArr(length2 - i)(length1 - j - (length2 - i)) = digit1 * digit2
      }
    }

    for {
      i <- 0 until length2
      j <- 0 until totalLength
    } println(s"($i)($j) = ${productArr(i)(j)}")


  }

}
