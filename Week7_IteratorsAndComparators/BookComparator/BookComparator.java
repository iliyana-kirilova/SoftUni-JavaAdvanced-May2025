package BookComparator;

import java.util.Comparator;

public class BookComparator implements Comparator<Book> {


    @Override
    public int compare(Book firstBook, Book secondBook) {
        int resultTitle = firstBook.getTitle().compareTo(secondBook.getTitle());
        if (resultTitle ==0){
            resultTitle = Integer.compare(firstBook.getYear(), secondBook.getYear());

        }

        return resultTitle;
    }
}
