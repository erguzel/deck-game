package com.erg.deckgame.core;

import com.erg.cpaar.CmdFlag;
import com.erg.cpaar.CmdOption;
import com.erg.cpaar.ParserStarter;
import com.erg.deckgame.rule.RuleFactory;
import com.erg.deckgame.abstraction.RuleTypes;



public class Run {

    public static void main(String[] args) throws Exception {

       new ParserStarter()
            .AddOption(new CmdOption("NumberOfPlayers","-np",Integer.class,false))
               .AddFlag(new CmdFlag("IsStatistics","-st",false))
                .Parse(args);

        Controller.Initialize();

        Controller.Configure(RuleFactory.CreateRule(RuleTypes.SimpleWinnerIntelligent));

        Controller.StartGame();

        if(Controller.getIsStatisticalMode()){

            Controller.RunStatistics();
        }

    }
}
