package com.erg.deckgame.rule;

import com.erg.abst.deckgame.IRule;
import com.erg.abst.deckgame.RuleTypes;

/*
Represents the factory for creating different rule parameters programmatically
 */
public class RuleFactory {

    public static IRule CreateRule(RuleTypes ruleType) {

        switch (ruleType) {
            case SameCardWins:
                return new SameCardWinsRule();

            case SimpleWinner:
                return new SimpleWinnerRule();

            case SimpleWinnerIntelligent:
                return new SameCardWinsIntelligentRule();

            default:
               break;
        }

        return null;
    }
}
