package linkedlist

//partition linked list by a value x so that all elementsin the left must be less than X and right greater than x
object LinkedListPartition{
	def main(args : Array[String])={
		val head = createLinkedList(Array(5,64,10,4,3,19))
		println("input : ")
		displayLinkedList(head)
		val partitionedNodeHead = partition(head,15)

		println(partitionedNodeHead._2.data)
		displayLinkedList(partitionedNodeHead._1)
	}

	private def createLinkedList(inputArray : Array[Int])={
       var current : Node = null
       var first : Node = null
		inputArray.foreach(input=> {
            val node = new Node(input.toString,null)
			if(current != null) current.next=node else first = node
			current =  node
		})

		first
	}

	private def displayLinkedList(node : Node)={
    var current = node
	   while(current != null){
	     println(current.data)
	     current = current.next
	   }
	}

	private def partition(node : Node , partitionData : Int)={
	    var first = node
		var current:Node = node
		var before: Node = node
		while(current.data.toInt > partitionData){
		  before = current
		  current = current.next
		}

    var partitionNode = current
        var previous = current
        current = current.next

		while(current != null){
		  if(current.data.toInt < partitionData){
		     previous.next = current.next
		  	 reArrangeNode(before,current)

		  }
		   previous = current
		   current=current.next
		}

    (first,partitionNode)
	}

	private def reArrangeNode(before: Node, current : Node){

		val tmp = before.next
		before.next= current
		current.next=tmp


	}
}