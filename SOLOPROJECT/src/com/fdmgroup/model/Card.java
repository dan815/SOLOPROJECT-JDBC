package com.fdmgroup.model;

import java.util.*;

public class Card implements IStorable {
private long cardID;
private CardType cardType; 
private Rarity rarity;
private List<Action> cardActions;
private String cardName;

public Card(String cardName) {
	super();
	this.cardName = cardName;
}

public Card(long cardID, CardType cardType, Rarity rarity, List<Action> cardActions, String cardName) {
	super();
	this.cardID = cardID;
	this.cardType = cardType;
	this.rarity = rarity;
	this.cardActions = cardActions;
	this.cardName = cardName;
}

public long getCardID() {
	return cardID;
}

public void setCardID(long cardID) {
	this.cardID = cardID;
}

public CardType getCardType() {
	return cardType;
}

public void setCardType(CardType cardType) {
	this.cardType = cardType;
}

public Rarity getRarity() {
	return rarity;
}

public void setRarity(Rarity rarity) {
	this.rarity = rarity;
}

public List<Action> getCardActions() {
	return cardActions;
}

public void setCardActions(List<Action> cardActions) {
	this.cardActions = cardActions;
}

public String getCardName() {
	return cardName;
}

public void setCardName(String cardName) {
	this.cardName = cardName;
}


}
