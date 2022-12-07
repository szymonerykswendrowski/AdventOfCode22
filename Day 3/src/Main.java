import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        String str = "abcdefghijklmnopqrstuvwxyz";
        String Str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int score1 = 0;
        int score2 = 0;
        for (char c : str.toCharArray()) {
            int temp = (int)c;
            map.put(c, temp-96);
        }
        for (char c : Str.toCharArray()) {
            int temp = (int)c;
            map.put(c, temp-38);
        }
        // Part 1 code:
        try {
            Scanner scanner = new Scanner(new File("input.txt"));
            while (scanner.hasNextLine()) {
                String currentLine = scanner.nextLine();
                char[] chars = currentLine.toCharArray();
                int mid = currentLine.length() / 2;
                String part1 = currentLine.substring(0, mid);
                String part2 = currentLine.substring(mid);
                char[] chars1 = part1.toCharArray();
                char[] chars2 = part2.toCharArray();
                Arrays.sort(chars1);
                Arrays.sort(chars2);
                outerloop: /* in practice, you would make this a method and then just return, easier to just
                label loop here */
                for (int i=0; i < chars1.length; i++) {
                    for (int j=0; j < chars2.length; j++) {
                        if (chars1[i] == chars2[j]) {
                            score1 += map.get(chars1[i]);
                            break outerloop;
                        }
                    }
                }
            } scanner.close();
            System.out.println("The sum of the priorities is " + score1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // Part 2 code:
        try {
            Scanner scanner = new Scanner(new File("input.txt"));
            while (scanner.hasNextLine()) {
                String line1 = scanner.nextLine();
                String line2 = scanner.nextLine();
                String line3 = scanner.nextLine();
                char[] chars1 = line1.toCharArray();
                char[] chars2 = line2.toCharArray();
                char[] chars3 = line3.toCharArray();
                Arrays.sort(chars1);
                Arrays.sort(chars2);
                Arrays.sort(chars3);
                outerloop:
                for (int i=0; i < chars1.length; i++) {
                    for (int j=0; j < chars2.length; j++) {
                        for (int k=0; k < chars3.length; k++) {
                            if (chars1[i] == chars2[j] && chars2[j] == chars3[k]) {
                                score2 += map.get(chars1[i]);
                                break outerloop;
                            }
                        }
                    }
                }
            } scanner.close();
            System.out.println("The badges score is " + score2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}