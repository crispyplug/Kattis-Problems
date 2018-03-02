
import java.util.Stack;

/* Name of the class has to be "Main" only if the class is public. */
class TowersOfHanoi {
	public static void main(String[] args) {

	}

	class Tower {
		Stack<Integer> disks = new Stack<Integer>();

		public void add(Integer n) {
			if (!disks.isEmpty() && disks.peek() >= n) {
				// throw exception
			} else {
				disks.add(n);
			}
		}

		public void movetoTop(Tower wow) {
			wow.add(disks.pop());
		}

		public void moveTo(int n, Tower buffer, Tower destination) {
			moveTo(n - 1, buffer, destination);
			add(n);
			buffer.moveTo(n - 1, destination, this);
		}

	}
}