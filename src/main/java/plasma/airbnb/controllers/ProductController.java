package plasma.airbnb.controllers;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import plasma.airbnb.dto.response.ProductResponse;
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
    public final SortedService sorted_service;
    private final ProductService productService;

    @GetMapping("/get-all")
    public String getAll() {
        productService.findAll();
        return "successfully getting";
    }

    @GetMapping("/get-by-id/{id}")
    public String getById(@PathVariable("id") Long id) {
        productService.findById(id);
        return "successfully founded";
    }

    @PostMapping("/save")
    public String save(@RequestBody Product product) {
        productService.save(product);
        return "successfully saved";
    }

    @PutMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, @RequestBody Product product) {
        productService.update(id, product);
        return "successfully edited";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        productService.deleteById(id);
        return "successfully deleted";
    }

    @GetMapping("/sort/name")
    public ResponseEntity<List<Product>> sortByName(String name) {
        List<Product> sortedList = sorted_service.sortByName(name);
        return ResponseEntity.ok().body(sortedList);
    }

    @GetMapping("/sort/price")
    public ResponseEntity<List<Product>> sortByPrice(int price) {
        List<Product> sortedList = sorted_service.sortByPrice(price);
        return ResponseEntity.ok().body(sortedList);
    }

    @GetMapping("/sort/region")
    public ResponseEntity<List<Product>> sortByRegion(Region region) {
        List<Product> sortedList = sorted_service.regions(region);
        return ResponseEntity.ok().body(sortedList);
    }

    @GetMapping("/sort/type")
    public ResponseEntity<List<Product>> sortByType(Type type) {
        List<Product> sortedList = sorted_service.types(type);
        return ResponseEntity.ok().body(sortedList);
    }

    @GetMapping("/sort/rating/3")
    public List<ProductResponse> sortedThree() {
        return sorted_service.ratingThree();
    }

    @GetMapping("/sort/rating/all")
    public List<ProductResponse> sortedALl() {
        return sorted_service.ratingSort();
    }

    @GetMapping("/sort/rating/date/last")
    public List<ProductResponse> sortedDate() {
        return sorted_service.sortForDate();
    }

    @GetMapping("/sorted-by-rating-apartments")
    public List<ProductResponse> sortedByRatingApartments() {
        return sorted_service.ratingSortApartments();
    }

}