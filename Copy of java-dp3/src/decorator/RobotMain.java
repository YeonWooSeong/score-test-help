package decorator;
/*
 * 데코레이션 패턴  꾸미기 패턴
 * 기본 클래스 및 해당 객체 자체에 추가적인 서브 클래스를 구성해서 
 * 생성자 파라미터로 객체를 넘겨서 원하는 기능을 표현하는 방법
 * 자바의 IO 대부분이 데코레이터로 표현되어 있음
 * 
 * <연관관계> isA
 * 상속과 추상 - > 연관관계 -> 커플링 -> 가족관계 - > 한몸 - > 우리가 남 임?
 * 
 * <의존관계> hasA
 * 직접적인 상속 , 추상과 달리 파라미터를 통해 관계를 맺는것
 * 파라미터 -> 약한 커플링 -  사용자와 물건 - > 쓰고나면 버린다 - > 매변이 바껴도 본체상관무
 * 한데 장식패턴은 그 방향이 반대로 되었다.
 * 기 이유는 파이널 클래스의 기능적인 측면이 중요하기 때문이다.
 * 
 */


public class RobotMain {
public static void main(String[] args) {
BasicBot myBot = new BasicBot();
BasicBot myGun = new GunBot(myBot);
BasicBot myShield = new ShieldBot(myBot);
BasicBot myTank = new TankBot();
BasicBot mySniper = new SniperBot(myBot);

System.out.println(myBot.status());
myBot.chargeEnargy(200);
System.out.println(myBot.status());
myBot.attack();
System.out.println(myBot.status());
myBot.run();
System.out.println(myBot.status());
myBot.shield(50);
System.out.println(myBot.status());
myBot.run();
System.out.println(myBot.status());
	System.out.println("=======gun========");
	System.out.println(myGun.status());
	myGun.chargeEnargy(200); //충전
	System.out.println(myGun.status());
	myGun.shield(50); // 공격 받으니 방어함
	System.out.println(myGun.status());
	System.out.println("=======shield========");
	System.out.println(myShield.status());
	myShield.run();
	System.out.println(myShield.status());
	myShield.shield(60);
	System.out.println(myShield.status());
	System.out.println(mySniper.status());
	mySniper.run();
	System.out.println(mySniper.status());
	mySniper.attack();
	System.out.println(mySniper.status());
	mySniper.shield(10);
	System.out.println(mySniper.status());
}
}