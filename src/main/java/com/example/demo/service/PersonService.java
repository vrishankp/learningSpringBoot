package com.example.demo.service;
import com.example.demo.model.Person;
import com.example.demo.dao.PersonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.List;
@Service // Could also use @Component
public class PersonService {
    private final PersonDAO PersonDAO; // Used for Dependency Injection

    @Autowired // Used for Dependency Injection. Could have multiple immplementations of PersonDAO,
                // so we need to specify which one to use.
    public PersonService(@Qualifier("fakeDAO") PersonDAO personDAO) {
        this.PersonDAO = personDAO;
    }

    public int addPerson(Person person){
        return PersonDAO.insertPerson(person);
    }

    public List<Person> returnAllPeople(){
        return PersonDAO.selectAllPeople();
    }
}
