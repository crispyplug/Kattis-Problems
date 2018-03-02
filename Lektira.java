
/*
Mario is making up silly games again instead of reading Dostoevsky for school. The rules of his newest game follow.
First he chooses a random word from the book. Then he splits the word in two arbitrary places to get three separate words.
After that he reverses the order of the letters in each of those three words (exchanges the first and last letters,
the second and second last and so on).

Finally, he puts the three words back together in the same order in which they were before splitting.
The goal of the game is to obtain the lexicographically smallest word possible.
In other words, of all words that can be obtained by the above procedure, find one which would be earliest in a dictionary.

Write a program that plays Mario’s game perfectly.
*/
import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 *
 * @author Jami Daly <jcd0035@auburn.edu>
 * @version 2016
 *
 */

public class Lektira {

	public static char function1(char[] arr) {
		char smallest = arr[0];
		for (int i = 1; i < arr.length - 2; i++) {
			if (smallest > arr[i]) {
				smallest = arr[i];
			}
		}
		return smallest;
	}

	public static void main(String[] args) {
		Scanner m = new Scanner(System.in);
		String n = m.nextLine();
		int p = n.length();
		char[] arr = n.toCharArray();
		char smallest = function1(arr);
		TreeSet<String> tree = new TreeSet<String>();
		for (int i = 0; i < arr.length - 2; i++)
			if (arr[i] == smallest) {
				gen(i + 1, i + 2, p, n, tree);
			}
		String output = tree.first();
		System.out.println(output);
	}

	public static void gen(int start1, int start2, int end, String input,
			TreeSet<String> tree) {
		if (start2 != end) {
			String omg = breakUp(start1, start2, end, input);
			tree.add(omg);
			gen(start1, start2 + 1, end, input, tree);
		}
	}

	public static String breakUp(int start1, int start2, int end,
			String input) {
		StringBuilder word1 = new StringBuilder();
		StringBuilder word2 = new StringBuilder();
		StringBuilder word3 = new StringBuilder();
		StringBuilder result = new StringBuilder();
		word1.append(input.substring(0, start1));
		// System.out.println(word1.toString());
		word1 = word1.reverse();
		word2.append(input.substring(start1, start2));
		// System.out.println(word2.toString());
		word2 = word2.reverse();
		word3.append(input.substring(start2, end));
		// System.out.println(word3.toString());
		word3 = word3.reverse();
		result.append(word1);
		result.append(word2);
		result.append(word3);
		return result.toString();
	}

}
