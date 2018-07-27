package com.erg.deckgame.abstraction;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public interface IPlayer {
    /*
    Gets the name of the player
    */
    String get_name();

    /*
    Gets the unique id of the player.
     */
    int get_Id();


    public Stack<ICard> get_hand();


    /*
    Represents the cars that player holds in hand
     */
    Stack<ICard> _hand = new Stack<ICard>();
    /*
    Represents the cars the player collected after winning
     */
    List<ICard> _pile = new ArrayList<>();

    /*
    Gets total point of a player in any time of the gane
     */
    double get_point();

    /*
    Gets a card passed by dealer
     */
    void acceptCard(ICard card);

    ICard throwCard();

    ICard throwCardByRule(ICard previousCard) throws Exception;

    /*
    Adds a collected of cards to the pile after a winning tour
     */
    void addPile(List<ICard> crds);

    /*
    Increment bonus number of player after a special win
     */
    void incrementBonusPoint();

    /*
    Gets total bonus point of the player
     */
    int getbonusPoint();

    /*
    Increments the number of tours that the player won
     */
    void incrementLuckyTourNumber();

    /*
    Gets the total winning tour number of player
     */
    int getTotalLuckyTours();

    /*
    Gets the total card number collected after winning.
     */
    int getTotalCardsCollected();
}