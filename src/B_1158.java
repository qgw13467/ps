
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B_1158 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int k = scanner.nextInt();

		Queue<Integer> queue = new LinkedList<Integer>();
		CustomList<Integer> list = new CustomList<>();
		for (int i = 1; i <= n; i++) {
			queue.add(i);
		}
		int count = 1;
		while (true) {
			if (queue.size() == 0) {
				break;
			}
			int temp = queue.poll();
			if (count % k == 0) {
				count = 1;
				list.add(temp);
				continue;
			}
			queue.add(temp);
			count++;
		}

		System.out.println(list);

	}
}

class CustomList<E> extends ArrayList<E> {
	@Override
	public String toString() {
		Iterator<E> it = iterator();
		if (!it.hasNext())
			return "<>";

		StringBuilder sb = new StringBuilder();
		sb.append('<');
		for (;;) {
			E e = it.next();
			sb.append(e == this ? "(this Collection)" : e);
			if (!it.hasNext())
				return sb.append('>').toString();
			sb.append(',').append(' ');
		}
	}
}
