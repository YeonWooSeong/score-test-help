package member_home;

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
	private Statement stmt; //String을 query로 바꿔줌
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
	
	public int insert(MemberVO o) {
		int result = 0;
		try {
			stmt = con.createStatement(); // 커넥터에게 회원가입 양식지를 받는다.
			rs = stmt.executeQuery(o.insert());  // dao 패턴은 con stmt rs 반드시 필요함.
			if (rs != null) {
				result = 1;
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result ;
		
	}
	
	public int update(MemberVO o) {
		int result = 0;
		try {
			stmt = con.createStatement();
			stmt.executeQuery(o.update());
			if (rs != null) {
				result = 1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //양식지
		
		return result;
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<MemberVO> selectAll() {
		//System.out.println("셀렉올 진입");
		/**
		 * Account a = new Account();
		 * List<>list = new ArrayList<>(); => 다형성   입양의 의미 DeepCopy 깊은복사
		 * stmt = con.createStatement(); => > 기능만 할당 -> Shallow copy 얕은복사
		 */ 
		try {
			//System.out.println("셀렉올 트라이 진입");
			stmt = con.createStatement();  //Query를 실행하는 객체.  
			rs = stmt.executeQuery(member.selectAll());// executeQuery를 불러오는 객체 stmt
			while (rs.next()) {
				//System.out.println("while문 진입");
				MemberVO temp = new MemberVO(); //5개든 6개든 만들어져야 함
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

	
	public List<MemberVO> selectBy(String name) {//이름으로 검색.
		List<MemberVO> list = new ArrayList<MemberVO>();
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(member.selectOneBy(name));
		
			while (rs.next()) {
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
			e.printStackTrace();
		}
		return list;
	
	
	}

	
	public List<MemberVO>selectSomeBy(String s1, String s2) {
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(member.selectSomeBy(s1,s2));
		
			while (rs.next()) {
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
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	@Override
	public MemberVO selectOneBy(String key) {
		MemberVO temp = new MemberVO();
		try {
			stmt = con.createStatement();
			/*System.out.println(member.selectOneBy(key)+"구분");*/
			rs = stmt.executeQuery(member.selectOneBy(key));
			if (rs == null) {
			temp = null;	
			}
			while (rs.next()) {
				//System.out.println("while문 진입");
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
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return temp;
	}

	@Override
	public int count() {
		int temp = 0;
		try {
			stmt = con.createStatement();// 양식지 = 컨에 있다. 컨은 오라클이랑 연결되어 있음  + 오라클(외부)이랑 연결되어 있기 때문에 트라이 캐치를 써야함
			rs = stmt.executeQuery(member.count());
			while (rs.next()) {
			
				temp = rs.getInt("count");
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		} 
		return temp;
	}

	@Override
	public int delete(String id) {
		int result =0;
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(member.delete());
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	
		
	}
	public MemberVO login(String id , String pass){
		MemberVO loginMember = new MemberVO();
		loginMember = this.selectOneBy(id);
		if (loginMember.getUserid() == null) {
		}
		if (loginMember.getPassword().equals(pass)) {
			return loginMember;
		} else {
			return null;
		}
	}

	
	
}