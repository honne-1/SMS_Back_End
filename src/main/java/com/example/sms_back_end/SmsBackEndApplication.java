package com.example.sms_back_end;

import com.example.sms_back_end.entity.Student;
import com.example.sms_back_end.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SmsBackEndApplication implements CommandLineRunner {
    @Autowired
    private StudentRepository studentRepository;

    public static void main(String[] args) {
        SpringApplication.run(SmsBackEndApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Student student = new Student();
        student.setFirstName("Zhuangqi");
        student.setLastName("HAN");
        student.setZid(5281819);
        student.setProgramCode(8888);
        student.setStage(1);
        student.setEmail("123@gmail.com");
        student.setContact("123456789");
        studentRepository.save(student);
    }
}
