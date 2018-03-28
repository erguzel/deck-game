package app.app.core;

import app.model.Card;
import app.model.Deck;
import app.model.Player;

import java.util.List;
import java.util.Random;

public class Dealer {

    private int _seed;

    private Deck _deck = new Deck();

    /*
    Todo: in the third edition
     */
    private List<Player> _loosers;

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    // Current players
    private Player player1;
    private Player player2;

    public Dealer(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    /*
    TODO : Not implemented yet
     */
 /*   public Card giveBundleCard(){

      Random rnd = new Random(53);

        for(int k = 1; k < 26; k++){
            System.out.println(rnd.nextInt(52));
        }

    }*/

    public Card giveSingleCard(){

        int seed = this._deck.getBundle().size();

        Random rnd = new Random(seed);


        return this._deck.getBundle().remove(rnd.nextInt());


    }


}
