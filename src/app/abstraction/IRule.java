package app.abstraction;

import app.model.Card;
import app.model.Player;

import java.util.List;
import java.util.Stack;

/*
Represents a deck game rule with unique execution logic
 */
public interface IRule {
    /*
    Executes the rule logic with the given player and card collection
     */
    public void Execute(List<Player> players, Stack<Card> gameObject);
}
