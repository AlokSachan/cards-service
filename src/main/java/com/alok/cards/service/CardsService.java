package com.alok.cards.service;

import com.alok.cards.entity.Cards;

import java.util.List;

public interface CardsService {
    List<Cards> findByCustomerId(Integer customerId);
}
