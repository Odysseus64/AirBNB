package plasma.airbnb.controllers.main_page;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    @GetMapping("/home/getById{id}")
    public ResponseEntity<Product> findById(@PathVariable("id") Long id){
        service.findById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/home/sortByName")
    public ResponseEntity<Product> sortByName(String name, Product product){
        // find by title Bektur sir Это ваша работа
        return new ResponseEntity<>(HttpStatus.OK);
    }
    // Не удалось затестить проект, отсуствует сваггер
    // в ветке kokodae есть конфлект нужно исправить как моэно быстрее
}
