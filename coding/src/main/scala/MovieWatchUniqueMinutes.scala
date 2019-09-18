import scala.collection.mutable.ArrayBuffer

//given a list of tuples of movie watched times, find how many unique minutes of the movie did the viewer watch e.g. [(0,15),(10,25)]. The viewer watched 25 minutes of the movie.
object MovieWatchUniqueMinutes {

  def main(args : Array[String])={
   // val inpiutList = Array((0,15),(5,10),(30,40))
    val inpiutList = Array((0,10),(5,25),(10,15),(20,30))
    inpiutList.length
    calculateUniqueMinutes(inpiutList)
    print(calculateUniqueMinutesByMerge(inpiutList))
  }

  private def calculateUniqueMinutes(inputMinutesList: Array[(Int, Int)])={
    val length = inputMinutesList.length
    var totalMinutes = inputMinutesList(0)._2 - inputMinutesList(0)._1
    var maxUpperBound = inputMinutesList(0)._2
    for(i <- 1 to length - 1){

      val diff =inputMinutesList(i)._1 - inputMinutesList(i-1)._2
      if(diff > 0){
          totalMinutes += (inputMinutesList(i)._2 - inputMinutesList(i)._1)
      }else{

        if(inputMinutesList(i)._2 > maxUpperBound){
           totalMinutes += (inputMinutesList(i)._2 - inputMinutesList(i-1)._2)

        }

      }
   if(maxUpperBound < inputMinutesList(i)._2) maxUpperBound = inputMinutesList(i)._2
    }
    println(totalMinutes)
   }

  	def calculateUniqueMinutesByMerge(input : Array[(Int,Int)]):Int={
	   val merged = new scala.collection.mutable.ArrayBuffer[(Int,Int)]()
		var uniqueMinutes = input(0)._2 - input(0)._1
	   merged += input(0)
	   for(i <- 1 to input.length-1){
			 if(input(i)._1 < merged.last._2){
				 if(input(i)._2 > merged.last._2) {
	   	 	  val newMerged= (merged.last._1,input(i)._2)
					uniqueMinutes += input(i)._2 - merged.last._2
	   	 	  merged -= merged.last
	   	 	  merged += newMerged

	   	 	}

	   	 }else{
				  uniqueMinutes += (input(i)._2 - input(i)._1)
	   	     merged += input(i)
	   	 }
	   }

   uniqueMinutes
	}


}
