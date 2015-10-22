package observer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 *숫자 발생기 추상 클래스. //
 *추상 클래스를 사용할 지 인터페이스를 사용할 지 여부판단 기준.
 *개발자에게 필드값을 규제하고 메소드 추가는 허용해야 할 때 -> 추상 클래스.
 *개발자에게 필드값을 허용하고 메소드 규제만을 강요할 때    -> 인터페이스
 * 
 */
public abstract class NumberGenerator {
private List<Observer> list = new ArrayList<Observer>(); // Obsever는 인터페이스 이므로 객체 생성이 안된다.
public void add(Observer o){
	list.add(o);
	
	
}
public void delete(Observer o){
	list.remove(o);
	
}

public void notifyObserver(){
	Iterator<Observer> it = list.iterator();
	while (it.hasNext()) {
		Observer o = (Observer) it.next();
		o.update(this);
	}
	
}




public abstract int getNum();
public abstract void execute();

}
