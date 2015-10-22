package iterator_array;

import java.util.Arrays;

import iterator_global.MyIterator;
import iterator_global.Student;

public class HanbitServiceImpl implements HanbitService{ //배열로 선언.
	private Student[] studentlist;
	private int last = 0;
	
	
	public HanbitServiceImpl(int size){
		this.studentlist = new Student[size];
	}
	
	public void add(Student student) {
		if (last < studentlist.length) {
			this.studentlist[last] = student;
			last++;
		} else {
			System.out.println("안돼");
		}
		
	}

	public int getCount() {
		return last;
	}

	public Student getStudentAt(int index) {
		return studentlist[index];
	}

	public Student searchByName(String name){
		MyIterator it = iterator(); //왜 여기 있어야 되는거야
									// 필드에선 안되고.
		while (it.hasNext()) {
			Student search = (Student) it.next();
			if (name.equals(search.getName())) {
				return search;
			}
		}
		return null;
	}
	
	public Student[] searchBySubject(String subject){
		MyIterator it = iterator();
		int count = 0;
		while (it.hasNext()) {
			Student search = (Student) it.next();
			if (subject.equals(search.getSubject())) {
				count++;
			}
		}
		//System.out.println(count);
		Student[] list = new Student[count];
		count = 0;
		it = iterator(); // iterator를 맨 처음으로 되돌려야함.
		while (it.hasNext()) {
			Student search = (Student) it.next();
			if (subject.equals(search.getSubject())) {
				list[count] = search;
				count++;
			}
		}
		
		return list;
	}
	
	@Override
	public MyIterator iterator() {
		
		return new HanbitIterator(this);
	}
	
}
