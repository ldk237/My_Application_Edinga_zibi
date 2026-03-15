package com.example.myapplication

import org.apache.poi.ss.usermodel.WorkbookFactory
import java.io.InputStream

fun readExcelFile(inputStream: InputStream): List<Student> {
    val students = mutableListOf<Student>()
    val workbook = WorkbookFactory.create(inputStream)
    val sheet = workbook.getSheetAt(0)

    for (row in sheet) {
        if (row.rowNum == 0) continue
        val name = row.getCell(0)?.stringCellValue ?: continue
        val score = row.getCell(1)?.numericCellValue ?: continue
        students.add(Student(name, score))
    }

    workbook.close()
    return students
}