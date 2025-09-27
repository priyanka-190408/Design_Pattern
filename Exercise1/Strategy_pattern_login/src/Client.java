import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Welcome to Authentication System ===");
        System.out.println("Choose login method: ");
        System.out.println("1. Google");
        System.out.println("2. Facebook");
        System.out.println("3. Email/Password");

        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        AuthenticationService service = null;

        switch (choice) {
            case 1:
                service = new AuthenticationService(new GoogleLogin());
                break;
            case 2:
                service = new AuthenticationService(new FacebookLogin());
                break;
            case 3:
                service = new AuthenticationService(new EmailPasswordLogin());
                break;
            default:
                System.out.println("Invalid choice!");
                System.exit(0);
        }

        service.login(username, password);

        scanner.close();
    }
}
