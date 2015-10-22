package grade;

import global.SQL;

/**
 * @file_name : Grade.java
 * @author    : pheonix0717@naver.com
 * @date      : 2015. 10. 1.
 * @story     : 성적표 관리 객체 클래스
 */
public class GradeVO implements SQL{
	private int kor, eng, math;
	private String userid, name; // hak은 유일한 ID값
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public int getEng() {
		return eng;
	}
	public int getMath() {
		return math;
	}
	
	public void setKor(int kor) {
		this.kor = kor;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public void setMath(int math) {
		this.math = math;
	}
	
	public int getTotal(){
		
		return kor+eng+math;
	}

	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	@Override
	public String toString() {
		return "GradeVO [kor=" + kor + ", eng=" + eng + ", math=" + math + ", userid=" + userid + ", name=" + name
				+ "]";
	}

	
	
	//================================================
	
	
	

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
