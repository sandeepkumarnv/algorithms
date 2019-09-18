package graph

import scala.collection.mutable


object GraphOps {

  def main(args : Array[String]): Unit ={

    val start = createManual

    val visited = scala.collection.mutable.Set[Int]()

    println("Depth First Search")
    println(depthFirstSearch(start, 7,visited))

    println("Breadth First Search")
    println(breadthFirstSearch(start, 7))

  }


  def depthFirstSearch(node : Node, inp : Int, visited : scala.collection.mutable.Set[Int]):Boolean={
    if(node == null) return false
    println(node.data)
    if( visited.contains(node.data)) return false
    if(node.data == inp ) return true
    visited += node.data

    if(node.adjacentNodes.isEmpty) return false

    for(i <- 0 to node.adjacentNodes.length-1){

        val found = depthFirstSearch(node.adjacentNodes(i), inp, visited)
        if (found) return true

    }

    return false
  }

  def breadthFirstSearch(node : Node, inp : Int):Boolean={
    val bfsQuueue = new mutable.Queue[Node]()
    bfsQuueue.enqueue(node)
    while(!bfsQuueue.isEmpty){
      val currentNode = bfsQuueue.dequeue()
      println(currentNode.data)
      if(currentNode.data == inp) return true
      if(!currentNode.adjacentNodes.isEmpty){
        for(i <- 0 to currentNode.adjacentNodes.length-1){
          bfsQuueue.enqueue(currentNode.adjacentNodes(i))
        }
      }
    }

    return false
  }

  def createManual : Node={
    var node11 = new Node(11, null)
    var node6 = new Node(6, Array(node11))
    var node9 = new Node(9, Array(node6))
    var node8 = new Node(8, Array(node9))
    var node7 = new Node(7, Array(node8))
    var node5 = new Node(5, Array(node6))
    var node10 = new Node(10, Array(node5))
     var node4 = new Node(4,Array(node5))
    var node3 = new Node(3, Array(node4))
    var node2 = new Node(2, Array(node3, node4))
    var node1 = new Node(1, Array(node2, node7))
    node11.adjacentNodes = Array(node10)

    node1

  }

}

class Node(_data : Int,_adjacentNodes : Array[Node]){
   var data = _data
   var adjacentNodes = _adjacentNodes
}
