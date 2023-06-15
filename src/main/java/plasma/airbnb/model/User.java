package plasma.airbnb.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import plasma.airbnb.enums.Role;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
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

    private LocalDateTime dateOfCreate;

    // It will be necessary to indicate in the diagram that I connected (User to FeedBack)
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
    private List<FeedBack> feedBacks = new ArrayList<>();

    public User(String name,
                String email,
                String password,
                Role role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public User(String email) {
        this.email = email;
    }

    @PrePersist
    private void init() {
        dateOfCreate = LocalDateTime.now();
    }
}