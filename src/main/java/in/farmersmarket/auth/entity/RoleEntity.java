package in.farmersmarket.auth.entity;

import in.farmersmarket.common.model.BaseEntity;
import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "roles")
public class RoleEntity extends BaseEntity {

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
    private Set<RolePermissionEntity> rolePermissions = new HashSet<>();

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Set<RolePermissionEntity> getRolePermissions() { return rolePermissions; }
    public void setRolePermissions(Set<RolePermissionEntity> rolePermissions) { this.rolePermissions = rolePermissions; }
}
