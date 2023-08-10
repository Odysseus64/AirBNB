package plasma.airbnb.model;

import lombok.*;
import org.springframework.http.ResponseEntity;
import plasma.airbnb.enums.DecisionStatus;
import plasma.airbnb.enums.Role;

import javax.persistence.*;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long applicationId;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @ToString.Exclude
    private User user;
    @Enumerated(EnumType.STRING)
    private DecisionStatus decisionStatus;
    private boolean accepted;
    private String message;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    @ToString.Exclude
    private Product product;


}