public class FacebookLogin implements AuthenticationStrategy {
    @Override
    public boolean authenticate(String username, String password) {
        // Simulated Facebook login check
        return username.endsWith("@facebook.com") && password.equals("fb123");
    }
}
