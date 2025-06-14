package Library;

import java.util.Iterator;

public class Library implements Iterable<Book> {
    private Book [] books;

    public Library(Book... books) {
        this.books = books;
    }


    @Override
    public Iterator<Book> iterator() {
        return new LibraryIterator();
    }

    private class LibraryIterator implements Iterator<Book>{

        private int position = 0;
        @Override
        public boolean hasNext() {
            return position< books.length;
        }

        @Override
        public Book next() {
            return books[position++];
        }
    }

}
