package com.alok.cards.controller;


import com.alok.cards.adaptor.CardsAdaptor;
import com.alok.cards.config.CardsServiceConfig;
import com.alok.cards.model.CardsDto;
import com.alok.cards.model.PropertiesDto;
import com.alok.cards.service.CardsService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
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

    @Autowired
    private CardsServiceConfig cardsServiceConfig;

    @GetMapping("/myCards/{customerId}")
    public ResponseEntity<List<CardsDto>> getCardDetails(@PathVariable Integer customerId) {
        return new ResponseEntity<>(cardsAdaptor.adapt(cardsService.findByCustomerId(customerId)), HttpStatus.OK);
    }

    @GetMapping("/myCards/properties")
    public String getPropertyDetails() throws JsonProcessingException {
        ObjectWriter ow= new ObjectMapper().writer().withDefaultPrettyPrinter();
        PropertiesDto properties= PropertiesDto.builder().msg(cardsServiceConfig.getMsg())
                .buildVersion(cardsServiceConfig.getBuildVersion()).mailDetails(cardsServiceConfig.getMailDetails())
                .activeBranches(cardsServiceConfig.getActiveBranches()).build();
        String jsonStr = ow.writeValueAsString(properties);
        return jsonStr;
    }
}
