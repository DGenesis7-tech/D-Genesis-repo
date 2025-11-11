package data.models;

public class Owner {
    String name;
    String address;
    long phone;
    Gender gender;
    String email;
    String id;

    public Owner(String name, String address, long phone, Gender gender, String email, String id) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.gender = gender;
        this.email = email;
        this.id = id;
    }

    public Owner() {}


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(String gender) {
       if (gender.equals("M")) {
           this.gender = Gender.MALE;
       }
       else if (gender.equals("F")) {
           this.gender = Gender.FEMALE;
       }
       else {
           this.gender = Gender.CURSED;
       }
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        boolean isNum = false;
        if ((phone <= 999999999L) || (phone > 9999999999L)) {
            System.out.println("INVALID PHONE NUMBER, INVALID RANGE");
        }
        else {
            this.phone = phone;
            System.out.println("Created successfully!");
        }


    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
