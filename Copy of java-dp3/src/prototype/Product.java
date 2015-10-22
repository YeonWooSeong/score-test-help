package prototype;

public interface Product extends Cloneable{ //extends Cloneable : 프로토타입 패턴의 중요점.
	public StringBuffer spec();
	public Product createClone();
}
