package com.example.librarymanagementsystem.service.impl;

import com.example.librarymanagementsystem.entity.Card;
import com.example.librarymanagementsystem.entity.Student;
import com.example.librarymanagementsystem.enums.CardStatus;
import com.example.librarymanagementsystem.repository.StudentRepository;
import com.example.librarymanagementsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public String addStudent(Student student) {

        //generate a new card for the student
        Card card = new Card();
        card.setCardStatus(CardStatus.ACTIVATED);
        card.setValidDate("2024-01-01");
        card.setStudent(student);

        //set card for the student
        student.setCard(card);

        studentRepository.save(student);
        return "Student Added";
    }
}
