//find all permutatons of s in b where s is a small string and b is a big string
object StringPermutationCheck {

  def main(args : Array[String]): Unit ={
   permutationCheck("cbab","abcbabbcascbcacabba")
  }

  private def permutationCheck(small : String, big : String): Unit ={
    val smallSorted = small.sorted
    for(i <- 0 to big.length-1-small.length){
      val bigSubStr = big.substring(i,i+small.length)
      if(smallSorted.equals(bigSubStr.sorted)){
        println(bigSubStr)
      }
    }
  }

}
