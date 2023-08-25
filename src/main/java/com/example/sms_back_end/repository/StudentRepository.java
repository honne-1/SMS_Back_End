package com.example.sms_back_end.repository;

import com.example.sms_back_end.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author zhuangqihan
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    // CRUD operations for Student
    Student findStudentByZid(long zid);
}
