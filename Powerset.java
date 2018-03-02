
import java.util.ArrayList;

/* Name of the class has to be "Main" only if the class is public. */
class Powerset {
	public static void main(String[] args) {
	}

	public static ArrayList<ArrayList<Integer>> powerset(
			ArrayList<Integer> array) {
		ArrayList<ArrayList<Integer>> powerset = new ArrayList<ArrayList<Integer>>();
		double n = Math.pow(2, array.size());
		for (int i = 0; i < n; i++) {
			ArrayList<Integer> actual = intToSet(i, array);
			powerset.add(actual);
		}
		return powerset;
	}

	public static ArrayList<Integer> intToSet(int x,
			ArrayList<Integer> actual) {
		ArrayList<Integer> numbers = new ArrayList<>();
		int current = 0;
		for (int k = x; k > 0; k >>= 1) {
			if ((k & 1) == 1) {
				numbers.add(actual.get(0));
			}
			current++;
		}
		return numbers;
	}
}