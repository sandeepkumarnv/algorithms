package linkedlist


object FindNthNodeLinkedList extends App{
	//def main(args : Array[String]){
		val head = createList(Array("1","2","3","4","5","6","7"))
		val nthNode = findNthNode(3, head)
  nthNode.map(x=>println(x.data))
    println(nthNode match {

      case Some(node) => node.data
      case None=> "NOt Found"
    })
	//}

	def findNthNode(n : Int, head : Node):Option[Node]={
		var current = head
		var nthNode : Node = null
		var i = 0
		while(current != null){
            if(i == n) nthNode = head
            current = current.next
            if(nthNode != null) nthNode = nthNode.next

			i +=1
		}

		Some(nthNode)
	}

   private def createList(dataArray : Array[String])={
    var head: Node  = null
    var current: Node = null
    for(i <- 0 to dataArray.length -1){
      current = new Node(dataArray(i), head)

      head = current

    }
     head

  }
}