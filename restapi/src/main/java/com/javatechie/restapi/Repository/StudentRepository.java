package com.javatechie.restapi.Repository;

import com.javatechie.restapi.iopackage.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {


}
