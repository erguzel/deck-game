package app.abstraction;

import app.model.Card;
import app.model.Player;

import java.util.Collection;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public interface IRule {

    public void Execute(List<Player> players, Stack<Card> gameObject);
}
