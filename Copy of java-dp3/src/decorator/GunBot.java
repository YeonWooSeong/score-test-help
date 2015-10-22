package decorator;

import decorator.BasicBot;
import decorator.Robot;

public class GunBot extends BasicBot {
	Robot robot;
	public GunBot ( Robot robot){
		this.robot = robot;
	
	}
	
	@Override
	public int attack() {
		return robot.attack()*3 ;
	}
	@Override
	public void chargeEnargy(int enargy) {
		super.chargeEnargy(enargy);
	}
	@Override
	public void shield(int attack) {
		super.shield(attack);
	}
	@Override
	public void run() {
		super.speed += 10;
	}
	
}
