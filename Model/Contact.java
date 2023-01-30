package Model;

public class Contact {
    private String contactName;
    private String contact;

    public Contact(String contactName, String contact) {
        this.contactName = contactName;
        this.contact = contact;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "{" + contactName + " : " + contact + "}";
    }
}
