package app.util;

import app.core.Controller;

import java.util.ArrayList;
import java.util.List;

public class CmdParser {

    private int numberOfPlayers;
    boolean isNpProvided = false;
    boolean isStProvided = false;
    private String[] _args;

    private List<String> _Supportedarguments = new ArrayList<String>() {
        {
            add("-np");
            add("-st");
        }
    };

    private List<String> arguments = new ArrayList<>();

    private int _numOfPlayers;

    public CmdParser(String[] _args) throws Exception {

        this._args = _args;
        validateParameters(this._args);
        normalizeParameters();
    }

    private void validateParameters(String[] arguments) throws Exception {

        int numOfPlayers;

        for (String ar : arguments) {

            if (ar.trim().startsWith("-")) {

                boolean isUnSupported = _Supportedarguments.contains(ar)?false:true;

                if (isUnSupported) {

                    throw new Exception("Error:Unsupported argument. The argument " + ar + " not supported");
                }
                this.arguments.add(ar);
            }

            if (ar.trim().equals("-np")) {

                isNpProvided = true;
                continue;

            }
            if (ar.trim().equals("-st")) {
                isStProvided = true;
                Controller.setIsStatisticalMode(true);
                continue;
            }

            if (isStProvided) {

                Controller.setIsStatisticalMode(true);
            }

            if (isNpProvided) {

                try {
                    numOfPlayers = Integer.parseInt(ar);
                } catch (NumberFormatException e) {

                    throw e;
                }

                boolean isBadPlayerNumbers = 52 % numOfPlayers == 0 ? false : true;
                if (isBadPlayerNumbers) {
                    throw new Exception(" Bad player number. I can not pass cards equally.");
                }

                Controller.setNumOfPlayers(numOfPlayers);

            }

        }

        if (!isNpProvided) {
            // defaut num of players
            Controller.setNumOfPlayers(2);
        }

    }

    private void normalizeParameters() throws Exception {

        boolean tooManyParameters = arguments.size() > 3 ? true : false;

        if(tooManyParameters){

            throw new Exception("Error:  There are too many arguments provided.");
        }

    }

}
