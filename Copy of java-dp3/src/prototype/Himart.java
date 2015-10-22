package prototype;

import java.util.ArrayList;
import java.util.List;

import member2.MemberVO;

public class Himart {
	public static void main(String[] args) {
		Manager manager = new Manager();
		Product luna = new Phone("SK", "루나");
		Product gals6 = new Phone("삼성", "엣지");
		Product v10 = new Phone("LG", "V10");
		Product oledTV = new TV("LG", "올레드TV", "올레드");
		Product samTV = new TV("삼성", "고화질TV", "SUHD");
		manager.add("설현폰", luna); //판매하는 명. 즉 같은스펙의 제품을 판매명으로 바꿈?
		manager.add("엣지폰", gals6);
		manager.add("LG의 혁신폰", v10);
		manager.add("LG 프리미엄TV", oledTV);
		manager.add("삼성초특가대박TV", samTV);
		
		MemberVO hong = new MemberVO();
		hong.setName("홍길동");
		List<StringBuffer> cart = new ArrayList<StringBuffer>();
		cart.add(manager.sell("설현폰").spec());
		cart.add(manager.sell("엣지폰").spec());
		cart.add(manager.sell("설현폰").spec());
		cart.add(manager.sell("설현폰").spec());
		cart.add(manager.sell("LG의 혁신폰").spec());
		
		System.out.println("==== " + hong.getName()+"의 주문목록=====");
		for (StringBuffer stringBuffer : cart) {
			System.out.println(stringBuffer);
		}
	
		
		// 매장의 견본품(cart)이 아닌 창고에 있는 신품(map)에서 줘야함. 복사본을 던져줌.
		//지금은 파라미터를 쓰지 않았지만, 
	}
}
