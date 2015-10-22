package iterator_map;

import java.util.Scanner;

import iterator_global.MyIterator;
import iterator_global.Student;

public class HanbitMain {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		HanbitServiceImpl hb = new HanbitServiceImpl(10);  //총 정원수 10명, 반은2개
		MyIterator it = hb.iterator();
		
		hb.add(new Student("빅데이터", "길동1"));
		hb.add(new Student("빅데이터", "길동2"));
		hb.add(new Student("빅데이터", "길동3"));
		
		hb.add(new Student("자바", "유신1"));
		hb.add(new Student("자바", "유신2"));
		hb.add(new Student("자바", "유신3"));
		hb.add(new Student("자바", "유신4"));
		
		//System.out.println("빅데이터 반은 3명이며, 길동1, 길동...");
		
		while (true) {
			System.out.println("1.학생추가 2.학생조회(유일한값이름) 3.학생조회 4.총학생수");
			switch (scan.nextInt()) {
			case 1:
				System.out.println("배우는 과목, 이름 입력 :");
				hb.add(new Student(scan.next(), scan.next()));
				break;
			case 2:
				System.out.println("조회할 학생 이름 입력 : ");
				System.out.println(hb.searchByName(scan.next()));
				
				break;
			case 3:
				System.out.println("조회할 과목 입력 : ");
				String input = scan.next();
				for (int i = 0; i < hb.searchBySubject(input).length; i++) {
					System.out.println(hb.searchBySubject(input)[i]);
				}
				break;
			case 4:
				
			default:
				break;
			}
			
		}
		/* HanmitEni
		 * 1. 배열 버젼
		 * 2. ArrayList 버젼
		 * 3. HashMap 버젼
		 * 
		 */
		
	}
}
