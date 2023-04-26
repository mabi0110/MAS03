public class Main {
    private static final String APP_NAME = "Biblioteka wydawinctwa WSIP";
    public static void main(String[] args) {
        System.out.println(APP_NAME);
        LibraryControl libraryControl = new LibraryControl();
        libraryControl.controlLoop();
    }
}