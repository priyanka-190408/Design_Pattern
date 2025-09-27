public class GoogleLogin implements AuthenticationStrategy {
    @Override
    public boolean authenticate(String username, String password) {
        // Simulated Google login check
        return username.endsWith("@gmail.com") && password.equals("google123");
    }
}
