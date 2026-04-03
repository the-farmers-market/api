package in.farmersmarket.auth.security;

import in.farmersmarket.auth.entity.UserEntity;
import in.farmersmarket.auth.entity.UserRoleEntity;
import io.smallrye.jwt.build.Jwt;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.time.Duration;
import java.util.Set;
import java.util.stream.Collectors;

@ApplicationScoped
public class JwtProvider {

    @ConfigProperty(name = "mp.jwt.verify.issuer")
    String issuer;

    public String generateToken(UserEntity user) {
        Set<String> roles = user.getUserRoles().stream()
                .map(UserRoleEntity::getRole)
                .map(role -> role.getName())
                .collect(Collectors.toSet());

        return Jwt.issuer(issuer)
                .subject(user.getId().toString())
                .upn(user.getEmail() != null ? user.getEmail() : user.getPhone())
                .groups(roles)
                .claim("email", user.getEmail() != null ? user.getEmail() : "")
                .claim("phone", user.getPhone() != null ? user.getPhone() : "")
                .claim("firstName", user.getFirstName() != null ? user.getFirstName() : "")
                .claim("lastName", user.getLastName() != null ? user.getLastName() : "")
                .expiresIn(Duration.ofHours(24))
                .sign();
    }
}
