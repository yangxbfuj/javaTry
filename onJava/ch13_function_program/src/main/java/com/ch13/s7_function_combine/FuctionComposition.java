import java.util.function.*;

public class FunctionComposition {
	static Function<String,String> f1 = s -> {
		System.out.println("f1 input  " + s);
		String r = s.replace('A','_');
		System.out.println("f1 output " + r);
		return r;
	},
	f2 = s -> {
		System.out.println("f2 input  " + s);
		String r = s.substring(3);
		System.out.println("f2 output " + r);
		return r;
	},
	f3 = s -> {
		System.out.println("f3 input  " + s);
		String r = s.toLowerCase();
		System.out.println("f3 output " + r);
		return r;
	},
	// step1 先执行 f2 在执行 f1
	// 先执行 step1 再执行 f3
	f4 = f1.compose(f2).andThen(f3);

	public static void main(String[] args){
		System.out.println(f4.apply("GO AFTER ALL AMBULANCES"));
	}

}