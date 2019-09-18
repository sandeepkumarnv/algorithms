package linkedlist

import util.control.Breaks._

object LinkedListOps {

  def main(args : Array[String]): Unit ={

    val node = createLinkedList()

    displayNodes(node)

    val nodeFound = findNode(node,"ghi")
    println("checkig for ghi....")
    displayNodes(nodeFound)

  }

  private def createLinkedList()={
    val dataArray = Array("abc","def","ghi","klm","nop")
    var head: Node  = null
    var current: Node = null
    for(i <- 0 to dataArray.length -1){
      current = new Node(dataArray(i), head)

      head = current

    }
     head

  }

  private def displayNodes(node : Node)={
   var current = node
   while(current != null){
     println(current.data)
     current = current.next
   }

  }

  private def findNode(node : Node , data : String)={
    var current = node
    var nodeFound: Node = null
   while(current != null) {
      if (current.data.equals(data)) {
        current.next = null
        nodeFound= current

      }
     current = current.next
    }


    nodeFound
  }

}
