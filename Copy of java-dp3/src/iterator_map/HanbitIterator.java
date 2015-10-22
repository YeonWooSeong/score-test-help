package iterator_map;

import iterator_global.MyIterator;
import iterator_global.Student;

public class HanbitIterator implements MyIterator{
	private HanbitServiceImpl hb;
	private int index;
	
	public HanbitIterator(HanbitServiceImpl student) {
		this.hb = student;
		this.index = 0;
	}
	@Override
	public boolean hasNext() {
		if (index < hb.getCount()) { // 배열이 가지고 있는 실제 요소갯수
			return true;
		} else {
			return false;	
		}
	}

	@Override
	public Object next() {
		Student student = hb.getStudentAt(index);
		index++;
		return student;
	}

	
	
}
