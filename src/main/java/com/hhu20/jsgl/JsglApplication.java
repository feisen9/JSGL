package com.hhu20.jsgl;

import com.hhu20.jsgl.intermediate.UserMaintenance;
import com.hhu20.jsgl.pojo.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class JsglApplication {

    public static void main(String[] args) {
        test();
        SpringApplication.run(JsglApplication.class, args);
    }
    public static void test(){
        Instant date = new Date().toInstant();
        String datee = date.toString().substring(0,19);
        System.out.println("aaa: "+datee);
    }

}
