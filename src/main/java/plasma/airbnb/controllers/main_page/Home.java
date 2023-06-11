package plasma.airbnb.controllers.main_page;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import plasma.airbnb.service.ProductService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v3")
public class Home {
    private final ProductService service;
    @GetMapping("/home/")
    public String houme(){
        service.findAll();
        return "Get All product";
    }
    @GetMapping("/hoem/getById{id}")
    public String findById(@RequestParam("id") Long id){
        service.findById(id);
        return "Id found " + id;
    }

//    @PostMapping("/home/save")
//    public String save(@ModelAttribute("product") Product product){
//        service.save(product);
//        return "Saved!";
//    }

//    @DeleteMapping("/home/delete/{id}")
//    public String deleteById(@RequestParam("id") Long id){
//        service.deleteById(id);
//        return "Product deleted";
//    }
}
