package com.exportExcel.SpringExportExcel.excel;

import com.exportExcel.SpringExportExcel.models.Student;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UserExcelExporter {

    private XSSFWorkbook workbook;
    private XSSFSheet sheet;

    private List<Student> studentList;

    public UserExcelExporter(List<Student> studentList) {
        this.studentList = studentList;
        this.workbook = new XSSFWorkbook();
    }

    private void createCell(Row row, int columncCount, Object value, CellStyle cellStyle) {
        sheet.autoSizeColumn(columncCount);
        Cell cell = row.createCell(columncCount);

        if (value instanceof Long) {
            cell.setCellValue((Long) value);

        } else if (value instanceof Integer) {
            cell.setCellValue((Integer) value);

        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);

        } else {
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(cellStyle);
    }

    private void writeHeaderLine() {
        sheet = workbook.createSheet("Student");

        Row row = sheet.createRow(0);
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(20);
        style.setFont(font);
        style.setAlignment(HorizontalAlignment.CENTER);

        createCell(row, 0, "Student Information", style);
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 4));
        font.setFontHeightInPoints((short) (10));

        row = sheet.createRow(1);
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);
        createCell(row, 0, "Student ID", style);
        createCell(row, 1, "Student Name", style);
        createCell(row, 2, "Student Address", style);
        createCell(row, 3, "Student City", style);
        createCell(row, 4, "Student Pin", style);
    }

    private void writeDataLines() {
        int rowCount = 2;

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);

        for (Student student : studentList) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
            createCell(row, columnCount++, student.getId(), style);
            createCell(row, columnCount++, student.getName(), style);
            createCell(row, columnCount++, student.getAddress(), style);
            createCell(row, columnCount++, student.getCity(), style);
            createCell(row, columnCount++, student.getPin(), style);
        }
    }

    public void export(HttpServletResponse response) throws IOException {
        writeHeaderLine();
        writeDataLines();

        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }
}