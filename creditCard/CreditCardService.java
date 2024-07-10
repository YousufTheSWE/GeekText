package com.example.geekText.creditCard;

import com.example.geekText.profile.ProfileRepository;
import com.example.geekText.profile.Profiles;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CreditCardService {

    private final CreditCardRepository creditCardRepository;
    private final ProfileRepository profileRepository;

    @Autowired
    public CreditCardService(CreditCardRepository creditCardRepository, ProfileRepository profileRepository) {
        this.creditCardRepository = creditCardRepository;
        this.profileRepository = profileRepository;
    }

    @Transactional
    public void deleteCreditCardByCardNumber(String cardNumber) {
        Optional<CreditCard> creditCardOptional = creditCardRepository.findByCardNumber(cardNumber);
        if (creditCardOptional.isPresent()) {
            creditCardRepository.delete(creditCardOptional.get());
        } else {
            throw new IllegalArgumentException("Credit card with number " + cardNumber + " not found");
        }
    }

    public void addCreditCard(String username, CreditCard creditCard) {
        Optional<Profiles> profileOptional = profileRepository.findProfileByUsername(username);
        if (!profileOptional.isPresent()) {
            throw new IllegalStateException("Profile with username " + username + " does not exist");
        }
        Profiles profile = profileOptional.get();

        Optional<CreditCard> existingCard = creditCardRepository.findByCardNumber(creditCard.getCardNumber());
        if (existingCard.isPresent()) {
            throw new IllegalStateException("Credit card with number " + creditCard.getCardNumber() + " already exists");
        }

        creditCard.setProfile(profile);
        creditCardRepository.save(creditCard);
    }
}