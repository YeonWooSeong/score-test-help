package bridge;

/*
 * 브릿지 패턴
 * 
 * -상속보다는 합성을 쓰도록 하자. 여기서 합성이란 필드에 객체를 두는것
 * -즉 한 클래스가 다른 클래스를 포함하여 사용하게 하는 것.
 * -무기가 유닛을 사용한다 가 맞는 표현인가 ? 아니면 유닛이 무기를 사용한다가 맞는 표현인가.
 * - 이 논리를 생각하면서 포함시키는 클래스와 포함하는 클래스를 선택해야한다.
 * 위 문제라면 당연히 유닛이 무기를 사용한다가 맞는 표현.
 * 따라서 유닛 클래스 내부에(필드) 무기 클래스를 장착한다.
 * 이 떄, 무기 클래스의 종류에 따라 기능(메소드)이 달라질 것이며
 * 이 무기 클래스 객체는 유닛 클래스 객체에 긴으을 전달하는 다리역할을 하게 된다.
 * 이를 브릿지 패턴이라고 한다
 * 이 패턴에서는 두개의 객체가 서로다른 최고의 추상클래스(인터페이스)로 갈라져 나오는것에 주의한다
 *	 
 * 
 */

public class StarMain {
public static void main(String[] args) {
	Unit marine = new Marine(new Gun());
	Unit superMarine = new Marine(new Steampack());
	Unit firebet = new Firebet(new FireGun());
	Unit medic = new Medic(new Syringe());
	Unit attackMedic = new Medic(new Steampack());
	
	System.out.println(marine.act());
	System.out.println(superMarine.act());
	System.out.println(firebet.act());
	System.out.println(medic.act());
	System.out.println(attackMedic.act());
}

}
