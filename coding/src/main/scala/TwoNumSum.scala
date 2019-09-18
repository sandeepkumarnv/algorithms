object TwoNumSum {
    def main(args : Array[String]): Unit ={
      val res = twoSumOptimal(Array(3,4,8,1,12,15,6),14)
      if(res.length > 0) println(s"pair found : ${res.mkString(" ")}") else println("pair not found")
    }
    def twoSum(nums: Array[Int], target: Int): Array[Int] = {
        var first = 0
        var last = nums.length-1
        var sum = 0
        val resultBuff= new scala.collection.mutable.ArrayBuffer[Int]()
        while(resultBuff.isEmpty && first<last ){
            while(nums(last)+nums(first) > target){
                last -=1
            }
            while(nums(last)+nums(first) < target){
                first +=1
            }
            
            if(nums(last)+nums(first) == target){
                resultBuff += nums(first)
                resultBuff += nums(last)
            }
            
        }
        resultBuff.toArray
    }

    private def twoSumOptimal(inputArr : Array[Int], target : Int):Array[Int]={
		val numberIndexMap = scala.collection.mutable.Map[Int,Int]()

		for(i <- 0 to inputArr.length-1){
            if(numberIndexMap.get(target-inputArr(i)).isDefined){
            	return Array(i,numberIndexMap.get(target-inputArr(i)).get).sorted
            }
           numberIndexMap += (inputArr(i) -> i)


		}

		 Array[Int]()

	}
}