package app.app.rule;


import app.abstraction.IRule;
import app.model.Card;
import app.model.Player;
import app.core.Controller;

import java.util.*;
import java.util.stream.Collectors;

/*
Represents a game rule:
Each player throws their card first,
Than whose card is the biggest numbered, it wins
Process runs till all player cards consumed
 */
public class SimpleWinnerRule implements IRule{


    @Override
    public void Execute(List<Player> players, Stack<Card> cards) {

        while (players.get(players.size()-1).get_hand().size() != 0){

            for (Player pl : players) {

                Card playerCard = pl.throwCard();

                System.out.println(pl.toString() + " throws " + playerCard.toString());

                if (cards.isEmpty()){

                    cards.add(playerCard);
                    continue;

                }

                cards.add(playerCard);

                if (cards.size() == Controller.getNumOfPlayers()) {

                    Card winnerCard=cards.stream().max(Comparator.comparing(Card::get_id)).get();

                    int winnerId = cards.indexOf(winnerCard);

                    Player winnerPlayer = Controller.get_players().get(winnerId);

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
