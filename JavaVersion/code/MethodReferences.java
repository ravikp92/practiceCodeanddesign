package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReferences {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Consumer<List<Integer>> list= l->Collections.sort(l);
		
		Consumer<List<Integer>> list2=Collections::sort;

		
		
		List<Integer> l=Arrays.asList(1,6,3,9,2,1);
		list.accept(l);
		List<Integer> l2=Arrays.asList(1,6,3,9,2,1);

		list2.accept(l2);
		System.out.println(l);
		System.out.println("Static method ref"+l2);
		
		
		
		Supplier<StringBuilder> st1=StringBuilder::new;
		StringBuilder sb1=st1.get();
		sb1.append(false);sb1.append("string");
		System.out.println(sb1);

		Function<Integer,List<String>> strings=x->new ArrayList(x);

		
		Function<Integer,List<String>> string2s=ArrayList::new;
		
		List<String> listOfstr=string2s.apply(2);
		listOfstr.add("11");
		System.out.println("constructor ref "+listOfstr);
		
		
		
		
		
		
	}

}
