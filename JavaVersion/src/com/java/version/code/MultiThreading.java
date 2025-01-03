package com.java.version.code;

import java.util.Iterator;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MultiThreading {

	private static AtomicInteger atomicCount=new AtomicInteger();

	public static void main(String[] args) {
		
		Thread obj=new Mythread();
		obj.start();
		System.out.println(obj.currentThread().getName());

		System.out.println("main thread: "+Thread.currentThread().getName());
		Thread obj2=new Thread(new Mythread2());
		obj2.start();
		System.out.println(obj2.currentThread().getName());

		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Counting going down...");
		Thread countDown=new Thread(new countDown());
		countDown.start();
		
		try {
			countDown.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("finished countdown..");
		
		
		ExecutorService ess=Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		
		ess.execute(()-> System.out.println("runnable running .."));
		
		ess.shutdown();
		ExecutorService ess2=Executors.newSingleThreadExecutor();

		Future<Integer> future=ess2.submit(()-> 3+7);
		
		try {
			System.out.println("future answer: "+
		future.get(10,TimeUnit.MILLISECONDS));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ess2.shutdown();
		
		
		ScheduledExecutorService schedEs=Executors.newScheduledThreadPool(10);
		
		Future<String> futureSch=schedEs.schedule(()->"A",1,TimeUnit.SECONDS);
		
		try {
			System.out.println(futureSch.get());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Always at the end!!");
		schedEs.shutdown();

		
		
		ExecutorService es1=Executors.newFixedThreadPool(5);
			for(int i=1;i<=10;i++) {
				es1.submit(()->System.out.println(atomicCount.incrementAndGet()));

		}
			
			Lock lock=new ReentrantLock();
			try {
				lock.lock();
				es1.submit(()->System.out.println(atomicCount.incrementAndGet()));

				//do critical section
			}catch (Exception e) {
				lock.unlock();
			}
	
		
		es1.shutdown();
		
	}
}

class Mythread extends Thread{
	
	@Override
	public void run() {
		System.out.println("run method: "+getName());
	}
	
	
}

class Mythread2 implements Runnable{

	@Override
	public void run() {
		System.out.println("runnable run :"+Thread.currentThread().getName());
	} 
	
}


class countDown implements Runnable{

	@Override
	public void run() {
		for(int i=9;i>=0;i--) {
			try {
				System.out.println("Tick : "+i);
				Thread.sleep(50);
			}catch (Exception e) {
					e.printStackTrace();
			}
		}
	}
	
}



