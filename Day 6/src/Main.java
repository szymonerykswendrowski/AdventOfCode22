import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        try {
            Scanner scanner = new Scanner(new File("input.txt"));

            String currentLine = scanner.nextLine();
            System.out.println(currentLine);

            boolean packetFound = false;
            boolean messageFound = false;

            for (int i=0; i <= currentLine.length() - 14;) {

                int packetMarker = i + 4;
                int messageMarker = i + 14;

                String currentCharsPacket = currentLine.substring(i, i+4);
                Set<Character> charSetPacket = new HashSet<>();
                String currentCharsMessage = currentLine.substring(i, i+14);
                Set<Character> charSetMessage = new HashSet<>();

                for (int j = 0; j < currentCharsPacket.length(); j++) {
                    charSetPacket.add(currentCharsPacket.charAt(j));
                }
                for (int k = 0; k < currentCharsMessage.length(); k++) {
                    charSetMessage.add(currentCharsMessage.charAt(k));
                }

                // You could put packets and messages into individual loops and then include a break statement
                // when the first one is found to avoid computing the whole string.
                if (charSetPacket.size() == currentCharsPacket.length() && packetFound == false) {
                    System.out.println("Found packet! " + currentCharsPacket + " at " + packetMarker);
                    packetFound = true;
                }
                if (charSetMessage.size() == currentCharsMessage.length() && messageFound == false) {
                    System.out.println("Found message! " + currentCharsMessage + " at " + messageMarker);
                    messageFound = true;
                }
                i += 1;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}