package co.com.card.santander.demo.service;

import co.com.card.santander.demo.controllers.request.IssuedCardRequest;
import co.com.card.santander.demo.controllers.response.CardResponse;
import co.com.card.santander.demo.domain.CardStatus;
import co.com.card.santander.demo.domain.CurrencyCode;
import co.com.card.santander.demo.domain.entity.Card;
import co.com.card.santander.demo.domain.entity.Product;
import co.com.card.santander.demo.repository.CardRepository;
import co.com.card.santander.demo.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.time.LocalDate;

@AllArgsConstructor
@Service
public class CardService {
    private static final SecureRandom random = new SecureRandom();
    private final CardRepository cardRepository;
    private final ProductRepository productRepository;

    public String generate(String productId) {
        StringBuilder cardNumber = new StringBuilder(16);
        cardNumber.append(productId);
        for (int i = 0; i < 10; i++) {
            cardNumber.append(random.nextInt(10));
        }
        return cardNumber.toString();
    }

    @Transactional
    public Void issue(IssuedCardRequest issuedCardRequest) {
        Product product = productRepository.findById(issuedCardRequest.getProductId())
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));

        Card card = new Card();
        card.setProduct(product);
        card.setHolderName(issuedCardRequest.getHolderName());
        card.setStatus(CardStatus.ACTIVE);
        LocalDate now = LocalDate.now();
        card.setIssuedAt(now);
        card.setExpiresAt(now.plusYears(3));
        card.setStatus(CardStatus.ISSUED);
        card.setBalance(new BigDecimal("0.00"));
        card.setCurrency(CurrencyCode.USD);

        for (int attempt = 0; attempt < 5; attempt++) {
            card.setCardNumber(generate(product.getProductId()));
            try {
                return cardRepository.saveAllAndFlush(card);
            } catch (Exception e) {
                throw new RuntimeException("Failed to issue card: " + e.getMessage(), e);
            }
        }
    }
}
