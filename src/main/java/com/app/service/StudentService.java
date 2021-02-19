package com.app.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

import com.app.model.Student;


@Service
public class StudentService {

    public List<Student> getStudents(){
        final List<Student> students =  new ArrayList<Student>();
        students.add(new Student(1,"patar","timotius", LocalDate.now(),"jakarta","UGM",Boolean.TRUE));
        students.add(new Student(2,"patar","timotius", LocalDate.now(),"jakarta","UGM",Boolean.TRUE));
        students.add(new Student(3,"patar","timotius", LocalDate.now(),"jakarta","UGM",Boolean.TRUE));
        students.add(new Student(4,"patar","timotius", LocalDate.now(),"jakarta","UGM",Boolean.TRUE));
        
        		
        		
        		return students;
    }
}