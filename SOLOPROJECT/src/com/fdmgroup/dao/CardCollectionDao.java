package com.fdmgroup.dao;

import java.util.*;
import java.util.List;

import com.fdmgroup.model.*;

public class CardCollectionDao implements ICardDao{
	private List<Card> cards = null;
	public CardCollectionDao(){
		super();
		cards = new ArrayList<>();
		cards.add(new Card("Card_1"));
		cards.add(new Card("Card_2"));
	}
	@Override
	public Card create(Card card) {
		Card foundCard = findByCardName(card.getCardName());
		if(foundCard == null){
			cards.add(foundCard);
		}
		
		return null;
	}
	
	@Override
	public Card findById(long id) {
		for(Card card : cards){
			if(card.getCardID()== id){
				return card;
			}
		}
		return null;
	}
	@Override
	public List<Card> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Card update(Card card) {
		Card foundCard = findById(card.getCardID());
		
		if (card.getCardName()!= null && !card.getCardName().isEmpty()) {
			foundCard.setCardType(card.getCardType());
		}
		if (card.getRarity()!= null ) {
			foundCard.setRarity(card.getRarity());
		}
		if (card.getCardType()!= null) {
			foundCard.setCardType(card.getCardType());
		}
		if (card.getCardActions()!= null && card.getCardActions().size()!=0) {
			foundCard.setCardName(card.getCardName());
		}
			
		return foundCard;
	}
	@Override
	public boolean remove(Card card) {
		return cards.remove(card);
	}

	@Override
	public List<Card> findByType(CardType cardType) {
		List<Card> typedCards = new ArrayList<Card>();
		for(Card card : cards){
			if(card.getCardType() == cardType){
				typedCards.add(card);
			}
		}
		return typedCards;
	}
	@Override
	public Card findByCardName(String cardName) {
		for(Card card : cards){
		if(card.getCardName().equals(cardName)){
			return card;
		}
	}
	return null;
	}
	@Override
	public Card findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
