package plasma.airbnb.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import plasma.airbnb.service.ProductService;

@Controller
@RequiredArgsConstructor
public class ProductController {
    public final ProductService service;
    @GetMapping("/product/save")
    public String save(){

        return "/product/save";
    }
}
