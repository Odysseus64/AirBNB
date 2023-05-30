package plasma.airbnb.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import plasma.airbnb.model.Product;
import plasma.airbnb.service.ProductService;

@Controller
@RequiredArgsConstructor
public class ProductController {
    public final ProductService service;
    @GetMapping("/product/save")
    public String save(Model model){
        model.addAttribute("save", service.save(new Product()));
        return "/product/save";
    }
}
