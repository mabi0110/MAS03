import model.Library;

public class Main {

    public static void main(String[] args) {
        Library library = new Library("Biblioteka WSIP");
        LibraryControl libraryControl = new LibraryControl(library);
        libraryControl.controlLoop();
    }
}