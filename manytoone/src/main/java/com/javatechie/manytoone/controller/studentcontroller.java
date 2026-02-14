package in.bushansirgur.studentregistration.controller;


import jakarta.persistence.EntityManager;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
@Transactional
public class StudentController {


    private final StudentService studentService;



    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Student addStudent(@Valid @RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @GetMapping
    public List<Student> readStudents() {
        return studentService.getStudents();
    }

    @GetMapping("/{id}")
    public Student readStudent(@PathVariable Integer id) {
        return studentService.getStudent(id);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Integer id,
                                 @RequestBody Student updatedStudent) {
//        Student student = entityManager.find(Student.class, id);
//        if (student != null) {
//            student.setName(updatedStudent.getName());
//            student.setDob(updatedStudent.getDob());
//            entityManager.merge(student);
//            return student;
//        }
//        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found for the Id: "+id);
        updatedStudent.setId(id);
        return studentService.updateStudent(updatedStudent);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);
    }
}