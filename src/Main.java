import model.Book;
import model.Magazine;
import model.Publication;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Publication book1 = new Book("Ania z Zielonego Wzgórza", Year.of(2001), "L. Montgomery", "123456789");
        Publication book2 = new Book("Janko Muzykant", Year.of(2003), "M. Konopnicka", "123456780");
        Publication magazine1 = new Magazine("Ilustrator", Year.of(2001), 12, 1);

        List<Publication> publications = new ArrayList<>();
        publications.add(book1);
        publications.add(book2);
        publications.add(magazine1);


        for (Publication publication : publications){
            System.out.println(publication.getData());
        }

    }
}