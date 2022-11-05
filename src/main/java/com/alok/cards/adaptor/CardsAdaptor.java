package com.alok.cards.adaptor;

import com.alok.cards.entity.Cards;
import com.alok.cards.model.CardsDto;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class CardsAdaptor {
    public List<CardsDto> adapt(List<Cards> cards) {
        return Optional.ofNullable(cards)
                .orElseGet(Collections::emptyList)
                .stream()
                .map(input-> mapDtoResponse(input))
                .collect(Collectors.toList());
    }

    private CardsDto mapDtoResponse(Cards cards) {
        return CardsDto.builder()
                .cardId(cards.getCardId())
                .customerId(cards.getCustomerId())
                .cardNumber(cards.getCardNumber())
                .cardType(cards.getCardType())
                .totalLimit(cards.getTotalLimit())
                .amountUsed(cards.getAmountUsed())
                .availableAmount(cards.getAvailableAmount())
                .createDt(cards.getCreateDt()).build();
    }
}
