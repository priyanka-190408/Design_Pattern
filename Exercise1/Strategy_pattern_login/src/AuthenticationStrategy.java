public interface AuthenticationStrategy {
    boolean authenticate(String username, String password);
}
