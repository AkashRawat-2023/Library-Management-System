package com.example.librarymanagementsystem.DTO.RequestDto;

import com.example.librarymanagementsystem.enums.Genre;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddBookRequestDto {

    private String title;

    private Genre genre;

    private int numberOfPages;

    private int price;

    private int authorId;
}
