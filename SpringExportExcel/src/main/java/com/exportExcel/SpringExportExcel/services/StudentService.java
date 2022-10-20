package com.exportExcel.SpringExportExcel.services;

import com.exportExcel.SpringExportExcel.models.Student;
import com.exportExcel.SpringExportExcel.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> findAllStudent() {
        return studentRepository.findAll();
    }
}
