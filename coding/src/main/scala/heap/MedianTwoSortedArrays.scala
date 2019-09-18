package heap



object MedianTwoSortedArrays {

    def main(args : Array[String]): Unit ={
        val nums1 = Array(1,2)
        val nums2 = Array(3,4)

      println(findMedianSortedArrays(nums1,nums2))
    }
    def findMedianSortedArrays(nums1: Array[Int], nums2: Array[Int]): Double = {
        val minHeap = new scala.collection.mutable.PriorityQueue[Int]().reverse
        val maxHeap = new scala.collection.mutable.PriorityQueue[Int]()

       nums1.foreach(n1=>addToHeap(n1,minHeap,maxHeap))
       nums2.foreach(n2=>addToHeap(n2,minHeap,maxHeap))

        val smallheap = if(maxHeap.size <= minHeap.size)  maxHeap else minHeap
        val bigheap = if(maxHeap.size > minHeap.size)  maxHeap else minHeap
       if(smallheap.size == bigheap.size) ((smallheap.head + bigheap.head)/2).toDouble else bigheap.head.toDouble


    }

    def addToHeap(num: Int, minHeap : scala.collection.mutable.PriorityQueue[Int], maxHeap : scala.collection.mutable.PriorityQueue[Int]){
        if(maxHeap.isEmpty || num <  maxHeap.head) maxHeap.enqueue(num) else minHeap.enqueue(num)

            val smallheap = if(maxHeap.size <= minHeap.size)  maxHeap else minHeap
            val bigheap = if(maxHeap.size > minHeap.size)  maxHeap else minHeap

            if((bigheap.size - smallheap.size) ==  2) smallheap.enqueue(bigheap.dequeue())
    }
}
