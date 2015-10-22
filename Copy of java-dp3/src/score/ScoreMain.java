package score;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScoreMain {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		ScoreService service = new ScoreServiceImpl();
		List<ScoreVO> score = new ArrayList<ScoreVO>();
		while (true) {
			System.out.println(
					"1:성적등록     2:학적부리스트보기     3:id로 검색       4: 검색. " + 
			"     5:  성적 상위순으로 순위출력     6:성적 하위순으로 순위출력(스왑)     7:이름 오름차순 출력  8:종료");

			switch (s.nextInt()) {
			case 1:
				System.out.println("자바 점수");
				int java = s.nextInt();
				System.out.println("jsp점수");
				int jsp = s.nextInt();
				System.out.println("html 점수");
				int html = s.nextInt();
				System.out.println("javaScript 점수");
				int javaS = s.nextInt();
				System.out.println("오라클점수");
				int oracle = s.nextInt();
				System.out.println("스프링 점수");
				int spring = s.nextInt();
				System.out.println("학생이름");
				String name = s.next();
				ScoreVO temp = new ScoreVO(java, jsp, html, javaS, oracle, spring, name);
				service.input(temp);
				break;
				
				
			case 2:
				System.out.println("명단   :"+"\t"+service.getList());
				break;
				
				
			case 3:
				System.out.println("id를 입력해 주세요");
				String userid = s.next();
				System.out.println(service.searchByUserid(userid));	
				break;
				/*service.searchByName(subJname);*/
				
				
				
			case 4: //★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
				System.out.println("과목 입력\t 1.java 2.oracle 3.spring");
				switch (s.nextInt()) {
				case 1:
					System.out.println("(자바)의 점수를 입력하세요");
				score =	service.searchBySubject("java", s.nextInt());
					break;
				case 2:
					System.out.println("(오라클)의 점수를 입력하세요");
				score =	service.searchBySubject("oracle", s.nextInt());
					break;
				case 3:
					System.out.println("(스프링)의 점수를 입력하세요");
				score =	service.searchBySubject("spring", s.nextInt());
					break;
				default:
					break;
				}
				for (ScoreVO vo : score) {
					System.out.println(vo);
				}
				break;
			case 5: // 성적 상위
				System.out.println(service.descByTotal());
				break;
				
				
			case 6: // 성적 하위
				service.ascByTotal();
				
				break;
			case 7: // 이름 오름
				System.out.println(service.ascByName());
				
				break;
			case 8:
				System.out.println("종료합니다.");
				return;
			default:
				break;
			}
		}
	}
}
