package com.exportExcel.SpringExportExcel.repositories;

import com.exportExcel.SpringExportExcel.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {


}
