
/*A binary search tree is a tree in which every node has at most two children nodes (a left and a right child). Each node has an integer written inside it. If the number X is written inside a node, then the numbers in its left subtree are less than X and the numbers in its right subtree are greater than X. You will be given a sequence of integers between 1 and N (inclusive) such that each number appears in the sequence exactly once. You are to create a binary search tree from the sequence, putting the first number in the root node and inserting every other number in order.
When inserting a new number Y in a tree, you first traverse the tree as if you were searching for Y. When you arrive at a node Z such that you can’t continue searching for Y, you put Y as a left or right son of Z depending on if Z>Y or Z<Y, so that after the insertion the tree will still be a binary search tree. After the insertion you add the depth of Y to a counter C and print the value of C. The counter C is set to 0 in the beginning.*/
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BinarySearchTree {
	public static void main(String[] args) throws java.lang.Exception {
		IO sc = new IO(System.in);
		TreeMap<Integer, Integer> map = new TreeMap<>();
		long count = 0;
		Integer cDepth;
		Integer floor;
		Integer ceiling;
		Integer current;
		int seqLength = sc.nextInt();
		for (int i = 0; i < seqLength; i++) {
			current = sc.nextInt();
			floor = map.floorKey(current);
			ceiling = map.ceilingKey(current);
			if (floor == null) {
				if (ceiling == null) {
					cDepth = 0;
				} else {
					cDepth = map.get(ceiling) + 1;
				}
			} else if (ceiling == null) {
				cDepth = map.get(floor) + 1;
			} else {
				cDepth = Math.max(map.get(floor), map.get(ceiling)) + 1;
			}
			map.put(current, cDepth);
			count += cDepth;
			System.out.println(count);
		}
	}
}

class IO extends PrintWriter {
	static BufferedReader r;
	static StringTokenizer t;

	public IO(InputStream i) {
		super(new BufferedOutputStream(System.out));
		r = new BufferedReader(new InputStreamReader(i));
		t = new StringTokenizer("");
	}

	public String nextLine() throws IOException {
		return r.readLine();
	}

	public String next() throws IOException {
		while (!t.hasMoreTokens()) {
			t = new StringTokenizer(r.readLine());
		}
		return t.nextToken();
	}

	public int nextInt() throws IOException {
		return Integer.parseInt(next());
	}

	public long nextLong() throws IOException {
		return Long.parseLong(next());
	}

	public double nextDouble() throws IOException {
		return Double.parseDouble(next());
	}
}
