package com.biblioteca.flash_cards.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name= "card")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long Id;

    public String QuestionText;

    public String AnswerText;

    public Long DeckId;
}
