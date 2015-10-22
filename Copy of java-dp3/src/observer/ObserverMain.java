package observer;

public class ObserverMain {
public static void main(String[] args) {
	NumberGenerator gen = new RandomNumGenerator();
	gen.add(new DigitObserver());
	gen.add(new GraphObserver());
	gen.execute();

}
}
