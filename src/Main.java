import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        // Onload read the file contacts.txt
        ContactManager.contactList = Files.readAllLines(ContactManager.filepath);

        Scanner sc = new Scanner(System.in);

        ContactManager.printMainMenu(sc);
//        ContactManager.mainMenu(2,sc);
        // Writing contact list to contacts.txt
        Files.write(ContactManager.filepath, ContactManager.contactList);


    } // main method

} // main class
//        ContactManager.addContact(sc);
//        Contact peter = new Contact("Peter", "Hardtospell", "111-111-1111");
//        ContactManager.addToContactList(peter);
//        ContactManager.printList();
//        ContactManager.printMainMenu();