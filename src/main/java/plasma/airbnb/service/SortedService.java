package plasma.airbnb.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import plasma.airbnb.enums.Region;
import plasma.airbnb.enums.Type;
import plasma.airbnb.model.Product;
import plasma.airbnb.reposiroty.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SortedService {
    public final ProductRepository repository;

    // SORT BY NAME
    public List<Product> sortByName(String title) {
        if (title != null) {
            repository.findByTitle(title);
        }
        return repository.findAll();
    }

    // SORT BY PRICE
    public List<Product> sortByPrice(int price) {
        if (price != 0) {
            repository.ratingPrice();
        }
        return repository.findAll();
    }

    // SORT BY REGION (BISHKEK, OSH, CHYI, TALAS, YSSYK-KYL, BATKEN, NARYN)
    public List<Product> sortByRegion(Region region){
        if (region != null){
            repository.findByRegion(region);
        }
        return repository.findAll();
    }

    // SORT BY TYPE (APARTMENT & HOUSE)
    public List<Product> sortByType(Type type){
        if (type != null) {
            return repository.findByType(type);
        }
        return repository.findAll();
    }
}

