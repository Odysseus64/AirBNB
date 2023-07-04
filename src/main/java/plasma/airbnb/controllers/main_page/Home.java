package plasma.airbnb.controllers.main_page;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import plasma.airbnb.enums.Region;
import plasma.airbnb.model.Product;
import plasma.airbnb.service.ProductService;
import plasma.airbnb.service.SortedService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RestController("/v3/api-docs")
public class Home {
    private final ProductService service;
    private final SortedService sortedService;

    @GetMapping("/home/")
    public ResponseEntity<List<Product>> houme() {
        List<Product> products = service.findAll();
        return ResponseEntity.ok().body(products);
    }

    @GetMapping("/home/getById/{id}")
    public ResponseEntity<Product> findById(@PathVariable("id") Long id) {
        Product product = service.findById(id);
        if (product == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
            return ResponseEntity.ok().body(product);
    }

    @GetMapping("/batken")
    public ResponseEntity<String> batken() {
        sortedService.findByRegion(Region.BATKEN);
        return ResponseEntity.ok().body("okey  working");
    }

    @GetMapping("/osh")
    public ResponseEntity<String> osh() {
        sortedService.findByRegion(Region.OSH);
        return ResponseEntity.ok().body("Wery ok");
    }

    @GetMapping("/jalal-abad")
    public ResponseEntity<String> jalalabad() {
        sortedService.findByRegion(Region.JALALABAD);
        return ResponseEntity.ok().body("Workung");
    }

    @GetMapping("/bishkek")
    public ResponseEntity<String> bishkek() {
        sortedService.findByRegion(Region.BISHKEK);
        return ResponseEntity.ok().body("Working!");
    }

    @GetMapping("/naryn")
    public ResponseEntity<String> naryn() {
        sortedService.findByRegion(Region.NARYN);
        return ResponseEntity.ok().body("Working!");
    }

    @GetMapping("/issyk-kol")
    public ResponseEntity<String> yssykkol() {
        sortedService.findByRegion(Region.ISSYKKUL);
        return ResponseEntity.ok().body("Working!");
    }

    @GetMapping("/talas")
    public ResponseEntity<String> talas() {
        sortedService.findByRegion(Region.TALAS);
        return ResponseEntity.ok().body("Working!");
    }

    @GetMapping("/chyi")
    public ResponseEntity<String> chyi() {
        sortedService.findByRegion(Region.CHUI);
        return ResponseEntity.ok().body("Working!");
    }
    @GetMapping("/search")
    public ResponseEntity<String> search(@RequestParam("title")String title,
                                         @RequestParam("city") String city, @RequestParam("region") Region region){
        sortedService.search(title, city, region);
        return ResponseEntity.ok().body("Working!");
    }
}
