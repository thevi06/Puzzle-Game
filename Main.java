import java.io.File;
import java.util.List;
public class Main {
    public static void main(String[] args) {

        //call the method that get input form a file and store it as map
        Map map = Parser.parse();

        while (choice != 1 && choice != 2) {
            // Ask the user to choose between loading from benchmark_series or text_file
            System.out.println("Choose an option:");
            System.out.println("1. Load from benchmark_series");
            System.out.println("2. Load from text_file");
            System.out.print("Enter the number corresponding to your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            if (choice != 1 && choice != 2) {
                System.out.println("Invalid choice. Please select either 1 or 2.");
            }
        }

        String directoryPath = (choice == 1) ? "benchmark_series" : "text_file";
        File directory = new File(directoryPath);

        // Check if the directory exists
        if (!directory.exists()) {
            System.out.println("Directory '" + directoryPath + "' does not exist.");
            return null;
        }

        // List all files in the directory
        File[] files = directory.listFiles();

        if (files == null || files.length == 0) {
            System.out.println("No text files found in the folder.");
            return null;
        }

        // Display available text files
        System.out.println("Available files:");