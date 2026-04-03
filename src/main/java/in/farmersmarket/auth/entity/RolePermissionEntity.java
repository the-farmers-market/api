package in.farmersmarket.auth.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "role_permissions")
@IdClass(RolePermissionId.class)
public class RolePermissionEntity {

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private RoleEntity role;

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "permission_id", referencedColumnName = "id")
    private PermissionEntity permission;

    public RoleEntity getRole() { return role; }
    public void setRole(RoleEntity role) { this.role = role; }
    public PermissionEntity getPermission() { return permission; }
    public void setPermission(PermissionEntity permission) { this.permission = permission; }
}
