package plasma.airbnb.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import plasma.airbnb.enums.Region;
import plasma.airbnb.enums.Type;
import plasma.airbnb.model.Product;
import plasma.airbnb.reposiroty.ProductRepository;

import java.util.Collections;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class SortedService {
    private final ProductRepository repository;

    public List<Product> sortByName(String title) {
        if (title != null){
            log.info("Sort by name: {}", title);
            return repository.findByTitle(title);
        }
        return repository.findAll();
    }

    public List<Product> sortByPrice(int price) {
        if (price != 0) {
            log.info("Sort by price: {}", price);
            return repository.ratingPrice();
        }
        return repository.findAll();
    }

    public List<Product> sortByRegion(Region region) {
        if (region != null){
            log.info("Sort by region: {}", region);
            return repository.findByRegion(region);
        }
        return repository.findAll();
    }

    public List<Product> sortByType(Type type) {
        if (type != null){
            log.info("Sort by type: {}", type);
            return repository.sortByType(type);
        }
        return repository.findAll();
    }

    public List<Product> search(String title, String city, Region region){
        if(title == null && city == null && region == null) {
            return Collections.emptyList();
        }
        log.info("Searching with title: {}, city: {}, region: {}", title, city, region);
        return repository.search(title, city, region);
    }

    public List<Product> findByRegion(Region region){
        if (region != null) {
            log.info("Get region: {}", region);
            return repository.findByRegion(region);
        }
        return repository.findAll();
    }

    public List<Product> findByType(Type type){
        if (type != null){
            log.info("Get type: {}", type);
            return repository.sortByType(type);
        }
        return repository.findAll();
    }
}