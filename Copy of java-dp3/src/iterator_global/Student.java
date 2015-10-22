package iterator_global;

public class Student {
	private String name; //학생이름
	private String subject; //배우는 과목
	
	public Student(String subject, String name) {
		this.subject = subject;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String getSubject() {
		return subject;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", subject=" + subject + "]";
	}
	
}
