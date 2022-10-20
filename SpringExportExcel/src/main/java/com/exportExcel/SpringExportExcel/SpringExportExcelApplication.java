package com.exportExcel.SpringExportExcel;

import com.exportExcel.SpringExportExcel.models.Student;
import com.exportExcel.SpringExportExcel.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringExportExcelApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringExportExcelApplication.class, args);
    }

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void run(String... args) throws Exception {
        Student student1 = new Student(1L, "Isaque", "My address line 1", "São Paulo", "321");
        Student student2 = new Student(2L, "Isaias", "My address line 2", "Minas Gerais", "123");

        studentRepository.save(student1);
        studentRepository.save(student2);
    }
}
