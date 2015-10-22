package decorator;


public class SniperBot extends BasicBot {
	Robot robot;

	public SniperBot(Robot robot) {
		this.robot = robot;
	}

	@Override
	public int attack() {
		
		return super.attack()*20;
	}

	@Override
	public void shield(int attack) {
		// TODO Auto-generated method stub
		super.shield(attack+50);
	}

	@Override
	public void run() {
		robot.run();
		speed +=15;
	}

	@Override
	public void chargeEnargy(int enargy) {
		super.chargeEnargy(enargy*2);
	}

}
