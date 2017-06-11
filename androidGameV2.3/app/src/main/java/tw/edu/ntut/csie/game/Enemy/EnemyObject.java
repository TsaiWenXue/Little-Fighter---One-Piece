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

    public void move(CharacterObject ch, int roadPx) ;
    public int getDamage();
    public int[] getAttackArea();
    public boolean isAttacking();
    public boolean isAttacking_r();

    public void release();
    public boolean isDead();
}
