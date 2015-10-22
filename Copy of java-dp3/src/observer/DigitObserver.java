package observer;

public class DigitObserver implements Observer{

	@Override
	public void update(NumberGenerator gen) {
		System.out.println("랜덤 숫자 : " + gen.getNum());
		try {
			Thread.sleep(1000);// 1초 쉬었다가 실행.
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 

		
	}
	

}
