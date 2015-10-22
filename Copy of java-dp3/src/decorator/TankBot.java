package decorator;

import decorator.BasicBot; // 탱크 타고 돌아다님

public class TankBot extends BasicBot{

@Override
public int attack() {

	return super.attack()*10;
}
	@Override
		public void shield(int attack) {
			super.hp -= (attack* 0.2);
		}

	@Override
		public void run() {
		
		super.speed += 50;
		}
	@Override
		public String status() {
			return super.status();
		}
	@Override
		public void chargeEnargy(int enargy) {
			super.chargeEnargy(enargy);
		}
}
