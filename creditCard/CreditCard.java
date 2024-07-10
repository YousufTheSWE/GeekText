package com.example.geekText.creditCard;

import com.example.geekText.profile.Profiles;
import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "credit_cards")
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String cardHolderName;

    @Column(nullable = false, unique = true)
    private String cardNumber;

    @Column(nullable = false)
    private String expiryDate;

    @Column(nullable = false)
    private String securityCode;

    @ManyToOne
    @JoinColumn(name = "profile_id")
    @JsonIgnore // Prevent circular reference
    private Profiles profile;

    public CreditCard() {
    }

    public CreditCard(String cardHolderName, String cardNumber, String expiryDate, String securityCode, Profiles profile) {
        this.cardHolderName = cardHolderName;
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.securityCode = securityCode;
        this.profile = profile;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    public Profiles getProfile() {
        return profile;
    }

    public void setProfile(Profiles profile) {
        this.profile = profile;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "id=" + id +
                ", cardHolderName='" + cardHolderName + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", expiryDate='" + expiryDate + '\'' +
                ", securityCode='" + securityCode + '\'' +
                ", profile=" + profile +
                '}';
    }
}