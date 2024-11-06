package StreamsPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class StreamsDemo {

	@Test
	public void findNames() {
		ArrayList<String> names = new ArrayList<String>();

		names.add("abhishek");
		names.add("soham");
		names.add("adhish");

		names.add("rohan");

		names.add("vikas");

		names.add("amol");
		int c = 0;

		for (int i = 0; i < names.size(); i++) {

			String n = names.get(i);
			System.out.println(n + " ");

			if (n.startsWith("a")) {
				c++;
			}
		}

		System.out.println(c);

	}

	@Test
	public void findNamesWithStream() {
		ArrayList<String> names = new ArrayList<String>();

		names.add("abhishek");
		names.add("soham");
		names.add("adhish");

		names.add("rohan");

		names.add("vikas");

		names.add("amol");
		long c = names.stream().filter(s -> s.startsWith("a")).count();

		System.out.println(c);

		long d = Stream.of("abhishek", "soham", "adhish", "rohan", "amol").filter(s -> s.startsWith("a")).count();
		System.out.println(d);
		names.stream().filter(s -> s.length() > 4).forEach(s -> System.out.println(s));

		names.stream().filter(s -> s.length() > 4).limit(1).forEach(s -> System.out.println(s));

	}
	
	@Test
	public void streamMap() {
		Stream.of("sonali","Rama").filter(s->s.endsWith("a")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		List<String>  names=Arrays.asList("apple","mango","adam","angur");
		names.stream().filter(s->s.startsWith("a")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		List<String>  names1=Arrays.asList("Banana","pineapple");
		
		Stream<String> newStream=Stream.concat(names.stream(), names1.stream());

		//newStream.sorted().forEach(s->System.out.println(s));
		
		boolean flat=newStream.anyMatch(s->s.equalsIgnoreCase("adam"));
		
		Assert.assertTrue(flat);
		
	}

}
