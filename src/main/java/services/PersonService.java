package services;

import DAO.PersonDAO;
import models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonDAO personDAO;

    public void add(Person person) {
        person.setId(Person.COLLECTION_NAME);
        personDAO.save(person);
    }

    public void update(Person person) {
        personDAO.save(person);
    }

    public Person get(String id) {
        return personDAO.get(id);
    }

    public List<Person> getAll() {
        return personDAO.getAll();
    }

    public void remove(String id) {
        personDAO.remove(id);
    }
}
