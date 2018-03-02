import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.BigInteger;

/* Name of the class has to be "Main" only if the class is public. */
class Factorials
{
	public static void main (String[] args)
	{	
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
		BigInteger x = factorial(n);
		System.out.println(x.toString());

	}

	public static BigInteger factorial(int n){
		BigInteger result = new BigInteger(Integer.toString(n));
		BigInteger start = BigInteger.ONE;
		for(int i = 0; i < n; i++){
			start = start.multiply(result);
			result = result.subtract(BigInteger.ONE);
		}
		return start;
	}
}