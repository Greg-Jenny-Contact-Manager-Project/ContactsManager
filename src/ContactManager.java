import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class ContactManager {

    public static String filename = "contacts.txt";
    public static String currentDir = System.getProperty("user.dir");
    public static String directory = currentDir + "/data";
    public static Path filepath = Paths.get(directory, filename);
    public static List<String> contactList = new ArrayList<>();
    public static String breakPt = "-------------------------------------------------------";

    public static void printMainMenu(Scanner sc)  {
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

    public static void mainMenu(Scanner sc)  {
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1:
                printList(sc);
                break;
            case 2:
                addContact(sc);
                break;
            case 3:
                searchContact(sc);
                break;
            case 4:
                deleteContact(sc);
                break;
            case 5:
                System.out.println("Thank you, Goodbye!");;
                break;
        }
    }

    // 1. Prints list of all contacts
    public static void printList(Scanner sc)  {
        contactList.forEach(System.out::println);
        System.out.println("----------------------------------");
        System.out.println("1. Return to main menu\n" +
                "2. Exit");
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1:
                printMainMenu(sc);
                break;
            case 2:
                break;
        }
    }

    // 2. Prompts users for contact info and creates contact object
    public static Consumer<Scanner> addContact(Scanner sc)  {
        String firstName;
        String lastName;
        String number;

        System.out.println("---- ADD CONTACT ----\n" +
                "Enter the first name of the contact");
        firstName = sc.nextLine();
        System.out.println("Enter the last name");
        lastName = sc.nextLine();
        System.out.println("Enter the phone number");
        number = sc.nextLine();
        Contact newContact = new Contact(firstName, lastName, number);
        addToContactList(newContact);
        returnMenu(sc, "Add a new contact ", ContactManager::addContact);
        return addContact(sc);
    }

    // Adds new contact to the contact list array
    public static void addToContactList(Contact newContact) {
        if (contactList.contains(String.valueOf(newContact))) {
            System.out.println("Contact already exist");
        } else {
            contactList.add(String.valueOf(newContact));
        }
    }

    // 3. Searches contact by contact name and returns list that match name
        public static Consumer<Scanner> searchContact(Scanner sc)  {
            System.out.println("\n" + breakPt + "\n                    SEARCH CONTACT\n" + breakPt);
            List<String> result = searchfunction(sc);
            System.out.println(breakPt + "\n");
            if (!result.isEmpty()) {
                returnMenu(sc, "Search another contact", ContactManager::searchContact);
            } else {
                System.out.println("No contact found");
            }
            returnMenu(sc, "Search another contact", ContactManager::searchContact);
            return searchContact(sc);
        }
        public static List<String> searchfunction(Scanner sc) {
            List<String> result;
            System.out.println("Enter the name of the contact");
            String contact = sc.nextLine();
            result = contactList.stream()
                    .filter(x -> x.toLowerCase().contains(contact.toLowerCase())).collect(Collectors.toList());
            result.forEach(System.out::println);
            return result;
        }


    public static Consumer<Scanner> deleteContact(Scanner sc)  {
        List<String> result = searchfunction(sc);
            int indexNum = contactList.indexOf(result.get(0));
            contactList.remove(indexNum);
            System.out.println(result + " has been deleted!\n" + breakPt);
            try {
                returnMenu(sc, "Delete contact", ContactManager::deleteContact);
            } catch (Exception e) {
                System.out.println(e);
            }
        return deleteContact(sc);
    }

    // Method accepts sc, a prompt, and a method. Prints prompt as menu item and inserts method in switch statement.
    public static Consumer<Scanner> returnMenu(Scanner sc, String prompt, Consumer<Scanner> method)  {
        System.out.println("\n" + breakPt + "\n1. " + prompt +
                "\n2. Return to main menu\n" +
                "3. Exit\n" + breakPt);
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1:
                try {
                    Consumer<Scanner> method1 = method;
                } catch (Exception e) {
                    System.out.println(e);
                } finally {
                    break;
                }

            case 2:
                printMainMenu(sc);
                break;
            case 3:
                exit();
        }
        return method;
    }

    public static void returnMenu(Scanner sc)  {
        System.out.println(
                "\n1. Return to main menu\n" +
                "2. Exit\n" + breakPt);
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1:
                printMainMenu(sc);
                break;
            case 2:
                exit();
        }
    }

    private static String byee = "Thank you for using GREY Contact Manager!\n";

    public static void exit() {
        try {
            System.out.println(breakPt + "\n" + byee + breakPt);
            Files.write(ContactManager.filepath, ContactManager.contactList);
            System.exit(0);
        } catch (IOException e) {
            System.out.println(e);
        }

    }

}// ContactManager CLASS

