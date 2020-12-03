package main.controllers;
//import org.springframework.beans.factory.annotation.Autowired;
import main.services.PersonService;
import main.models.Person;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping(value = "/persons")
    public ResponseEntity<?> read(){
        final List<Person> persons = personService.getAll();
        return persons!=null && !persons.isEmpty()?new ResponseEntity<Object>(persons, HttpStatus.OK):new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/createperson")
    public ResponseEntity<?> add(@RequestBody Person person){

        personService.add(person);
        return new ResponseEntity<Object>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/person/{id}")
    public ResponseEntity<?> getById(@PathVariable(name="id")String id){
        final Person person = personService.get(id);
        return person!=null ? new ResponseEntity<Object>(person, HttpStatus.OK):new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/person/{id}")
    public ResponseEntity<?> remove(@PathVariable(name="id") String id){
        final boolean deleted = true;
        personService.remove(id);
        return deleted ? new ResponseEntity<Object>(HttpStatus.OK): new ResponseEntity<Object>(HttpStatus.NOT_MODIFIED);
    }

//    @PutMapping(value="/person/{id}")
//    public ResponseEntity<?> update(@RequestBody Person person){
//        final boolean updated = true;
//        personService.update(person);
//        return updated ? new ResponseEntity<Object>(HttpStatus.OK):new ResponseEntity<Object>(HttpStatus.NOT_MODIFIED);
//    }
}
