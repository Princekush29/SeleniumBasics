import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Streams2 {

	static List<String> al = new ArrayList<String>();
	static {
		al.add("Sumit");
		al.add("Amit");
		al.add("Virat");
		al.add("MS");
		al.add("Adam");
		al.add("AA");
	}

	@Test
	public static void withoutStreams() {

		int count = 0;
		// Method 6
		for (int i = 0; i < al.size(); i++) {
			String str = al.get(i);
			if (str.toUpperCase().startsWith("A")) {
				count++;
			}
		}
		System.out.println("Count is " + count);
	}

	@Test
	public void withStreams() {
		Long count = al.stream().filter(s -> s.startsWith("A")).count();
		System.out.println("From streams " + count);

		Long count1 = Stream.of("Abhi", "Virat").filter(s -> s.startsWith("A")).count();
		System.out.println("Count 1 is " + count1);

		al.stream().forEach(System.out::println);

		Long lengthGreater = al.stream().filter(s -> s.length() > 4).count();
		System.out.println("Length more than 4 " + lengthGreater);
		al.stream().filter(s -> s.length() > 4).forEach(System.out::println);
		System.out.println("---");
		al.stream().filter(s -> s.length() > 4).forEach(s -> System.out.println(s));
		System.out.println("---");
		al.stream().filter(s -> s.length() > 4).limit(1).forEach(s -> System.out.println(s));

	}

	@Test
	public void streamMap() {
		al.stream().filter(s -> s.length() > 4).map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));
		System.out.println("-----");
		al.stream().map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));

		System.out.println("+++");
		al.stream().filter(s -> s.startsWith("A"))
				// .map(s->s.toUpperCase())
				.sorted().forEach(System.out::println);

		// sort
		System.out.println("+_+_");
		al.stream().sorted().forEach(System.out::println);

		boolean flag = al.stream().anyMatch(s -> s.equalsIgnoreCase("Adam"));
		Assert.assertTrue(flag);
	}

	@Test
	public void streamCollect() {

		List<String> collectorList = al.stream().filter(s -> s.length() > 4).map(s -> s.toUpperCase())
				.collect(Collectors.toList());

		System.out.println(collectorList);
		System.out.println(collectorList.get(0));

		Set<String> setList = al.stream().filter(s -> s.length() > 4).map(s -> s.toUpperCase())
				.collect(Collectors.toSet());
		System.out.println("1111");
		System.out.println(setList);

		al.stream().filter(s -> s.length() > 4).map(s -> s.toUpperCase()).collect(Collectors.toMap(null, null));

	}

	@Test
	public void sortIntergerArrayUsingStreams() {
		List<Integer> values = Arrays.asList(1, 1, 3, 5, 6, 7, 8, 2, 4, 6, 7);
		values.stream().distinct().forEach(s -> System.out.println(s));
		System.out.println("2");
		values.stream().sorted().forEach(s -> System.out.println(s));
		System.out.println("22");
		values.stream().distinct().sorted().forEach(s -> System.out.println(s));
		System.out.println("222");
		values.stream().sorted().sequential().forEach(s -> System.out.println(s));
		System.out.println("2222");
		values.stream().sorted(Comparator.reverseOrder()).forEach(s -> System.out.println(s));

	}
}
