package main.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Repository;

@Repository
@Document(collection = Message.COLLECTION_NAME)
public class Message {
    public static final String COLLECTION_NAME = "messages";
    @Id
    private String id;
    private String text;
    private String idFrom;
    private String idTo;

    public void setText(String text){
        this.text = text;
    }

    public String getText(){
        return text;
    }

    public void setIdFrom(String idFrom){
        this.idFrom = idFrom;
    }

    public String getIdFrom() {
        return idFrom;
    }

    public void setIdTo(String idTo) {
        this.idTo = idTo;
    }

    public String getIdTo() {
        return idTo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
