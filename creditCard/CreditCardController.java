package com.example.geekText.creditCard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "geektext/profiles/{username}/creditcards")
public class CreditCardController {

    private final CreditCardService creditCardService;

    @Autowired
    public CreditCardController(CreditCardService creditCardService) {
        this.creditCardService = creditCardService;
    }

    @PostMapping
    public void addCreditCard(@PathVariable("username") String username, @RequestBody CreditCard creditCard) {
        creditCardService.addCreditCard(username, creditCard);
    }

    @DeleteMapping("/{cardNumber}")
    public ResponseEntity<Void> deleteCreditCard(
            @PathVariable("username") String username,
            @PathVariable("cardNumber") String cardNumber) {
        creditCardService.deleteCreditCardByCardNumber(cardNumber);
        return ResponseEntity.ok().build();
    }
}