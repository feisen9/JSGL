package com.hhu20.jsgl;

import com.hhu20.jsgl.intermediate.UserMaintenance;
import com.hhu20.jsgl.pojo.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class JsglApplication {

    public static void main(String[] args) {
        SpringApplication.run(JsglApplication.class, args);
    }

    public static void test(){

        List<Student> studentList = UserMaintenance.getStuInfoById("a",true);

        for (Student s: studentList){
            System.out.println(s.getSNO());
        }
    }


}
