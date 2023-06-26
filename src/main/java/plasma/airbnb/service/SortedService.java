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

    public List<Product> sortByName(String title) {
        if (title != null) repository.findByTitle(title);
        return repository.findAll();
    }

    public List<Product> sortByPrice(int price) {
        if (price != 0) repository.ratingPrice();
        return repository.findAll();
    }

    public List<Product> sortByRatingRegion(Region region) {
        if (region != null) repository.ratingRegion();
        return repository.findAll();
    }

    public List<Product> sortByRegion(Region region1) {
        if (region1 != null) repository.findByRegion(region1);
        return repository.findAll();
    }

    public List<Product> sortByRatingRegion(Type type) {
        if (type == null) repository.ratingType();
        return repository.findAll();
    }
    public List<Product> sortByRatingType(Type type1) {
        if (type1 != null) repository.ratingType();
        return repository.findAll();
    }

    public List<Product> sortByType(Type type){
        if (type != null) return repository.findByType(type);
        return repository.findAll();
    }
    public List<Product> search(String title, String city, Region region){
        if (title != null || city != null || region != null) repository.search(title, city, region);
        return repository.findAll();
    }
    public List<Product> regions (Region region){
        if (region != null){
            repository.region(region);
        }
        return repository.findAll();
    }
}

