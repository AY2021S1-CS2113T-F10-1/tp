package seedu.hdbuy;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import seedu.hdbuy.api.ApiRepository;
import seedu.hdbuy.command.Command;
import seedu.hdbuy.data.QueryKey;
import seedu.hdbuy.data.Unit;
import seedu.hdbuy.data.exception.InvalidParameterException;
import seedu.hdbuy.parser.Parser;
import seedu.hdbuy.ui.TextUi;

public class HdBuy {

    private static HashMap<QueryKey,String> inputs = new HashMap<>();
    /**
     * Main entry-point for the java.duke.Duke application.
     */

    public static void main(String[] args) {
        TextUi.showWelcome();
        receiveCommand(false);
        /*
          Example IO
        System.out.println("Parameters: location = jurong, type = 4 room, lease = 95 years\n");
        HashMap<QueryKey,String> inputsExample = new HashMap<>();
        inputs.put(QueryKey.LOCATION, "jurong");
        inputs.put(QueryKey.TYPE, "4 room");
        inputs.put(QueryKey.LEASE_REMAINING, "95");
        HashMap<Integer, Unit> units = ApiRepository.fetchUnits(inputsExample);
         */
    }

    private static void receiveCommand(boolean isExit) {
        if (!isExit) {
            String fullCommand = TextUi.readCommand();
            TextUi.showSeparator();
            Command command = Parser.parse(fullCommand);
            command.execute(inputs);
            TextUi.showSeparator();
            receiveCommand(command.isExit());
        }
    }
}
