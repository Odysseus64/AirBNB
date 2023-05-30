package plasma.swagger.exam.dto.auth;


import com.example.exam.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthResponse {

    private String email;
    private Role role;
    private String jwt;
}