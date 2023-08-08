package plasma.airbnb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import plasma.airbnb.enums.Role;

import javax.persistence.*;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String accept;
    private String reject;
    private String email;
}