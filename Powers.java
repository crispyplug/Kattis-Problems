/*
https://open.kattis.com/problems/powers
*/
import java.util.*;
import java.lang.*;
import java.math.BigInteger;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Powers
{
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        Scanner sc = new Scanner(System.in);
        BigInteger num = new BigInteger(sc.next());
        BigInteger b = new BigInteger(sc.next());
        BigInteger num2 = num;
        num = num.multiply(num.add(BigInteger.ONE));
        num = num.divide(BigInteger.valueOf(2));
        num = num.modPow(b, num2);
        System.out.println(num);
    }
}
