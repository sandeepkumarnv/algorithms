object ReverseString {

  def main(args : Array[String])={
    printReverseString("sandeep")
  }

  private def printReverseString(inputStr: String): Unit = {
    for(i <- inputStr.length-1 to 0 by -1){
      print(inputStr.charAt(i))
    }
  }

}
