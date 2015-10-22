package score;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ScoreServiceImpl implements ScoreService{	

/*private static ScoreService instance = new ScoreServiceImpl();	
public static ScoreService getInstance(){
	return instance;
	
}*/
	
	ScoreVO vo = new ScoreVO();
	ScoreDAO dao = new ScoreDAO();	


	@Override
	public String input(ScoreVO score) {
		String result = "";
		System.out.println("성적등록."+score.toString());
		if (dao.insert(score) == 1) {
			System.out.println("성적 등록 완료");
		} else {
			System.out.println("다시 입력하세요. 등록 실패//!!!");
		}
		return result;
	}
	@Override
	public List<ScoreVO> getList() {
		List<ScoreVO> list = new ArrayList<ScoreVO>();
		list = dao.selectAll();
		return list;
	}

	@Override // 이름으로 찾기 
	public ScoreVO searchByUserid(String name) {
		ScoreVO score = new ScoreVO();
		 score = dao.selectOneBy(name);
		return score;
	}

	
	
	@Override  //
	public List<ScoreVO> searchByName(String name) {
		ArrayList<ScoreVO> list = new ArrayList<ScoreVO>();
		
		return list;
	}
	
/*	public List<ScoreVO> searchBySubject(String subject , String choosnum) {
		 List<ScoreVO> result = new ArrayList<ScoreVO>();
		 result = dao.selectSomeBy("java", choosnum);
		 result = dao.selectSomeBy("oracle",choosnum);
		 result = dao.selectSomeBy("spring",choosnum);
		 
		return result;
	}*/
	

	@Override //성적 상위
	public List<ScoreVO> descByTotal() {
		List<ScoreVO> list = new ArrayList<ScoreVO>();
		
		dao.selectAll(); //★★★★★★★★★★★
		descTotal desctotal = new DescTotal();
		Collections.sort(list, desctotal);
		
		return list;
		
	}

	@Override  //성적 하위
	public List<ScoreVO> ascByTotal() {
		ArrayList<ScoreVO> list = new ArrayList<ScoreVO>();
		
		return list;
	}
	
	@Override
	public List<ScoreVO> ascByName() {
		ArrayList<ScoreVO> list = new ArrayList<ScoreVO>();
		AscName asc = new AscName();
		
		Collections.sort(list, asc);
		
		return list;
	}
	@Override
	public List<ScoreVO> searchBySubject(String subject, int i) {
		List<ScoreVO> result = new ArrayList<ScoreVO>();
		 result = dao.selectSubjectBy("java", i);
		 result = dao.selectSubjectBy("oracle",i);
		 result = dao.selectSubjectBy("spring",i);
		 
		return result;
	}
	

	

}
