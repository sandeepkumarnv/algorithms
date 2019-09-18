package heap

object MedianFinder {

    val minHeap = new scala.collection.mutable.PriorityQueue[Int]().reverse
    val maxHeap = new scala.collection.mutable.PriorityQueue[Int]()

   def main(args : Array[String]): Unit ={
      addNum(1)
     addNum(10)
     addNum(16)
     addNum(25)
      println(findMedian)
         addNum(30)
     addNum(40)
     addNum(50)
      println(findMedian)

   }
    def addNum(num : Int) {
        if(minHeap.size == 0 || num < minHeap.head) maxHeap.enqueue(num) else minHeap.enqueue(num)

        var bigHeap : scala.collection.mutable.PriorityQueue[Int] = null
      var smallHeap : scala.collection.mutable.PriorityQueue[Int] = null

      if(minHeap.size <= maxHeap.size) {
         bigHeap = maxHeap
         smallHeap = minHeap
      }else{
         bigHeap = minHeap
         smallHeap = maxHeap
      }


        if(bigHeap.size - smallHeap.size == 2) smallHeap.enqueue(bigHeap.dequeue())
    }

    def findMedian() : Double = {
        if(minHeap.size == maxHeap.size) {
          if(minHeap.size == 0) minHeap.head else ((minHeap.head + maxHeap.head)/2).toDouble
        }
        else if(minHeap.size > maxHeap.size){
          minHeap.head.toDouble
        }
        else {
          maxHeap.head.toDouble
        }
    }
}