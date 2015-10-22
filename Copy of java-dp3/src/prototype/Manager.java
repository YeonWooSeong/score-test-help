package prototype;

import java.util.HashMap;
import java.util.Map;

public class Manager { // bean 객체로 만들려함. -> 필드에 선언할 것....
	 private Map<String, Object> map = new HashMap<String, Object>(); 
	 /*
	  * 매니저는 제품 입고, 등록, 판매를 담당.
	  * map은 인스턴스 매장 창고.
	  * 창고에 있는 제품을 판매하는 모양
	  */
	 public Product sell(String productName){
		 Product temp = (Product) map.get(productName);
		 return temp.createClone(); // 같은 물품이 여러개 들어오면 그 각각의 바코드는 달라야 함.
		 							// 즉. 같은 product라도 주소값을 달리 해줘야함 이 것이 createClone?
	 }
	 
	 /*
	  * 창고로 입고되는 제품에 하이마트가 부여한 이름(바코드 같은 것)으로
	  * 바꿔서 창고에 보관하는 모양.
	  */
	 public void add(String name, Product proto){
		 map.put(name, proto);
		 
	 }
	
}
