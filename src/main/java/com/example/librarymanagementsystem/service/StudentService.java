package com.example.librarymanagementsystem.service;

import com.example.librarymanagementsystem.DTO.RequestDto.StudentRequestDto;
import com.example.librarymanagementsystem.DTO.RequestDto.UpdateStudentMobRequestDto;
import com.example.librarymanagementsystem.DTO.ResponseDto.StudentResponseDto;
import com.example.librarymanagementsystem.DTO.ResponseDto.UpdateStudentMobNoResponseDto;
import com.example.librarymanagementsystem.entity.Student;
import com.example.librarymanagementsystem.exceptions.StudentNotFoundException;

public interface StudentService {

    public String addStudent(StudentRequestDto studentRequestDto);

    public UpdateStudentMobNoResponseDto updateMobNo(UpdateStudentMobRequestDto updateStudentMobRequestDto) throws StudentNotFoundException;

    public StudentResponseDto getStudentById(int id);
}
