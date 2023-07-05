package plasma.airbnb.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import plasma.airbnb.model.Product;
import plasma.airbnb.reposiroty.ProductRepository;
import plasma.airbnb.reposiroty.methods.ProductMethods;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService implements ProductMethods {

    private final ProductRepository repository;

    @Override
    public void deleteById(Long id) {
        log.info("Deleting product with id: {}", id);
        repository.deleteById(id);
    }
    @Transactional
    @Override
    public void update(Long id, Product product) {
         try{
            Product pro = repository.findById(id).orElseThrow();
            pro.setTitle(product.getTitle());
            pro.setDescription(product.getDescription());
            pro.setPrice(product.getPrice());
            pro.setMaxGuests(product.getMaxGuests());
            pro.setTownProvince(product.getTownProvince());
            pro.setRegion(product.getRegion());
            pro.setType(product.getType());
            pro.setImages(product.getImages());
            pro.setFeedBacks(product.getFeedBacks());
            repository.save(pro);
            log.info("Product updated: {}", pro);
            log.info("Product finding with id: {}", id);
        }catch (Exception exception){
             log.error("Log: Error while updating product: {}", exception.getMessage());
            throw new RuntimeException("Product not found with id: " + id);
        }
    }

    @Override
    public Product findById(Long id) {
        log.info("Finding product with id: {}", id);
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }

    @Override
    public Product save(Product product) {
        try {
            log.info("Saving product: {}", product);
            return repository.save(product);
        } catch (Exception exception) {
            log.error("Error while saving product: {}", exception.getMessage());
            throw new RuntimeException("Failed to save product", exception);
        }
    }

    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }
}
