public class Contact {
    String name;
    String email;
    String phone;

    public Contact(String name , String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = setPhoneNum(phone);
    }

    public String getName() {
        return name;
    }

    public void setName() {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNum() {
        return phone;
    }

    public String setPhoneNum(String phone) {
        if (phone.length() != 11) {
            System.out.println("INVALID PHONE NUMBER, LENGTH EXCEEDED");
            return null;
        }
        this.phone = phone;
        return phone;
    }

}
