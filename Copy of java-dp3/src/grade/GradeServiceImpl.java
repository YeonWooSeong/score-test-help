package grade;

import java.util.ArrayList;

public class GradeServiceImpl implements GradeService{
	
	
	ArrayList<GradeVO> vec = new ArrayList<GradeVO>();
	
	/*
	 * 학생을 성적부에 등록하기 
	 * 힌트) 벡터 메소드 중에 한 객체만 넣는 메소드 사용. = 연산자 사용x
	 * 
	 */
	@Override
	public void input(String hak, String name, int kor, int eng, int math) {
		GradeVO grade = new GradeVO();
		grade.setUserid(hak);
		grade.setName(name);
		grade.setKor(kor);
		grade.setEng(eng);
		grade.setMath(math);
		
		vec.add(grade);
	}
	
	/*
	 * 성적부에 등록된 전체 학생 리스트 출력
	 * 힌트) 필드에 있는 객체에 모든 학생 리스트가 존재.
	 * 필드 객체 값을 지역변수에 할당.  
	 */ 
	@Override
	public ArrayList<GradeVO> getList() {
		
		return vec;
	}

	/*
	 * 학번으로 벡터를 뒤져 일치하는 학번 리턴.
	 */
	@Override
	public GradeVO searchByHak(String hak) {
		GradeVO grade = new GradeVO();
		
		for (int i = 0; i < vec.size(); i++) {
			//System.out.println(vec.get(i).getEng());
			if (hak.equals(vec.get(i).getUserid())) {
				grade = vec.get(i);
			} 
		}
		return grade;
	}

	/*
	 * 이름으로 등록된 학생정보 전부 검색
	 * 동명이인 역시 전부 검색
	 */
	@Override
	public ArrayList<GradeVO> searchByName(String name) {
		ArrayList<GradeVO> result = new ArrayList<GradeVO>();
		
		for (int i = 0; i < vec.size(); i++) {
			if (name.equals(vec.get(i).getName())) {
				result.add(vec.get(i));
			} 
		}
		return result;
	}

	@Override
	public ArrayList<GradeVO> descGradeByTotal() {
		
		for (int i = 0; i < vec.size(); i++) {
			for (int j = 0; j < vec.size(); j++) {
				GradeVO temp = new GradeVO();
				if (vec.get(i).getTotal() > vec.get(j).getTotal()) {
					temp = vec.get(i);
					vec.set(i, vec.get(j));
					vec.set(j, temp);
				}
			
			}
		}
		return vec;
	}

	@Override
	public ArrayList<GradeVO> ascGradeByTotal() {
		
		for (int i = 0; i < vec.size()-1; i++) {
			for (int j = 0; j < vec.size()-1-i; j++) {
				GradeVO temp = new GradeVO();
				if (vec.get(j).getTotal() < vec.get(j+1).getTotal()) {
					temp = vec.get(j);
					vec.set(j, vec.get(j+1));
					vec.set(j+1, temp);
				}
			}
		}
		return vec;
	}

	@Override
	public ArrayList<GradeVO> ascGradeByName() {
		
		for (int i = 0; i < vec.size()-1; i++) {
			for (int j = 0; j < vec.size()-1-i; j++) {
				GradeVO temp = new GradeVO();
				if (vec.get(j).getName().compareTo(vec.get(j+1).getName())>0) {
					temp = vec.get(j);
					vec.set(j, vec.get(j+1));
					vec.set(j+1, temp);
				}
			}
		}
		
		return vec;
	}

}
