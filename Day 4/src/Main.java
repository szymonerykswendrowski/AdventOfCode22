import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int rangePairs = 0;
        int pairsOverlap=0;
        try {
            Scanner scanner = new Scanner(new File("input.txt"));
            while (scanner.hasNextLine()) {
                String currentLine = scanner.nextLine();
                String[] currentLineArray = currentLine.split(",|\\-");
                int[] numbersArray = Arrays.stream(currentLineArray).mapToInt(Integer::parseInt).toArray();
                if ((numbersArray[0] <= numbersArray[2] &&
                        numbersArray[1] >= numbersArray[3]) ||
                        ((numbersArray[2] <= numbersArray[0] &&
                                numbersArray[3] >= numbersArray[1]))) {
                    rangePairs += 1;
                }
                if (numbersArray[0] <= numbersArray[3] && numbersArray[1] >= numbersArray[2]) {
                    pairsOverlap += 1;
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("For " + rangePairs + " pairs, one range fully contains the other.");
        System.out.println("For " + pairsOverlap + " pairs, ranges overlap.");
    }

}
