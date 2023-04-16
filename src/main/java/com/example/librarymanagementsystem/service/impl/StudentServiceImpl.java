package com.example.librarymanagementsystem.service.impl;

import com.example.librarymanagementsystem.DTO.RequestDto.StudentRequestDto;
import com.example.librarymanagementsystem.DTO.RequestDto.UpdateStudentMobRequestDto;
import com.example.librarymanagementsystem.DTO.ResponseDto.CardResponseDto;
import com.example.librarymanagementsystem.DTO.ResponseDto.StudentResponseDto;
import com.example.librarymanagementsystem.DTO.ResponseDto.UpdateStudentMobNoResponseDto;
import com.example.librarymanagementsystem.entity.Card;
import com.example.librarymanagementsystem.entity.Student;
import com.example.librarymanagementsystem.enums.CardStatus;
import com.example.librarymanagementsystem.exceptions.StudentNotFoundException;
import com.example.librarymanagementsystem.repository.StudentRepository;
import com.example.librarymanagementsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public String addStudent(StudentRequestDto studentRequestDto) {

        Student student = new Student();
        student.setAge(studentRequestDto.getAge());
        student.setName(studentRequestDto.getName());
        student.setDepartment(studentRequestDto.getDepartment());
        student.setMobNo(studentRequestDto.getMobNo());

        Card card = new Card();
        card.setCardStatus(CardStatus.ACTIVATED);
        card.setValidTill("2024-01-01");
        card.setStudent(student);

        student.setCard(card);
        studentRepository.save(student);

        return "Student Added";

    }

    @Override
    public UpdateStudentMobNoResponseDto updateMobNo(UpdateStudentMobRequestDto updateStudentMobRequestDto) throws StudentNotFoundException {


        try{
            Student student = studentRepository.findById(updateStudentMobRequestDto.getId()).get();
            student.setMobNo(updateStudentMobRequestDto.getMobNo());
            Student updateStudent = studentRepository.save(student);

            //prepare response dto
            UpdateStudentMobNoResponseDto updateStudentMobNoResponseDto = new UpdateStudentMobNoResponseDto();
            updateStudentMobNoResponseDto.setName(updateStudent.getName());
            updateStudentMobNoResponseDto.setMobNo(updateStudentMobRequestDto.getMobNo());
            return updateStudentMobNoResponseDto;

        }
        catch (Exception e){
            throw new StudentNotFoundException("Invalid Student Id");
        }
    }

    @Override
    public StudentResponseDto getStudentById(int id) {
        Student student = studentRepository.findById(id).get();

        //prepare a response dto
        StudentResponseDto studentResponseDto = new StudentResponseDto();
        studentResponseDto.setId(student.getId());
        studentResponseDto.setName(student.getName());
        studentResponseDto.setDepartment(student.getDepartment());
        studentResponseDto.setAge(student.getAge());
        studentResponseDto.setMobNo(student.getMobNo());

        CardResponseDto cardResponseDto = new CardResponseDto();
        cardResponseDto.setIssueDate(student.getCard().getIssueDate());
        cardResponseDto.setCardStatus(student.getCard().getCardStatus());
        cardResponseDto.setUpdateOn(student.getCard().getUpdateOn());
        cardResponseDto.setValidTill(student.getCard().getValidTill());
        cardResponseDto.setId(student.getCard().getId());

        studentResponseDto.setCardResponseDto(cardResponseDto);
        return studentResponseDto;

    }
}
