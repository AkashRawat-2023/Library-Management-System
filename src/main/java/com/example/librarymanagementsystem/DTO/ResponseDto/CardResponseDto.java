package com.example.librarymanagementsystem.DTO.ResponseDto;

import com.example.librarymanagementsystem.enums.CardStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CardResponseDto {

    private int id;

    private Date issueDate;

    private Date updateOn;

    private CardStatus cardStatus;

    private String validTill;
}
