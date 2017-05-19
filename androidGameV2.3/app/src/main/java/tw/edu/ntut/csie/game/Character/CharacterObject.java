package tw.edu.ntut.csie.game.Character;

/**
 * Created by huyuxiang on 2017/4/14.
 */

public interface CharacterObject {
    public void initialize() ;

    public int getX();
    public int getY();
    public int getWidth();
    public int getHeight();

    public void show();

    public void move(int roadPx) ;

    public void release();

    public int[] getAttackArea();

    public int getDamage();

    public boolean isAttacking();
    public boolean isAttacking_r();

    public boolean isPerforming();
}
