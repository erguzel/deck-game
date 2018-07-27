package com.erg.deckgame.rule;


import com.erg.deckgame.abstraction.ICard;
import com.erg.deckgame.abstraction.IPlayer;
import com.erg.deckgame.abstraction.IRule;
import com.erg.deckgame.core.Controller;

import java.util.*;
import java.util.stream.Collectors;

/*
Represents a game rule:
Each player throws their card first,
Than whose card is the biggest numbered, it wins
Process runs till all player cards consumed
 */
public class SimpleWinnerRule implements IRule {


    @Override
    public void Execute(List<IPlayer> players, Stack<ICard> cards) {

        while (players.get(players.size()-1).get_hand().size() != 0){

            for (IPlayer pl : players) {

                ICard playerCard = pl.throwCard();

                System.out.println(pl.toString() + " throws " + playerCard.toString());

                if (cards.isEmpty()){

                    cards.add(playerCard);
                    continue;

                }

                cards.add(playerCard);

                if (cards.size() == Controller.getNumOfPlayers()) {

                    ICard winnerCard=cards.stream().max(Comparator.comparing(ICard::get_id)).get();

                    int winnerId = cards.indexOf(winnerCard);

                    IPlayer winnerPlayer = Controller.get_players().get(winnerId);

                    winnerPlayer.addPile(cards.stream().collect(Collectors.toList()));
                    winnerPlayer.incrementLuckyTourNumber();
                    cards.clear();
                    System.out.println(winnerPlayer.toString() +" gets all points on table.");
                    System.out.println("---New tour--");
                    continue;

                }

            }

        }

        System.out.println("Game Over...");

    }
}
