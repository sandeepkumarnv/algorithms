package tries


object TrieOps{
	def main(args: Array[String]){
		val input = Array("car","cat","can","canvas","cattle","carrot","care")
		val root = new Node
		input.foreach(str=>{
			root.add(str)
		})

    println(root.findString("canvas",0))
     println(root.findString("car",0))
    println(root.findString("camel",0))
     println(root.findString("tiger",0))

		println("end")

	}

}

class Node{
    val NUMBER_OF_CHARACTERS = 26
	val children = scala.collection.mutable.ArrayBuffer.fill[Node](NUMBER_OF_CHARACTERS)(null)

	def getIndexFromChar(c : Char):Int = {
		c - 'a'
	}

	def getNode(c : Char):Node={
		children(getIndexFromChar(c))
	}

	def setNode(c: Char, node : Node){
		children(getIndexFromChar(c))=node
	}

	def add(str : String){
		add(str,0)
	}

	def add(str: String, index  : Int){
    if(index == str.length)return false
    var child = getNode(str(index))
			if(child == null){
			   child = new Node
			   setNode(str(index),child)
			}
    child.add(str,index+1)

	}

  def findString(str : String,index : Int):Boolean={
    if(str.length == index) return true
    val child = getNode(str(index))

    if(child == null) return false
    child.findString(str,index+1)
  }
}