package observer;

public class GraphObserver implements Observer{

	@Override
	public void update(NumberGenerator gen) {
		System.out.print("스타표시 :");
		for (int i = 0; i < gen.getNum(); i++) {
			System.out.print(" * ");
		}
		System.out.println("");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
