package decorator;


import decorator.BasicBot;
import decorator.Robot;
 
public class ShieldBot extends BasicBot{

Robot robot;

public ShieldBot(Robot robot) {
this.robot = robot;
}
@Override
	public int attack() {
		return super.attack();
	}
@Override
	public void shield(int attack) {
	super.shield((int) (attack *0.2));   //int 타입 다운캐스팅
}
@Override
	public void run() {
	robot.run();
	speed -= 5;
}
@Override
	public void chargeEnargy(int enargy) {
		super.chargeEnargy(enargy);
	}





}
