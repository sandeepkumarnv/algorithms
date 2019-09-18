
object SpiralArray extends App{

	val input = Array(Array(1,2,3,4,5,100),
	                   Array(6,7,8,9,10,101),
	                   Array(11,12,13,14,15,102),
	                   Array(16,17,18,19,20,103),
  Array(105,106,107,108,109,110))
	// spiral(input,5,6,(0,0))
	println(spiralOrder(input).mkString(" "))

    def spiral(input : Array[Array[Int]], rowCount : Int, colCount : Int ,startIndex : (Int,Int)):Unit = {
       // if(rowCount <= 2 || colCount <=2) return
        var i = startIndex._1
        var j = startIndex._2
    	while(j < colCount){
    		println(input(i)(j))
    		j += 1
    	}

    	j -= 1
      i += 1

        while(i < rowCount){
    		println(input(i)(j))
    		i += 1
    	}

        i -= 1
         j -= 1

        while(j >= startIndex._2){
    		println(input(i)(j))
    		j -= 1
    	}

    	j += 1
      i -= 1
             var insideLoop = false
        while(i > startIndex._1){
    		println(input(i)(j))
    		i -= 1
                  insideLoop = true
    	}

      if(!insideLoop) return


      i += 1
    	spiral(input,rowCount-1,colCount-1,(i,j+1))


    }


	def spiralOrder(matrix: Array[Array[Int]]): scala.collection.mutable.ArrayBuffer[Integer] = {
		val ans = new scala.collection.mutable.ArrayBuffer[Integer]
		if (matrix.length == 0) return ans
		val R = matrix.length
		val C = matrix(0).length
		val seen = Array.ofDim[Boolean](R,C)

		val dr = Array(0, 1, 0, -1)
		val dc = Array(1, 0, -1, 0)
		var r = 0
		var c = 0
		var di = 0
		var i = 0
		for (i <- 0 to R * C) {
			ans += (matrix(r)(c))
			seen(r)(c) = true
			val cr = r + dr(di)
			val cc = c + dc(di)
			if (0 <= cr && cr < R && 0 <= cc && cc < C && !seen(cr)(cc)) {
				r = cr
				c = cc
			}
			else {
				di = (di + 1) % 4
				r += dr(di)
				c += dc(di)
			}

			{

			}
		}
		ans
	}
}