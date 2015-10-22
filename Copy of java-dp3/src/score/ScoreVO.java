package score;

import java.io.Serializable;

import global.SQL;

public class ScoreVO implements SQL, Serializable{
	private static final long serialVersionUID = 1L;

	private int score_seq;
	private int java; //자바점수
	private int jsp; 
	private int html; 
	private int javaScript;
	private int oracle;
	private int spring;
	private String userid;
	private int total;
	
	
	public ScoreVO() {
		// TODO Auto-generated constructor stub
	}
	
	
	public ScoreVO(int java,int jsp,int html,
			int javaScript,int oracle,int spring,String userid){
	
	this.java = java;
	this.jsp = jsp;
	this.html = html;
	this.javaScript = javaScript;
	this.oracle = oracle;
	this.spring = spring;
	this.userid = userid;
	}
	
	
	
	
	
	public void setTotal(int total) {
		this.total = java+jsp+html+javaScript+oracle+spring;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	@Override
	public String insert() {             //ddddd   score_seq
		String query = "insert into score"
				+ "(score_seq,java,jsp,html,javaScript,"
				+ "oracle,spring,userid) values(score_seq.nextval, ?, ?, ?, ?, ?, ?, ?)";
		
		return query;
	}

	@Override
	public String update() {               //dddddd
		String query = "update score"
				+ "set java = ?,"
				+ ", jsp = ?,"
				+ ", html = ?,"
				+ ", javascript = ?,"
				+ ", oracle = ?,"
				+ ", spring = ?"
				+ "where userid = ?";
		return query;
	}

	@Override
	public String delete() {
		String query = "delete from score where userid = ?";
		
		return query;
	}

	@Override
	public String selectAll() {
		String query = "select * from score";
		return query;
	}
	
		
	@Override //이름으로 찾기
	public String selectOneBy(String s) {
		String query = "select * from score where userid ="+this.make(s);
		
		return query;
	}
	@Override
	public String selectSomeBy(String s1, String s2) {
		String query = "select * from member where "+s1+" ="+this.make(s2);
		return query;
	}


	// 과목검색
	public String selectSubjectBy(String s1, int s2) {
		String query = "select * from member where "+s1+" ="+s2;
		return query;
		
		
		
	}
	@Override
	public String count() {
		String query = "select count(*) as count from score";
		return query;
	}

	@Override
	public String make(String s) {
		// make(java) => 'java'
		return "'"+s+"'";
	}
	public int getTotal(){
		int result = 0;
		
		return result;
	/**
	 * 체크하기.
	 * 1  vo에 vo꼴로 만드는가  
	 * 2. compare 데이터 타입으로 설정되어있는 scoreVO를 어떻게 풀었나.
	 * 3. 내 접근방식 = 점수를 각각의 list<> 로 담은걸 만들어서 list = score.getTotal(); 형태인가
	 * 4. int getTotal 에서 int 형인데 compare 안에 ()  값 변경
	 */
		
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "학생 [번호=" + score_seq + ", java점수=" + java + ", jsp점수=" + jsp
				+ ", html점수=" + html + ", javaScript점수=" + javaScript + ", oracle점수=" + oracle
				+ ", spring점수=" + spring + ", 학생이름=" + userid + "]";
	}


	public int getScore_seq() {
		return score_seq;
	}


	public int getJava() {
		return java;
	}


	public int getJsp() {
		return jsp;
	}


	public int getHtml() {
		return html;
	}


	public int getJavaScript() {
		return javaScript;
	}


	public int getOracle() {
		return oracle;
	}


	public int getSpring() {
		return spring;
	}


	public void setScore_seq(int score_seq) {
		this.score_seq = score_seq;
	}


	public void setJava(int java) {
		this.java = java;
	}


	public void setJsp(int jsp) {
		this.jsp = jsp;
	}


	public void setHtml(int html) {
		this.html = html;
	}


	
	public void setJavaScript(int javaScript) {
		this.javaScript = javaScript;
	}


	public void setOracle(int oracle) {
		this.oracle = oracle;
	}


	public void setSpring(int spring) {
		this.spring = spring;
	}

	
}
