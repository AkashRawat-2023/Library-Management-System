package com.example.librarymanagementsystem.service;

import com.example.librarymanagementsystem.DTO.RequestDto.IssueBookRequestDto;
import com.example.librarymanagementsystem.DTO.RequestDto.ReturnBookRequestDto;
import com.example.librarymanagementsystem.DTO.ResponseDto.IssueBookResponseDto;
import com.example.librarymanagementsystem.DTO.ResponseDto.ReturnBookResponseDto;

public interface TransactionService {

    public IssueBookResponseDto issueBook(IssueBookRequestDto issueBookRequestDto) throws Exception;

    public ReturnBookResponseDto returnBook(ReturnBookRequestDto returnBookRequestDto) throws Exception;
}
