package co.com.card.santander.demo.domain.entity;

import co.com.card.santander.demo.domain.CardStatus;
import co.com.card.santander.demo.domain.CurrencyCode;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "cards")// ToDO: verify!!!
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "card_id", nullable = false, updatable = false)
    private UUID cardId;
    @Column(name = "card_number", length = 16, nullable = false, unique = true)
    private String cardNumber;
    @Column(name = "holder_name", nullable = false)
    private String holderName;
    @Column(name = "isued_at", nullable = false)
    private LocalDate issuedAt;//ToDo: verify Instante
    @Column(name = "expires_at", nullable = false)
    private LocalDate expiresAt;// Calculate based on issuedAt + 3 years
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private CardStatus status;
    @Column(name = "blocked_at", nullable = false)
    private LocalDate blockedAt;
    @Column(name = "blocked_reason", nullable = false)
    private String blockedReason;
    @Column(name = "balance", nullable = false, precision = 19, scale = 4)
    private BigDecimal balance;
    @Enumerated(EnumType.STRING)
    @Column(name = "currency", nullable = false)
    private CurrencyCode currency;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
}
