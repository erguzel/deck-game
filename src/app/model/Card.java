package app.model;

import app.enumic.CardTypes;
import app.enumic.RankTypes;

public class Card {

    private Integer _id;

    private CardTypes _type;

    public  Card() {

    }

    public Card(Integer _id, CardTypes _type) {
        this._id = _id;
        this._type = _type;
    }

    public Integer get_id() {

        return _id;
    }

    public void set_id(Integer _id) {
        this._id = _id;
    }

    public CardTypes get_type() {
        return _type;
    }

    public void set_type(CardTypes _type) {
        this._type = _type;
    }



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
