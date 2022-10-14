import java.io.IOException;
import java.nio.file.Files;

public class Main {
    public static void main(String[] args) throws IOException {
        // Onload read the file contacts.txt
        ContactManager.contactList = Files.readAllLines(ContactManager.filepath);


        Contact peter = new Contact("Peter", "Hardtospell", "111-111-1111");
        ContactManager.addContact(peter);


        // Writing contact list to contacts.txt
        Files.write(ContactManager.filepath, ContactManager.contactList);

        ContactManager.printList();

        ContactManager.printMainMenu();
    } // main method




} // main class