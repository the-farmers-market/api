package in.farmersmarket.auth.mapper;

import in.farmersmarket.auth.dto.response.UserDto;
import in.farmersmarket.auth.entity.UserEntity;
import in.farmersmarket.auth.entity.UserRoleEntity;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.stream.Collectors;

@ApplicationScoped
public class UserMapper {

    public UserDto toDto(UserEntity entity) {
        UserDto dto = new UserDto();
        dto.setId(entity.getId());
        dto.setEmail(entity.getEmail());
        dto.setPhone(entity.getPhone());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setBusinessName(entity.getBusinessName());
        dto.setCity(entity.getCity());
        dto.setState(entity.getState());
        dto.setActive(entity.isActive());
        dto.setVerified(entity.isVerified());
        dto.setRoles(entity.getUserRoles().stream()
                .map(UserRoleEntity::getRole)
                .map(r -> r.getName())
                .collect(Collectors.toList()));
        return dto;
    }
}
