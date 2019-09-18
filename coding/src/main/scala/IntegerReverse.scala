object IntegerReverse extends App{

   println(reverse(1534236469))

   def reverse(x: Int): Int = {
        var digBuff = new scala.collection.mutable.ArrayBuffer[Int]()
        var result = 0
        var inp = if(x < 0 ) -1*x else x

       var sign = if(x > 0) 1 else -1


        while(inp>0){
            val dig = inp%10
            inp = inp/10
            digBuff += dig
        }

        var len = digBuff.length
        for(i <- 0 to len-1){
            var product = 1
            for(j <- 1 to len-1-i) product *= 10
            result += digBuff(i) * product
        }

        result *= sign
        if((x > 0 && result < 0) || (x < 0 && result > 0) ) return -1
        result

    }


}


