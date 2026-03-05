package co.com.card.santander.demo.controllers.response;

import co.com.card.santander.demo.domain.CardStatus;
import co.com.card.santander.demo.domain.CurrencyCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class CardResponse {
    private UUID cardId;
    private String cardNumber;
    private String holderName;
    private CardStatus status;
    private LocalDate blockDate;
    private String blockReason;
    private LocalDate expiresAt;
    private BigDecimal balance;
    private CurrencyCode currency;
}
