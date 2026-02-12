package com.javatechie.restapi.Services;

import com.javatechie.restapi.DAO.StudentDAO;
import com.javatechie.restapi.Repository.StudentRepository;
import com.javatechie.restapi.iopackage.Student;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentDAO studentDAO;
    private final StudentRepository studentRepository;

    public Student addStudent(Student student) {
//        return studentDAO.addStudent(student);
        return studentRepository.save(student);
    }

    public List<Student> getStudents() {
//        return studentDAO.getStudents();
        return studentRepository.findAll();
    }

    public Student getStudent(Integer id) {
//        Student student = studentDAO.getStudent(id);
//        if (student != null) {
//            return student;
//        }
//        throw new ResponseStatusException(
//                HttpStatus.NOT_FOUND,
//                "Student not found for id: " + id
//        );
//    }
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()){
            return optionalStudent.get();
    }
    throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Student not found for the id:"+id);
//    return studentRepository.findByid(id)
//            .orElseThrow(()->new RuntimeException("student not found"+id));
}

    @Transactional
    public Student updatedStudent(Student updatedStudent) {
//        return studentDAO.updateStudent(updatedStudent);
        return studentRepository.save(updatedStudent);
    }

    @Transactional
    public void deleteStudent(Integer id) {
//        if (!studentDAO.deleteStudent(id)) {
//            throw new ResponseStatusException(
//                    HttpStatus.NOT_FOUND,
//                    "Student not found " + id
//            );
        Student existingStudent=getStudent(id);
        studentRepository.delete(existingStudent);

        }
    }

