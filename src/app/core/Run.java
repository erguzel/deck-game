package app.core;

import app.app.rule.RuleFactory;
import app.enumic.RuleTypes;
import com.prs.abstraction.enumic.ConstraintTypes;
import com.prs.abstraction.interfaces.IOption;
import com.prs.main.CParser;

public class Run {



    public static void main(String[] args) throws Exception {

        CParser cm = new CParser();
        cm.AddOption("-np",Integer.class, ConstraintTypes.Optional)
                .submit("NumberOfPlayers")
                .AddFlag("-st")
                .submit("StatisticalDisplay")
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
