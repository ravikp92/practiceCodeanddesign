package com.java.version.code;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class FunctionalInterfaces {

	public static void main(String[] args) {
//		-----------------------------------------------------------------------
		// TODO Auto-generated method stub
		System.out.println("Predicate");
		
		Predicate<String> p1=(s1)-> s1.contains("s");
		
		System.out.println(p1.test("nss"));
		System.out.println(p1.test("ll"));
		
		BiPredicate<String,Integer> bi =(s1,i1)->s1.length()==i1;
		
		System.out.println(bi.test("qwe", 3));
		System.out.println(bi.test("iil",1));
		
//		-----------------------------------------------------------------------
		
		System.out.println("Supplier");
		
		
		Supplier<StringBuilder> str=()-> new StringBuilder();
		System.out.println(str.get().append(true));
		
		Supplier<LocalTime> time=()->LocalTime.now();
		System.out.println(time.get());
		
		Supplier<Double> ran=()-> Math.random();
		System.out.println(ran.get());
		
//		-----------------------------------------------------------------------

		
		System.out.println("Consumer");
		
		Consumer<String> printC= s -> System.out.println(s);
		
		List<String> list=new ArrayList<>();
		list.add("printing");list.add("list");list.add("consumer");
		list.forEach(printC);
		
		Map<String,Integer> mapOfItems=new HashMap<>();
		BiConsumer<String, Integer> bicns= (s,i)-> mapOfItems.put(s,i);
		
		bicns.accept("pen",2);
		bicns.accept("pencil", 3);
		
		System.out.println(mapOfItems);
		
		BiConsumer<String,Integer> print=(s,i)-> System.out.println("Item :"+s+" Quantity:"+i);
		
		mapOfItems.forEach(print);
		
		
//		-----------------------------------------------------------------------
		
		System.out.println("Function");
		Function<String, Integer> f1=(s)-> s.length();
		
		System.out.println(f1.apply("hello"));
		
		BiFunction<String, String, String> bif2=(s1,s2) -> s1.concat(s2);
		
		System.out.println(bif2.apply("Merge ", " Me ."));
		
		
		
		
		
		
//		-----------------------------------------------------------------------
		System.out.println("Unary & binary operator");
		
		
		UnaryOperator<String> name=(s)-> "My name is "+s;
		name.apply("Ravi");
		
		BinaryOperator<String> merge=(s1,s2) -> s1.concat(s2);
		System.out.println(merge.apply("binary", " apply"));
		
//		-----------------------------------------------------------------------


	}

}
