package score;

import java.util.ArrayList;
import java.util.List;

public interface ScoreService {
	// DML
	public String input(ScoreVO score);
	
	// DQL  전체목록
	public List<ScoreVO> getList();
	
	//이름으로 찾기
	public ScoreVO searchByUserid(String userid);
	
	//이름으로 찾기
	public List<ScoreVO> searchByName(String name);
	
	public List<ScoreVO> searchBySubject(String subject , int i);
	
	public List<ScoreVO> descByTotal();  // 성적을 내림차순으로 정렬(300,270,230,...)
	public List<ScoreVO> ascByName();   // 성적을 이름에 따라 오름차순(ㄱ,ㄴ,ㄷ...)
	public List<ScoreVO> ascByTotal(); // 성적을 오름차순으로 정렬(230,270,300...)
}
