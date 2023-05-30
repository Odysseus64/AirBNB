package plasma.airbnb.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import plasma.airbnb.service.ProductService;

@Controller
@RequiredArgsConstructor
public class ProductController {
    public final ProductService service;
}
