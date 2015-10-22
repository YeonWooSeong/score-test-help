package member2;

import java.util.HashMap;
import java.util.Map;

public class MemberServiceImple implements MemberService{
	
	private static MemberService service = new MemberServiceImple();//--
	public static MemberService getService() {
		return service;
	}//-- => 싱글톤 패턴으로 객체 생성.

	Map<String,Object> map = new HashMap<String,Object>();
	MemberVO member = new MemberVO();
	
	public void join(String id, String pass, String name, String age, String addr) {
		
		member.setUserid(id);
		member.setPassword(pass);
		member.setName(name);
		member.setAddr(addr);
		map.put(id, member);
		
		//System.out.println(member.toString());
	}

	@Override
	public String login(String id, String pass) {
		/*
		 * 환영합니다. ??에 사시는 ??세 ??님.
		 * 비번이 다릅니다. 다시 입력하세요
		 * 입력하신 ID는 존재하지 않거나, 일치하지 않습니다.
		 * Map(HashMap)에서 Value값만 가져오는 메소드는 map.get("Key")
		 */
		String result = null;
		MemberVO temp = (MemberVO) map.get(id);
		if (id.equals(temp.getUserid())&&pass.equals(temp.getPassword())) {
			temp = (MemberVO) map.put(id, member);
			result = "환영합니다."+temp.getAddr()+"에 사시는";
			//System.out.println("둘다 일치");
		} else if (id.equals(temp.getUserid())) {
			result = "비번이 다릅니다. 다시 입력하세요.";
		}
		else{
			result = "입력하신 ID는 존재하지 않거나 일치하지 않습니다.";
			
		}
		return result;
	}

	@Override
	public int count() {
		return map.size();
	}

	@Override
	public MemberVO searchById(String id) {
		/*Member temp = (Member) map.get(id);
		Member result = null;
		if (id.equals(temp.getId())) {
			result = (Member) map.get(id);
		}*/
		return (MemberVO) map.get(id);
	}

	@Override
	public MemberVO changePass(String id, String pass) {
		MemberVO target = (MemberVO)map.get(id);
		if (target != null) {
			target.setPassword(pass);
		} else {
			System.out.println("비번 변경 x");
		}
		
		return target;
	}

	@Override
	public String deleteId(String id) {
			//Member result = (Member) map.remove(id);
		String result = null;
		Object m = map.remove(id);
		if (m != null) {
			result = "입력한 " + id +"가 삭제되었습니다.";
		}
		
		return result;
	}

	
	
}