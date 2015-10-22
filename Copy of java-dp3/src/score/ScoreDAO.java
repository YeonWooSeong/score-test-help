package score;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import global.Constants;
import global.DAO;
import global.DatabaseFactory;
import global.Vendor;
import member.MemberVO;

public class ScoreDAO extends DAO{
	private Connection con;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private List<ScoreVO> list = new ArrayList<ScoreVO>();
	private ScoreVO score = new ScoreVO();
	
	private static ScoreDAO instance = new ScoreDAO();
	public static ScoreDAO getInstance() {
		return instance;
	}
	
	
	
	public ScoreDAO() {
		con = DatabaseFactory
				.getDatabase(Vendor.ORACLE, Constants.ORACLE_ID, Constants.ORACLE_PASSWORD)
				.getConnection();}
	
	
	
	// DML
	public int insert(ScoreVO o) {
		int result = 0;
		try {//여기부터 하기
			pstmt = con.prepareStatement(o.insert());
			pstmt.setInt(1, o.getJava());
			pstmt.setInt(2, o.getJsp());
			pstmt.setInt(3, o.getHtml());
			pstmt.setInt(4, o.getJavaScript());
			pstmt.setInt(5, o.getOracle());
			pstmt.setInt(6, o.getSpring());
			pstmt.setString(7, o.getUserid());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	// DQL
	@Override
	public List<ScoreVO> selectAll() {
		List<ScoreVO> list = new ArrayList<ScoreVO>();
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(score.selectAll());
			while (rs.next()) {
				ScoreVO temp = new ScoreVO();
				temp.setScore_seq(rs.getInt("score_seq"));
				temp.setJava(rs.getInt("java"));
				temp.setJsp(rs.getInt("jsp"));
				temp.setHtml(rs.getInt("html"));
				temp.setJavaScript(rs.getInt("javaScript"));
				temp.setOracle(rs.getInt("oracle"));
				temp.setSpring(rs.getInt("spring"));
				temp.setUserid(rs.getString("userid"));
				list.add(temp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public ScoreVO selectOneBy(String key) {
		ScoreVO result = new ScoreVO();
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(score.selectOneBy(key));
			while (rs.next()) {
				result.setScore_seq(rs.getInt("Score_seq"));
				result.setJava(rs.getInt("java"));
				result.setJsp(rs.getInt("jsp"));
				result.setHtml(rs.getInt("html"));
				result.setJavaScript(rs.getInt("javaScript"));
				result.setOracle(rs.getInt("oracle"));
				result.setSpring(rs.getInt("spring"));
				result.setUserid(rs.getString("userid"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public List<ScoreVO> selectSomeBy(String s1,String s2){
		List<ScoreVO> result = new ArrayList<ScoreVO>();
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(score.selectSomeBy(s1, s2));
			while (rs.next()) {
				ScoreVO temp = new ScoreVO();
				temp.setScore_seq(rs.getInt("Score_seq"));
				temp.setJava(rs.getInt("java"));
				temp.setJsp(rs.getInt("jsp"));
				temp.setHtml(rs.getInt("html"));
				temp.setJavaScript(rs.getInt("javaScript"));
				temp.setOracle(rs.getInt("oracle"));
				temp.setSpring(rs.getInt("spring"));
				temp.setUserid(rs.getString("userid"));
				result.add(temp);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return result;
	}
	
/*	public List<ScoreVO> getTotal(){
		list = score.getTotal();
		return list;*/
	public List<ScoreVO> selectSubjectBy(String s1 , int s2){
		List<ScoreVO> result = new ArrayList<ScoreVO>();
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(score.selectSubjectBy(s1, s2));
			while (rs.next()) {
				ScoreVO temp = new ScoreVO();
				temp.setScore_seq(rs.getInt("Score_seq"));
				temp.setJava(rs.getInt("java"));
				temp.setJsp(rs.getInt("jsp"));
				temp.setHtml(rs.getInt("html"));
				temp.setJavaScript(rs.getInt("javaScript"));
				temp.setOracle(rs.getInt("oracle"));
				temp.setSpring(rs.getInt("spring"));
				temp.setUserid(rs.getString("userid"));
				result.add(temp);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return result;
		
	}
	
	
	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
