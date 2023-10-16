import plugins.Jwt;

public class Main {
    public static void main(String[] args) {
        Jwt jwt = new Jwt();
        String token = jwt.generateToken();
        jwt.verifyToken(token);
    }
}
