package tw.edu.ntut.csie.game.Enemy;

import tw.edu.ntut.csie.game.Character.CharacterObject;
import tw.edu.ntut.csie.game.R;
import tw.edu.ntut.csie.game.extend.Animation;
import tw.edu.ntut.csie.game.state.Navigation;
import tw.edu.ntut.csie.game.state.Stage1BG;

/**
 * Created by huyuxiang on 2017/5/4.
 */

public class MarinAI implements EnemyObject {
    private Animation marin;
    private Animation marin_r;
    private Animation marinDead;
    private Animation marinDead_r;
    private Animation marinHit;
    private Animation marinHit_r;
    private Animation marinRun;
    private Animation marinRun_r;
    private Animation marinAttack;
    private Animation marinAttack_r;

    private int px, py;

    private boolean visible = false, visible_r = true;
    private boolean hitVisible = false, hitVisible_r = false;
    private boolean deadVisible = false, deadVisible_r = false;
    private boolean runVisible = false, runVisible_r = false;
    private boolean attackVisible = false, attackVisible_r = false;

    private boolean getHit = false, getHit_r = false;

    private final int maxHealthPoint = 100;
    private int healthPoint = maxHealthPoint;
    private int damage = 10;
    private int[] attackArea = new int[4];

    public MarinAI() {
        marin = new Animation();        marin_r = new Animation();
        marinDead = new Animation();    marinDead_r = new Animation();
        marinHit = new Animation();     marinHit_r = new Animation();
        marinRun = new Animation();     marinRun_r = new Animation();
        marinAttack = new Animation();  marinAttack_r = new Animation();

        px = 600; py = 200;
    }

    public void initialize() {
        addFrame();
        setLocation(px, py);
        setDelay();
        setVisible();
        setRepeating();
        setCurrentIndex();
    }

    public boolean isDead() {
        if (healthPoint <= 0 && (deadVisible||deadVisible_r))
            return true;
        return false;
    }

    public int getX() {return px;}
    public int getY() {return py;}
    public int getDamage() {
        return damage;
    }
    public int[] getAttackArea() {
        return attackArea;
    }
    public boolean isAttacking() {
        return attackVisible;
    }
    public boolean isAttacking_r() {
        return attackVisible_r;
    }

    public void show() {
        marin.show();           marin_r.show();
        marinHit.show();        marinHit_r.show();
        marinDead.show();       marinDead_r.show();
        marinRun.show();        marinRun_r.show();
        marinAttack.show();     marinAttack_r.show();
    }

    public void move(CharacterObject ch, int roadPx) {
        marin.move();           marin_r.move();
        marinHit.move();        marinHit_r.move();
        marinDead.move();       marinDead_r.move();
        marinRun.move();        marinRun_r.move();
        marinAttack.move();     marinAttack_r.move();


        if (healthPoint <= 0) {
            if (marinHit.isLastFrame())
                deadVisible = true;
            else if(marinHit_r.isLastFrame())
                deadVisible_r = true;

        }
        else {
            getHit(ch);
            if (!getHit && !getHit_r && marinAttack.getCurrentFrameIndex() == -1 && marinAttack_r.getCurrentFrameIndex() == -1) {
                moving(ch);
                attack(ch);
            }
        }
        if (roadPx < 800 && roadPx > -800)
            px -= (Navigation.controllerPx - Navigation.initialCtrlPx)/5;

        else if ( (roadPx == 800 && ch.getX() >= 410) ||
                (roadPx == -800 && ch.getX() <= 390) )
            px -= (Navigation.controllerPx -  Navigation.initialCtrlPx)/5;

        if (ch.getX() != 400) {
            px -= ch.getX() - 400;
        }

        setVisible();
        setLocation(px, py);


    }

    public void release() {
        marin.release();        marin_r.release();
        marinHit.release();     marinHit_r.release();
        marinDead.release();    marinDead_r.release();
        marinRun.release();     marinRun_r.release();
        marinAttack.release();  marinAttack_r.release();
    }


    /********************
     * AI Function Area *
     ********************/

    public void attack (CharacterObject ch) {

        if (py + marin.getHeight() >= ch.getY() + ch.getHeight()*3/4 && py <= ch.getY() + ch.getWidth()*3/4) {
            if (px + marin.getWidth() >= ch.getX() && px <= ch.getX()) {
                visible = false;
                visible_r = false;
                runVisible = false;
                runVisible_r = false;
                attackVisible = true;
                marinAttack.reset();
                setAttackArea(marinAttack);
            }
            else if (px <= ch.getX() + ch.getWidth() && px >= ch.getX()){
                visible = false;
                visible_r = false;
                runVisible = false;
                runVisible_r = false;
                attackVisible_r = true;
                marinAttack_r.reset();
                setAttackArea(marinAttack_r);
            }
        }
    }

    public void moving(CharacterObject ch) {
//        attackVisible = false;
//        attackVisible_r = false;
        approachPlayer(ch);
        if (marinAttack.getCurrentFrameIndex()==-1 && marinAttack_r.getCurrentFrameIndex() == -1) {
            setAttackArea();
        }
    }

    //Let marin keep approaching player until player is in the attack area
    public void approachPlayer(CharacterObject ch) {
        if (py + marin.getHeight() < ch.getY() + ch.getHeight()*4/5) {
            py++;
            if (px + marin.getWidth() < ch.getX()) {
                runVisible = true;
                visible = false;
                visible_r = false;
            }
            else {
                runVisible_r = true;
                visible = false;
                visible_r = false;
            }
        }
        else if (py > ch.getY() + ch.getHeight()/3) {
            py--;
            visible = false;
            visible_r = false;
            if (px + marin.getWidth() < ch.getX())
                runVisible = true;
            else
                runVisible_r = true;
        }
        if (px + marin.getWidth() < ch.getX()) {
            visible = false;
            visible_r = false;
            runVisible = true;
            px += 2;
        }
        else if(px > ch.getX() + ch.getWidth()) {
            visible = false;
            visible_r = false;
            runVisible_r = true;
            px -= 2;
        }
        else {
            if(px < ch.getX() + ch.getWidth()/2) {
                visible = true;
                visible_r = false;
                runVisible = false;
                runVisible_r = false;
            }
            else {
                visible = false;
                visible_r = true;
                runVisible = false;
                runVisible_r = false;
            }
        }
    }


    /************************
     * Move Function Area *
     ************************/

    //Set marin's attack area by attack animation
    public void setAttackArea(Animation skill) {
        attackArea[0] = skill.getX();
        attackArea[1] = skill.getY();
        attackArea[2] = skill.getY() + skill.getHeight();
        attackArea[3] = skill.getX() + skill.getWidth();
    }
    //reset marin's attack area
    public void setAttackArea() {
        for(int i = 0; i < 4; i++) {
            attackArea[i] = 0;
        }
    }

    //Set marin's location
    public void setLocation(int x, int y) {
        marin.setLocation(x, y);        marin_r.setLocation(x, y);
        marinHit.setLocation(x, y);     marinHit_r.setLocation(x, y);
        marinDead.setLocation(x, y);    marinDead_r.setLocation(x, y);
        marinRun.setLocation(x, y);     marinRun_r.setLocation(x, y);
        marinAttack.setLocation(x, y);  marinAttack_r.setLocation(x, y);
    }

    //Sett all marin animations visible
    public void setVisible() {
        marin.setVisible(visible);              marin_r.setVisible(visible_r);
        marinHit.setVisible(hitVisible);        marinHit_r.setVisible(hitVisible_r);
        marinDead.setVisible(deadVisible);      marinDead_r.setVisible(deadVisible_r);
        marinRun.setVisible(runVisible);        marinRun_r.setVisible(runVisible_r);
        marinAttack.setVisible(attackVisible);  marinAttack_r.setVisible(attackVisible_r);
    }

    public void getHit(CharacterObject ch) {
//        attackVisible = false;
//        attackVisible_r = false;
        runVisible = false;
        runVisible_r = false;
        if (ch.isAttacking_r()) {
            if (px <= ch.getAttackArea()[3] && px + marin.getWidth() >= ch.getAttackArea()[0] &&
                    py + marin.getHeight() >= ch.getAttackArea()[1] && py <= ch.getAttackArea()[2] &&
                    !getHit) {
                marinHit.reset();
                visible = false;
                visible_r = false;
                hitVisible = true;
                healthPoint -= ch.getDamage();
                getHit = true;
            }
        } else if (ch.isAttacking()) {
            if (px + marin.getWidth() >= ch.getAttackArea()[0] && px <= ch.getAttackArea()[3] &&
                    py + marin.getHeight() >= ch.getAttackArea()[1] && py <= ch.getAttackArea()[2] &&
                    !getHit_r) {
                marinHit_r.reset();
                visible = false;
                visible_r = false;
                hitVisible_r = true;
                healthPoint -= ch.getDamage();
                getHit_r = true;
            }
        }
        if (marinHit.getCurrentFrameIndex() >= 0) {
            px--;
        } else if (marinHit_r.getCurrentFrameIndex() >= 0) {
            px++;
        }
        if (marinHit.getCurrentFrameIndex() == -1 && marinHit_r.getCurrentFrameIndex() == -1) {
            if (getHit_r) {
                visible_r = true;
                hitVisible_r = false;
                getHit_r = false;
            } else if (getHit) {
                visible = true;
                hitVisible = true;
                getHit = false;
            }
        }
    }

    public boolean isInAttackArea(int[] attackArea) {
        if ( px >= attackArea[0] && px <= attackArea[2] &&
                py >= attackArea[1] && py <= attackArea[3])
            return true;
        return false;
    }


    /****************************
     * Initialize Function Area *
     ****************************/

    //Add marin's frames
    public void addFrame() {
        marin.addFrame(R.drawable.marin);
        marin_r.addFrame(R.drawable.marin_r);

        marinHit.addFrame(R.drawable.marin_hit01);
        marinHit.addFrame(R.drawable.marin_hit02);
        marinHit.addFrame(R.drawable.marin_hit03);
        marinHit.addFrame(R.drawable.marin_hit04);
        marinHit.addFrame(R.drawable.marin_hit05);
        marinHit_r.addFrame(R.drawable.marin_hit01_r);
        marinHit_r.addFrame(R.drawable.marin_hit02_r);
        marinHit_r.addFrame(R.drawable.marin_hit03_r);
        marinHit_r.addFrame(R.drawable.marin_hit04_r);
        marinHit_r.addFrame(R.drawable.marin_hit05_r);

        marinDead.addFrame(R.drawable.marin_hit05);
        marinDead_r.addFrame(R.drawable.marin_hit05_r);

        marinRun.addFrame(R.drawable.marin_run01);
        marinRun.addFrame(R.drawable.marin_run02);
        marinRun.addFrame(R.drawable.marin_run03);
        marinRun.addFrame(R.drawable.marin_run04);
        marinRun.addFrame(R.drawable.marin_run03);
        marinRun.addFrame(R.drawable.marin_run02);
        marinRun_r.addFrame(R.drawable.marin_run01_r);
        marinRun_r.addFrame(R.drawable.marin_run02_r);
        marinRun_r.addFrame(R.drawable.marin_run03_r);
        marinRun_r.addFrame(R.drawable.marin_run04_r);
        marinRun_r.addFrame(R.drawable.marin_run03_r);
        marinRun_r.addFrame(R.drawable.marin_run02_r);

        marinAttack.addFrame(R.drawable.marin_attack01);
        marinAttack.addFrame(R.drawable.marin_attack02);
        marinAttack.addFrame(R.drawable.marin_attack03);
        marinAttack.addFrame(R.drawable.marin_attack04);
        marinAttack.addFrame(R.drawable.marin_attack05);
        marinAttack_r.addFrame(R.drawable.marin_attack01_r);
        marinAttack_r.addFrame(R.drawable.marin_attack02_r);
        marinAttack_r.addFrame(R.drawable.marin_attack03_r);
        marinAttack_r.addFrame(R.drawable.marin_attack04_r);
        marinAttack_r.addFrame(R.drawable.marin_attack05_r);
    }

    public void setDelay() {
        marin.setDelay(5);
        marin_r.setDelay(5);
        marinDead.setDelay(5);
        marinDead_r.setDelay(5);
        marinHit.setDelay(4);
        marinHit_r.setDelay(4);
        marinRun.setDelay(2);
        marinRun_r.setDelay(2);
        marinAttack.setDelay(2);
        marinAttack_r.setDelay(2);
    }

    public void setRepeating() {
        marinHit.setRepeating(false);
        marinHit_r.setRepeating(false);
        marinAttack.setRepeating(false);
        marinAttack_r.setRepeating(false);
        marinDead.setRepeating(true);
    }

    public void setCurrentIndex() {
        marinHit.setCurrentFrameIndex(-1);
        marinHit_r.setCurrentFrameIndex(-1);
        marinAttack.setCurrentFrameIndex(-1);
        marinAttack_r.setCurrentFrameIndex(-1);
    }
}
