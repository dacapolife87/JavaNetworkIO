package chap03;

public class InheritanceTest {
	public static void main(String[] args) {
		//FirstChild fc = new FirstChild();
		
		//System.out.println(fc.read());
		
		//SecondChild sc = new SecondChild();
		//System.out.println(sc.read());
	}
	
	class Parent{
		public String read(){
			return "Parent ¿‘¥œ¥Ÿ";
		}
	}
	
	class FirstChild extends Parent{
		public String read(){
			return super.read() + ": firstChild";
		}
	}
	class SecondChild extends Parent{
		public String read(){
			return super.read() + ": secondChild";
		}
	}
	class ThridChild extends Parent{
		Parent p ;
		public ThridChild(Parent p ){
			this.p = p;
		}
		public String read(){
			return p.read() + ": thirdChild";
		}
	}
}
