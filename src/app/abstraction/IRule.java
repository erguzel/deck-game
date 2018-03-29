package app.abstraction;

import app.model.Card;
import app.model.Player;

import java.util.Collection;
import java.util.List;
import java.util.Queue;

public interface IRule {

    public void Execute(List<Player> players, List<Card> gameObject);
}
