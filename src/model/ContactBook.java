package model;

import java.util.ArrayList;
import java.util.List;

public class ContactBook {

    private List<Contact> contacts = new ArrayList<>();
    private String name;

    public ContactBook(String name){
        this.name = name;
    }

    public void addContact(Contact contact){
        if (!contacts.contains(contact)){
            contacts.add(contact);
        }
    }

    @Override
    public String toString() {
        String info = "Contact book " + name + "\n";
        for (Contact contact : contacts) {
            info += " " + contact.getName() + " " + contact.getPhone() + "\n";
        }
        return info;
    }
}
