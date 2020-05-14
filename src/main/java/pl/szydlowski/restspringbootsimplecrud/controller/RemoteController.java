package pl.szydlowski.restspringbootsimplecrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;
import pl.szydlowski.restspringbootsimplecrud.model.CatFact;

@Controller
public class RemoteController {

    public RemoteController() {

        RestTemplate restTemplate = new RestTemplate();

       CatFact[] forObject = restTemplate.getForObject("https://cat-fact.herokuapp.com/facts/random?animal_type=cat&amount=2",
               CatFact[].class);

        for (CatFact catFact : forObject) {
            System.out.println(catFact.getText());
        }
    }
}
