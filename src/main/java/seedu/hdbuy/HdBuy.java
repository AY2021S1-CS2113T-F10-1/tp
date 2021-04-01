package seedu.hdbuy;

import java.util.logging.Logger;

import seedu.hdbuy.command.Command;
import seedu.hdbuy.data.UserInput;
import seedu.hdbuy.parser.Parser;
import seedu.hdbuy.ui.TextUi;

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
