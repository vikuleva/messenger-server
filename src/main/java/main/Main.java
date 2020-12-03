package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@SpringBootApplication
public class Main{
    public static void main(String[] args){
        try {
            SpringApplication.run(Main.class, args);
      }
        catch (Exception ex){
            System.out.println("Исключение"+ex+ex.getMessage());
        }
    }
}
 