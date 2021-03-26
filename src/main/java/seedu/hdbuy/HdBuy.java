package seedu.hdbuy;

import seedu.hdbuy.command.Command;
import seedu.hdbuy.common.QueryKey;
import seedu.hdbuy.data.UserInput;
import seedu.hdbuy.parser.Parser;
import seedu.hdbuy.ui.TextUi;

import java.util.HashMap;
import java.util.logging.Logger;

public class HdBuy {

    private static Logger logger = Logger.getLogger("HDBuy");
    private static UserInput userInput;

    /**
     * Main entry-point for the java.duke.Duke application.
     */

    public static void main(String[] args) {
        logger.info("Starting process");
        userInput = new UserInput();
        TextUi.showWelcome();
        receiveCommand(false);
        cleanUp();
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
            assert userInput != null : "Input is not initiated";
            command.execute(userInput);
            TextUi.showSeparator();
            receiveCommand(command.isExit());
        }
    }

    private static void cleanUp() {
        userInput = null;
        logger = null;
    }
}
