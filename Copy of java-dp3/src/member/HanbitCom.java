package member;

import java.util.ArrayList;
import java.util.Iterator;
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
		MemberService service = MemberServiceImple.getService();
		//원래 13번줄은 서비스에서 가져오지만 이제
		//DB에서 가져오도록 바꿔야함 요기 밑에부터 수정.
		List<MemberVO> list = new ArrayList<MemberVO>();
		
		
		while (true) {
			System.out.println("1.회원가입 2.로그인 3.총회원수"
					+ " 4.ID검색 5.검색  6.회원정보수정 7.전체회원정보 9.회원탈퇴 10.종료");
			
			switch (scan.nextInt()) {
			case 1:
				System.out.println("ID 입력 : ");
				String id = scan.next();
				if (service.searchById(id).getUserid() != null) {
					System.out.println("이미 가입한 아이디 입니다.");
					break; // 아이디 유효성 체크
				}
				System.out.println("비번 입력 : ");
				String pw = scan.next();
				System.out.println("이름 입력 : ");
				String name = scan.next();
				System.out.println("성별 입력 : ");
				String gender = scan.next();
				System.out.println("생년 입력 : ");
				String birth = scan.next();
				System.out.println("이메일 입력 : ");
				String email = scan.next();
				System.out.println("주소 입력 : ");
				String addr = scan.next();
				System.out.println("전번호 입력 : ");
				String pnum = scan.next();
			
				
				/*		System.out.println("비밀번호 입력 : ");
				String pass = scan.next();
				System.out.println("이름 입력 : ");
				String name = scan.next();
				System.out.println("나이 입력 : ");
				String age = scan.next();
				System.out.println("주소 입력 : ");
				String addr = scan.next();*/
				/*service.join(id, pass, name, age, addr);*/
				
				
				
				MemberVO temp = new MemberVO(id,pw,name,gender,birth,email,addr,pnum);
				/*service.join(temp);*/
				System.out.println(service.join(temp));
				
				
				//System.out.println(service.toString());
				
				
				break;
			case 2:
				System.out.println("ID : ");
				String idlog = scan.next();
				System.out.println("Password : ");
				String pwlog = scan.next();
				member = service.login(idlog, pwlog);
				if (member.getUserid() !=null) { // result = true 이면
					System.out.println("환영합니다.");
				} else {
					System.out.println("로그인 실패."); //a
				}
				break;
			case 3:
				System.out.println(service.count()+"명");
				break;
			case 4:
				System.out.println("검색할 ID 입력 : ");
				String input = scan.next();
				member = service.searchById(input);
				if (member.getUserid() !=null) {
					System.out.println(member.toString());
				} else {
					System.out.println("id존재 안함");
				}
				break;
			
			case 5:
				System.out.println("검색할 항목을 정해주세요 1.이름   2.주소   3. 성별");
				int sub = scan.nextInt();
				switch (sub) {
				case 1:
					System.out.println("검색할 이름 입력 ");
				list = service.seratchBySerarchword("name",scan.next());
					break;
				case 2:
					System.out.println("검색할 주소 입력 ");
					list = service.seratchBySerarchword("addr",scan.next());
					
					break;
				case 3:
					System.out.println("검색할 성별 입력");
					list = service.seratchBySerarchword("gender", scan.next());
					break;

				default:
				 break;
				}
				for(MemberVO vo : list){
					System.out.println(vo);
				}
				break;
			
			case 6:
				System.out.println("ID : ");
				String idlog2 = scan.next();
				System.out.println("Password : ");
				String pwlog2 = scan.next();
				member = service.login(idlog2, pwlog2);
				if (member !=null) { // result = true 이면
					System.out.println("환영합니다.");
				} else {
					System.out.println("다시 로그인 해주세염"); break;
				}
					System.out.println("수정할 항목을 정해주세요(비번 : pass , 주소 : addr)");
					String column = scan.next();
					System.out.println("수정값을 입력하세여");
					String changeval = scan.next();
					switch (column) {
					case "pass" :
						member.setPassword(changeval);
						service.changePass(member);
						break;
					case "addr" :
						member.setAddr(changeval);
						service.changeAddr(member);
						break;
					default:
						break;
					}
			System.out.println("정보가 수정 되었습니다.");
			
				break;
			case 7:
				list = service.getList();
				for (MemberVO mem : list) {
					System.out.println(mem);
				}
				break;
			case 9:
				System.out.println("아이디 비밀번호입력.");
				String deID = scan.next();
				String dePW = scan.next();
				member = service.login(deID, dePW);
				if (member != null ) {
					System.out.println("환영합니다"+deID+"님.");
				}else {
					System.out.println("아이디 비밀번호를 확인하세요.");
				}
				if (service.remove(member) == 1) {
					System.out.println("아이디가 삭제되었습니다.");
				}
				
				
				
			/*System.out.println("삭제할 ID 입력 : ");
			String deleteID = scan.next();
			service.remove(service.searchById(deleteID));
			System.out.println("아이다가 삭제되었습니다.");
				System.out.println(dao.delete(deleteID));*/
				break;
			case 10:
				return;
			default:
				break;
			}
		}
	}

	
	/*private static void searchByID(MemberDAO dao, String searchId) {
	
			MemberVO member;
		member = dao.selectOneBy(searchId);
		String a = scan.next();
		System.out.println(dao.selectOneBy(a));*/
	}