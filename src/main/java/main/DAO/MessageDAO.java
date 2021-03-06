package main.DAO;

import main.models.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MessageDAO {
    @Autowired
    private MongoOperations mongoOperations;

    public void save(Message message) {
        mongoOperations.save(message);
    }

    public Message get(String id) {
        return mongoOperations.findOne(Query.query(Criteria.where("id").is(id)), Message.class);
    }

    public List<Message> getAll() {
        return mongoOperations.findAll(Message.class);
    }

    public void remove(String id) {
        mongoOperations.remove(Query.query(Criteria.where("id").is(id)), Message.class);
    }

    public List<Message> getCorrespondence(String idFrom, String idTo){
        return mongoOperations.find(Query.query(Criteria.where("idFrom").in(idFrom,idTo).andOperator(Criteria.where("idTo").in(idTo, idFrom))),Message.class);
    }
}
