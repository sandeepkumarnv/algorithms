package recursion;

public class FibonacciSum {

    public static void main(String[] args){
        int n=10;
        Integer[] cache= new Integer[n];
        System.out.println(fibonacci(n,cache));

        for(Integer i: cache){
            System.out.println(i);
        }

    }



    private static int fibonacci(int n, Integer[] cache){
        if(n <= 0) return 0;
        if(n ==1) return 1;
        int f1 = 0;
        if(cache[n-1] == null) {
            f1 = fibonacci(n-1,cache) ;
            cache[n-1] = f1;
        }
        else f1 = cache[n-1];

        int f2 = 0;
        if(cache[n-2] == null){
            f2 = fibonacci(n-2,cache) ;
            cache[n-2] = f2;
        }
        else f2 = cache[n-2];

        return f1+f2;
    }
}

