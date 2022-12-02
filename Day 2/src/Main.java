import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("input.txt"));
            int score = 0;

            while (scanner.hasNextLine()) {
                String currentLine = scanner.nextLine();
                int n = currentLine.length();
                char x1 = currentLine.charAt(0);
                char x2 = currentLine.charAt(n-1);

                switch (currentLine) {
                    /* Part 1
                    case "A X":
                        // Rock Rock
                        score += 4;
                        break;
                    case "B Y":
                        // Paper Paper
                        score += 5;
                        break;
                    case "C Z":
                        // Scissors Scissors
                        score += 6;
                        break;
                    case "A Y":
                        // Rock Paper
                        score += 8;
                        break;
                    case "A Z":
                        // Rock Scissors
                        score += 3;
                        break;
                    case "B X":
                        // Paper Rock
                        score += 1;
                        break;
                    case "B Z":
                        // Paper Scissors
                        score += 9;
                        break;
                    case "C X":
                        // Scissors Rock
                        score += 7;
                        break;
                    case "C Y":
                        // Scissors Paper
                        score += 2;
                        break;
                     */
                    case "A X":
                        // Rock Scissors, you need to lose
                        score += 3;
                        break;
                    case "B Y":
                        // Paper Paper, you need to draw
                        score += 5;
                        break;
                    case "C Z":
                        // Scissors Rock, you need to win
                        score += 7;
                        break;
                    case "A Y":
                        // Rock Rock, you need to draw
                        score += 4;
                        break;
                    case "A Z":
                        // Rock Paper, you need to win
                        score += 8;
                        break;
                    case "B X":
                        // Paper Rock, you need to lose
                        score += 1;
                        break;
                    case "B Z":
                        // Paper Scissors, you need to win
                        score += 9;
                        break;
                    case "C X":
                        // Scissors Paper, you need to lose
                        score += 2;
                        break;
                    case "C Y":
                        // Scissors Scissors, you need to draw
                        score += 6;
                        break;
                }
            }
            scanner.close();
            System.out.print("Your total score is: " + score);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}