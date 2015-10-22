package member.copy3;

public interface MemberService {

	//회원가입
	public void join(String id, String pass, String name, String age, String addr);
	
	//로그인
	public String login(String id, String pass);
	
	//총회원수
	public int count();
	
	//아이디검색
	public MemberVO searchById(String id);
	
	//비밀번호 변경
	public MemberVO changePass(String id, String pass);
	
	//회원탈퇴
	public String deleteId(String id);
	
}