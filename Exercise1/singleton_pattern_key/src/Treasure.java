public class Treasure {
    // Step 1: Static member (only one treasure instance)
    private static Treasure instance;

    // Secret key for accessing the treasure
    private final String secretKey = "GOLDEN-KEY-123";

    // Step 2: Private constructor (no external instantiation)
    private Treasure() {
        System.out.println("💎 Treasure has been created! Guarded carefully...");
    }

    // Step 3: Static factory method (global access point)
    public static Treasure getInstance() {
        if (instance == null) {
            instance = new Treasure();  // Lazy initialization
        }
        return instance;
    }

    // Method to try accessing the treasure
    public void accessTreasure(String key, String playerName) {
        if (secretKey.equals(key)) {
            System.out.println(playerName + " unlocked the Treasure!");
        } else {
            System.out.println(playerName + " failed to open the Treasure (Wrong Key)");
        }
    }
}
