package com.javatechie.restapi.controller;

//import com.javatechie.restapi.iopackage.Student;
//import jakarta.validation.Valid;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;

//@Controller
//@RestController
//@RequestMapping("/students")

//@ResponseBody
//@ResponseStatus(HttpStatus.OK)
//public class studentcontroller {


//    @RequestMapping(value="/register",method= RequestMethod.POST)// value is identifier
//    public String registerStudent(){
//        return "taking addmission for student";
//
//    }
//    @PostMapping("/register")
//    public String registerStudent(@RequestBody Student student){
//        System.out.println("printing the student details:"+student);
//        return "taking addmission for student"+student;
//    @ResponseStatus(HttpStatus.CREATED)
//    public Student registerStudent(@RequestBody Student student){
//        student.setId(1);
//        return student;
//    public ResponseEntity<?> registerStudent(@Valid @RequestBody Student student){
//        if(student.getName()==null||student.getDob()==null|| student.getEmail()==null){
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Required details are missing");


//        }
//        student.setId(1);
//        return ResponseEntity.status(HttpStatus.CREATED).body(student);
//    }
//    @GetMapping("/read")
//    public String readStudentdetail(@RequestParam(value = "name",required = false) String name,@RequestParam(value = "email" ,required = false) String email,@RequestParam("age")Integer age){
//        return "fetching all student info from server"+name+","+email+","+age;
//    }
//    @DeleteMapping("/delete/{id}/{name}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public String deletestudentdetails(@PathVariable (required = false)int id,@PathVariable(required = false) String name){
//        System.out.println("deleting the student details"+id+","+name);
//        return "deleting student details"+id;
//    }
//    @PutMapping("/update")
//    public String updateStudentDetails(){
//        return "updating the student details";
//
//    }
//
//
//}


import com.javatechie.restapi.Services.StudentService;
import com.javatechie.restapi.iopackage.Student;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
@Transactional
public class studentcontroller {

//    private final EntityManager entityManager;


    private final StudentService studentService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Student addStudent(@Valid @RequestBody Student student) {
//        entityManager.persist(student);
//        return student;
        return studentService.addStudent(student);


    }

    @GetMapping
    public List<Student> readStudents() {
//        return entityManager.createQuery("from Student",Student.class).getResultList();
        return studentService.getStudents();

    }

    @GetMapping("/{id}")
    public Student readStudent(@PathVariable Integer id) {
//        Student student =entityManager.find(Student.class,id);
//        if(student !=null){
//            return student;
//
//        }
//        throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Student not found for the id:"+id);
        return studentService.getStudent(id);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Integer id, @RequestBody Student updatedStudent) {
//        Student student=entityManager.find(Student.class,id);
//        if(student!=null){
//            student.setName(updatedStudent.getName());
//            student.setDob(updatedStudent.getDob());
//            entityManager.merge(student);
//            return student;
//
//
//        }
//        throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Student not found for the id:"+id);
//        try {
//            entityManager.merge(updatedStudent);
//            return updatedStudent;
//        }
//        catch (Exception e){
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Student not found for the id:"+updatedStudent.getId());
//
//
//        }
//          entityManager.merge(updatedStudent);
//          return updatedStudent;
        updatedStudent.setId(id);
        return studentService.updatedStudent(updatedStudent);

    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Integer id) {
//        Student student=entityManager.find(Student.class,id);
//        if(student!=null){
//            entityManager.remove(student);
//            return;
//        }
//        throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Student not found"+id);
//
//
//    }
        try{
            studentService.deleteStudent(id);

        }catch (Exception e){
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
        }
        studentService.deleteStudent(id);

    }
}
