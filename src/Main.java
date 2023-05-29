import model.wielodziedziczenie.Admin;
import model.wielodziedziczenie.Librarian;
import model.wielodziedziczenie.LibrarianAdmin;
import model.wielodziedziczenie.User;

import java.time.Year;

public class Main {

    public static void main(String[] args) {
        /*

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

         */

        LibrarianAdmin librarianAdmin = new LibrarianAdmin("Jan", "Nowak", Year.of(1992), "e12345", "888123123");
        System.out.println(librarianAdmin.getSalary());
        librarianAdmin.addUser(new User("Ola", "Nowak", Year.of(2003), "u12345"));
        librarianAdmin.removeUser(new User("Ola", "Nowak", Year.of(2003), "u12345"));
        librarianAdmin.addPerson(new User("Ola", "Nowak", Year.of(2003), "u12345"));
        librarianAdmin.addPerson(new Admin("Adam", "Nowak", Year.of(2000), "e12346", "789123456"));
        librarianAdmin.addPerson(new Librarian("Ela", "Nowak", Year.of(1999), "e12347"));
    }
}