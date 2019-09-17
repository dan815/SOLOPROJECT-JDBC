package com.fdmgroup.dao;

import java.util.List;

import com.fdmgroup.model.*;

public interface ICardDao extends IStorage<Card>, IEditable<Card>, IRemovable<Card>{
public Card findByCardName(String cardName);
public List<Card> findByType(CardType cardType);
public Card findById(long id);
}
