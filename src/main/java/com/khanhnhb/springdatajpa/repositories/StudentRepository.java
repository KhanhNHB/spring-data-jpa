package com.khanhnhb.springdatajpa.repositories;

import com.khanhnhb.springdatajpa.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
