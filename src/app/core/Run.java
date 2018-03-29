package app.core;

import app.app.rule.SameCardWinsRule;
import app.app.rule.SimpleWinnerRule;

public class Run {



    public static void main(String[] args) throws Exception {

        Controller.Initialize(args);

        Controller.Configure(new SameCardWinsRule());

        Controller.StartGame();

        if(Controller.getIsStatisticalMode()){

            Controller.RunStatistics();
        }

        System.out.println("Everything is okay");









    }
}
