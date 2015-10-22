package member2;

import java.io.Serializable;

import global.SQL;

public class MemberVO implements Serializable, SQL{ //implements Serializable 이후 노란줄에 시리얼넘버 추가.
	//VO : Value Object;
	private static final long serialVersionUID = 1L;
	
	private String userid, password, name, Birth, Phone;  //ID, PS, 이름, 주소, 생일, 폰번
	private String Email, gender, addr, regdate, profile; //이메일, 성별, 주소, 등록일, 프로필사진
	
	public String getUserid() {
		return userid;
	}
	public String getPassword() {
		return password;
	}
	public String getName() {
		return name;
	}
	public String getBirth() {
		return Birth;
	}
	public String getPhone() {
		return Phone;
	}
	public String getEmail() {
		return Email;
	}
	public String getGender() {
		return gender;
	}
	public String getAddr() {
		return addr;
	}
	public String getRegdate() {
		return regdate;
	}
	public String getProfile() {
		return profile;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setBirth(String Birth) {
		this.Birth = Birth;
	}
	public void setPhone(String Phone) {
		this.Phone = Phone;
	}
	public void setEmail(String Email) {
		this.Email = Email;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	
	@Override
	public String toString() {
		return "MemberVO [userid=" + userid
				+ ", password=" + password
				+ ", name=" + name
				+ ", Birth=" + Birth
				+ ", Phone=" + Phone 
				+ ", Email=" + Email
				+ ", gender=" + gender
				+ ", addr=" + addr 
				+ ", regdate=" + regdate 
				+ ", profile=" + profile + "]";
	}
	/*
	 * executeUpdate
	 * 추가
	 */
	
	
	//==============SQL interface=======================//
	@Override
	public String insert() { //오라클 p.291
		String query = "insert into member values("
				+make(this.userid)
				+make(this.password)
				+make(this.name)
				+make(this.Birth)
				+make(this.Phone)
				+make(this.Email)
				+make(this.gender)
				+make(this.addr)
				+make(this.regdate)
				+make(this.profile)
				+ ")";
		
		return query;
	}
	@Override
	public String update() { //오라클 p.311
		String query = "update member"
				+ "set password = "+make(this.password)
				+ "set Email = "+make(this.Email)
				+ "set Phone = "+make(this.Phone)
				+ "set addr = "+make(this.addr)
				+ "set profile= "+make(this.profile);
		return query;
	}
	@Override
	public String delete() { //오라클 p.323
		String query = "delete from member"
				+ "where userid = " +make(this.userid); //객체안에 유저 아이디가 있으므로 받아올 필요가 없다.
		return null;
	}
	@Override
	public String selectAll() {
		String query = "select * from member";
		return query;
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
	public String make(String s) { // " 나오기 전에 오라클 언어는 '로 감쌌음.
									//make() 는 외부값을 감싸기 위함.
		return "'"+s+"'";
	}
	@Override
	public String selectSomeBy(String s1, String s2) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
}

