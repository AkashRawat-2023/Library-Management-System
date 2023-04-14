package com.example.librarymanagementsystem.service.impl;

import com.example.librarymanagementsystem.DTO.ResponseDto.AuthorResponseDto;
import com.example.librarymanagementsystem.entity.Author;
import com.example.librarymanagementsystem.repository.AuthorRepository;
import com.example.librarymanagementsystem.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    AuthorRepository authorRepository;
    @Override
    public String addAuthor(Author author) {


        authorRepository.save(author);
        return "Author added";
    }

    @Override
    public AuthorResponseDto getByEmail(String email) {
        Author authors = authorRepository.findByEmail(email);

        //prepare a response Dto

        AuthorResponseDto authorResponseDto = new AuthorResponseDto();

        authorResponseDto.setName(authors.getName());
        authorResponseDto.setAge(authors.getAge());

        return authorResponseDto;

    }
}
