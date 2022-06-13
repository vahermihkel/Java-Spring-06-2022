package ee.mihkel.webshop.controller;

import ee.mihkel.webshop.model.Person;
import ee.mihkel.webshop.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    PersonRepository personRepository;

    @PostMapping("signup")  // localhost:8080/signup    --> singup
    public String signup(@RequestBody Person person) {
        personRepository.save(person);
        return "Registreerimine edukas!";
    }
}
