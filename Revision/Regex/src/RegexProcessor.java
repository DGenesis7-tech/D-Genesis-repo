public class RegexProcessor {

    public boolean isPhoneNumberValid(String phoneNumber) {
        if (phoneNumber == null) {
            return false;
        }

        String phonePattern = "^\\(080\\)\\d{8}$|^\\+235-*[0-9]{8}$";
        return phoneNumber.matches(phonePattern);
    }

    public boolean isEmailValid(String email) {
        if (email == null) {
            return false;
        }
        String emailPattern = "^[a-zA-Z0-9._%+-]+@[gmail]+\\.[a-zA-Z]+$";
        return email.matches(emailPattern);
    }


}
