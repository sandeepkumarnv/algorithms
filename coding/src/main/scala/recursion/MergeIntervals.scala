//package recursion
//
//
//object MergeIntervals {
//    def merge(intervals: List[Interval]): List[Interval] = {
//        mergeInterval(intervals,intervals.size)
//    }
//
//    def mergeInterval(intervals: List[Interval], i : Int):scala.collection.mutable.ListBuffer[Interval]={
//        if(i <= 0){
//            return new scala.collection.mutable.ListBuffer[Interval]
//        }
//         val merged = new scala.collection.mutable.ListBuffer[Interval]
//        if(intervals(i).start <= intervals(i-1).end){
//           merged += new Interval(intervals(i-1).start,intervals(i).end)
//
//        }else {
//
//          merged += intervals(i-1)
//           merged +=  intervals(i)
//        }
//
//        //mergeInterval(merged, i-1)
//
//    }
//}
//
// class Interval(var _start: Int = 0, var _end: Int = 0) {
//    var start: Int = _start
//    var end: Int = _end
//  }
//
