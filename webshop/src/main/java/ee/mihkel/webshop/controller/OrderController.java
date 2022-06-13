package ee.mihkel.webshop.controller;

import ee.mihkel.webshop.model.Order;
import ee.mihkel.webshop.model.Person;
import ee.mihkel.webshop.model.Product;
import ee.mihkel.webshop.repository.OrderRepository;
import ee.mihkel.webshop.repository.PersonRepository;
import ee.mihkel.webshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class OrderController {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    PersonRepository personRepository;

    @PostMapping("order/{personCode}") // localhost:8080/order/3131231
    public String addOrder(@PathVariable String personCode, @RequestBody List<Product> products) {

        Order order = new Order();
        order.setCreatedDate(new Date());

        List<Product> originalProducts = products.stream()
                .map(e -> productRepository.findById(e.getId()).get())
                .collect(Collectors.toList());

//        List<Product> originalProducts2 = new ArrayList<>();
//        for (Product p: products) {
//            Product databaseProduct = productRepository.findById(p.getId()).get();
//            originalProducts2.add(databaseProduct);
//        }

        order.setProducts(originalProducts);

        double orderSum = originalProducts.stream()
                .mapToDouble(Product::getPrice)
                .sum();

//        double orderSum2 = 0;
//        for (Product p: originalProducts)  {
//            orderSum2 += p.getPrice();
//        }

        order.setSum(orderSum);

        Person person = personRepository.findById(personCode).get();
        order.setPerson(person);

        orderRepository.save(order);


        return "Edukalt tellimus lisatud";
    }

    @GetMapping("order")
    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    @GetMapping("order/{id}")
    public Order getOrder(@PathVariable Long id) {
        System.out.println("võtsin orderi");
        return orderRepository.findById(id).get();
    }

    @GetMapping("person-order/{personCode}")
    public List<Order> getPersonOrders(@PathVariable String personCode) {
        System.out.println("võtsin orderi personcode kaudu");
        Person person = personRepository.findById(personCode).get();
        return orderRepository.getAllByPerson(person);
    }
}
