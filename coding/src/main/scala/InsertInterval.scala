//if input is Array((0,5),(10,20),(30,40),(45,50)) and we insert (15,45) result should be (0,5) (10,45) (45,50)
object InsertInterval extends App {

//  val intervalArray = List(new Interval(1, 3), new Interval(6, 9))
//  val resultArray = insert(intervalArray, new Interval(2, 5))
    val intervalArray = List(new Interval(1, 5),new Interval(8, 15))
  val resultArray = insert(intervalArray, new Interval(6, 10))
  resultArray.foreach(x => println(x.start, x.end))

  def insert(intervals: List[Interval], newInterval: Interval): List[Interval] = {
        if(newInterval == null) return intervals
        if(intervals.isEmpty) return List(newInterval)

        val result = scala.collection.mutable.ListBuffer[Interval]()

        var j = 0
        while (j < intervals.length && intervals(j).start <=  newInterval.start){
            result += intervals(j)
            j += 1
        }

        if(j == intervals.length){
            merge(result, newInterval)
        }

        var newIntervalInserted = true
        for(i <- j to intervals.length -1){
            if(intervals(i).start <=  newInterval.start)  result += intervals(i)
            else{
                if(newIntervalInserted){
                   if(result.isEmpty)  result += newInterval
                   else merge(result, newInterval)
                  newIntervalInserted = false
              }
                merge(result, intervals(i))
            }
        }
        result.toList

    }

    def merge(result : scala.collection.mutable.ListBuffer[Interval], interval: Interval)={
        if(!result.isEmpty && result.last.end >= interval.start){
            result.last.end = if(interval.end > result.last.end) interval.end else    result.last.end
        }else{
            result += interval
        }
    }
}

class Interval(var _start: Int = 0, var _end: Int = 0) {
  var start: Int = _start
  var end: Int = _end
}