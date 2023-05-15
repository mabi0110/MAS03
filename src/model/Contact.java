package model;

public class Contact {

    private String name;
    private int phone;

    private ContactBook contactBook;

    public Contact(ContactBook contactBook, String name, int phone) {
        this.name = name;
        this.phone = phone;
        this.contactBook = contactBook;
    }

    public static Contact createNewContact(ContactBook contactBook, String name, int phone) throws Exception {
        if (contactBook == null){
            throw new Exception("ContactBook nie istnieje");
        }
        Contact contact = new Contact(contactBook, name, phone);
        contactBook.addContact(contact);
        return contact;
    }

    public ContactBook getContactBook() {
        return contactBook;
    }

    public void setContactBook(ContactBook contactBook) {
        this.contactBook = contactBook;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
}
