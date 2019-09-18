

/*
  BigInt 3262362362326263272727
  BigInt 1111111111111111111111
  Sum    43...
*/
// package whatever; // don't place package name!

import java.io.*;

public class BigNumAdd
{
    public static void main (String[] args) throws java.lang.Exception
    {
        System.out.println("Hello Java");
        BigInt num1 = new BigInt("12345");
        BigInt num2 = new BigInt("5678");

        System.out.println(num1.add(num2));
    }
}

class BigInt{

    String numStr;

    public BigInt(String numString){
        this.numStr = numString;
    }

    public String add(BigInt numToAddBigInt){
        String numToAdd =  numToAddBigInt.numStr;
        int carry = 0;
        int i = numStr.length()-1;
        int j= numToAdd.length()-1;
        StringBuilder result = new StringBuilder();
        while(i >= 0 && j >=0){
            int digit1 = Character.getNumericValue(numStr.charAt(i));
            int digit2 = Character.getNumericValue(numToAdd.charAt(j));
            int digitSum =  (digit1+ digit2+carry)%10;
            carry =  (digit1+ digit2+carry)/10;
            result.append(String.valueOf(digitSum));
            i--;
            j--;

        }

        if(i < 0){

            while( j >= 0){
                int digit = Character.getNumericValue(numToAdd.charAt(j));
                int digitSum = (digit+carry)%10;
                carry = (digit+carry)/10;
                result.append(String.valueOf(digitSum));
                j--;
            }

        }else{

            while( i >= 0){
                int digit = Character.getNumericValue(numStr.charAt(i));
                int digitSum = (digit+carry)%10;
                carry = (digit+carry)/10;
                result.append(String.valueOf(digitSum));
                i--;
            }

        }

        if(carry > 0){
            result.append(String.valueOf(carry));
        }

        return result.reverse().toString();
    }
}