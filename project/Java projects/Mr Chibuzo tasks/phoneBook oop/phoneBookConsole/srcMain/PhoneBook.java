import java.util.ArrayList;
import java.util.List;

public class PhoneBook {
    private List<Contact> contactsList;
    private String name;
    private String email;
    private String id;

    public PhoneBook() {
        this.contactsList = new ArrayList<>();
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void addContact(Contact contact) {
        for (Contact contact1 : this.contactsList ) {
            if (contact == contact1) {
                System.out.println("CONTACT ALREADY EXISTS");
            }
        }
        this.contactsList.add(contact);
    }

    public Contact getContact(String name) {
        for (Contact contact : this.contactsList) {
            if (contact.getName().equalsIgnoreCase(name)) {
                return contact;
            }
        }
        return null;
    }

    public void deleteContact(String name) {
        for (Contact contact : this.contactsList) {
            if (contact.getName().equalsIgnoreCase(name)) {
                this.contactsList.remove(contact);
                break;
            }
            else  {
                System.out.println("CONTACT NOT EXISTS");
            }
        }
    }

    public List<Contact> getContactsList() {
        return contactsList;
    }



}
