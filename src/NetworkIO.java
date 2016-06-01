class SuperClass{
	public String compose(){
		return "Super Class";
	}
}

class SubClass extends SuperClass{
	public String compose(){
		return super.compose() + "- sub class";
	}
}




public class NetworkIO {
	public static void main(String[] args) {
		SuperClass sc = new SuperClass();
		SubClass subc = new SubClass();
		
		System.out.println(sc.compose());
		System.out.println(subc.compose());
		
	}
}
