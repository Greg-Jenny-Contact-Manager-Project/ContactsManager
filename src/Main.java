import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static String filename = "contacts.txt";
    public static String currentDir = System.getProperty("user.dir");
    public static String directory = currentDir + "/data";
    public static Path filepath = Paths.get(directory,filename);
    public static ArrayList<Contact> contactList = new ArrayList<>();

    public static void addContact(Contact newContact) {
        contactList.add(newContact);
    }
    public static void main(String[] args) throws IOException {
        // Onload read the file contacts.txt
        List<String> fileContactList = Files.readAllLines(filepath);

        Contact jenny = new Contact("Jenny", "Austin", "333-333-3333");
        Contact john = new Contact("John", "Smith", "333-333-4444");
        addContact(jenny);
        addContact(john);

        Files.write(filepath,contactList);

        System.out.println(contactList);
        System.out.println(fileContactList);
    } // main method
} // main class