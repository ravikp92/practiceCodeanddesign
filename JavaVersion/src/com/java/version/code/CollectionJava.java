package com.java.version.code;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class CollectionJava {
	public static void main(String[] args) {
		Queue<Integer> que=new LinkedList<Integer>();
		
		//ARE - throws exception
		que.add(1);
		System.out.println(que.element());
		que.remove(1);
		System.out.println(que);
		
		//POP - does not throw exceptions - return null/false
		que.offer(1);
		System.out.println(que.peek());
		que.poll();
		System.out.println(que);
		
		
		Deque<Integer> arque=new ArrayDeque<Integer>();
		
		//ARG - throws exception
		arque.addFirst(1);
		arque.addLast(2);
		System.out.println(arque);
		System.out.println(arque.getFirst());
		System.out.println(arque.getLast());
		arque.removeLast();
		arque.removeFirst();
		System.out.println(arque);
		
		//POP does not throw exception - return null/false
		arque.offerFirst(1);
		arque.offerLast(2);
		System.out.println(arque);
		System.out.println(arque.peekFirst());
		System.out.println(arque.peekLast());
		arque.pollFirst();
		arque.pollLast();
		System.out.println(arque);
		
		Queue<Integer> priorityNaturalOrder=new PriorityQueue<Integer>();
		
		priorityNaturalOrder.add(3);
		priorityNaturalOrder.add(1);
		priorityNaturalOrder.add(5);
		System.out.println(priorityNaturalOrder);
		
		
		Queue<Integer> priorityDifferentOrder=new PriorityQueue<Integer>
		((o1, o2) -> {if(o2>o1) return o2; else return o1;});
		
		priorityDifferentOrder.add(3);
		priorityDifferentOrder.add(1);
		priorityDifferentOrder.add(5);
		System.out.println(priorityDifferentOrder);
		Iterator itInts=priorityDifferentOrder.iterator();
		while (itInts.hasNext()) {
			Integer i=priorityDifferentOrder.poll();
			System.out.println(i);
			
		}
		
		//Sorting

        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat("Trixy", 5));
        cats.add(new Cat("Bella", 7));
        cats.add(new Cat("Bella", 2)); // second Bella

		Comparator<Cat> comp=Comparator.comparing(Cat::getName).thenComparing(Cat::getAge);
		Collections.sort(cats,comp);
		System.out.println(cats);
		
	}


}