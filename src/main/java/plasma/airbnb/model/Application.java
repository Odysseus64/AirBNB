package plasma.airbnb.model;

import lombok.*;
import plasma.airbnb.enums.DecisionStatus;
import javax.persistence.*;

/**
 * Created by mouflon on 05.07.2023.
 */
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long applicationId;

    // An administrator who accepts or rejects a user's application
    @ManyToOne
    @JoinColumn(name = "admin_id")
    @ToString.Exclude
    private User admin;
    @Enumerated(EnumType.STRING)
    private DecisionStatus decisionStatus;
    private boolean accepted;
    private String message;
    // The user who sent the application for acceptance of the house/apartment
    private Long userId;
}