package tw.edu.ntut.csie.game.Enemy;


import tw.edu.ntut.csie.game.Character.CharacterObject;

/**
 * Created by huyuxiang on 2017/4/21.
 */

public interface EnemyObject {
    public void initialize() ;

    public int getX();
    public int getY();

    public void show();

    public void move(CharacterObject ch) ;

    public void release();
}
