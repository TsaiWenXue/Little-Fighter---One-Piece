package tw.edu.ntut.csie.game.state;

import tw.edu.ntut.csie.game.core.MovingBitmap;
import tw.edu.ntut.csie.game.extend.Animation;
import tw.edu.ntut.csie.game.GameObject;


public class Enemy {
    private MovingBitmap enemy;
    private MovingBitmap enemy_r;
    private Animation enemyRun;
    private Animation enemyRun_r;
    private Animation enemyAttack;
    private Animation enemyAttack_r;
    private Animation enemyHit;
    private Animation enemyHit_r;

    private int healthPoint = 100;
    private int px, py;
    private boolean run = false, run_r = false;
    private boolean visible = false, visible_r = false;
    private boolean getHit = false, getHit_r = false;

    public Enemy() {
        enemy = new MovingBitmap();
        enemy_r = new MovingBitmap();

        enemyRun = new Animation();
        enemyRun_r = new Animation();
        enemyAttack = new Animation();
        enemyAttack_r = new Animation();
        enemyHit = new Animation();
        enemyHit_r = new Animation();

        px = 600; py = 200;
    }


    //enemyaracter normal bitmap loadin
    public void loadNormal(int resId) {
        enemy.loadBitmap(resId);
    }
    public void loadNormalReverse(int resId) {
        enemy_r.loadBitmap(resId);
    }

    //enemyaracter Run add frame
    public void addRun(int resId) {
        enemyRun.addFrame(resId);
    }
    public void addRunReverse(int resId) {
        enemyRun_r.addFrame(resId);
    }

    //enemyaracter Attack add frame
    public void addAttack(int resId) {
        enemyAttack.addFrame(resId);
    }
    public void addAttackReverse(int resId) {
        enemyAttack_r.addFrame(resId);
    }
    public void addHit(int resId) {
        enemyHit.addFrame(resId);
    }
    public void addHit_r(int resId) {
        enemyHit_r.addFrame(resId);
    }


    public void initialize() {
        visible = true;
        visible_r = false;
        run = false;
        run_r = false;

        enemy.setLocation(px, py);
        enemy_r.setVisible(visible_r);

        enemyAttack.setDelay(1);
        enemyAttack.setRepeating(false);
        enemyAttack.setDelay(1);
        enemyAttack_r.setRepeating(false);

        enemyRun.setVisible(run);
        enemyRun.setDelay(2);
        enemyRun_r.setVisible(run_r);
        enemyRun_r.setDelay(2);
        enemyAttack.setVisible(Button.atPointerPressed);
        enemyAttack_r.setVisible(Button.atPointerPressed);

        enemyHit.setVisible(getHit);
        enemyHit.setDelay(3);
        enemyHit.setRepeating(false);
        enemyHit_r.setVisible(getHit_r);
        enemyHit_r.setDelay(3);
        enemyHit_r.setRepeating(false);
    }

    public int getX() {
            return enemy.getX();
    }
    public int getY() {
        return enemy.getY();
    }

    public void show(){
        enemy.show();
        enemy_r.show();
        enemyRun.show();
        enemyRun_r.show();
        enemyAttack.show();
        enemyAttack_r.show();
        enemyHit.show();
        enemyHit_r.show();
    }

    public void move(Character ch) {
        enemyRun.move();
        enemyRun_r.move();
        enemyAttack.move();
        enemyAttack_r.move();
        enemyHit.move();
        enemyHit_r.move();

//        if(ch.attack())
    //        hit(ch);

        if (Stage1BG.roadPx < 800 && Stage1BG.roadPx > -800)
            px -= (Navigation.controllerPx - Navigation.initialCtrlPx)/5;
        if (Stage1BG.roadPx > 800)
            px = 800;
        else if (Stage1BG.roadPx < -800)
            px = -800;
        else if ( (Stage1BG.roadPx == 800 && ch.getX() >= 410) ||
                  (Stage1BG.roadPx == -800 && ch.getX() <= 390) )
            px -= (Navigation.controllerPx -  Navigation.initialCtrlPx)/5;
        enemySetLocatioin(px, py);
    }

    public boolean isHit(Character ch) {
        return ( px <= ch.attackArea[3] &&
                 (py >= ch.attackArea[1] || py + enemy.getHeight() <= ch.attackArea[2]) );
    }
    public boolean isHit_r(Character ch) {
        return ( px + enemy.getWidth() >= ch.attackArea[0] &&
                 (py >= ch.attackArea[1] || py + enemy.getHeight() <= ch.attackArea[2]) );
    }

    public void hit(Character ch) {
        enemy.setVisible(false);
        enemy_r.setVisible(false);
        enemyRun.setVisible(false);
        enemyRun_r.setVisible(false);
        enemyAttack.setVisible(false);
        enemyAttack_r.setVisible(false);
        if (isHit(ch) && getHit_r == false) {
            getHit = true;
            enemyHit.setVisible(getHit);
            enemyHit.reset();
        }
        else if (isHit_r(ch) && getHit == false){
            getHit_r = true;
            enemyHit_r.setVisible(getHit_r);
            enemyHit_r.reset();
        }
        if (getHit) {
            px+=2;
        }
        else if(getHit_r) {
            px-=2;
        }
        enemySetLocatioin(px, py);
        if (enemyHit.isLastFrame()){
            getHit = false;
            enemy_r.setVisible(true);
        }
        if (enemyHit_r.isLastFrame()){
            getHit_r = false;
            enemy.setVisible(true);
        }
    }

    public void release(){
        enemy.release();
        enemy = null;
        enemyRun.release();
        enemyRun = null;
        enemyRun_r.release();
        enemyRun_r = null;
        enemyAttack.release();
        enemyAttack = null;
        enemyAttack_r.release();
        enemyAttack_r = null;

        //enemy_r.release();
        enemy_r = null;
    }

    public void enemySetLocatioin(int x, int y) {
        enemy.setLocation(x, y);
        enemy_r.setLocation(x, y);
        enemyRun.setLocation(x, y);
        enemyRun_r.setLocation(x, y);
        enemyAttack.setLocation(x, y);
        enemyAttack_r.setLocation(x, y);
        enemyHit.setLocation(x, y);
        enemyHit_r.setLocation(x, y);
    }
}
