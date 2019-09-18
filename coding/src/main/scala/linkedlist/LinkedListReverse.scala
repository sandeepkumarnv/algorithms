package linkedlist

object LinkedListReverse extends App{
	val head = createLinkedList(Array(5,64,10,4,3,19))
	//displayLinkedList(head)
	println("___________________________")
	reverseLinkedList(head)
	//displayLinkedList(reversed)

	def reverseLinkedList(node : Node):Unit={
		if(node == null) return
		reverseLinkedList(node.next)
		println(node.data)
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


}