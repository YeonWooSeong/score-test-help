package grade;

import java.util.Scanner;
import java.util.Vector;

public class HanbitSchool {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		GradeService service = new GradeServiceImpl();
		
		while(true){
			System.out.println("1.성적등록 2.학적부리스트 3.학번으로 검색 4.이름으로검색 "
					+ "5.성적 하위순출력 6. 성적 상위순출력 7.이름순출력 8.종료");
			int input = scan.nextInt();
			
			
			switch (input) {
			case 1:
				System.out.println("학번 입력 : ");
				String hak = scan.next();
				System.out.println("이름 입력 : ");
				String name = scan.next();
				System.out.println("국어 점수 입력 : ");
				int kor = scan.nextInt();
				System.out.println("영어 점수 입력 : ");
				int eng = scan.nextInt();
				System.out.println("수학 점수 입력 : ");
				int math = scan.nextInt();
				service.input(hak, name, kor, eng, math);
				//System.out.println(service.vec);
				break;
			case 2:
				System.out.println(service.getList());
				break;
			case 3:
				System.out.println("학번으로 검색 : ");
				String input3 = scan.next();
				service.searchByHak(input3);
				System.out.println(service.searchByHak(input3));
				break;
			case 4:
				System.out.println("이름으로 검색 : ");
				String input4 = scan.next();
				service.searchByName(input4);
				System.out.println(service.searchByName(input4));
				break;
			case 5:
				System.out.println(service.descGradeByTotal());
				break;
			case 6:
				System.out.println(service.ascGradeByTotal());
				break;
			case 7:
				System.out.println(service.ascGradeByName());
				break;
			default:
				break;
			}
			
		
		
		
		}
		
	}
}
