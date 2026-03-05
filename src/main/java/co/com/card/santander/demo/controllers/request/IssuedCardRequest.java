package co.com.card.santander.demo.controllers.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IssuedCardRequest {
    private String productId;
    private String holderName;
}
