package member;

import java.util.List;

public interface MemberService {
	/*
	 * DML            scanner로 입력받는 값.  즉 실질적으로 변함.
	 */
	
	
	//회원가입
	public String join(MemberVO o);
	
	//비밀번호 변경
	public String changePass(MemberVO o);
	
	public String changeAddr(MemberVO o);
	
	//회원탈퇴
	public int remove(MemberVO o);
	/*service.remove(service.searchById(deleteID));*/
	
	
	/*
	 *DQL  값만 보여주게 표현.
	 */

	//로그인
	public MemberVO login(String id, String pass);  //외부에서 준 값. MemberVO o 사용 x  
	//총회원수
	public int count();
	//아이디검색
	public MemberVO searchById(String id);
	//키워드검색(중복허용)
	public List<MemberVO> seratchBySerarchword(String domain,String searchWord);
	//전체 회원 목록 
	public List<MemberVO> getList();
	
}
