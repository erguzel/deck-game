package app.app.rule;

import app.abstraction.IRule;
import app.model.Card;
import app.model.Player;

import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class SameCardWinsIntelligentRule implements IRule {
    @Override
    public void Execute(List<Player> players, Stack<Card> gameObject) {
        Card playerCard = null;

        while (players.get(players.size() - 1).get_hand().size() != 0) {

            for (Player pl : players) {

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

                    Card winnerCard = pl.get_hand().stream().filter(a -> a.get_id() == gameObject.peek().get_id()).findFirst().get();

                    pl.get_hand().remove(winnerCard);

                    System.out.println(pl.toString() + " finds the same-number card " + winnerCard.toString() + " and plays it to get points ");

                    gameObject.add(winnerCard);

                    pl.addPile(gameObject.stream().collect(Collectors.toList()));

                    pl.incrementLuckyTourNumber();

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

