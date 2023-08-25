package com.example.sms_back_end.controller;

import com.example.sms_back_end.entity.Student;
import com.example.sms_back_end.exception.ResourceNotFoundException;
import com.example.sms_back_end.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zhuangqihan
 */
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @GetMapping("/{zid}")
    public ResponseEntity<Student> getStudentById(@PathVariable long zid) {
        Student student = studentRepository.findStudentByZid(zid);
        if (student == null) {
            throw new ResourceNotFoundException("Student not found with zid: " + zid);
        }
        return ResponseEntity.ok(student);
    }

    @PutMapping("/{zid}")
    public ResponseEntity<Student> updateStudent(@PathVariable long zid, @RequestBody Student studentDetails) {
        Student student = studentRepository.findStudentByZid(zid);
        if (student == null) {
            throw new ResourceNotFoundException("Student not found with zid: " + zid);
        }
        student.setFirstName(studentDetails.getFirstName());
        student.setLastName(studentDetails.getLastName());
        student.setEmail(studentDetails.getEmail());
        student.setContact(studentDetails.getContact());
        student.setProgramCode(studentDetails.getProgramCode());
        student.setStage(studentDetails.getStage());
        Student updatedStudent = studentRepository.save(student);
        return ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping("/{zid}")
    public ResponseEntity<Student> deleteStudent(@PathVariable long zid) {
        Student student = studentRepository.findStudentByZid(zid);
        if (student == null) {
            throw new ResourceNotFoundException("Student not found with zid: " + zid);
        }
        studentRepository.delete(student);
        return ResponseEntity.ok(student);
    }
}
