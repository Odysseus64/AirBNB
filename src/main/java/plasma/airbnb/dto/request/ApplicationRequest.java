package plasma.airbnb.dto.request;

import lombok.Data;
import plasma.airbnb.model.Product;
import plasma.airbnb.model.User;

@Data
public class ApplicationRequest {
     private User user;
     private Product product;

}
