package com.example.librarymanagementsystem.controller;

import com.example.librarymanagementsystem.DTO.RequestDto.StudentRequestDto;
import com.example.librarymanagementsystem.DTO.RequestDto.UpdateStudentMobRequestDto;
import com.example.librarymanagementsystem.DTO.ResponseDto.UpdateStudentMobNoResponseDto;
import com.example.librarymanagementsystem.entity.Student;
import com.example.librarymanagementsystem.exceptions.StudentNotFoundException;
import com.example.librarymanagementsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/add")
    public String addStudent(@RequestBody StudentRequestDto studentRequestDto){
        return studentService.addStudent(studentRequestDto);
    }
    @PutMapping("/update_mobile")
    public UpdateStudentMobNoResponseDto updateMobNo(@RequestBody UpdateStudentMobRequestDto updateStudentMobRequestDto) throws StudentNotFoundException {

        return studentService.updateMobNo(updateStudentMobRequestDto);
    }

    // delete a student by id

    // update the student by id

    // find a student by id

    // find all the students
}
