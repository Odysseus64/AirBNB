package plasma.airbnb.controllers.main_page;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import plasma.airbnb.model.Product;
import plasma.airbnb.service.ProductService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v3")
public class Home {
    private final ProductService service;
    @GetMapping("/home/")
    public ResponseEntity<Product> houme(){
        service.findAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/home/getById/{id}")
    public ResponseEntity<Product> findById(@PathVariable("id") Long id) {
        Product product = service.findById(id);
        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
    @GetMapping("/batken")
    public ResponseEntity<Product> batken(Product product){


        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/osh")
    public ResponseEntity<Product> osh(Product product){


        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/jalalabad")
    public ResponseEntity<Product> jalalabad(Product product){


        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/bishkek")
    public ResponseEntity<Product> bishkek(Product product){


        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/naryn")
    public ResponseEntity<Product> naryn(Product product){


        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/yssyk-kol")
    public ResponseEntity<Product> yssykkol(Product product){


        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/talas")
    public ResponseEntity<Product> talas(Product product){


        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/chyi")
    public ResponseEntity<Product> chyi(Product product){


        return new ResponseEntity<>(HttpStatus.OK);
    }
}
