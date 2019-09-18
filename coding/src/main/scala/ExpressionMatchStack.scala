
object ExpressionMatchStackSolution {

    def main(args: Array[String]) {
        val sc = new java.util.Scanner (System.in);
        var t = sc.nextInt();
        var a0 = 0;
        while(a0 < t){
            var expression = sc.next();
            println(isEpressionValid(expression))
            a0+=1;
        }

    }

    private def isEpressionValid(exp : String): String={
        val expStack = scala.collection.mutable.Stack[Char]()
        val expMap = scala.collection.immutable.Map('}'->'{',')'->'(',']'->'[')
        for(i <- 0 to exp.length - 1){
            //if(!expMap.get(exp(i)).isDefined) return "NO"
            if(expStack.size > 0 &&  expMap.get(exp(i)).isDefined && expMap.get(exp(i)).get == expStack.top){
                expStack.pop
            }else{
                expStack.push(exp(i))
            }
        }
        if(expStack.size > 0) "NO" else "YES"
    }

}
