object QueUsing2Stacks {

  class MyQueue[T] {
    val pushStack = scala.collection.mutable.Stack[T]()
    val popStack = scala.collection.mutable.Stack[T]()



    def enqueue(value: T): Unit = {
      pushStack.push(value)
    }

    def peek: T = {
        if(popStack.isEmpty) populatePopStack
        popStack.top
    }

    def dequeue: T = {
        if(popStack.isEmpty) populatePopStack
        popStack.pop
    }

    private def populatePopStack={
      pushStack.foreach(elem=>{
        popStack.push(pushStack.pop())
      })
    }
  }

  def main(args: Array[String]): Unit = {
    val queue = new QueUsing2Stacks.MyQueue[Integer]
    val scan = new java.util.Scanner(System.in)
    val n = scan.nextInt()
    var i = 0
    while ( {
      i < n
    }) {
      val operation = scan.nextInt
      if (operation == 1) { // enqueue
        queue.enqueue(scan.nextInt)
      }
      else if (operation == 2) { // dequeue
        queue.dequeue
      }
      else if (operation == 3) { // print/peek
          System.out.println(queue.peek)
        }

      {
        i += 1; i - 1
      }
    }
    scan.close
  }
}