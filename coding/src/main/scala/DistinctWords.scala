import scala.reflect.internal.util.HashSet
//How many unique world are in the provided string?
object DistinctWords {

  def main(args : Array[String]): Unit ={
    val input = "hi How are you how do u do hi how r u."

    //calculateUniqueWords(input)
    calculateUniqueWordsBySplit(input)


  }

  private def calculateUniqueWords(input : String)={
    var index = 0
    val uniqueSet = Set.empty[String]
    while(index < input.length) {

    }
  }

  private def calculateUniqueWordsBySplit(input : String)={
    var distinctWordsCount = 0
    var wordSet = Set.empty[String]
    input.split("\\W+").foreach(word => {
      wordSet += word
    })

    print(wordSet.size)
  }


}
