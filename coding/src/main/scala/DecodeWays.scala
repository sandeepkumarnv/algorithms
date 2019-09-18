object DecodeWays extends App {

  //val count = numDecodings("12112")
  val count = numDecodings("122345")
  print(count)

  def numDecodings(s: String): Int = {
    if (s == null || s.length == 0) return 0
    val n = s.length
    val decodeCount = new Array[Int](n + 1)
    decodeCount(0) = 1
    decodeCount(1) = if (s(0)== '0') 0 else 1
    var i = 2
    while (i <= n) {
      val single = s.substring(i - 1, i).toInt
      val double = s.substring(i - 2, i).toInt
      if (single != 0) decodeCount(i) += decodeCount(i - 1)
      if (double >= 10 && double <= 26) decodeCount(i) += decodeCount(i - 2)

      i += 1

    }
    decodeCount(n)
  }

}