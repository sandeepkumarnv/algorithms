object FinHighestLivingPopulationYear {

  def main(args : Array[String])={

    val input = Array((1950,2015),(1927,1950),(1983,2000),(1910,1940),(1897,1964))

    printHighestLivingPopulationYearEnhanced(input)
  }

  private def printHighestLivingPopulationYearEnhanced(birthDeathArray : Array[(Int,Int)])={
    //var yearCountMap = scala.collection.mutable.Map[Int, Int]()
     var yearCountMap = Map.empty[Int,Int]
    val max = birthDeathArray.maxBy(_._1)._1
    val min = birthDeathArray.minBy(_._1)._1
    for(year <- min to max){
      yearCountMap += (year->0)
    }


    birthDeathArray.foreach(birthDeath=>{
       var birthCount = yearCountMap.getOrElse(birthDeath._1,0)
        birthCount = birthCount+1
        yearCountMap += (birthDeath._1->birthCount)

       var deathCount = yearCountMap.getOrElse(birthDeath._2+1,0)
        deathCount = deathCount-1
        yearCountMap += (birthDeath._2+1->deathCount)

    })

    var maxCountyear = (0,0)
    var totalSum = 0
    var maxSum = 0
    for(year <- min to max){
      totalSum = totalSum + yearCountMap.get(year).get
      if(totalSum > maxSum) {
        maxSum = totalSum
        maxCountyear = (year,maxSum)
      }

    }

    println(s"max count and year is : $maxCountyear")

    println(s"1950-> : ${yearCountMap.get(1950)}")
  }

   private def printHighestLivingPopulationYear(birthDeathArray : Array[(Int,Int)])={
    //var yearCountMap = scala.collection.mutable.Map[Int, Int]()
     var yearCountMap = Map.empty[Int,Int]
    var maxCountyear = (0,0)
    birthDeathArray.foreach(birthDeath=>{
      for(i <- birthDeath._1 to birthDeath._2){
        var count = yearCountMap.getOrElse(i,0)
        count = count+1
        yearCountMap += (i->count)
        if(count > maxCountyear._2) maxCountyear = (i,count)
      }
    })

    println(s"max count and year is : $maxCountyear")

    println(s"1950-> : ${yearCountMap.get(1950)}")
  }

}
