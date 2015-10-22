package iterator;

import iterator_global.MyIterator;

public class BookShelf implements BookShelfService{ //책을 모아놧다 필요한 것은 주고 아닌 것은 빼고.
	private Book[] books;
	private int last = 0;
	
	public BookShelf(int size){
		this.books = new Book[size];
	}
	
	public void add(Book book){
		this.books[last] = book;
		last++;
	}
	
	public Book getBookAt(int index){
		return books[index];
	}
	public int getCount(){ //배열의 사이즈가 아닌 실제 요소들의 갯수
		return last;
	}
	
	@Override
	public MyIterator iterator() {
		return new BookShelfIterator(this); //본 클래스를 검색하는 객체
		//this 자체는 클래스. 객체는 아님. 타입을 맞춰주는 것.
		//main에서 
	}
	
	
}
