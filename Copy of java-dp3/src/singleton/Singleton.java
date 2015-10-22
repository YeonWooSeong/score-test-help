package singleton;

public class Singleton {
	
	private static Singleton intstance = new Singleton();
	
	public static Singleton getIntstance() {
		return intstance;
	}

	public void test() {
		System.out.println(" **** "); // 연관관계가 깊어짐.
		//return으로 전달하면 연관관계가 얇아진다 -> loose coupling
	}	
}
