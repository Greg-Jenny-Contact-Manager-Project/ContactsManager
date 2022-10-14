import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ContactManager {

        public static String filename = "contacts.txt";
        public static String currentDir = System.getProperty("user.dir");
        public static String directory = currentDir + "/data";
        public static Path filepath = Paths.get(directory,filename);
        public static List<String> contactList = new ArrayList<>();

        public static void addContact(Contact newContact) {
                if (contactList.contains(String.valueOf(newContact))) {
                        System.out.println("Contact already exist");
                } else {
                        contactList.add(String.valueOf(newContact));
                }
        }

        public  static void printList() {
                contactList.forEach(System.out::println);
        }


        public static void writeContactList(ArrayList<Contact> list) {

        }


    } //

