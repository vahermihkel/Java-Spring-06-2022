package ee.mihkel.webshop.controller;

import ee.mihkel.webshop.model.request.ParcelMachine;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class ParcelMachineController {

    @GetMapping("parcel-machines")
    public List<ParcelMachine> getParcelMachines() throws Exception {

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<ParcelMachine[]> response = restTemplate.exchange("https://www.omniva.ee/locations.json", HttpMethod.GET, null, ParcelMachine[].class);

        if (response.getBody() != null) {
            ParcelMachine[] parcelMachines = response.getBody();
            return Arrays.asList(parcelMachines);
        } else {
            throw new Exception();
        }
    }
}
