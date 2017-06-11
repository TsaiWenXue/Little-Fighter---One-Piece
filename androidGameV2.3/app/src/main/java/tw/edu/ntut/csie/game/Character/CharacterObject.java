package tw.edu.ntut.csie.game.Character;

import java.util.ArrayList;

import tw.edu.ntut.csie.game.Enemy.AttackObject;
import tw.edu.ntut.csie.game.R;
import tw.edu.ntut.csie.game.core.MovingBitmap;

/**
 * Created by huyuxiang on 2017/4/14.
 */

public interface CharacterObject {
    public ArrayList<MovingBitmap> hp = new ArrayList<MovingBitmap>();
    public MovingBitmap hpBg = new MovingBitmap(R.drawable.healthpoint_bg);

    public void initialize() ;

    public int getX();
    public int getY();
    public int getWidth();
    public int getHeight();
    public int getHp();


    public void show();

    public void move(int roadPx) ;

    public void release();

    public int[] getAttackArea();

    public int getDamage();

    public boolean isAttacking();
    public boolean isAttacking_r();
    public boolean isNotPerforming();
    public void setSecondModelVisible();
    public boolean isDead();

    public void getHit(ArrayList<AttackObject> at, int roadPx);
    public boolean getHitting();
}
