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