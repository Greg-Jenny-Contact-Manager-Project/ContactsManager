import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        // Onload read the file contacts.txt
        ContactManager.contactList = Files.readAllLines(ContactManager.filepath);
        Scanner sc = new Scanner(System.in);
        ContactManager.addContact(sc);
//        Contact peter = new Contact("Peter", "Hardtospell", "111-111-1111");
//        ContactManager.addToContactList(peter);


        // Writing contact list to contacts.txt
        Files.write(ContactManager.filepath, ContactManager.contactList);

//        ContactManager.printList();
//        ContactManager.printMainMenu();
    } // main method




} // main class