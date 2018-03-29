package app.core;

import app.abstraction.IRule;
import app.enumic.CardTypes;
import app.enumic.RuleTypes;
import app.model.Card;
import app.model.Player;
import app.util.CmdParser;

import java.util.*;
import java.util.concurrent.LinkedTransferQueue;
import java.util.stream.Collectors;

public class Controller {

    private static IRule _gameRule;

    public static int getNumOfPlayers() {
        return numOfPlayers;
    }

    public static void setNumOfPlayers(int numOfPlayers) {
        Controller.numOfPlayers = numOfPlayers;
    }

    private static int numOfPlayers;
    private static Stack<Card> _bundle = new Stack<Card>();

    public static List<Player> get_players() {
        return _players;
    }

    private static List<Player> _players = new ArrayList<Player>();

    private static final int _DeckSize = 52;
    private static final int _GroupSize = 13;

    public static void Initialize(String[] args) throws Exception {

        CmdParser c = new CmdParser(args);
        createDeck();
    }

    public static void Configure(IRule rule) {

        _gameRule = rule;
        setPlayers();
        passCards(_bundle);

    }

    public static void StartGame() {

        _gameRule.Execute(_players, _bundle);

    }

    private static void setPlayers() {

        for (int i = 0; i < Controller.getNumOfPlayers(); i++) {

            _players.add(new Player(i + 1));

        }

    }

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

    public static Stack<Card> getBundle() {
        return _bundle;
    }

    public static Card popCard() {

        return _bundle.pop();

    }

    private static void passCards(Stack<Card> deckk) {

        for (int a = 0; a < Controller._DeckSize; a++) {

            int playerIndex = a % Controller.numOfPlayers;

            _players.get(playerIndex).acceptCard(deckk.pop());

        }

        System.out.println("cards are passed");

    }


    private static boolean _isStatisticalMode;

    public static boolean getIsStatisticalMode(){
        return _isStatisticalMode;
    }

    public static void setIsStatisticalMode(boolean isStatisticalMode){
        _isStatisticalMode = isStatisticalMode;
    }


    public static void RunStatistics() {

        System.out.println("PlayerName      TotalLuckyTours     TotalCollectedCards     TotalBonusPoints");

        for (Player pls : _players) {

            System.out.println(pls.get_name()+"      " + pls.getTotalLuckyTours() + "               " + pls.getTotalCardsCollected()+"                                 "+ pls.getbonusPoint());

        }


    }

    public static class RuleController{

        public static RuleTypes get_rtype() {
            return _rtype;
        }

        public static void set_rtype(RuleTypes _rtype) {
            RuleController._rtype = _rtype;
        }

        private static RuleTypes _rtype;
    }

}
