package app.app.rule;

import app.abstraction.IRule;
import app.core.Controller;
import app.model.Card;
import app.model.Player;

import java.util.*;
import java.util.stream.Collectors;

/*
Represents a game rule:
Each player pops their card without thinking,
If the card number matches the previous car number, the player wins the cards on table.
Process runs till all player cards consumed.
 */
public class SameCardWinsRule implements IRule{

    @Override
    public void Execute(List<Player> players, Stack<Card> tableCards) {

        Card playerCard = null;

        while (players.get(players.size()-1).get_hand().size() != 0){

            for (Player pl : players) {

                if (tableCards.isEmpty()){

                    playerCard = pl.throwCard();
                    tableCards.add(playerCard);

                    System.out.println(pl.toString() + " throws " + playerCard.toString());
                    continue;

                }

                playerCard = pl.throwCard();
                System.out.println(pl.toString() + " throws " + playerCard.toString());

                if(tableCards.peek().get_id() == playerCard.get_id()){

                    tableCards.add(playerCard);
                    pl.addPile(tableCards.stream().collect(Collectors.toList()));

                    System.out.println(pl.toString() + " takes collects "+tableCards.size() + " points.");
                    pl.incrementLuckyTourNumber();
                    if(tableCards.size() == 2){

                        System.out.println(pl.toString() + " also made a bonus point");
                        pl.incrementLuckyTourNumber();
                        pl.incrementBonusPoint();

                    }

                    tableCards.clear();
                    continue;

                }

                tableCards.add(playerCard);

            }

        }

        System.out.println("Game Over...");

        System.out.println("Non gained car number :" + tableCards.size());

    }
}
