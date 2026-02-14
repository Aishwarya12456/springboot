package com.javatechie.manytoone.dao;


import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class StudentDAO {

    private final EntityManager entityManager;

    public Student addStudent(Student student) {
        entityManager.persist(student);
        return student;
    }

    public List<Student> getStudents() {
        return entityManager.createQuery("FROM Student", Student.class).getResultList();
    }

    public Student getStudent(Integer id) {
        return entityManager.find(Student.class, id);
    }

    public Student updateStudent(Student updatedStudent) {
        entityManager.merge(updatedStudent);
        return updatedStudent;
    }

    public boolean deleteStudent(Integer id) {
        Student student = entityManager.find(Student.class, id);
        if (student != null) {
            entityManager.remove(student);
            return true;
        } else {
            return false;
        }
    }
}