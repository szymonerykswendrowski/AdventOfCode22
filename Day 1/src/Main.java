import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("input.txt"));
            int elfN = 0;
            int maxElf = 0;
            int maxElfCal = 0;
            int currentCal = 0;
            List<Integer> CalList = new ArrayList<Integer>();

            while (scanner.hasNextLine()) {
                String currentLine = scanner.nextLine();
                if (!currentLine.isEmpty()) {
                    currentCal = currentCal + Integer.parseInt(currentLine);
                    if (currentCal > maxElfCal) {
                        maxElfCal = currentCal;
                        maxElf = elfN;
                    }
                } else {
                    CalList.add(currentCal);
                    elfN = elfN + 1;
                    currentCal = 0;
                }
            }
            scanner.close();

            Collections.sort(CalList);
            List<Integer> top3 = new ArrayList<Integer>(CalList.subList(CalList.size() - 3, CalList.size()));
            int top3sum = 0;
            for (int i: top3) {
                top3sum += i;
            }

            System.out.println("The elf with the most calories is elf number " + maxElf);
            System.out.println("They have " + maxElfCal + " calories");
            System.out.println("The top 3 elves have a total of " + top3sum + " calories");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}