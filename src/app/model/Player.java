package app.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class Player {

    public String get_name() {
        return _name;
    }

    public int get_Id() {
        return _Id;
    }

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
    public void acceptCard(Card card) {

        this._hand.add(card);

    }

    public Card throwCard() {

       return _hand.pop();
    }

    public Card throwCardByRule(Card previousCard) throws Exception {

        throw new Exception("not implemented");

    }

    public Player(Integer _Id) {

        this._name = Player.class.getName().concat(_Id.toString());
        this._Id = _Id;
    }

    public void addPile(List<Card> crds){

        _pile.addAll(crds);
    }

    @Override
    public String toString() {

        return this.get_name();

    }

    private int totalLuckyTours;

    /*
    Happens when a player can throw the same card as the previous player for the first time
     */
    private Integer bonusPoint=0;

    public void incrementBonusPoint(){bonusPoint ++;}

    public int getbonusPoint(){

        return bonusPoint;
    }
    public void incrementLuckyTourNumber(){
        totalLuckyTours ++;
    }

    public int getTotalLuckyTours(){
        return totalLuckyTours;
    }

    public int getTotalCardsCollected(){

        return _pile.size();
    }
}

