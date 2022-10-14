import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static String filename = "contacts.txt";
    public static String currentDir = System.getProperty("user.dir");
    public static String directory = currentDir + "/data";
    public static Path filepath = Paths.get(directory,filename);
    public static void main(String[] args) {
        Contact jenny = new Contact("Jenny", "Austin", "333-333-3333");
        System.out.println(jenny);
    } // main method
} // main class