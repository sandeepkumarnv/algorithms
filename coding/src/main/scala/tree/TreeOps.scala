package tree

object TreeOps extends App {
//  val inp = Array(1,2,3,4,5,6,7,8,9,10)
//  val root = createTree(inp,0,inp.length-1 )

  val root = createTreeManual()

  inorder(root)

  println(s"height ${height(root)}")

  println(s"is balanced ${isBalancedOptimized(root)}")

  println("end")


  def createTreeManual()={
    var node6= new Node(6,null,null)
    var node5= new Node(5,null,node6)

    var node25= new Node(25,null,null)
    var node35= new Node(35,null,null)

    var node10= new Node(10,node5,null)
    var node30= new Node(30,node25,node35)
    var node20 = new Node(20,node10,node30)


    var node70= new Node(70,null,null)
    var node90= new Node(90,null,null)
    var node80 = new Node(80,node70,node90)

    var node50 = new Node(50,node20,node80)

    node50

  }

  def createTree(input : Array[Int], start : Int, end : Int): Node ={
     if(start > end) return null
     var mid = (start + end) /2

    var root = new Node(input(mid),null,null)
    root.left = createTree(input, 0 , mid-1)
    root.right = createTree(input, mid +1 , end)

    root
  }

  def isBalanced(node : Node):Boolean={
		if(node == null) return true
		val diff = height(node.left) - height(node.right)

		if(java.lang.Math.abs(diff) > 1) return false
		isBalanced(node.left)
		isBalanced(node.right)
	}

   def isBalancedOptimized(node : Node):Boolean={
     if(checkHeight(node) == -1) false else true
   }

  def checkHeight(node : Node): Int={
    if(node == null) return 0
    val lHeight = checkHeight(node.left)
     val rHeight = checkHeight(node.right)
    val diff = java.lang.Math.abs(lHeight - rHeight)
    if(diff > 1) return -1
    else{
       1 + (if(lHeight > rHeight) lHeight else rHeight)
    }
  }

  def checkTree(node : Node,lowerLimit : Int, upperLimit : Int):Boolean={
    if(node == null) return true
    if(node.data < lowerLimit || node.data > upperLimit ) return false
    val leftCheck = checkTree(node.left,lowerLimit,node.data-1)
    val rightCheck = checkTree(node.right,node.data+1,upperLimit)

    leftCheck & rightCheck

  }


  def inorder(node : Node): Unit ={
    if(node == null) return
    inorder(node.left)
    println(node.data)
    inorder(node.right)
  }

  def height(node : Node):Int={
    if(node == null) return 0
    //if(node.left == null && node.right == null) return 1
    val hLeft = height(node.left)
    val hRight = height(node.right)
    1 + (if(hLeft > hRight) hLeft else hRight)
  }
}
