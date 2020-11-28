package models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = Person.COLLECTION_NAME)
public class Person implements Serializable {

    public static final String COLLECTION_NAME = "persons";
    @Id
    private String id;
    private String name;
    private char password;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPassword(char password) {
        this.password = password;
    }

    public char getPassword() {
        return password;
    }
}
