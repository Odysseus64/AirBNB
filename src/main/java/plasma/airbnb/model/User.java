package plasma.airbnb.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import plasma.airbnb.enums.Role;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = " _user")
@Data
@NoArgsConstructor
public class User {
    @Id
    @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "user_sequence")
    private Long id;
    private String name;
    private String email;
    private String password;
    private String address;
    private String description;
    private String phoneNumber;
    private boolean active;
    @Enumerated(EnumType.STRING)
    private Role role;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "image_id")
    private Image image;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Product> product;
    private LocalDateTime dateOfCreate;

    public User(String name) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    @PrePersist
    private void init() {
        dateOfCreate = LocalDateTime.now();
    }
}