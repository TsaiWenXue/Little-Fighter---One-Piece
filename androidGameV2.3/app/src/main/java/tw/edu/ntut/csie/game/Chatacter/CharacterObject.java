package tw.edu.ntut.csie.game.Chatacter;

import tw.edu.ntut.csie.game.GameObject;

/**
 * Created by huyuxiang on 2017/4/14.
 */

public interface CharacterObject {
    public void initialize() ;

    public int getX();
    public int getY();

    public void show();

    public void move(int roadPx) ;

    public void release();
}
