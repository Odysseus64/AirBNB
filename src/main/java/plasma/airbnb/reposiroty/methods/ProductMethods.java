package plasma.airbnb.reposiroty.methods;

import plasma.airbnb.model.Product;

import java.util.List;

public interface ProductMethods
{
    void deleteById(Long id);
    void update(Long id, Product product);
    Product findById(Long id);
    Product save(Product product);
    List<Product> findAll();
}
