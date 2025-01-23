package code;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class Java11changes {

//	var s="as"; // cannot define here
//	static var h=1; not allowed here
	public static void main(String[] args) {
		var x="abc";
		System.out.println(x);
		var c=1.2;
		System.out.println(c);
		
//		var i=null;//not allowed to null
		var i=(String )null; // now it will know the type
		var var="str"; // its fine.
		
		tennis tens=new professional();
		tens.backhand();
		tennis.forehand();
	}
	
	{
		var z=1.2;//initialize is must in same line
//		z="a"; //type cannot be changed
	}
	
//	void test(var h) not allowed here
	public Java11changes() {
		var z=1.2;
	}
	
	
}

class professional implements tennis{}

interface tennis{
	private static void hit(String srr) {
		System.out.println("Hitting stroke : "+srr);
	}
	
	static void forehand() {hit("ravi");}
	default void backhand() {hit("kumar");}
	private void smash() {hit("puri");}
	
	

}

@FunctionalInterface
interface Moveables{
	void move();
	
	// object method not count as abstract method in functional interface	
	boolean equals(Object m);
	String toString();
	
}

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE_USE,ElementType.METHOD})
@interface OnWeb{
	int startTime() default 9;
	int hours();
}

@OnWeb(startTime = 8,hours = 1)
class Human {
	
	@OnWeb(hours = 1)
	void m1() {};
}

class man extends Human{
	
}


@interface Batteries{
	Battery[] value();
}

@Repeatable(Batteries.class)
@interface Battery{
	String level();
	boolean recharge();
}

@Battery(level = "low",recharge = false)
@Battery(level = "high",recharge = true)
class ElectricCar{}