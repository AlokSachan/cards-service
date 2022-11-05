package com.alok.cards.controller;


import com.alok.cards.adaptor.CardsAdaptor;
import com.alok.cards.model.CardsDto;
import com.alok.cards.service.CardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CardsController {

    @Autowired
    private CardsService cardsService;

    @Autowired
    private CardsAdaptor cardsAdaptor;

    @GetMapping("/myCards/{customerId}")
    public ResponseEntity<List<CardsDto>> getCardDetails(@PathVariable Integer customerId) {
        return new ResponseEntity<>(cardsAdaptor.adapt(cardsService.findByCustomerId(customerId)), HttpStatus.OK);
    }
}
