package in.farmersmarket.auth.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_roles")
@IdClass(UserRoleId.class)
public class UserRoleEntity {

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity user;

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private RoleEntity role;

    @Column(name = "assigned_at")
    private LocalDateTime assignedAt;

    @PrePersist
    protected void onCreate() { this.assignedAt = LocalDateTime.now(); }

    public UserEntity getUser() { return user; }
    public void setUser(UserEntity user) { this.user = user; }
    public RoleEntity getRole() { return role; }
    public void setRole(RoleEntity role) { this.role = role; }
    public LocalDateTime getAssignedAt() { return assignedAt; }
    public void setAssignedAt(LocalDateTime assignedAt) { this.assignedAt = assignedAt; }
}
