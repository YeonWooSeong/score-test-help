package member2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HanbitCom {
	/**
	 * "안녕하세요"String.substring(0,2); => 0이상 2미만
	 * 결과 : 안녕  
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		MemberVO member = new MemberVO();
		MemberService service = MemberServiceImpl.getService();
		//원래 13번줄은 서비스에서 가져오지만 이제
		//DB에서 가져오도록 바꿔야함 요기 밑에부터 수정.
		MemberDAO dao = MemberDAO.getInstance(); //싱글톤
		List<MemberVO> list = new ArrayList<MemberVO>();
		
		
		while (true) {
			System.out.println("1.회원가입 2.로그인 3.총회원수"
					+ " 4.ID검색 5.비번수정 6.전체회원정보 9.회원탈퇴 10.종료");
			
			switch (scan.nextInt()) {
			case 1:
				System.out.println("ID 입력 : ");
				String id = scan.next();
				System.out.println("비밀번호 입력 : ");
				String pass = scan.next();
				System.out.println("이름 입력 : ");
				String name = scan.next();
				System.out.println("나이 입력 : ");
				String age = scan.next();
				System.out.println("주소 입력 : ");
				String addr = scan.next();
				service.join(id, pass, name, age, addr);
				//System.out.println(service.toString());
				break;
			case 2:
				System.out.println("ID : ");
				String id2 = scan.next();
				System.out.println("Password : ");
				String pass2 = scan.next();
				System.out.println(service.login(id2, pass2));
				break;
			case 3:
				System.out.println(service.count());
				break;
			case 4:
				System.out.println("검색할 ID 입력 : ");
				System.out.println(service.searchById(scan.next()));
				break;
			case 5:
				System.out.println("ID입력 : ");
				String id5 = scan.next();
				System.out.println("변경할 비번 입력 : ");
				String pass5 = scan.next();
				System.out.println(service.changePass(id5, pass5));
				
				break;
			case 6:
				list = dao.selectAll();
				//System.out.printf(list+"\n");
				for (MemberVO mem : list) {
					System.out.println(mem);
				}
				break;
			case 9:
				System.out.println("삭제할 ID 입력 : ");
				service.deleteId(scan.next());
				break;
			case 10:
				return;
			default:
				break;
			}
		}
	}
}
