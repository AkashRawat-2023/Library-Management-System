package com.example.librarymanagementsystem.entity;

import com.example.librarymanagementsystem.enums.CardStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "card")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @CreationTimestamp
    private Date issueDate;

    @UpdateTimestamp
    private Date updateOn;

    @Enumerated(EnumType.STRING)
    private CardStatus cardStatus;

    private String validTill;

    //Child to Parent Relationship
    //Student is Parent && Card is Child
    @OneToOne
    @JoinColumn
    Student student;

    //Parent to child Relationship
    //Card is Parent && Transaction and Book child
    @OneToMany(mappedBy = "card",cascade = CascadeType.ALL)
    List<Book> bookIssued = new ArrayList<>(); //When the card is first time allocated ,Give empty arrayList

    @OneToMany(mappedBy = "card",cascade = CascadeType.ALL)
    List<Transaction> transactionList = new ArrayList<>();
}
