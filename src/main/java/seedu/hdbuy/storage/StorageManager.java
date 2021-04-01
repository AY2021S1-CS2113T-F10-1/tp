package seedu.hdbuy.storage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Logger;

import seedu.hdbuy.common.Unit;
import seedu.hdbuy.data.ShortList;

public class StorageManager {

    private static final String filePath = "./shortlist.txt";

    public static void read() {
        try {
            File f = new File(filePath);
            if (f.createNewFile()) {
                Logger.getLogger("StorageManager").info("Shortlist can be found at: \" + f.getPath()");
            }
            Scanner s = new Scanner(f);
            while (s.hasNext()) {
                String input = s.nextLine();
                if (!input.isEmpty()) {
                    Unit unit = UnitDecoder.textToUnit(input);
                    if (unit != null) {
                        ShortList.addToShortList(unit);
                    }
                }
            }
        } catch (IOException | NullPointerException exception) {
            Logger.getLogger("StorageManager").severe("Unable to locate text file at: \" + f.getPath()");
        }
    }

    public static void write() {
        ArrayList<Unit> units = ShortList.getShortListedUnits();
        try {
            FileWriter fw = new FileWriter(filePath);
            for (Unit unit : units) {
                String unitText = unit.encodeToText();
                if (unitText != null && !unitText.isEmpty()) {
                    fw.write(unitText + "\n");
                }
            }
            fw.close();
        } catch (IOException | NullPointerException exception) {
            Logger.getLogger("StorageManager").severe("Unable to locate text file at: \" + f.getPath()");
        }
    }
}
