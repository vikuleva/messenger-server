package main.services;

import main.DAO.PersonDAO;
import main.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonDAO personDAO;

    public void add(Person person) {
        personDAO.save(person);
    }

//    public void update(Person person) { personDAO.update(person); }

    public Person get(String id) {
        return personDAO.get(id);
    }

    public List<Person> getAll() {
        return personDAO.getAll();
    }

    public void remove(String id) {
        personDAO.remove(id);
    }

    public Person getByPasswordByName(String password, String name){
       return  personDAO.getByPasswordByName(password, name);
    }

    public Person getByPassword(String password){
        return  personDAO.getByPassword(password);
    }
}
