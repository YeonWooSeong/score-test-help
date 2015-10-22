package member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberServiceImple implements MemberService{
	
	private static MemberService service = new MemberServiceImple();//--
	public static MemberService getService() {
		return service;
	}
	MemberDAO dao = new MemberDAO();
/**
 * DML
 */
	//회원가입
	@Override
	public String join(MemberVO o) {
		String result = "";
		if (dao.insert(o) == 1) {
			System.out.println("회원가입 성공");
		}else {
			System.out.println("회원가입 실패");
		}
		return result;
	}
	@Override // 비번변경
	public String changePass(MemberVO o) {
		String result = "";
		dao.update(o);
		return result;
	}
	
	// 주소변경
	@Override
	public String changeAddr(MemberVO o) {
	String result = "";
	dao.update(o);
		return result;
	}
	
	
	@Override //회원탈퇴
	public int remove(MemberVO o) {
		int result = 0;
		dao.delete(o);
		return result;
	}
	
/**
 * DQL
 */
	// 로그인
	@Override
	public MemberVO login(String id, String pass) {
		
		MemberVO m = new MemberVO();
		m = dao.login(id, pass);
		return m;
	}
	

	@Override //id로 회원검색
	public MemberVO searchById(String id) {
		MemberVO m = new MemberVO();
		m = dao.selectOneBy(id);
		
		return m;

	}

	
	@Override
	public List<MemberVO> seratchBySerarchword(String domain,String searchWord) {
		List<MemberVO> list = new ArrayList<MemberVO>();
		list = dao.selectSomeBy("name", searchWord);
		list = dao.selectSomeBy("addr", searchWord);
		list = dao.selectSomeBy("gender",searchWord);
		return list;
	}
	@Override
	//전체회원목록
	public List<MemberVO> getList() {
		List<MemberVO>list = new ArrayList<MemberVO>();
		list = dao.selectAll();
		
		return list;
	}
	//전체 회원수
		@Override
		public int count() {
			return dao.count();
		}
	
	
	
}