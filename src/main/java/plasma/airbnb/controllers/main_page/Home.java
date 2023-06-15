package plasma.airbnb.controllers.main_page;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import plasma.airbnb.enums.Region;
import plasma.airbnb.model.Product;
import plasma.airbnb.service.ProductService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v3")
public class Home {
    private final ProductService service;
    @GetMapping("/home/")
    public ResponseEntity<List<Product>> houme(){
        List<Product> products = service.findAll();
        return ResponseEntity.ok().body(products);
    }
    @GetMapping("/home/getById/{id}")
    public ResponseEntity<Product> findById(@PathVariable("id") Long id) {
        Product product = service.findById(id);
        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.ok().body(product);
        }
    }

    // Есть идея сделать Регион в формате String для удобства и для упрошения разработки
    @GetMapping("/batken")
    public ResponseEntity<Product> batken(Product product){
        if(Region.BATKEN != product.getRegion()){
        }
        return ResponseEntity.ok().body(product);
    }
    // Дописать сорт по или упростить код одним методом
    @GetMapping("/osh")
    public ResponseEntity<Product> osh(Product product){
        return ResponseEntity.ok().body(product);
    }

    @GetMapping("/jalalabad")
    public ResponseEntity<Product> jalalabad(Product product){
        return ResponseEntity.ok().body(product);
    }

    @GetMapping("/bishkek")
    public ResponseEntity<Product> bishkek(Product product){
        return ResponseEntity.ok().body(product);
    }

    @GetMapping("/naryn")
    public ResponseEntity<Product> naryn(Product product){
        return ResponseEntity.ok().body(product);
    }

    @GetMapping("/yssyk-kol")
    public ResponseEntity<Product> yssykkol(Product product){
        return ResponseEntity.ok().body(product);
    }

    @GetMapping("/talas")
    public ResponseEntity<Product> talas(Product product){
        return ResponseEntity.ok().body(product);
    }

    @GetMapping("/chyi")
    public ResponseEntity<Product> chyi(Product product){
        return ResponseEntity.ok().body(product);
    }
}
