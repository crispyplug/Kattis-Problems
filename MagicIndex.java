
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.BigInteger;

/* Name of the class has to be "Main" only if the class is public. */
class MagicIndex
{
	public static void main (String[] args)
	{	
		int[] array = new int[]{-10,-5,2,2,2,3,4,7,9,12,13};
		System.out.println(magicIndex(array));
	}

	public static int magicIndex(int[] array){
		return magicIndex(array, 0, array.length - 1);
	}

	public static int magicIndex(int[] array, int left, int right){
		if(right < left){
			return -1;
		}
		int middle = (left + right)/ 2;
		System.out.println(left + " " + right + " " + middle);
		if(array[middle] == middle){
			return middle;
		}
		else if(array[middle] < middle){
			int leftIndex = magicIndex(array, Math.min(array[middle], middle + 1), right);
			if(leftIndex >= 0){
				return leftIndex;
			}
		}
		int rightIndex = magicIndex(array, left, Math.max(middle - 1, array[middle]));
			return rightIndex;
		
	}
}