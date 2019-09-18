package tree

object ConvertBinaryTreeToList extends App{
	val root = createTreeManual
	val treeList = convertToList(root)
  val treeListData= treeList.map(node=>{
    if(node == null) -1 else node.data
  })

	println(treeListData.mkString(" "))

  val newRoot = convertBackToTree(treeListData,0)
  inorder(newRoot)

	def convertToList(node : Node):List[Node]= {
    if (node == null) return List.empty[Node]

    val nodeBuff = new scala.collection.mutable.ListBuffer[Node]()
    nodeBuff += node
    val queue = new scala.collection.mutable.Queue[Node]()
    queue.enqueue(node)
    while (!queue.isEmpty) {
      val n = queue.dequeue()
      if (n.left != null) queue.enqueue(n.left)
      if (n.right != null) queue.enqueue(n.right)
      nodeBuff += n.left
      nodeBuff += n.right
    }

    nodeBuff.toList
  }
  def convertBackToTree(treeDataList : List[Int],nodeIndex : Int):Node = {
    if(nodeIndex > treeDataList.length-1) return null
    if(treeDataList(nodeIndex) == -1) return null

   new Node(treeDataList(nodeIndex),
                       convertBackToTree(treeDataList,nodeIndex+1),
                       convertBackToTree(treeDataList,nodeIndex+2))



  }
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

  def inorder(node : Node): Unit ={
    if(node == null) return
    inorder(node.left)
    println(node.data)
    inorder(node.right)
  }

}

