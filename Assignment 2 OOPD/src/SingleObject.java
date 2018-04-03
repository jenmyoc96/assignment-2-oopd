// this is the singleton pattern
public class SingleObject {

	private static SingleObject instance = new SingleObject();
	private SingleObject() {}
		
		public static SingleObject getInstance() {
			return instance;
		}
		public void showMessage() {
			System.out.print("this is our 4 design pattern assignment");
		}
		
	}

 