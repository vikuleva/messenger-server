package main.controllers;

import main.models.Message;
import main.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MessageController {
    @Autowired
    private MessageService messageService;
    @Autowired private SimpMessagingTemplate messagingTemplate;

    @GetMapping(value = "/messages")
    public ResponseEntity<?> read(){
        final List<Message> messages = messageService.getAll();
        return messages!=null && !messages.isEmpty()?new ResponseEntity<Object>(messages, HttpStatus.OK):new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/createmessage")
    public ResponseEntity<?> add(@RequestBody Message message){
        messageService.add(message);
        messagingTemplate.convertAndSend("/messenger","обновись");
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

    @GetMapping(value = "/messagefromto/{idFrom}/{idTo}")
    public ResponseEntity<?> getCorrespondence(@PathVariable(name="idFrom") String idFrom, @PathVariable(name = "idTo")  String idTo ){
        final List<Message> messages = messageService.getCorrespondence(idFrom,idTo);
        return messages!=null && !messages.isEmpty()?new ResponseEntity<Object>(messages, HttpStatus.OK):new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
    }
    @MessageMapping("/messenger")
    @SendTo("topic/messenger")
    public ResponseEntity<?> dfdf(Message message){
        return new ResponseEntity<Object>(message, HttpStatus.OK);
    }
}
