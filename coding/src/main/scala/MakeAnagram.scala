object MakeAnagram {

    def main(args: Array[String]) {
        val sc = new java.util.Scanner (System.in);
        var a = sc.next();
        var b = sc.next();
        val diff = makeAnagram(a,b)
        println(diff)
    }

    private def makeAnagram(a : String, b : String)={
        val anagramMap = scala.collection.mutable.Map[Char,Int]()
        for(i <- 0 to a.length-1){
            var count = anagramMap.getOrElse(a(i),0)
            count = count +1
            anagramMap += (a(i) -> count)
        }

        for(i <- 0 to b.length-1){
            var count = anagramMap.getOrElse(b(i),0)
            count = count - 1
            anagramMap += (b(i) -> count)
        }

        anagramMap.values.map(java.lang.Math.abs(_)).sum
    }
}
