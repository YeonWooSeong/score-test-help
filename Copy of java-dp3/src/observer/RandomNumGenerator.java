package observer;

public class RandomNumGenerator extends NumberGenerator{
	
	private int num;
/*
 * 1부터 20까지 랜덤 숫자 발생 메소드
 * ex => 로또 10장을 구매하는 상황
*/
	@Override
	public int getNum() {
		// TODO Auto-generated method stub
		return num;
	}

	@Override//그래프 만들기
	public void execute() {
			for (int i = 0; i <= 20; i++) {
				num = (int) (Math.random()*20+1); // 20은 곱한ㄷ 수
				notifyObserver();//랜덤으로 생성된 숫자를 통보하는 메소드
				
				
			}
	}

	

}
