package tw.edu.ntut.csie.game.state;

import java.util.ArrayList;

import tw.edu.ntut.csie.game.Enemy.EnemyObject;
import tw.edu.ntut.csie.game.extend.Animation;

/**
 * Created by huyuxiang on 2017/5/4.
 */

public class StageStuffs {
    ArrayList <EnemyObject> enemyList;
    StageBG background;

    public void addObjects(EnemyObject en) {
        enemyList.add(en);
    }
    public void addObjects(StageBG bg) {
        background = bg;
    }

    public void moveAllObjects(int x, int y) {
        for (EnemyObject en : enemyList) {
            en.editLocation(en.getX() + x, en.getY() + y);
        }
        background.editLocation(background.getX() + x, background.getY() + y);
    }

}
