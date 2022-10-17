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



    } // main method

} // main class
