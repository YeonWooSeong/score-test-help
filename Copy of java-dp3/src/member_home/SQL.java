package member_home;

public interface SQL {
	/*
	 * executeUpdate : DML 중에 테이블의 데이터값이 변형됨
	 */
	public String insert(); //추가
	public String update(); //수정
	public String delete(); //삭제
	
	/*
	 * executeQuery : DML 중에 테이블의 데이터값이 변형되지 않음
	 */
	public String selectAll(); //조회
	public String selectOneBy(String s); // ID로 검색
	public String count(); // 전체 수량
	public String selectSomeBy(String s1, String s2);
	/*
	 * 쿼리 스타일
	 */
	public String make(String s); // SQL 타입의 파라미터로 변환.
/*	public String delete(String id);
	public String selectSomeBy(String s1, String s2);*/
	
}
