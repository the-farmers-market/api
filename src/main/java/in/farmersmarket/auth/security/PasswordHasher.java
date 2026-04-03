package in.farmersmarket.auth.security;

import jakarta.enterprise.context.ApplicationScoped;
import org.mindrot.jbcrypt.BCrypt;

@ApplicationScoped
public class PasswordHasher {

    public String hash(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt(12));
    }

    public boolean verify(String password, String hash) {
        return BCrypt.checkpw(password, hash);
    }
}
