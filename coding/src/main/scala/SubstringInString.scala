//-Count the number of times a substring appear in a string
object SubstringInString {

  def main(args : Array[String]) = {
    var inputStr = "awsdfwawsdfpdfccc"
    var inputString = "awsdfwawsdfpdfccc"
    val substr = "df"

    //using substring method
    var numberOfSubstrings = 0
    while(inputStr.indexOf("df") >= 0){
      numberOfSubstrings = numberOfSubstrings+1
     inputStr= inputStr.substring(inputStr.indexOf("df")+1)
    }

   //not using substring

    var index = 0
    var substringCount = 0
    while(index < inputString.length - 1 - substr.length){
      var subIndex = 0
      while(subIndex < substr.length && inputString.charAt(index) == substr.charAt(subIndex)){
        index = index+1
        subIndex = subIndex + 1
      }
      if(subIndex == substr.length)  substringCount = substringCount +1
      index = index + 1
    }

    println(s"substringCount is : $substringCount")
  }

}
