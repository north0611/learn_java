package learn_java;


class Demo_1 {
	Demo_1(){
		System.out.println("Demo_1");
	}
	
	void method(int a) {
		System.out.println("void method(int a)");
	}

	void method(String str) {
		System.out.println("void method(String str)");
	}
	
	void method(int a, int b) {
		System.out.println("void method(int a, int b)");
	}
	
	String method() {
		System.out.println("String method()");
		return new String();
	}

	
//	String method(int a) {
//		return new String();
//	}
}

class Demo_2 {
	public String str1;
	public int int1=2;
	public double double1;
	
	Demo_2(String str1){
		this.str1 = str1;
		
		System.out.println("Demo_2");
	}
}

class Demo_3 {
	public String str1;
	public int int1;
	public double double1;
	public boolean boolean1;

}

class Demo_4 {
	public String str1 = new String("1");
	public int int1 = 2;
	public double double1 = 3;
	public boolean boolean1 = true;
	
	Demo_4(){
		System.out.println("Demo_4");
	}
	
	Demo_4(String str1, int int1, double double1, boolean boolean1){
		this();
		
		this.str1 = str1;
		this.int1 = int1;
		this.double1 = double1;
		this.boolean1 = boolean1;
	}

}

class Father {
	private String name;
	private int age;
	
//	Father() {
//		
//	}
	
	Father(String name, int age){
		System.out.println("Father");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	private void privateMethod() {
		System.out.println("Father_privateMethod");
	}
	
	protected void protectedMethod() {
		System.out.println("Father_protectedMethod");
	}
}

class Son1 extends Father{

	Son1() {
		super("name", 18);
		System.out.println("Son1");
		
		System.out.println(super.getName() + " " + super.getAge());
		System.out.println(this.getName() + " " + this.getAge());
		
		super.protectedMethod();
		this.protectedMethod();
		System.out.println("======================================>");
//		super.privateMethod();
	}
	
}

class Son2 extends Father{
	
	Son2() {
		super("name", 18);
		System.out.println("Son1");
		
		System.out.println(super.getName() + " " + super.getAge());
		System.out.println(this.getName() + " " + this.getAge());
		
		System.out.println("======================================>");
	}
	
}

class Son3 extends Father{
	private int height;
	
	Son3() {
		super("name", 18);
		System.out.println("Son1");
		
		System.out.println(super.getName() + " " + super.getAge());
		System.out.println(this.getName() + " " + this.getAge());
		
		System.out.println("======================================>");
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
		
}

class Son4 extends Father{//, Son1{
	
	Son4() {
		super("name", 18);
		System.out.println("Son1");
		
		System.out.println(super.getName() + " " + super.getAge());
		System.out.println(this.getName() + " " + this.getAge());
		
		System.out.println("======================================>");
	}
	
}

public class Class_190922 {
	
	public static void main(String[] args) {

		Demo_1 demo_1 = new Demo_1();
		demo_1.method(1);
		demo_1.method("1");
		demo_1.method(1, 2);
		demo_1.method();
//		System.out.println(demo_1.getClass().getMethods());

//		Demo_2 demo_2 = new Demo_2();
		Demo_2 demo_2 = new Demo_2("11");
//		System.out.println(demo_2.getClass().getMethods().toString());
		System.out.println(demo_2.str1 +"\t"+ demo_2.int1 +"\t" + demo_2.double1);

		Demo_3 demo_3 = new Demo_3();
//		System.out.println(demo_3.getClass().getMethods().toString());
		System.out.println(demo_3.str1 +"\t"+ demo_3.int1 +"\t" + demo_3.double1 +"\t" + demo_3.boolean1);

		Demo_4 demo_4 = new Demo_4("11", 12, 13, false);
//		System.out.println(demo_4.getClass().getMethods().toString());
		System.out.println(demo_4.str1 +"\t"+ demo_4.int1 +"\t" + demo_4.double1 +"\t" + demo_4.boolean1);

		Son1 son1 = new Son1();
		
		
		Son2 son2 = new Son2();
		Father father2 = (Father)son2;
		Father father22 = new Father(null, 0);
		if( father22 instanceof Son2 ) {
			Son2 son22 = (Son2)father22;
			System.out.println("father22 instanceof Son2");
		}
		
		Son3 son3 = new Son3();
		Father father3 = (Father)son3;
		Father father33 = new Father(null, 0);
		Son3 son33 = (Son3)father33;
		
		Son4 son4 = new Son4();
		
	}

}
