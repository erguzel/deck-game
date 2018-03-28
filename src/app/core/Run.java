package app.core;

import app.app.core.Dealer;
import app.model.Card;
import app.model.Deck;
import app.model.Player;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Random;

public class Run {

    public static void main(String[] args){

        Player p1 = new Player("looser1",1);

        Player p2 = new Player("looser2", 2);

        Dealer winner = new Dealer(p1,p2);

        feedPlayer(winner, p1);

        feedPlayer(winner,p2);

        for (Card card1: winner.getPlayer1().get_hand()){

            for(Card card2 : winner.getPlayer2().get_hand()){

                boolean IsPlayer1Get = (card1.get_id() > card2.get_id())? true: false;

                if (IsPlayer1Get){

                    
                }


            }



        }



    }

     static void feedPlayer(Dealer winner, Player player){

        for(int j = 1; j < 25; j++){

            player.acceptCard(winner.giveSingleCard());

        }

    }
}
