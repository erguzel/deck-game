package com.erg.deckgame.rule;

import com.erg.deckgame.abstraction.ICard;
import com.erg.deckgame.abstraction.IPlayer;
import com.erg.deckgame.abstraction.IRule;

import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/*
Represents a game rule:
Each player throws their card according to the previous player card;
if the same card exist in hand, next player throws it and win the points
otherwise pops a next card in hand.
Process runs till all player cards consumed.
 */
public class SameCardWinsIntelligentRule implements IRule {

    @Override
    public void Execute(List<IPlayer> players, Stack<ICard> gameObject) {
        ICard playerCard = null;
        /*
        run logic till the last card of last player
         */
        while (players.get(players.size() - 1).get_hand().size() != 0) {

            for (IPlayer pl : players) {

                if (gameObject.isEmpty()) {

                    playerCard = pl.throwCard();
                    gameObject.add(playerCard);

                    System.out.println(pl.toString() + " throws " + playerCard.toString());
                    continue;

                }

                    /*
                    If the next player have the same number, it throws it to win
                     */
                if (pl.get_hand().stream().anyMatch(a -> a.get_id() == gameObject.peek().get_id())) {

                    ICard winnerCard = pl.get_hand().stream().filter(a -> a.get_id() == gameObject.peek().get_id()).findFirst().get();

                    pl.get_hand().remove(winnerCard);

                    System.out.println(pl.toString() + " finds the same-number card " + winnerCard.toString() + " and plays it to get points ");

                    gameObject.add(winnerCard);

                    /*
                    Add the throwed cards to winner players pocket
                     */
                    pl.addPile(gameObject.stream().collect(Collectors.toList()));

                    pl.incrementLuckyTourNumber();

                    /*
                    If there are only two cards on table, that is considered as bonus which represents extra point
                     */
                    if (gameObject.size() == 2) {

                        System.out.println(pl.toString() + " also made a bonus point");
                        pl.incrementLuckyTourNumber();
                        pl.incrementBonusPoint();
                        gameObject.clear();
                        continue;

                    }

                    gameObject.clear();
                    continue;
                }
                else {
                      playerCard = pl.throwCard();
                    System.out.println(pl.toString() + " throws " + playerCard.toString());
                }

                gameObject.add(playerCard);
                continue;

            }

        }

        System.out.println("Game Over...");

        System.out.println("Non gained car number :" + gameObject.size());

    }


}

