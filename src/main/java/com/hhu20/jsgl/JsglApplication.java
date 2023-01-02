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
        String a  = "AA";
        String b = "AA";
        String c = "BB";
        System.out.println(a==c);
        System.out.println(a==b);
        System.out.println(a=="AA");
        System.out.println(a=="BB");
        System.out.println("asf"=="aaa");
        System.out.println("asf"=="asf");
        Instant date = new Date().toInstant();
        String datee = date.toString().substring(0,19);
        System.out.println("aaa: "+datee);
    }

}
