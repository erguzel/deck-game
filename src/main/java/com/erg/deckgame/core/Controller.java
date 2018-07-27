package com.erg.deckgame.core;

import com.erg.deckgame.abstraction.*;
import com.erg.deckgame.model.Card;
import com.erg.deckgame.model.Player;
import com.erg.cpaar.data.Outputs;


import java.util.*;

/*
Represents the main controller of all dynammic units of the application
 */
public class Controller {
    /*
    For now the game is played by 52 unique deck cards
     */
    private static final int _DeckSize = 52;
    /*
    Each group contains 13 different card rank/numbers by definition (hearts-diamonds...)
     */
    private static final int _GroupSize = 13;
    /*
Represents the player boots playing the game.
    */
    private static List<IPlayer> _players = new ArrayList<IPlayer>();
    /*
    Represents a game rule
     */
    private static IRule _gameRule;
    /*
    Represents number of total players
     */
    private static int numOfPlayers = 2;// default value
    /*
    Boolean swithch to whether show the game results on screen after game.
     */
    private static boolean _isStatisticalMode = false;

    /*
    Gets number of players included in game.
     */
    public static int getNumOfPlayers() {
        return numOfPlayers;
    }

    /*
    Sets the number of players included in game.
     */
    public static void setNumOfPlayers(int numOfPlayers) {
        Controller.numOfPlayers = numOfPlayers;
    }

    /*
    Represents a genuine deck card bundle.
     */
    private static Stack<ICard> _bundle = new Stack<ICard>();

    /*
    Gets current game members/players.
     */
    public static List<IPlayer> get_players() {
        return _players;
    }

    /*
    Initializes the program for parameters and the Deck for the cards.
     */
    public static void Initialize() throws Exception {

        Controller.setNumOfPlayers((int)Outputs.options.get("NumberOfPlayers").get(0));
        Controller.setIsStatisticalMode(Outputs.flags.get("IsStatistics"));

        createDeck();
    }
    /*
    Configures the rule that the game will be implementing.
     */
    public static void Configure(IRule rule) {

        _gameRule = rule;
        setPlayers();
        passCards(_bundle);

    }

    /*
    Starts the game with the choosen rule.
     */
    public static void StartGame() {

        _gameRule.Execute(_players, _bundle);

    }

    /*
    Sets the boot players.
     */
    private static void setPlayers() {

        for (int i = 0; i < Controller.getNumOfPlayers(); i++) {

            _players.add(new Player(i + 1));

        }

    }

    /*
    Creates a unique deck using random number generation approach.
     */
    private static void createDeck() {


        Set<String> __filteredLis = new HashSet<String>();

        Integer hashCode;
        Integer number;
        Integer type;


        // 52 is initial deck size

        while (_bundle.size() < 52) {

            Random rc = new Random();

            Random rt = new Random();

            number = rc.nextInt(_GroupSize);

            type = rt.nextInt(CardTypes.values().length);

            String key = number.toString() + CardTypes.values()[type];

            Card crd = new Card(number, CardTypes.values()[type]);

            boolean isIntheList = __filteredLis.contains(key);

            if (!isIntheList) {

                _bundle.add(crd);
                __filteredLis.add(key);

            }

        }


    }
    /*
    Gets the genuine card bundle.
     */
    public static Stack<ICard> getBundle() {
        return _bundle;
    }
    /*
    Pops a card in the stack collection.
     */
    public static ICard popCard() {

        return _bundle.pop();

    }

    /*
    Pass the genuine numbers among the number of players.
     */
    private static void passCards(Stack<ICard> deckk) {

        for (int a = 0; a < Controller._DeckSize; a++) {

            int playerIndex = a % Controller.numOfPlayers;

            _players.get(playerIndex).acceptCard(deckk.pop());

        }

        System.out.println("cards are passed");

    }

    /*
    Gets the boolean determining if the game status display is on.
     */
    public static boolean getIsStatisticalMode() {
        return _isStatisticalMode;
    }
    /*
    Sets the boolean determining if the game status display is on.
     */
    public static void setIsStatisticalMode(boolean isStatisticalMode) {
        _isStatisticalMode = isStatisticalMode;
    }

    /*
    Prints the player statistics recorded during a unique game.
     */
    public static void RunStatistics() {

        System.out.println("PlayerName      TotalLuckyTours     TotalCollectedCards     TotalBonusPoints");

        for (IPlayer pls : _players) {

            System.out.println(pls.get_name() + "      " + pls.getTotalLuckyTours() + "               " + pls.getTotalCardsCollected() + "                                 " + pls.getbonusPoint());

        }


    }

    /*
    Represents the rule generic logics can be used in different rule implementation.
     */
    public static class RuleController {

        public static RuleTypes get_rtype() {
            return _rtype;
        }

        public static void set_rtype(RuleTypes _rtype) {
            RuleController._rtype = _rtype;
        }

        private static RuleTypes _rtype;
    }

}
