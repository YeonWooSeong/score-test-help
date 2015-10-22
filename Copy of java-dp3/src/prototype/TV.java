package prototype;

public class TV implements Product{
	private String company, brand, display;
	private StringBuffer sb;
	
	public TV(String compnay, String brand, String display) {
		this.company = compnay;
		this.brand = brand;
		this.display = display;
		
		
	}@Override
	public StringBuffer spec() {
		sb.delete(0, sb.length());
		sb.append(company);
		sb.append(brand);
		sb.append(display);
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
