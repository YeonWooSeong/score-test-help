package iterator_arraylist;

import global.SQL;

public class HanbitVO implements SQL{
	private String name; // 지점(신촌점,강남점)
	private String subject; //배우는 과목
	private String userid; //회원ID -> member 테이블의 userid와 일치.
	
	public HanbitVO(String subject, String name) {
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

	@Override
	public String insert() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String selectOneBy(String s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String count() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String make(String s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String selectSomeBy(String s1, String s2) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
	