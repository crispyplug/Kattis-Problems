
/*
The NWERC organisers have decided that they want to improve the automatic grading of the submissions for the contest,
so they now use two systems: DOMjudge and Kattis. Each submission is judged by both systems and the grading results are
compared to make sure that the systems agree. However, something went wrong in setting up the connection between the systems,
and now the jury only knows all results of both systems, but not which result belongs to which submission! You are therefore
asked to help them figure out how many results could have been consistent.

*/
import java.util.HashMap;
import java.util.Scanner;

class Judging {
	public static void main(String[] args) {
		Scanner n = new Scanner(System.in);
		int userIn = n.nextInt();
		HashMap<String, Integer> dom = new HashMap<String, Integer>();
		HashMap<String, Integer> kat = new HashMap<String, Integer>();
		int total = 0;
		for (int i = 0; i < userIn; i++) {
			String s = n.next();
			if (!dom.containsKey(s))
				dom.put(s, 0);
			dom.put(s, dom.get(s) + 1);
		}
		for (int i = 0; i < userIn; i++) {
			String s = n.next();
			if (!kat.containsKey(s))
				kat.put(s, 0);
			kat.put(s, kat.get(s) + 1);
		}
		for (String s : dom.keySet()) {

			if (kat.containsKey(s)) {
				total += Math.min(kat.get(s), dom.get(s));
			}
		}
		System.out.print(total);
	}
}
