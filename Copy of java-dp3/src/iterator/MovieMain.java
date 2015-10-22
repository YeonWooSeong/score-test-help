package iterator;

import iterator_global.MyIterator;

public class MovieMain {
	public static void main(String[] args) {
		
		Multiplex mt = new Multiplex(50);
		mt.add(new Movie("반지의 제왕1"));
		mt.add(new Movie("반지의 제왕2"));
		mt.add(new Movie("반지의 제왕3"));
		mt.add(new Movie("해리포터"));
		
		MyIterator it = mt.iterator();
		while (it.hasNext()) {
			Movie movie = (Movie) it.next();
			System.out.println(movie.getName());
		}
	}
}
