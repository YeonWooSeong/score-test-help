package member_home;

import java.io.Serializable;

import global.SQL;

public class MemberVO implements Serializable, SQL{ //implements Serializable 이후 노란줄에 시리얼넘버 추가.
	//VO : Value Object;
	private static final long serialVersionUID = 1L;
	
	private String userid, password, name, birth, Phone;  //ID, PS, 이름, 주소, 생일, 폰번
	private String Email, gender, addr, regdate, profile; //이메일, 성별, 주소, 등록일, 프로필사진
	
	
	public MemberVO() {

	}
	public MemberVO(String userid,String password,String name,String birth,String Phone,String Email,String gender,String addr) {
this.userid = userid;
this.password = password;
this.name = name;
this.birth = birth;
this.Phone = Phone;
this.Email = Email;
this.gender = gender;
this.addr = addr;

this.profile = "defualt.png";
/*this.regdate = regdate;
this.profile = profile;*/
		
	}

	
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
		return birth;
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
	public void setBirth(String birth) {
		this.birth = birth;
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
		this.profile = "defualt.png";
	}
	
	@Override
	public String toString() {
		return "MemberVO [userid=" + userid
				+ ", password=" + password
				+ ", name=" + name
				+ ", birth=" + birth
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
		String query = "insert into member"+"(userid,password,name,birth,phone,email,gender,addr,regdate,profile) values("
				+make(this.userid)+","
				+make(this.password)+","
				+make(this.name)+","
				+make(this.birth)+","
				+make(this.Phone)+","
				+make(this.Email)+","
				+make(this.gender)+","
				+make(this.addr)+","+/*"select sysdate from dual"*/"sysdate"+","
			/*	+make(this.regdate)  //등록일  sql은 자바의 메소드에 해당하는 것은 함수이다.*/
			 
				+make(this.profile)
				+ ")";
		
		return query;
	}
	@Override
	public String update() { //오라클 p.311
		String query = "update member"
				+ " set password = "+make(this.password)+","
				+ "Email="+make(this.Email)+","
				+ "Phone="+make(this.Phone)+","
				+ "addr="+make(this.addr)+","
				+ "profile="+make(this.profile)+" where userid = "+make(this.userid);
		return query;
	}
	
	public String update2(String s1, String s2, String s3){
		String query = "update member"+"set"+s1+"="+make(s3)+"where"+s1+"="+make(s2);
		
		return query;
		
		
	}
	
	@Override
	public String delete() { //오라클 p.323
		String query = "delete from member where userid = " +make(this.userid);
		return query;
	}
	@Override
	public String selectAll() {
		String query = "select * from member";
		return query;
	}
	@Override
	public String selectOneBy(String s) {
		String query = "select * from member" + " where userid =" +make(s);
		return query;
	}
	@Override
	public String count() {
		// 오라클에서 as 는 결과값에 키값을 주는 역할을 수행한다.
		// 키값은 rs가 해당 value를 가져올 떄 사용된다.
		// 따로 정하지 않으면 컬럼명이 키값이 된다.    <map>
		String query = "select count(*) as count from member";
				
		return query;
	}
	@Override
	public String make(String s) { // " 나오기 전에 오라클 언어는 '로 감쌌음.
									//make() 는 외부값을 감싸기 위함.       
		return "'"+s+"'";
	}
	@Override
	public String selectSomeBy(String s1, String s2) {
	String query = "select * from member where "+s1+"="+this.make(s2);
	
		return query;
	}
	
	
	
	
}

//176  this.userid    <  --> this.make(s1)