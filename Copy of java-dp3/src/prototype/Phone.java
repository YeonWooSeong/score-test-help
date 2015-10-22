package prototype;

public class Phone implements Product{
	private String company, brand; //class 는 3가지의 패턴으로만 코딩. 필드에 어떤 것이 선언되냐에 따라 나뉨.
	private StringBuffer sb; //String이랑 달리 추가삭제 가능. sb는 담기 위한 것이라 get,set x
	//StringBuffer는 List<String list = ...  한 다음에 list.add("")의 성질. 

	public Phone(String company, String brand) {
		this.company = company;
		this.brand = brand;
		sb = new StringBuffer(); //인스턴스변수를 초기화, 지역변수는 초기화 잘 안함.
	}
	
	public String getCompany() {
		return company;
	}

	public String getBrand() {
		return brand;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public StringBuffer spec() { //use의 파라미터는 없어도 됨. 하는 역할이 없다...
		sb.delete(0, sb.length());  // << StringBuffer에 대한 이해를 더 해야함.
		sb.append(company);
		sb.append(brand); //입력할 땐 따로 입력되도 나중에 결과물은 합쳐져서 보여짐. 이게 StringBuffer의 특징.
		
		return sb;
	}

	@Override
	public Product createClone() {
		Product p = null;
		try {
			p = (Product) clone();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}

}
