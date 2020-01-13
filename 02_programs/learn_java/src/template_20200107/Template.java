package template_20200107;

public class Template<T> {
	public static int id = 100;
	public static String name = "abc";
	public static Template<String> t1 = new Template<String>();
	public static Template<Object> t2 = new Template<Object>();
	
	public void print() {
		System.out.println("method print.");
	}
	
	public static void main(String[] args) {
		System.out.println(Template.id);
		
		System.out.println(Template.t1.id);
		
		Template.t1.print();
		Template.t2.print();
	}

}
