package plasma;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import plasma.airbnb.reposiroty.ProductRepository;

@SpringBootApplication
@RequiredArgsConstructor
public class AirbnbApplication {
    private final ProductRepository productRepository;

    public static void main(String[] args) {
        SpringApplication.run(AirbnbApplication.class, args);
    }
}