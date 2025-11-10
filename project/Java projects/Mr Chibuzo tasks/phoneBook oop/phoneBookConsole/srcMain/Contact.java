public class Contact {
    String name;
    String email;
    long phone;

    public Contact(String name , String email, long phone) {
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

    public long getPhoneNum() {
        return phone;
    }

    public long setPhoneNum(long phoneNum) {
        boolean isNum = false;
        while (true) {
            if (phoneNum < 1000000000 || phoneNum > 9999999999L) {
                System.out.println("INVALID PHONE NUMBER, INVALID RANGE");
            }
            else {
                isNum = true;
                System.out.println("Created successfully!");
                return phoneNum;
            }
        }
    }

}
