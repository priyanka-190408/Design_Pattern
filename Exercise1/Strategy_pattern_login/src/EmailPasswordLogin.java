public class EmailPasswordLogin implements AuthenticationStrategy {
    @Override
    public boolean authenticate(String username, String password) {
        // Generic email & password check
        return username.contains("@") && password.length() >= 6;
    }
}
