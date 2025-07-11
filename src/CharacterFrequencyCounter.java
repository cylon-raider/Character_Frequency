import java.util.*;

public class CharacterFrequencyCounter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("\nEnter a string (or type 'q' or 'quit' to exit): ");
            String input = scanner.nextLine();

            // Exit condition
            if (input.equalsIgnoreCase("q") || input.equalsIgnoreCase("quit")) {
                System.out.println("Exiting program. Goodbye!");
                break;
            }

            // Remove spaces
            input = input.replaceAll("\\s+", "");

            // Count character frequencies
            Map<Character, Integer> charCountMap = new HashMap<>();
            for (char c : input.toCharArray()) {
                // To make case-insensitive, uncomment the next line
                // c = Character.toLowerCase(c);
                charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
            }

            // Sort output highest to lowest
            List<Map.Entry<Character, Integer>> sortedEntries = new ArrayList<>(charCountMap.entrySet());
            sortedEntries.sort((a, b) -> b.getValue().compareTo(a.getValue()));

            // Display the results
            System.out.println("Character frequencies (highest to lowest):");
            for (Map.Entry<Character, Integer> entry : sortedEntries) {
                System.out.println("'" + entry.getKey() + "' : " + entry.getValue());
            }
        }

        scanner.close();
    }
}
