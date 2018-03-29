package app.app.rule;

import app.abstraction.IRule;
import app.enumic.RuleTypes;

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
