import java.util.Scanner;

public class TreasureGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Treasure treasure = Treasure.getInstance(); // Singleton instance

        System.out.println("=== Treasure Hunt Game ===");

        boolean running = true;
        while (running) {
            System.out.print("\nEnter player name (or type 'exit' to quit): ");
            String playerName = sc.nextLine();
            if (playerName.equalsIgnoreCase("exit")) {
                running = false;
                continue;
            }

            System.out.print("Enter the secret key to unlock the treasure: ");
            String key = sc.nextLine();

            treasure.accessTreasure(key, playerName);
        }

        System.out.println("\nGame Over! Thanks for playing. 👋");
        sc.close();
    }
}
