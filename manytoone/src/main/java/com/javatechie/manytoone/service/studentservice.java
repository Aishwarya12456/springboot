package com.javatechie.manytoone.service;

import in.bushansirgur.studentregistration.dao.StudentDAO;
import in.bushansirgur.studentregistration.entity.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentDAO studentDAO;

    public Student addStudent(Student student) {
        return studentDAO.addStudent(student);
    }

    public List<Student> getStudents() {
        return studentDAO.getStudents();
    }

    public Student getStudent(Integer id) {
        Student student = studentDAO.getStudent(id);
        if (student != null) {
            return student;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found for the Id: "+id);
    }

    public Student updateStudent(Student updatedStudent) {
        try {
            return studentDAO.updateStudent(updatedStudent);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found for the Id: "+updatedStudent.getId());
        }
    }

    public void deleteStudent(Integer id) {
        if (!studentDAO.deleteStudent(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found for the Id: "+id);
        }
    }
}