/*
Find the prime reduction of a number described by
Consider the following process, which we’ll call prime reduction. Given an input xx:

1)if xx is prime, print xx and stop
2)factor xx into its prime factors p1,p2,…,pkp1,p2,…,pk
3)let x=p1+p2+⋯+pkx=p1+p2+⋯+pk
4)go back to step 1

sample input - 
2
3
5
76
100
2001
4
sampe output- 
2 1
3 1
5 1
23 2
5 5
5 6
*/
import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class PrimeReduciton
{
    public static void main (String[] args) throws java.lang.Exception
    {
        
        // your code goes here
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        while(num != 4){
            int count = 0;
            int i = 2;
            while(true){
              count++;
              i = primeFactors(num);
              if(i == -1){
                break;    
              }
            num = i;
            }
            System.out.println(num + " " + count);
            num = sc.nextInt();
        }
    }
    // A function to print all prime factors
    // of a given number n
    public static int primeFactors(int n)
    {
        int added = 0;
        int tot = 0;
        
        while (n%2==0)
        {
            tot += 2;
            added++;
            n /= 2;
        }
        //n has to be odd now
        for (int i = 3; i <= Math.sqrt(n); i+= 2)
        {
            while (n%i == 0)
            {
                tot += i;
                added++;
                n /= i;
            }
        }

        if (n > 2){
            tot += n;
            added++;
        }
        if(added == 1){
          //need to check to see if this did any calculatioon otherwise it is finished
            return -1;
        }
        return tot;
    }

}
