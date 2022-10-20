package com.exportExcel.SpringExportExcel.controllers;

import com.exportExcel.SpringExportExcel.excel.UserExcelExporter;
import com.exportExcel.SpringExportExcel.models.Student;
import com.exportExcel.SpringExportExcel.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/export")
public class ExcelController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public void exportToExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=Student_info.xlsx";

        response.setHeader(headerKey, headerValue);
        List<Student> studentList = studentService.findAllStudent();
        UserExcelExporter exporter = new UserExcelExporter(studentList);
        exporter.export(response);
    }
}
