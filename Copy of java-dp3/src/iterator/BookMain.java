package iterator;

import iterator_global.MyIterator;

public class BookMain {
	public static void main(String[] args) {
	
	BookShelf bookShelf = new BookShelf(100); //100권을 담을 수 있는 책장
	bookShelf.add(new Book("자바의 정석"));
	bookShelf.add(new Book("디자인패턴"));
	bookShelf.add(new Book("오라클문법"));
	bookShelf.add(new Book("JSP프로그래밍"));
	
	MyIterator it = bookShelf.iterator();	//shallow copy. (싱글톤x) 
		//내 안에 나를 검색할 수 있는 대상을 부를 수 있는 기능(iterator())이 있어야 한다.
	while (it.hasNext()) {
		Book book = (Book) it.next();
		System.out.println(book.getName()+"\t");
	}
	
	}
}
