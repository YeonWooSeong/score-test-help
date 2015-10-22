package iterator;

import iterator_global.MyIterator;

public class MultiplexIterator implements MyIterator{
	private Multiplex mt;
	private int index;
	
	public MultiplexIterator(Multiplex mt) {
		this.mt = mt;
		this.index = 0;
	}
	@Override
	public boolean hasNext() {
		if (index < mt.getCount()) { // 배열이 가지고 있는 실제 요소갯수
			return true;
		} else {
			return false;	
		}
	}

	@Override
	public Object next() {
		Movie movie = mt.getMovieAt(index);
		index++;
		return movie;
	}

}
