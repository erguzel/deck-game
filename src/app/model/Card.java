package app.model;

import app.app.enumic.CardTypes;

public class Card {

    public Card() {

    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_type() {
        return _type;
    }

    public void set_type(String _type) {
        this._type = _type;
    }

    public Card(int _id, String _type) {
        this._id = _id;
        this._type = _type;
    }

    private int _id;

    private String _type;

}
