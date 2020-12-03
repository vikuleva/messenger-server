package main.services;

import main.DAO.MessageDAO;
import main.models.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    private MessageDAO messageDAO;

    public void add(Message message) {
        messageDAO.save(message);
    }

//    public void update(Message message) {
//        messageDAO.save(message);
//    }

    public Message get(String id) {
        return messageDAO.get(id);
    }

    public List<Message> getAll() {

        return messageDAO.getAll();
    }

    public void remove(String id) {
        messageDAO.remove(id);
    }

    public  List<Message> getCorrespondence(String idFrom, String idTo){
        return messageDAO.getCorrespondence(idFrom, idTo);
    }
}
