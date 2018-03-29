package app.core;

import app.app.rule.RuleFactory;
import app.app.rule.SameCardWinsRule;
import app.app.rule.SimpleWinnerRule;
import app.enumic.RuleTypes;

public class Run {



    public static void main(String[] args) throws Exception {

        Controller.Initialize(args);

        Controller.Configure(RuleFactory.CreateRule(RuleTypes.SameCardWins));

        Controller.StartGame();

        if(Controller.getIsStatisticalMode()){

            Controller.RunStatistics();
        }

        System.out.println("Everything is okay");









    }
}
