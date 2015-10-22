package decorator;

public class BasicBot implements Robot{

	/*
	 * 필드에 있는 인스턴스변수는 초기화를 하지 않는다. - > 정석
	 * 단 필요할 떄는 할 수도 있다. -> 변칙
	 * 문법 오류는 아님.
	 * 지변 // 인변
	 * 지변은 무조건 초기호ㅏ.
	 */
	protected int enargy = 0;
	protected int attack = 10;
protected int hp = 100;
protected int speed = 0;

	
	@Override
	public int attack() {
		return attack;
	}

	
	
	@Override
	public void shield(int attack) {
	hp -= attack; // 방어 기술은 공격받은 숫자값만큼을 체력에서 감소시킨다.
		
	}

	@Override
	public void run() {
		speed += 10;  //달리기 메소드를 실행하면 솔력이 10 증가
	}

	@Override
	public String status() {
		return "BasicBot[로봇] [enargy[에너지]=" + enargy + ", attack[공격력]=" + attack + ", hp[체력]=" + hp + ", speed[속도]=" + speed + "]";		
	}

	@Override
	public void chargeEnargy(int enargy) {
		this.enargy += enargy;
	}
	public void printStatus(){
		System.out.println("hp : "+hp);
		System.out.println("속도 : "+speed);
		
	}
	
	

	public int getEnargy() {
		return enargy;
	}

	public int getAttack() {
		return attack;
	}

	public int getHp() {
		return hp;
	}

	public int getSpeed() {
		return speed;
	}

	public void setEnargy(int enargy) {
		this.enargy = enargy;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

}
