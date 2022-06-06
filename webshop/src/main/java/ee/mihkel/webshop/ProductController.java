package ee.mihkel.webshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
