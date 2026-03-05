package co.com.card.santander.demo.controllers;

import co.com.card.santander.demo.controllers.request.IssuedCardRequest;
import co.com.card.santander.demo.controllers.response.CardResponse;
import co.com.card.santander.demo.domain.entity.Card;
import co.com.card.santander.demo.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cards")
@RequiredArgsConstructor
public class CardController {
    private final CardService cardService;
    // POST /cards
    @PostMapping
    public ResponseEntity<Card> issue(@RequestBody IssuedCardRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cardService.issue(request));
    }

    // POST /cards/{cardId}/actívate

    // POST /cards/{cardId}/block

    // GET /cards/{cardId}
}
