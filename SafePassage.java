/*

https://open.kattis.com/problems/safepassage

Sample input- 5 12 1 3 8 6
Sample output- 29
*/

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class SafePassage
{
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        Scanner sc = new Scanner(System.in);
        int number_of_people = sc.nextInt();
        int[] times = new int[number_of_people];
        //Reading in the times of student to cross campus
        for(int i = 0; i < number_of_people; i++){
            times[i] = sc.nextInt();
        }
        
        Arrays.sort(times);
        int total_time = 0;
        if(number_of_people == 1){
            System.out.println(times[0]);
            return;
        }
        
        while(number_of_people > 0){
            if(number_of_people > 3){
              //take the max of the two choices
                if(times[number_of_people - 1] + times[0] + (times[1] * 2) < (times[0] * 2) + times[number_of_people - 1] + times[number_of_people - 2]){
                    total_time += times[number_of_people - 1] + times[0] + (times[1] * 2);
                    number_of_people = number_of_people - 2;
            }
                else{
                total_time += (times[0] * 2) + times[number_of_people - 1] + times[number_of_people - 2];
                number_of_people -= 2;
                    }
            }
            else{
                if(number_of_people == 2){
                    total_time += times[1];
                    number_of_people -= 2;
                }
                else{
                  total_time += times[number_of_people - 1] + times[0] + times[1];  
                }
                number_of_people -= 3;
            }
        }
        System.out.println(total_time);
    }
}
