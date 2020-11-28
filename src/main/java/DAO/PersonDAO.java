package DAO;

import models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonDAO {
    @Autowired
    private MongoOperations mongoOperations;

    public void save(Person person) {
        mongoOperations.save(person);
    }

    public Person get(String id) {
        return mongoOperations.findOne(Query.query(Criteria.where("id").is(id)), Person.class);
    }

    public List<Person> getAll() {
        return mongoOperations.findAll(Person.class);
    }

    public void remove(String id) {
        mongoOperations.remove(Query.query(Criteria.where("id").is(id)), Person.class);
    }
}
