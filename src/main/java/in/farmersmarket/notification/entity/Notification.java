package in.farmersmarket.notification.entity;

import in.farmersmarket.auth.entity.UserEntity;
import in.farmersmarket.common.model.BaseEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "notifications")
public class Notification extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "message", columnDefinition = "TEXT")
    private String message;

    @Column(name = "is_read", nullable = false)
    private boolean isRead = false;

    @Column(name = "data_json", columnDefinition = "TEXT")
    private String dataJson;

    public UserEntity getUser() { return user; }
    public void setUser(UserEntity user) { this.user = user; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
    public boolean isRead() { return isRead; }
    public void setRead(boolean read) { isRead = read; }
    public String getDataJson() { return dataJson; }
    public void setDataJson(String dataJson) { this.dataJson = dataJson; }
}
