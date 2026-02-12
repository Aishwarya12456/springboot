package com.javatechie.restapi.DAO;

import com.javatechie.restapi.iopackage.Student;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

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
        return entityManager
                .createQuery("from Student", Student.class)
                .getResultList();
    }

    public Student getStudent(Integer id) {
        return entityManager.find(Student.class, id);
    }

    public Student updateStudent(Student updatedStudent) {
        return entityManager.merge(updatedStudent);
    }

    public boolean deleteStudent(Integer id) {
        Student student = entityManager.find(Student.class, id);
        if (student != null) {
            entityManager.remove(student);
            return true;
        }
        return false;
    }
}
