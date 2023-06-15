package plasma.reposiroty.methods;



import plasma.model.Product;

import java.util.List;

public interface ProductMethods
{
    void deleteById(Long id);
    Product findById(Long id);
    Product save(Product product);
    List<Product> findAll();
}
