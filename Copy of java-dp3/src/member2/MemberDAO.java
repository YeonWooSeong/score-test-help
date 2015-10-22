package member2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import global.Constants;
import global.DAO;
import global.DatabaseFactory;
import global.Vendor;

public class MemberDAO extends DAO{
	private Connection con;  // 오라클과 이클립스 연동된 데이터를 여기까지 끌어옴.
	private Statement stm; //String을 query로 바꿔줌
	private ResultSet rs; //결과를 던지는 것(주머니(객체)) 고정되어있음.
	private List<MemberVO> list = new ArrayList<MemberVO>();
	private MemberVO member = new MemberVO();
	private static MemberDAO instance = new MemberDAO();
	//private static DAO instance = new MemberDAO(); 
	//21,22번 줄의 차이는 21번은 객체 생성
	//22번은 부모클래스를 상속, 카피의 개념. 객체 생성은 정확히 아님.
	
	public static MemberDAO getInstance() {
		return instance;
	} //싱글톤 패턴 = 21번줄+26~28줄
	
	public MemberDAO() {
		con = DatabaseFactory.getDatabase(Vendor.ORACLE, Constants.ORACLE_ID, 
				Constants.ORACLE_PASSWORD).getConnection(); //
	} 
	
	public void insert(MemberVO o) {
		// TODO Auto-generated method stub
		
	}
	
	public void update(MemberVO o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<MemberVO> selectAll() {
		//System.out.println("셀렉올 진입");
		try {
			//System.out.println("셀렉올 트라이 진입");
			stm = con.createStatement();
			rs = stm.executeQuery(member.selectAll());
			while (rs.next()) {
				//System.out.println("while문 진입");
				MemberVO temp = new MemberVO();
				temp.setUserid(rs.getString("userid"));
	            temp.setPassword(rs.getString("password"));
	            temp.setName(rs.getString("name"));
	            temp.setBirth(rs.getString("birth"));
	            temp.setPhone(rs.getString("phone"));
	            temp.setEmail(rs.getString("email"));
	            temp.setGender(rs.getString("gender"));
	            temp.setAddr(rs.getString("addr"));
	            temp.setRegdate(rs.getString("regdate"));
	            temp.setProfile(rs.getString("profile"));
				list.add(temp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<MemberVO> selectBy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberVO selectOneBy(String key) {
		// TODO Auto-generated method stub
		return null;
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