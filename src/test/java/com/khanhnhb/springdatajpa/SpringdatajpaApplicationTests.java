package com.khanhnhb.springdatajpa;

import com.khanhnhb.springdatajpa.entities.Student;
import com.khanhnhb.springdatajpa.repositories.StudentRepository;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SpringdatajpaApplicationTests {
    private final Logger logger = LoggerFactory.getLogger(SpringdatajpaApplicationTests.class);

    @Autowired
    StudentRepository repository;

    @Test
    public void testSaveStudent() {
        Student student = new Student();
        student.setId(1l);
        student.setName("KhanhNHB");
        student.setTestScore(8.0);
        repository.save(student);

        Optional<Student> savedStudent = repository.findById(1l);
        assertNotNull(savedStudent.get());
    }

    @Test
    public void testFindAllStudent() {
        List<Student> students = repository.findAll();
        assertNotNull(students);
    }

    @Test
    public void testUpdateStudent() {
        Optional<Student> optionalStudent = repository.findById(1l);
        optionalStudent.ifPresentOrElse((student) -> {
            assertNotNull(student);
            student.setTestScore(9.0);
            repository.save(student);

            Optional<Student> updatedStudent = repository.findById(1l);
            assertNotNull(updatedStudent.get());
        }, () -> {
            // TODO: Throw exception not found student by id
        });
    }

    @Test
    public void testDeleteStudent() {
        Optional<Student> student = repository.findById(1l);
        student.ifPresentOrElse((value) -> {
            repository.delete(value);

            Optional<Student> deletedStudent = repository.findById(1l);
            assertEquals(false, deletedStudent.isPresent());
        }, () -> {
            // TODO: Not found student by id
        });
    }
}
