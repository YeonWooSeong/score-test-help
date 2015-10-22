package singleton;

public class SingletonMain {
	public static void main(String[] args) {
		//단 하나의 인스턴스
		Singleton s = Singleton.getIntstance();
		Singleton s2 = Singleton.getIntstance(); //object 풀에서 싱글톤 객체를 뒤져 있으면 주소값만 할당함.
		if (s == s2) {
			System.out.println("두 인스턴스가 동일 주소값을 가짐");
		} else {
			System.out.println("두 인스턴스가 다른 주소값을 가짐");
		}
		s.test();
		s2.test();
	}
}
