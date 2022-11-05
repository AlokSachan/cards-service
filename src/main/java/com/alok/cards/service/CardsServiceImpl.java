package com.alok.cards.service;

import com.alok.cards.entity.Cards;
import com.alok.cards.repository.CardsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardsServiceImpl implements CardsService {


    @Autowired
    private CardsRepository cardsRepository;

    @Override
    public List<Cards> findByCustomerId(Integer customerId) {

       return cardsRepository.findByCustomerId(customerId);
    }
}
