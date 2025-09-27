import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Setup chain of responsibility
        LoanApprover clerk = new Clerk();
        LoanApprover manager = new Manager();
        LoanApprover director = new Director();

        clerk.setNextApprover(manager);
        manager.setNextApprover(director);

        Scanner sc = new Scanner(System.in);
        System.out.println("=== Loan Approval System ===");

        boolean running = true;
        while (running) {
            try {
                System.out.print("\nEnter applicant name (or type 'exit' to quit): ");
                String name = sc.nextLine();
                if (name.equalsIgnoreCase("exit")) {
                    running = false;
                    continue;
                }

                System.out.print("Enter loan amount: ");
                double amount = Double.parseDouble(sc.nextLine());

                LoanApplication loan = new LoanApplication(name, amount);
                clerk.approveLoan(loan);

            } catch (NumberFormatException e) {
                System.out.println("⚠ Invalid input. Please enter a valid number for loan amount.");
            } catch (IllegalArgumentException e) {
                System.out.println("⚠ Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("⚠ Unexpected error: " + e.getMessage());
            }
        }

        System.out.println("\nSystem exited. Thank you!");
        sc.close();
    }
}
