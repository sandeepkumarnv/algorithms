package linkedlist

object CirclularLinkedListStart{
	def main(args : Array[String]){
		val head = createLinkedList(Array("A","B","C","D","E","C"))

		val circularHead=findCircularHead(head)
		println(s"circular head is :${circularHead.data }")

	}

	def findCircularHead(head : Node)={
        var current = head
		val nodeSet = scala.collection.mutable.Set[Node]()
		while(current != null && !nodeSet.contains(current)){
			nodeSet += current
			current = current.next
		}

		current
    }
    def createLinkedList(inputArray : Array[String])={
    	var cNode : Node = null
    	var head:Node = null
    	var current:Node = null
    	var previous : Node = null
    	for(i <- 0 to inputArray.length-1){
    	  previous = current
    	  current = new Node(inputArray(i),null)
    	  if(cNode == null && inputArray(i).equals("C")) cNode = current
    	  if(head == null) head = current
    	  else previous.next = current

        }
        current.next =cNode

        head
    }
 }


