import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class PrintArrayList {

	public static void main(String[] args) {
		arrayListPrint();
	}

	public static void arrayListPrint() {
		List<String> al = new ArrayList<String>();
		al.add("Sumit");
		al.add("Amit");
		al.add("Virat");
		al.add("MS");
		al.add("Adam");

		// Method 1 - using java8
		al.stream().forEach(System.out::println);

		// Method 2
		System.out.println(al);

		// Method 3
		System.out.println(Arrays.asList(al));

		// Method 4
		Iterator<String> itr = al.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}

		// Method 5
		for (String list : al) {
			System.out.println(list);
		}

		// Method 6
		for (int i = 0; i < al.size(); i++) {
			System.out.println(al.get(i));
		}
	}
}
