package com.erg.deckgame.core;

import com.erg.abst.cpaar.prepare.IParserStarter;
import com.erg.cpaar.prepare.ParseStarter;
import com.erg.deckgame.rule.RuleFactory;
import com.erg.abst.deckgame.RuleTypes;



public class Run {



    public static void main(String[] args) throws Exception {

        IParserStarter ps = new ParseStarter();
        ps.addOption("-np",Integer.class,true)
                .submit("NumberOfPlayers")
                .addFlag("-st")
                .submit("IsStatistics")
                .parse(args);

        Controller.Initialize();

        Controller.Configure(RuleFactory.CreateRule(RuleTypes.SimpleWinnerIntelligent));

        Controller.StartGame();

        if(Controller.getIsStatisticalMode()){

            Controller.RunStatistics();
        }

        System.out.println("Everything is okay");









    }
}
