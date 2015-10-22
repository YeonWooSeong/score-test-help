package grade;

import java.util.ArrayList;

public interface GradeService {
	public void input(String hak, String name, int kor, int eng, int math);
	public ArrayList<GradeVO> getList();
	public GradeVO searchByHak(String hak);
	public ArrayList<GradeVO> searchByName(String name);
	public ArrayList<GradeVO> descGradeByTotal(); //총점 내림차순 정렬(과목별 점수도 보여줘야함)
	public ArrayList<GradeVO> ascGradeByTotal(); // 성적을 이름에 따라 오름차순(ㄱ,ㄴ,ㄷ...)
	public ArrayList<GradeVO> ascGradeByName();

}
