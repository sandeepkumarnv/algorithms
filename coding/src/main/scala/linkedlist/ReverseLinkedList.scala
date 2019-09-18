package linkedlist

object ReverseLinkedList{
	def main(args : Array[String]){
		val head = createLinkedList(Array("A","B","C","D","E"))

		displayNode(head)

		val reverseHead=reverse(head)

    println("______________")

		displayNode(reverseHead)

	}

	def reverse(head : Node)={
        var current = head
        var previous: Node = null
		   var nextNode : Node = null
		while(current != null){
			nextNode = current.next
			current.next = previous
            previous = current
			current = nextNode

		}
      previous
    }
    def createLinkedList(inputArray : Array[String])={

    	var head:Node = null
    	var current:Node = null
    	var previous : Node = null
    	for(i <- 0 to inputArray.length-1){
    	  previous = current
    	  current = new Node(inputArray(i),null)
    	  if(head == null) head = current
    	  else previous.next = current

        }

        head
    }

      private def displayNode(node : Node)={
   var current = node
   while(current != null){
     println(current.data)
     current = current.next
   }

  }

 }


