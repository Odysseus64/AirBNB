package plasma;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RequiredArgsConstructor
@RestController
public class AirbnbApplication {
	public static void main(String[] args) {
		SpringApplication.run(AirbnbApplication.class, args);
	}
	public void init(){

	}
}