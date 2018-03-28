package app.model;

import java.util.*;

public class Deck {

    public Deck() {

        createSequentialDeck();
    }

    private List<Card> _bundle =  new ArrayList<Card>();

    /*
    Represents the card types (not know in english written in turkis sorry)
     */
    private List<String> _cardTypes = new ArrayList<String>() {
        {add("Karo");
        add("Kupa");
        add("Maca");
        add("Sinek");}
    };

    /*
    Creates a unique card bundle
     */
    private void createSequentialDeck(){

        Random r = new Random();


        for(int i = 1; i <14 ; i ++){

            for (String type : this._cardTypes){

                Card crd = new Card();

                crd.set_id(i);
                crd.set_type(type);
                this._bundle.add(crd);

            }

        }

    }
    /*
    TODO: in second release
     */
    private boolean createRandomDeck() throws Exception {
        throw  new Exception("create Player object");
    }

    public List<Card> getBundle(){
        return this._bundle;
    }
}
