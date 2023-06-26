package plasma.airbnb.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import plasma.airbnb.enums.Region;
import plasma.airbnb.enums.Type;
import plasma.airbnb.model.Product;
import plasma.airbnb.reposiroty.ProductRepository;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SortedService {
    public final ProductRepository repository;

    public List<Product> sortByName(String title) {
        try {
            if (title != null){
                log.info("Sort by name: {}", title);
                repository.findByTitle(title);
            }
        }catch (Exception e) {
            log.error("Error: {}", e.getMessage());
            throw new RuntimeException(e);
        }
        return repository.findAll();
    }

    public List<Product> sortByPrice(int price) {
        try {
            if (price != 0) {
                log.info("Sort by price: {}", price);
                repository.ratingPrice();
            }
        }catch (Exception e){
            log.error("Error: {}", e.getMessage());
            throw new RuntimeException(e);
        }
        return repository.findAll();
    }

    public List<Product> sortByRatingType(Region region) {
        try {
            if (region != null){
                log.info("Info: {}", region);
                repository.findByRegion(region);
            }
        }catch (Exception e){
            log.error("Error: {}", e.getMessage());
            throw new RuntimeException(e);
        }
        return repository.findAll();
    }

    public List<Product> sortByRatingType(Type type) {
        try {
            if (type == null) {
                log.info("Info: {}", type);
                repository.ratingType();
            }
        }catch (Exception e){
            log.error("Error: {}", e.getMessage());
            throw new RuntimeException(e);
        }
        return repository.findAll();
    }
    public List<Product> search(String title, String city, Region region){
        try{
            if (title != null || city != null || region != null) {
                log.info("Searching with: {}", title);
                log.info("Searching with: {}", city);
                log.info("Searching with: {}", region);
                repository.search(title, city, region);
            }
        }catch (Exception e){
            log.error("Error: ", e.getMessage());
            throw new RuntimeException(e);
        }
        return repository.findAll();
    }
    public List<Product> regions (Region region){
        try{
            if (region != null) {
                log.info("Get region: {}", region);
                repository.region(region);
            }
        }catch (Exception e){
            log.error("Error: ", e.getMessage());
            throw new RuntimeException(e);
        }
        return repository.findAll();
    }
}

