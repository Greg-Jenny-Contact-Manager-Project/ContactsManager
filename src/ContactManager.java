import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ContactManager {
    public static String filename = "contacts.txt";
    public static String currentDir = System.getProperty("user.dir");
    public static String directory = currentDir + "/data";
    public static Path filepath = Paths.get(directory, filename);
    public static List<String> contactList = new ArrayList<>();
    

    // Take in new Contact object and add it to the ArrayList of all contacts as a STRING
    public static void addToContactList(Contact newContact) {
        if (contactList.contains(String.valueOf(newContact))) {
            System.out.println("Contact already exist");
        } else {
            contactList.add(String.valueOf(newContact));
        }
    }


    // Creates a new Contact object via user inputs in the terminal
    public static void addContact(Scanner sc) {
        String firstName;
        String lastName;
        String number;
        System.out.println("\n" + Menus.breakPt + "\n                      ADD CONTACT\n" + Menus.breakPt +
                "\nEnter the first name:");
        firstName = sc.nextLine();
        System.out.println("Enter the last name");
        lastName = sc.nextLine();
        System.out.println("Enter the phone number");
        number = sc.nextLine();
        Contact newContact = new Contact(firstName, lastName, number);
        addToContactList(newContact);
        Menus.returnMenu(sc, "1. Add another contact", ContactManager::searchContact);

    }

    // TODO: 10/15/22 need to adjust for an option to choose which selection to delete.
    // TODO: 10/15/22 If none found return statement "no contact found" and menu

    public static void deleteContact(Scanner sc) {
        System.out.println("\n" + Menus.breakPt + "\n                    DELETE CONTACT\n" + Menus.breakPt);
        try {
            System.out.println("Enter the name of the contact you would like to delete");
            String contact = sc.nextLine();
            List<String> result = contactList.stream()
                    .filter(x -> x.toLowerCase().contains(contact.toLowerCase())).collect(Collectors.toList());
            result.forEach(System.out::println);
            int deleteIndex = contactList.indexOf(result.get(0));
            contactList.remove(deleteIndex);

        } catch (IndexOutOfBoundsException e) {
            System.out.println(Menus.breakPt + "\n\nThat name does not match any contact in the GREY");
        }
         // this works only when there is a single entry returned, otherwise you delete the first on the list.
        Menus.returnMenu(sc, "1. Delete another contact", ContactManager::deleteContact);

    }


    // Searches contactList ArrayList based off a user input String, prints an array list of any Contact that has values that match the input. ignores case.
    public static void searchContact(Scanner sc) {
        System.out.println("\n" + Menus.breakPt + "\n                    SEARCH CONTACT\n" + Menus.breakPt);
        System.out.println("Enter the name of the contact");
        String contact = sc.nextLine();
        List<String> result = contactList.stream()
                .filter(x -> x.toLowerCase().contains(contact.toLowerCase())).collect(Collectors.toList());
        System.out.println(Menus.breakPt + "\n");
        result.forEach(System.out::println);
        Menus.returnMenu(sc, "1. Search another contact", ContactManager::searchContact);

    }

    // Prints the contactList in alphabetical order based on first name values
    public static void printList(Scanner sc) {
        Collections.sort(contactList);
        contactList.forEach(System.out::println);
        Menus.returnMenu(sc);
    }


}// end ContactManager CLASS

