package tries

object TrieOpsHashMap{
	def main(args: Array[String]){
		val input = Array("car","cat","can","canvas","cattle","carrot","care")
			//val input = Array("car","cat","can")
		val root = new TrieNode
		input.foreach(str=>{
			root.add(str)
		})

    println(root.findString("canvas",0))
     println(root.findString("car",0))
    println(root.findString("camel",0))
     println(root.findString("tiger",0))

		//val words = root.getAllWords()
		//println(words.mkString(" "))

		val regWords = root.findStrinRegExp("car*",0)
    println(regWords.mkString(" "))


	}

}

class TrieNode {
  val children = scala.collection.mutable.Map[Char,TrieNode]()
  var isLeaf = true


	def add(str : String){
		add(str,0)
	}

	def add(str: String, index  : Int){
    if(index == str.length)return false
    var child = children.get(str(index))
			if(!child.isDefined){
				child = Some(new TrieNode)
			   children += (str(index) -> child.get)
				 isLeaf = if(str.length-1 == index) true else false
			}
    child.get.add(str,index+1)

	}

  def findString(str : String,index : Int):Boolean={
    if(str.length == index) return true
    val child = children.get(str(index))

    if(!child.isDefined) return false
    child.get.findString(str,index+1)
  }

	 def findStrinRegExp(str : String,index : Int):Array[String]={
    if(str.length == index) return Array(str)
		if(str(index) == '*') {
			val wordsArray = new scala.collection.mutable.ArrayBuffer[String]
			this.getAllWords(wordsArray,str.substring(0,index))
			return wordsArray.toArray
		}
    val child = children.get(str(index))
		if(!child.isDefined) return Array.empty[String]
    child.get.findStrinRegExp(str,index+1)
  }

	def getAllWords():Array[String]={
		val wordsArrayBuff = new scala.collection.mutable.ArrayBuffer[String]()
		getAllWords(wordsArrayBuff,"")
		wordsArrayBuff.toArray
	}

	private def getAllWords(words: scala.collection.mutable.ArrayBuffer[String],sb : String){
		if(children.isEmpty) return
		 children.foreach(charNode=>{
			 val newStr = sb+ charNode._1
       println(charNode._1)
			 charNode._2.getAllWords(words,newStr)
			 if(isLeaf) words += newStr

		})

	}
}