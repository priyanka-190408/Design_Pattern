import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: College name
        System.out.print("Enter College Name: ");
        String collegeName = sc.nextLine();

        College.Builder builder = new College.Builder(collegeName);

        // Step 2: Ask user about facilities
        System.out.print("Does the college have a Library? (yes/no): ");
        if (sc.nextLine().equalsIgnoreCase("yes")) {
            builder.addLibrary();
        }

        System.out.print("Does the college have a Hostel? (yes/no): ");
        if (sc.nextLine().equalsIgnoreCase("yes")) {
            builder.addHostel();
        }

        System.out.print("Does the college have a Sports Complex? (yes/no): ");
        if (sc.nextLine().equalsIgnoreCase("yes")) {
            builder.addSportsComplex();
        }

        System.out.print("Does the college have Labs? (yes/no): ");
        if (sc.nextLine().equalsIgnoreCase("yes")) {
            builder.addLabs();
        }

        // Step 3: Build the College
        College college = builder.build();

        // Step 4: Display the result
        System.out.println("\n College constructed successfully!");
        System.out.println(college);

        sc.close();
    }
}
