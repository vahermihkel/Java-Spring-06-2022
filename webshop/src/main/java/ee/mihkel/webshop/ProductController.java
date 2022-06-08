package ee.mihkel.webshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
    List<Product> products = new ArrayList<>();

    @Autowired
    ProductRepository productRepository;

    @GetMapping("products")  // localhost:8080/products    GET
    public List<Product> getProducts() {
        //return products;
        return productRepository.findAll();
    }

    @PostMapping("products")  // localhost:8080/products    POST
    public void addProduct(@RequestBody Product product) {
        //products.add(product);
        productRepository.save(product);
    }

    @DeleteMapping("products/{id}")  // localhost:8080/products/0   DELETE
    public void deleteProduct(@PathVariable Long id) {
        productRepository.deleteById(id);
    }

    @PutMapping("products")  // localhost:8080/products/0   DELETE
    public void editProduct(@RequestBody Product product) {
        if (productRepository.findById(product.getId()).isPresent()) {
            // võtab kõik ja asendab ära
            // {id: 1, name: "Coca cola", price: 5}
            // {id: 1, name: "Coca cola", price: 6}


            // {id: 1, name: "Fanta", price: 2}
            productRepository.save(product);
        }
    }
}
