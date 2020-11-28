package models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = Message.COLLECTION_NAME)
public class Message {
    public static final String COLLECTION_NAME = "messages";
    @Id
    private String id;
    private String text;
    private String id1;
    private String id2;

    public void setText(String text){
        this.text = text;
    }

    public String getText(){
        return text;
    }

    public void setId1(String id1){
        this.id1=id1;
    }

    public String getId1() {
        return id1;
    }

    public void setId2(String id2) {
        this.id2 = id2;
    }

    public String getId2() {
        return id2;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
