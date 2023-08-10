package plasma.airbnb.dto.request;

import lombok.Data;
import plasma.airbnb.enums.Region;
import plasma.airbnb.enums.Type;

@Data
public class ProductRequest {
    private String title;
    private String description;
    private Type type;
    private Region region;
}
