package plasma.airbnb.dto.response;

import lombok.Data;
import plasma.airbnb.enums.Region;
import plasma.airbnb.model.Image;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class ProductResponse {
    private String title;
    private List<Image> images = new ArrayList<>();
    private Region region;
    private int price;
    private int rating;
    private LocalDateTime date_now;
}