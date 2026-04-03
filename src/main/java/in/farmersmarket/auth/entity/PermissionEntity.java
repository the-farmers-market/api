package in.farmersmarket.auth.entity;

import in.farmersmarket.common.model.BaseEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "permissions")
public class PermissionEntity extends BaseEntity {

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
