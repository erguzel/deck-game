package com.erg.com.erg.deckgame.model;

import com.erg.abst.deckgame.CardTypes;
import com.erg.abst.deckgame.ICard;
import com.erg.abst.deckgame.RankTypes;

/*
Represents a unique bundle card
 */
public class Card implements ICard{
    /*
    Represenst the power number of the card (0 to 12)
     */
    private Integer _id;
    /*
    Represents the type of the card (diamonds, spades....)
     */
    private CardTypes _type;

    public  Card() {

    }

    public Card(Integer _id, CardTypes _type) {
        this._id = _id;
        this._type = _type;
    }

    /*
        Gets the power number of the card.
     */
    public Integer get_id() {

        return _id;
    }

    /*
    Sets the power number of the card.
     */
    public void set_id(Integer _id) {
        this._id = _id;
    }

    /*
    Gets the type of the card.
     */
    public CardTypes get_type() {
        return _type;
    }
    /*
    Sets the type of the card
     */
    public void set_type(CardTypes _type) {
        this._type = _type;
    }

    /*
    Gets the rank of the card (king-queen vs)
     */
    public String getRank(){

        if(this._id == 0){

            return RankTypes.AS.toString();

        }

        if(this._id == 10){

            return RankTypes.Price.toString();
        }

        if(this._id == 11){

            return RankTypes.Queen.toString();
        }
        if (this._id == 12){

            return  RankTypes.King.toString();
        }

        return RankTypes.Plain.toString();

    }


    @Override
    public String toString() {

        return this.get_type() + this.get_id().toString();
    }
}
