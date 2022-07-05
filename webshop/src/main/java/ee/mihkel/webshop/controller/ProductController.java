package ee.mihkel.webshop.controller;

import ee.mihkel.webshop.cache.ProductCache;
import ee.mihkel.webshop.exceptions.ProductNotFoundException;
import ee.mihkel.webshop.repository.ProductRepository;
import ee.mihkel.webshop.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.ExecutionException;

@CrossOrigin("http://localhost:3000")
@RestController
public class ProductController {
//    List<Product> products = new ArrayList<>();

    @Autowired
    ProductCache productCache;

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

    @PutMapping("products")  // localhost:8080/products/0   PUT
    public void editProduct(@RequestBody Product product) {
        if (productRepository.findById(product.getId()).isPresent()) {
            // võtab kõik ja asendab ära
            // {id: 1, name: "Coca cola", price: 5}
            // {id: 1, name: "Coca cola", price: 6}


            // {id: 1, name: "Fanta", price: 2}
            productRepository.save(product);
        }
    }

    @GetMapping("products/{id}")  // localhost:8080/products/1    GET
    public Product getProduct(@PathVariable Long id) throws ProductNotFoundException {
        //Optional<Product>   ---> tagasta kas Product või null (tühjus)  KUI EI LEIA, SIIS ON OK
        try {
            return productCache.getProduct(id);
        } catch (Exception e) {
            throw new ProductNotFoundException();
        }
        //productRepository.findById(id).get() ---> tagasta Product või Error  KUI EI LEIA, ON ERROR
    }
}

// Spring Security -- JWT  Json Web Token abil sisselogimine
// kõik API otspunktid blokeeritakse kui ei ole meile sobivat tokeni antud
// 2 koolituspäeva, R ja P

// Frontend -- React, 3-4 koolituspäeva

// JUnit - on võimalik automaattestid käima panna, mis vaatavad rakendust üle
// Serverisse üles - Heroku

// Sisselogimisel erinevad rollid ja õigused
// Administraatori õigused ja tavakasutaja õigused

// Validaatorid - et peab olema mingid väljad täidetud
// Unikaalsus - kui tuleb uus kasutaja, siis peab olema e-mail unikaalne

// Proovitöid, mis on kogunenud - Vaata, milliseid tahad koos teha

// Smart ID backendis - ???
// E-mailide saatmist - ??
// SMS-de saatmist - ??
