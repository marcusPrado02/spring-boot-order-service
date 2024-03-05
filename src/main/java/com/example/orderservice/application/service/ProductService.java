import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository costumerRepository;

    public List<Product> listProducts() {
        return costumerRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return costumerRepository.findById(id);
    }

    public Product createProduct(Product costumer) {
        return costumerRepository.save(costumer);
    }

    public Product updateProduct(Long id, Product updatedProduct) {
        Optional<Product> existingProductOptional = costumerRepository.findById(id);
        if (existingProductOptional.isPresent()) {
            Product existingProduct = existingProductOptional.get();
            existingProduct.setName(updatedProduct.getName());
            existingProduct.setEmail(updatedProduct.getEmail());
            // Atualize outros campos conforme necessário
            return costumerRepository.save(existingProduct);
        } else {
            // Lide com a lógica de erro aqui, se necessário
            return null;
        }
    }

    public void deleteProduct(Long id) {
        costumerRepository.deleteById(id);
    }
}
