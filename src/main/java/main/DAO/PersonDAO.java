package main.DAO;

import com.mongodb.BasicDBObject;
import main.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonDAO {
    @Autowired
    private MongoOperations mongoOperations;

    public void save(Person person) {
        mongoOperations.save(person);
    }

//    public void update(Person person) {
//        Update update = new Update().pull("persons", new BasicDBObject("_id", person.getId()));
//        mongoOperations.updateFirst(Query.query(Criteria.where("id").is(person.getId())),update,Person.class);
//    }

    public Person get(String id) {
        return mongoOperations.findOne(Query.query(Criteria.where("id").is(id)), Person.class);
    }

    public List<Person> getAll() {
        return mongoOperations.findAll(Person.class);
    }

    public void remove(String id) {
        mongoOperations.remove(Query.query(Criteria.where("id").is(id)), Person.class);
    }

    public Person getByPasswordByName(String password, String name){return mongoOperations.findOne(Query.query(Criteria.where("password").is(password).andOperator(Criteria.where("name").is(name))), Person.class);}

    public Person getByPassword(String password){return mongoOperations.findOne(Query.query(Criteria.where("password").is(password)), Person.class);}
}
