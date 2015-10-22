package iterator;

public class Book { //빈(Bean)객체 클래스 (객체 안에 객체를 가짐?) 
					//필드 값은 private. 속성값을 가짐.
	private String name;
	
	public Book(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
