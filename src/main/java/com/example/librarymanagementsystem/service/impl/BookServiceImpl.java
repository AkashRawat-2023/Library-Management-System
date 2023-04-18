package com.example.librarymanagementsystem.service.impl;

import com.example.librarymanagementsystem.DTO.RequestDto.AddBookRequestDto;
import com.example.librarymanagementsystem.entity.Author;
import com.example.librarymanagementsystem.entity.Book;
import com.example.librarymanagementsystem.repository.AuthorRepository;
import com.example.librarymanagementsystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    AuthorRepository authorRepository;

    @Override
    public String addBook(AddBookRequestDto addBookRequestDto) throws Exception {

        Author author;
        try{
            author = authorRepository.findById(addBookRequestDto.getAuthorId()).get();
        }
        catch (Exception e){
            throw new Exception("Author not present");
        }

        Book book = new Book();
        book.setTitle(addBookRequestDto.getTitle());
        book.setGenre(addBookRequestDto.getGenre());
        book.setNumberOfPages(addBookRequestDto.getNumberOfPages());
        book.setPrice(addBookRequestDto.getPrice());
        author.getBooks().add(book);

        book.setAuthor(author);

        authorRepository.save(author);
        return "Book Added Successfully";


    }

}
