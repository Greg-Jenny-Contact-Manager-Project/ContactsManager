import java.util.Formatter;

public class Contact  {
    private String firstName;
    private String lastName;
    private String fullName;
    private String phone;

    public Contact(String firstName, String lastName, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.fullName = firstName + " " + lastName;
    }
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String toString() {
        String stringContact = String.format("%-23s| %s |", fullName, phone);
        return stringContact;
    }

    public static String format(String format, Object... args) {
        return new Formatter().format(format, args).toString();
    }
//System.out.printf("%-23s| %s   |%n",nameField, phoneNumberField);

}
