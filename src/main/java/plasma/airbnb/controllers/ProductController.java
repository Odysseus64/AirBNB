package plasma.airbnb.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import plasma.airbnb.enums.Region;
import plasma.airbnb.enums.Type;
import plasma.airbnb.model.Product;
import plasma.airbnb.service.ProductService;
import plasma.airbnb.service.SortedService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RestController("/api/product/")
public class ProductController {
    private final SortedService sortedService;
    private final ProductService productService;
    @GetMapping("/get-all")
    public String getAll(){
        productService.findAll();
        return "successfully getting";
    }
    @GetMapping("/get-by-id/{id}")
    public String getById(@PathVariable("id") Long id){
        productService.findById(id);
        return "successfully founded";
    }
    @PostMapping("/save")
    public String save(@RequestBody Product product){
        productService.save(product);
        return "successfully saved";
    }
    @PutMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, @RequestBody Product product){
        productService.update(id, product);
        return "successfully edited";
    }
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        productService.deleteById(id);
        return "successfully deleted";
    }

    @GetMapping("/sort/name")
    public ResponseEntity<List<Product>> sortByName(String name) {
        List<Product> sortedList = sortedService.sortByName(name);
        return ResponseEntity.ok().body(sortedList);
    }

    @GetMapping("/sort/price")
    public ResponseEntity<List<Product>> sortByPrice(int price) {
        List<Product> sortedList = sortedService.sortByPrice(price);
        return ResponseEntity.ok().body(sortedList);
    }

    @GetMapping("/sort/region")
    public ResponseEntity<List<Product>> sortByRegion(Region region) {
        List<Product> sortedList = sortedService.sortByRegion(region);
        return ResponseEntity.ok().body(sortedList);
    }

    @GetMapping("/sort/type")
    public ResponseEntity<List<Product>> sortByType(Type type) {
        List<Product> sortedList = sortedService.sortByType(type);
        return ResponseEntity.ok().body(sortedList);
    }
}
