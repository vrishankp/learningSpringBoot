package com.example.demo.api;
import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/v1/person") // This is the root URL
@RestController // This is a REST API (Can be accessed by clients)
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping // This method will be called when a POST request is made to the root URL
    public void addPerson(@RequestBody Person person){
        // @RequestBody tells Spring that the request body will contain a JSON object that needs to be
        personService.addPerson(person);
    }

    @GetMapping // This method will be called when a GET request is made to the root URL
    public List<Person> returnAllPeople(){
        return personService.returnAllPeople();
    }

}
