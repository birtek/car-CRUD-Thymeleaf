package pl.szydlowski.restspringbootsimplecrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Controller
public class RemoteController {

    public RemoteController() {

        RestTemplate restTemplate = new RestTemplate();

        String forObject = restTemplate.getForObject("https://cat-fact.herokuapp.com/facts/random?animal_type=cat&amount=2", String.class);
        System.out.println(forObject);
    }
}
