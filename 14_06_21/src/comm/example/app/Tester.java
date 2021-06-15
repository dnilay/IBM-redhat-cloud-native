package comm.example.app;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.UUID;

import comm.example.Desccomparator;
import comm.example.PriorityComparator;
import comm.example.Todo;

public class Tester {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		Desccomparator desccomparator = new Desccomparator();
		PriorityComparator priorityComparator = new PriorityComparator();
		Set<Todo> set = new TreeSet<Todo>(priorityComparator);

		set.add(new Todo(UUID.randomUUID().toString(), "compile", 3));
		set.add(new Todo(UUID.randomUUID().toString(), "Analysys", 1));
		set.add(new Todo(UUID.randomUUID().toString(), "ByteCodeVerifications", 1));
		/*
		 * for(Todo t:set) { System.out.println(t); }
		 * //CRUD(Create-Remove-Update-Display) Set s1=new TreeSet<>(); s1.size();
		 * s1.add(10);
		 * 
		 * s1.add(2); System.out.println(s1);
		 */
		for (Todo t : set) {
			System.out.println(t);

		}

		System.out.println("Enter Todo id: ");
		String id = scanner.next();
		Todo todo = null;
		Iterator<Todo> i = set.iterator();
		while (i.hasNext()) {
			todo = i.next();
			if (todo.getTodoId().equals(id)) {
				System.out.println("found: " + todo);
				set.remove(todo);
				System.out.println("removed.");
			}
		}
		for (Todo t : set) {
			System.out.printf("%s %s %d", t.getTodoId(),t.getDesc(),t.getPriority());
		}
	}
}