package main.controllers;

import main.models.Message;
import main.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MessageController {
    @Autowired
    private MessageService messageService;

    @GetMapping(value = "/messages")
    public ResponseEntity<?> read(){
        final List<Message> messages = messageService.getAll();
        return messages!=null && !messages.isEmpty()?new ResponseEntity<Object>(messages, HttpStatus.OK):new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/createmessage")
    public ResponseEntity<?> add(@RequestBody Message message){

        messageService.add(message);
        return new ResponseEntity<Object>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/message/{id}")
    public ResponseEntity<?> getById(@PathVariable(name="id")String id){
        final Message message = messageService.get(id);
        return message!=null ? new ResponseEntity<Object>(message, HttpStatus.OK):new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/message/{id}")
    public ResponseEntity<?> remove(@PathVariable(name="id") String id){
        final boolean deleted = true;
        messageService.remove(id);
        return deleted ? new ResponseEntity<Object>(HttpStatus.OK): new ResponseEntity<Object>(HttpStatus.NOT_MODIFIED);
    }

//    @PutMapping(value="/message/{id}")
//    public ResponseEntity<?> update(@RequestBody Message message){
//        final boolean updated = true;
//        messageService.update(message);
//        return updated ? new ResponseEntity<Object>(HttpStatus.OK):new ResponseEntity<Object>(HttpStatus.NOT_MODIFIED);
//    }

    @GetMapping(value = "/messagefromto/{idFrom}/{idTo}")
    public ResponseEntity<?> getCorrespondence(@PathVariable(name="idFrom") String idFrom, @PathVariable(name = "idTo")  String idTo ){
        final List<Message> messages = messageService.getCorrespondence(idFrom,idTo);
        return messages!=null && !messages.isEmpty()?new ResponseEntity<Object>(messages, HttpStatus.OK):new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
    }
}
