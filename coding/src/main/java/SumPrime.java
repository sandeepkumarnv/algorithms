public class SumPrime {


	public static void main(String[] args){
		int num = 18;
		boolean result = checkPrime(num);
		System.out.println(num + " priime:" + result);
	}

	private static boolean checkPrime(int num){
        for(int i=2; i < num/2 + 1; i++){
        	if(num % i == 0) return false;
        }

        return true;
    }
}
