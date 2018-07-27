package com.erg.deckgame.abstraction;

public interface ICard {


    /*
     Gets the power number of the card.
     */
    Integer get_id();

    /*
    Sets the power number of the card.
     */
    void set_id(Integer _id);

    /*
    Gets the type of the card.
     */
    CardTypes get_type();

    /*
    Sets the type of the card
     */
    void set_type(CardTypes _type);

    /*
    Gets the rank of the card (king-queen vs)
     */
    String getRank();

}
