import org.joda.time.DateTime

import scala.collection.mutable.{ArrayBuffer, ListBuffer}

object Util {

  def main(args : Array[String]): Unit ={
    //Array Sort tuplec
//    val input = Array((10,2),(5,3),(15,0),(7,8))
//    println(input.sortBy(_._1).mkString(" "))
//    println(input.sortBy(_._2).mkString(" "))
//    println(input.sortBy(x => x._1 - x._2).mkString(" "))
//    val x = ArrayBuffer('a', 'b', 'c', 'd', 'e', 'f')
// val y = x.slice(2,6)
//   // x.le
//    println(y.toArray.mkString(" "))

//    val a = -1
//    print(java.lang.Math.abs(a))
//
//         val expStack = scala.collection.mutable.Stack[Char]()
//  val expMap = scala.collection.immutable.Map('{'->'}','('->')','['->']')
//    expMap.get('q')

//    val testSet = scala.collection.mutable.Set[Int](1,2,3,4)
//    println(testSet.contains(1))
//    println(testSet.contains(6))
//
//    val a = Array(1,2)
//    val b = Array(1,2,3)
//
//    println(a.mkString(" "))
//    println(b.mkString(" "))

//Array.fill[Int](5)(0).toBuffer[Int].foreach(x=>print(x))

//    val str="{}"
//    println(str)
//
//    for(i <- 0 to str.length){
//      println("tets")
//    }

    //val maxHeap = new scala.collection.mutable.PriorityQueue[Int]()
//val result=  scala.collection.mutable.ArrayBuffer.fill(3,5)(' ')
//     result(0)(0) = 'v'
//     result(2)(3) = 'i'
//
//    println(result.mkString("").mkString(""))
//
//    println('A')
//
//    println(66.toChar)

		val test = " how are hi you hi i am hi fine"
    println(test.replaceAll("hi","nopes"))
  }

}
