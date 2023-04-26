package com.ch13.s5_advanced_function;

import java.util.function.*;

public class TransformFunction {

	public static class I {
		@Override
		public String toString(){
			return "I";
		}
	}

	public static class O {
		@Override
		public String toString(){
			return "O";
		}
	}


	static Function<I,O> transform(Function<I,O> in){
		return in.andThen(o -> {
			System.out.println(o);
			return o;
		});
	}

	public static void main(String[] args){
		Function<I,O> f2 = transform(i-> {
			System.out.println(i);
			return new O();
		});
		O o = f2.apply(new I());
	}
}