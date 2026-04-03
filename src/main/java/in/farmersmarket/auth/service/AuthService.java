package in.farmersmarket.auth.service;

import in.farmersmarket.auth.dto.request.LoginRequest;
import in.farmersmarket.auth.dto.request.RegisterRequest;
import in.farmersmarket.auth.dto.response.AuthResponse;
import in.farmersmarket.auth.entity.RoleEntity;
import in.farmersmarket.auth.entity.UserEntity;
import in.farmersmarket.auth.entity.UserRoleEntity;
import in.farmersmarket.auth.mapper.UserMapper;
import in.farmersmarket.auth.repository.RoleRepository;
import in.farmersmarket.auth.repository.UserRepository;
import in.farmersmarket.auth.security.JwtProvider;
import in.farmersmarket.auth.security.PasswordHasher;
import in.farmersmarket.common.exception.*;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.stream.Collectors;

@ApplicationScoped
public class AuthService {

    @Inject UserRepository userRepository;
    @Inject RoleRepository roleRepository;
    @Inject PasswordHasher passwordHasher;
    @Inject JwtProvider jwtProvider;
    @Inject UserMapper userMapper;

    @Transactional
    public AuthResponse register(RegisterRequest request) {
        if (request.getEmail() != null && userRepository.existsByEmail(request.getEmail())) {
            throw new EmailAlreadyExistsException("Email already registered");
        }
        if (request.getPhone() != null && userRepository.existsByPhone(request.getPhone())) {
            throw new PhoneAlreadyExistsException("Phone number already registered");
        }

        UserEntity user = new UserEntity();
        user.setEmail(request.getEmail());
        user.setPhone(request.getPhone());
        user.setCountry(request.getCountry());
        user.setPasswordHash(passwordHasher.hash(request.getPassword()));
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setBusinessName(request.getBusinessName());
        userRepository.persist(user);

        String roleName = request.getRole() != null ? request.getRole().toUpperCase() : "BUYER";
        RoleEntity role = roleRepository.findByName(roleName)
                .orElseThrow(() -> new InvalidRequestException("Invalid role: " + roleName));

        UserRoleEntity userRole = new UserRoleEntity();
        userRole.setUser(user);
        userRole.setRole(role);
        user.getUserRoles().add(userRole);
        userRepository.persist(user);

        String token = jwtProvider.generateToken(user);

        AuthResponse response = new AuthResponse();
        response.setToken(token);
        response.setEmail(user.getEmail());
        response.setPhone(user.getPhone());
        response.setFirstName(user.getFirstName());
        response.setLastName(user.getLastName());
        response.setRoles(user.getUserRoles().stream()
                .map(ur -> ur.getRole().getName())
                .collect(Collectors.toList()));
        return response;
    }

    public AuthResponse login(LoginRequest request) {
        UserEntity user;
        if (request.getEmail() != null) {
            user = userRepository.findByEmail(request.getEmail())
                    .orElseThrow(() -> new UserNotFoundException("User not found"));
        } else if (request.getPhone() != null) {
            user = userRepository.findByPhone(request.getPhone())
                    .orElseThrow(() -> new UserNotFoundException("User not found"));
        } else {
            throw new InvalidRequestException("Email or phone is required");
        }

        if (!passwordHasher.verify(request.getPassword(), user.getPasswordHash())) {
            throw new InvalidPasswordException("Invalid password");
        }

        String token = jwtProvider.generateToken(user);

        AuthResponse response = new AuthResponse();
        response.setToken(token);
        response.setEmail(user.getEmail());
        response.setPhone(user.getPhone());
        response.setFirstName(user.getFirstName());
        response.setLastName(user.getLastName());
        response.setRoles(user.getUserRoles().stream()
                .map(ur -> ur.getRole().getName())
                .collect(Collectors.toList()));
        return response;
    }
}
