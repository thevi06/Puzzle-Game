import java.util.List;
public class Main {
    public static void main(String[] args) {

        //call the method that get input form a file and store it as map
        Map map = Parser.parse();

        //call the path finding method
        List<Coordinate> shortestPath = PathFinder.pathFinding(map);