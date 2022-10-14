import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ContactManager {

    public static String filename = "contacts.txt";
    public static String currentDir = System.getProperty("user.dir");
    public static String directory = currentDir + "/data";
    public static Path filepath = Paths.get(directory, filename);
    public static List<String> contactList = new ArrayList<>();

    public static void addToContactList(Contact newContact) {
        if (contactList.contains(String.valueOf(newContact))) {
            System.out.println("Contact already exist");
        } else {
            contactList.add(String.valueOf(newContact));
        }
    }

    public static void addContact(Scanner sc) {
        String firstName;
        String lastName;
        String number;

        while (true) {
            System.out.println("---- ADD CONTACT ----\n" +
                    "Enter the first name of the contact");
            firstName = sc.nextLine();
            System.out.println("Enter the last name");
            lastName = sc.nextLine();
            System.out.println("Enter the phone number");
            number = sc.nextLine();
            Contact newContact = new Contact(firstName, lastName, number);
            addToContactList(newContact);
            System.out.println("Would you like to add another contact? y/n?");
            String input = sc.nextLine();
            if (!input.equalsIgnoreCase("y")) {
                break;
            }
        }
        printMainMenu(sc);
    }

    public static void deleteContact() {

    }

    public static void searchContact(Scanner sc) {
        System.out.println("Enter the name of the contact");
        String contact = sc.nextLine();
        List<String> result = contactList.stream()
                .filter(x -> x.contains(contact)).collect(Collectors.toList());
        System.out.println(result);
        System.out.println("---------------");
        System.out.println("1. Search another contact\n" +
                "2. Return to main menu\n");
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1:
                searchContact(sc);
                break;
            case 2:
                printMainMenu(sc);
    }

    }

    public static void printList() {
        contactList.forEach(System.out::println);
    }

    public static void printMainMenu(Scanner sc) {
        System.out.println(
                "------------------------------------------\n" +
                        "                Welcome!\n" +
                        "------------------------------------------\n" +
                        "1. View contacts\n" +
                        "2. Add a new contact\n" +
                        "3. Search a contact by name\n" +
                        "4. Delete an existing contact\n" +
                        "5. Exit\n" +
                        "Enter an option (1, 2, 3, 4 or 5):\n" +
                        "------------------------------------------\n");
        mainMenu(sc);
    }

    public static void mainMenu(Scanner sc) {
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1:
                printList();
                break;
            case 2:
                addContact(sc);
                break;
            case 3:
                searchContact(sc);
                break;
//            case 4:
//                category = "Meat";
//                break;
//            case 5:
//                category = "Other";
//                break;
        }
    }
}// ContactManager CLASS

