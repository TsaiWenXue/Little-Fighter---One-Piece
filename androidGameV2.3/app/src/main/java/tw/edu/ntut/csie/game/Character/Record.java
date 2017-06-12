package tw.edu.ntut.csie.game.Character;

import java.util.Date;

/**
 * Created by Hsiang on 2017/6/12.
 */

public class Record {
    private static double start;
    public static double time;
    public static int killed;

    //Reset all record information
    public static void reset() {
        start = new Date().getTime();
        killed = 0;
        time = 0;
    }

    //calculate the playing time
    public static void calTime() {
        time = new Date().getTime() - start;
    }
}
