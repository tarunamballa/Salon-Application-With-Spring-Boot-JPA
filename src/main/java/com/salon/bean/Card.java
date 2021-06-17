package com.salon.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Card {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private long cardId;
	@NotEmpty(message="Card Name should not be Empty")
	private String cardName;
	@NotNull
	private String cardNumber;
	@NotNull
    private String cardExpiry;
	@NotEmpty(message="cvv number should not be exceeded ")
	@Size(min=3,max=3)
    private int cvv;
	
	public Card() {
		
	}
	
	public Card(@NotNull String cardName, @NotNull String cardNumber, @NotNull String cardExpiry, @NotNull int cvv) {
		
		super();
		this.cardName = cardName;
		this.cardNumber = cardNumber;
		this.cardExpiry = cardExpiry;
		this.cvv = cvv;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardExpiry() {
		return cardExpiry;
	}

	public void setCardExpiry(String cardExpiry) {
		this.cardExpiry = cardExpiry;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	@Override
	public String toString() {
		return "Card [ cardName=" + cardName + ", cardNumber=" + cardNumber + ", cardExpiry="
				+ cardExpiry + ", cvv=" + cvv + "]";
	}
 	
}


