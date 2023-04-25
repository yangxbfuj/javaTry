import java.util.stream.Stream;
import java.util.*;

public class StreamOfTest {
	record Bubble(int b){}

	public static void createByStreamOf(){
		Stream.of(new Bubble(1), new Bubble(2), new Bubble(3))
			.forEach(System.out::println);
		Stream.of("It's ","a ","wonderful ","day ","for "," pie!")
			.forEach(System.out::print);
		System.out.println();
		Stream.of(3,14159, 2.718, 1.618)
			.forEach(System.out::println);
	}

	public static void createFromCollection(){
		List<Bubble> bubbles = Arrays.asList(new Bubble(1), new Bubble(2), new Bubble(3));
		System.out.println(bubbles.stream().mapToInt(b-> b.b()).sum());

		Set<String> w = new HashSet<>(Arrays.asList(
			"It's a wonderful day for pie!".split(" ")
		));
		w.stream().map(x -> x + " ").forEach(System.out::print);
		System.out.println();

		Map<String,Double> m = new HashMap<>();
		m.put("pi", 3.14159);
		m.put("e", 2.718);
		m.put("phi",1.618);
		m.entrySet().stream().map(e -> e.getKey() + ": " + e.getValue())
			.forEach(System.out::println);

	}

	public static void main(String[] args){
		createByStreamOf();
		createFromCollection();
	}
}