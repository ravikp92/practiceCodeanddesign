package com.java.version.code;

import java.util.Arrays;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Streams {
	
	public static void main(String[] args) {
		Stream.of("Alex","Rat","time","hey").peek(System.out::println).
			map(s->{
				System.out.println("map : "+s);
				return s.toUpperCase();
			}).peek(System.out::println)
			.anyMatch(s->{
				System.out.println("is it time? : "+s);
				return s.startsWith("t");

			});
		
		
		System.out.println("end........................................");
		Stream.of("Alex","Rat","time","hey","htl","html").
		peek(System.out::println).
		filter(s->s.startsWith("h")).limit(2).forEach(System.out::println);
		
		System.out.println("end........................................");

		
		Double[] numbes= {1.1,2.0,3.0,3.3};
		
		Stream<Double> streamsOfDouble=Arrays.stream(numbes);
		long n=streamsOfDouble.count();
		System.out.println("No. of elements. "+n);
		
		System.out.println("end........................................");
		List<String> an=Arrays.asList("cat","dog");
		
		Stream<String> animals=an.stream();
		System.out.println("No. of animals in list. "+animals.count());
		
		System.out.println("end........................................");
		Map<String,Integer> map=new HashMap();
		
		map.put("1", 1);
		map.put("2", 2);
		
		System.out.println("map counts: "+map.entrySet().stream().count());
		
		System.out.println("end........................................");

		Stream.iterate(2,a->a+2).limit(5).forEach(System.out::println);
		
		

		System.out.println("end........................................");

		
		// terminal operations , count , min and max
		
		long count =Stream.of("dog","horse","deer").count();
		System.out.println(count);
		
		Optional<String> min=Stream.of("dog","horse","deer").min((s1,s2)->s1.length()-s2.length());
		min.ifPresent(System.out::println);
		
		Optional<Integer> max = Stream.of(1,4,3,8,1,0,30).max((i1,i2)->i1-i2);
		max.ifPresent(System.out::println);
		
		
		Optional<Integer> emptyMax = Stream.of(1,4,3,8,1,0,30).filter(i->i>40).max((i1,i2)->i1-i2);
		emptyMax.ifPresent(System.out::println);// output is empty
		
		System.out.println("end........................................");

		
		// terminal operation findany, findfirst
		Optional<String> any=Stream.of("dog","horse","deer").findAny();
		Optional<String> first=Stream.of("dog","horse","deer").findFirst();
		
		System.out.println(any.orElse(null));
		System.out.println(first.orElse(null));
		
		System.out.println("end........................................");

		//terminal operations anymatch,allmatch or nonematch and foreach
		
		List<String> names=Arrays.asList("dog","horse","deer");
		Predicate<String> pred = name->name.startsWith("d");
		
		System.out.println(names.stream().anyMatch(pred));
		System.out.println(names.stream().allMatch(pred));
		System.out.println(names.stream().noneMatch(pred));
		
		names.forEach(System.out::print);
		
		System.out.println("end........................................");

		//reductions 
		
		String name=Stream.of("j","y","o","t","i").
				reduce("",(firstString,secondString)-> firstString+secondString);
		System.out.println(name);
		
		//return initial value if none found
		String noname=Stream.of("j","y","o","t","i").filter(s->s.length()>2).
				reduce("none",(firstString,secondString)-> firstString+secondString);
		System.out.println(noname);
		
		BinaryOperator<Integer> bin=(a,b)->a+b;
		
		Stream<Integer> empty=Stream.empty();
		Stream<Integer> oneval=Stream.of(6);
		Stream<Integer> multval=Stream.of(3,4,5,6);
		
		empty.reduce(bin).ifPresent(System.out::println);
		oneval.reduce(bin).ifPresent(System.out::println);
		multval.reduce(bin).ifPresent(System.out::println);
		

		
		System.out.println("end........................................");
		
		//count number of character of each string
		Stream<String> chars=Stream.of("can","you","count","all","values?");
		
		int countOfChars=chars.reduce(0,(i,s)->i+s.length(),(i1,i2)->i1+i2);
		System.out.println("total number of chars in each string: "+countOfChars);
		
		

		System.out.println("end........................................");

		StringBuilder word=Stream.of("can","you","count","all","values?").
				collect(()->new StringBuilder(),
						(sb,str)->sb.append(str+" "),
						(sb1,sb2)->sb1.append(sb2));
		System.out.println(word);
		
		System.out.println("end........................................");

		
		
		String s=Stream.of("apple","teeth","test").collect(Collectors.joining(","));
		System.out.println(s);
		Double avgs=Stream.of("apple","teeth","test").collect(Collectors.averagingDouble(s1->s1.length()));
		System.out.println(avgs);
		
		Map<String,Integer> m=Stream.of("apple","teeth","test").collect(
				Collectors.toMap(key->key, val->val.length()));
		System.out.println(m);
		
		//if length is same for two string using collectors map merge one
		
		Map<Integer,String> m2=Stream.of("apple","teeth","test").collect(
				Collectors.toMap(key->key.length(), val->val,
						(s1,s2)->s1+","+s2));
		System.out.println(m2);
		
		System.out.println("end........................................");

		
		//sort the values using treemap and if same key then merge length
		TreeMap<String,Integer> m3=Stream.of("apple","teeth","test","test").collect(
				Collectors.toMap(key->key, val->val.length(),
						(len1,len2)-> len1+len2,
						()-> new TreeMap<String, Integer>()));
		
		System.out.println(m3);
		
		
		System.out.println("end........................................");

		Stream<String> names1=Stream.of("apple","teeth","test","test","Joet");
		
		Map<Integer,List<String>> listFromGroup=names1.collect(Collectors.groupingBy(String::length));
		System.out.println(listFromGroup);
		
		//remove duplicates
		Stream<String> names2=Stream.of("apple","teeth","test","test","Joet");

		Map<Integer,Set<String>> setFromGroup=names2.collect(Collectors.groupingBy(
				String::length,
				Collectors.toSet()));
		System.out.println(setFromGroup);
		
		
		Stream<String> names3=Stream.of("apple","teeth","test","test","Joet");

		TreeMap<Integer,Set<String>> treeMapFromGroup=names3.collect(Collectors.groupingBy(
				String::length,TreeMap::new,Collectors.toSet()));
		System.out.println(setFromGroup);
		
		

		System.out.println("end........................................");
		
		Stream<String> names4=Stream.of("apple","teeth","test","test","Joet");
		
		Map<Boolean,List<String>> booleanValuesOnlyByPartition=names4.collect(
					Collectors.partitioningBy(sq->sq.startsWith("t")));
		System.out.println(booleanValuesOnlyByPartition);
		
		Stream<String> names5=Stream.of("apple","teeth","test","test","Joet");

		//get set view
		Map<Boolean,Set<String>> booleanValuesOnlyByPartitionSet=names5.collect(
				Collectors.partitioningBy(sq->sq.startsWith("t"),Collectors.toSet()));
		
		System.out.println(booleanValuesOnlyByPartitionSet);
		
		System.out.println("end........................................");

		//intermediate operation filter , distinct , limit
		Stream.of("eagle","cat","eagle","EAGLE").peek(sw->System.out.println("1. "+sw)).
			distinct().forEach(s2->System.out.println("2. : "+s2));
		
		Stream.of(1,3,2,4,5).limit(2).forEach(System.out::println);
		
		System.out.println("end........................................");

		
		//intermediate operation map,flatmap,sorted
		Stream.of("one","two","three").map(x->x.length()).forEach(System.out::print);
		

		System.out.println();

		List<String> l1=Arrays.asList("one","two");
		List<String> l2=Arrays.asList("three","four");
		
		Stream<List<String>> listofstr=Stream.of(l1,l2);
		
		listofstr.flatMap(list->list.stream()).forEach(System.out::print);

		System.out.println();

		Stream.of("Xmll","One","Two","Ahree").sorted().forEach(System.out::print);
		System.out.println();

		System.out.println("end........................................");

		
		//primitive streams
		
		IntStream ia=IntStream.of(1,2,3);
		DoubleStream da=DoubleStream.of(1.2,2.2,3.3);
		LongStream la=LongStream.of(1l,2l,3l);
		System.out.println("Counts"+ia.count()+"-"+da.count()+"-"+la.count());
		
		IntStream ints=Stream.of(1,2,3).mapToInt(i->i);
		System.out.println("Sum: "+ints.sum());
		
		
		OptionalInt primmin=IntStream.of(2,5,1,3,7).min();
		primmin.ifPresent(System.out::println);
		
		
		OptionalDouble primmax=DoubleStream.of(2,5,1,3,7).max();
		System.out.println(primmax.orElseThrow());
		
		OptionalDouble primavg=LongStream.of(2,5,1,3,7).average();
		System.out.println(primavg.orElseGet(()-> Math.random()));
		
		IntStream ints1=IntStream.empty();
		
		IntSummaryStatistics summary=ints1.summaryStatistics();
		System.out.println(summary.getMin());//max int val
		System.out.println(summary.getMax());//min int val

		System.out.println(summary.getAverage());
		System.out.println(summary.getCount());
		System.out.println(summary.getSum());

		System.out.println("end........................................");

//		Stream to Stream
		Stream.of("Xmll","One","Two","Ahree").map(l->l.toUpperCase()).forEach(System.out::println);		
//		Stream to DoubleStream
		Stream.of("Xmll","One","Two","Ahree").mapToDouble(l->l.length()).forEach(System.out::println);		
//		Stream to LongStream
		Stream.of("Xmll","One","Two","Ahree").mapToLong(l->l.length()).forEach(System.out::println);		
//		Stream to IntStream
		Stream.of("Xmll","One","Two","Ahree").mapToInt(l->l.length()).forEach(System.out::println);		

		
//		IntStream to Stream
		IntStream.of(1,2,3,4).mapToObj(n5 ->"Number: "+n5).forEach(System.out::println);
//		IntStream to DoubleStream
		IntStream.of(1,2,3,4).mapToDouble(n5 ->n5*2.0).forEach(System.out::println);

//		IntStream to LongStream
		IntStream.of(1,2,3,4).mapToLong(n5 ->n5*3l).forEach(System.out::println);

//		IntStream to IntStream
		IntStream.of(1,2,3,4).map(n5 ->n5*4).forEach(System.out::println);
		
		Optional optionals=Optional.ofNullable(null);
		System.out.println(optionals);//Optional.empty

		OptionalDouble avg=IntStream.rangeClosed(1, 4).average();
		System.out.println(avg.getAsDouble());
		System.out.println(avg.orElse(0.0));
		System.out.println(avg.orElseThrow());
		System.out.println(avg.orElseGet(()-> Double.NaN));

		
		
		int sum=Stream.of(1,3,4,5).mapToInt(d->d.intValue()).sum();
		System.out.println(sum);
		int sumparrallel=Stream.of(1,3,4,5).parallel().mapToInt(d->d.intValue()).sum();
		System.out.println(sumparrallel);
		
		
		
		
		
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		

		
	}

}
