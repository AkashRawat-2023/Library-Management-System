package com.example.librarymanagementsystem.service;

import com.example.librarymanagementsystem.DTO.RequestDto.AddBookRequestDto;
import com.example.librarymanagementsystem.entity.Book;

public interface BookService {
    public String addBook(AddBookRequestDto addBookRequestDto) throws Exception;
}
