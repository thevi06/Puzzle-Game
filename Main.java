import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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
        for (int i = 0; i < files.length; i++) {
            System.out.println((i + 1) + ". " + files[i].getName());
        }

        // Ask user to select a file
        int fileIndex = 0;
        while (fileIndex < 1 || fileIndex > files.length) {
            System.out.print("Enter the number corresponding to the text file you want to select: ");
            fileIndex = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            if (fileIndex < 1 || fileIndex > files.length) {
                System.out.println("Invalid input. Please select a valid number.");
            }
        }

        // Selected file
        File selectedFile = files[fileIndex - 1];

        char[][] grid;
        Coordinate start;
        List<String> lines = new ArrayList<>();
        Coordinate finish;
        List<Coordinate> rocks;

        if (selectedFile.isFile() && selectedFile.getName().endsWith(".txt")) {
            System.out.println("Reading file " + selectedFile.getName());

            // Read the lines in the text file and add them to an array list
            try (BufferedReader br = new BufferedReader(new FileReader(selectedFile))) {
                lines.clear();
                String line;
                while ((line = br.readLine()) != null) {
                    lines.add(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }