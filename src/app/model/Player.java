package app.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Player {

    private String _name;

    private int _Id;

    private double _point;

    public Stack<Card> get_hand() {
        return _hand;
    }

    /*
        For LIFO putpose
         */
    private Stack<Card> _hand = new Stack<Card>();


    private List<Card> _pile = new ArrayList<>();

    /*
    Gets total point of a player in any time of the gane
     */
    public double get_point() {

        return _pile.size();
    }

    /*
    Gets a card passed by dealer
     */
    public void acceptCard(Card card){

        this._hand.add(card);

    }

    public Player(String _name, int _Id) {
        this._name = _name;
        this._Id = _Id;
    }
}
