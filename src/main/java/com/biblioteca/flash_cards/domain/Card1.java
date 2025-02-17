package com.biblioteca.flash_cards.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name= "card")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Card1 {
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String questionText;

    private String answerText;
}
