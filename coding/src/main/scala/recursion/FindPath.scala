package recursion

object FindPath extends App{
	val input=Array(Array(1,0,1,1,1,1),
	               Array(1,1,1,1,0,1),
	               Array(0,0,1,0,1,0),
	               Array(1,1,1,1,1,1))

    val pointsBuff = scala.collection.mutable.ArrayBuffer[(Int,Int)]()
    val cache = scala.collection.mutable.Map[(Int,Int),Boolean]()
    findPath(3,4,pointsBuff)
    println(pointsBuff.mkString(" "))


    def findPath(x: Int, y: Int, points : scala.collection.mutable.ArrayBuffer[(Int,Int)]): Boolean={
    	if(x < 0 || y < 0 || input(x)(y) == 0) return false
      val cacheKey = (x,y)
      if (cache.contains(cacheKey)) return cache.get(cacheKey).get

      var result = false
    	if(findPath(x-1,y,points) || findPath(x,y-1,points) || (x==0 && y==0)){
        val xy= (x,y)
        points += xy
    		result =  true
    	}
       cache += (cacheKey -> result)
        return result

    }


}