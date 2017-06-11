package tw.edu.ntut.csie.game.Character;

import java.util.ArrayList;

import tw.edu.ntut.csie.game.R;
import tw.edu.ntut.csie.game.core.MovingBitmap;
import tw.edu.ntut.csie.game.extend.Animation;
import tw.edu.ntut.csie.game.state.Button;
import tw.edu.ntut.csie.game.state.Navigation;
import tw.edu.ntut.csie.game.Enemy.AttackObject;

/**
 * Created by huyuxiang on 2017/4/14.
 */

public class Luffy implements CharacterObject {
    private Animation luffy;
    private Animation luffy_r;
    private Animation luffyRun;
    private Animation luffyRun_r;
    private Animation luffyAttack;
    private Animation luffyAttack_r;
    private Animation luffyDefend;
    private Animation luffyDefend_r;
    private Animation luffyJump;
    private Animation luffyJump_r;
    private Animation luffyESkill;
    private Animation luffyESkill_r;
    private Animation luffyGSkill;
    private Animation luffyGSkill_r;
    private Animation luffyFSkill;
    private Animation luffyFSkill_r;
    private Animation luffyHit;
    private Animation luffyHit_r;

    private Animation sluffy;
    private Animation sluffy_r;
    private Animation sluffyRun;
    private Animation sluffyRun_r;
    private Animation sluffyAttack;
    private Animation sluffyAttack_r;
    private Animation sluffyDefend;
    private Animation sluffyDefend_r;
    private Animation sluffyJump;
    private Animation sluffyJump_r;
    private Animation sluffyESkill;
    private Animation sluffyESkill_r;
    private Animation sluffyGSkill;
    private Animation sluffyGSkill_r;
    private Animation sluffyFSkill;
    private Animation sluffyFSkill_r;
    private Animation sluffySSkill;
    private Animation sluffySSkill_r;


    private MovingBitmap luffy_small;

    private int px, py;
    private final int maxHp = 200;
    private int healthPoint;

    private boolean visible = true, visible_r = false;
    private boolean sec_visible = false;
    private boolean first_S_touch = false;
    private boolean sec_visible_r = false;
    private boolean runVisible = false, runVisible_r = false;
    private boolean hitVisible = false, hitVisible_r = false;

    public boolean attacking = false, attacking_r = false;
    private boolean defending = false, defending_r = false;
    private boolean jumping = false, jumping_r = false;
    private boolean ESkilling = false, ESkilling_r = false;
    private boolean GSkilling = false, GSkilling_r = false;
    private boolean FSkilling = false, FSkilling_r = false;
    private boolean SSkilling = false, SSkilling_r = false;

    public boolean isAttacking() {
        if (attacking || ESkilling || FSkilling || GSkilling || SSkilling)
            return true;
        return false;
    }

    public boolean isAttacking_r() {
        if (attacking_r || ESkilling_r || FSkilling_r || GSkilling_r || SSkilling_r)
            return true;
        return false;
    }


    private int[] attackArea = new int[4];
    private int damage = 0;


    public Luffy () {
        luffy_small = new MovingBitmap(R.drawable.luffy_s);
        luffy_small.setLocation(9, 18);

        luffy = new Animation();
        luffy_r = new Animation();

        luffyRun = new Animation();
        luffyRun_r = new Animation();
        luffyAttack = new Animation();
        luffyAttack_r = new Animation();
        luffyDefend = new Animation();
        luffyDefend_r = new Animation();
        luffyJump = new Animation();
        luffyJump_r = new Animation();
        luffyESkill = new Animation();
        luffyESkill_r =new Animation();
        luffyGSkill = new Animation();
        luffyGSkill_r = new Animation();
        luffyFSkill = new Animation();
        luffyFSkill_r = new Animation();
        luffyHit = new Animation();
        luffyHit_r = new Animation();

        for (int i = 0 ; i < 100; i++) {
            hp.add(new MovingBitmap(R.drawable.healthpoint));
            hp.get(i).setLocation(50 + i, 50);
        }
        hpBg.setLocation(49, 50);

        sluffy = new Animation();
        sluffy_r = new Animation();

        sluffyRun = new Animation();
        sluffyRun_r = new Animation();
        sluffyAttack = new Animation();
        sluffyAttack_r = new Animation();
        sluffyDefend = new Animation();
        sluffyDefend_r = new Animation();
        sluffyJump = new Animation();
        sluffyJump_r = new Animation();
        sluffyESkill = new Animation();
        sluffyESkill_r =new Animation();
        sluffyGSkill = new Animation();
        sluffyGSkill_r = new Animation();
        sluffyFSkill = new Animation();
        sluffyFSkill_r = new Animation();
        sluffySSkill = new Animation();
        sluffySSkill_r = new Animation();

        px = 400; py = 200;
    }

    public void initialize(){
        healthPoint = maxHp;
        addFrame();
        frameDelay();
        frameRepeating();
        setVisible();
        setCurrentIndex(-1);
        setLocation(px, py);

        secFrameDelay();
        secAddFrame();
        secFrameRepeating();
        secSetVisible();
        secSetCurrentIndex(-1);
        secSetLocation(px, py);
    }

    public int getX() {
        return px;
    }
    public int getY() {
        return py;
    }
    public int getWidth() {
        return luffy.getWidth();
    }
    public int getHeight() {
        return  luffy.getHeight();
    }
    public int getDamage() {return damage;}
    public int getHp() {
        return healthPoint;
    }
    public boolean isDead() {
        return !(hp.get(0).isVisible());
    }

    public int[] getAttackArea() {
        return attackArea;
    }
    public boolean getHitting() {
        return !(luffyHit.getCurrentFrameIndex() == -1 && luffyHit_r.getCurrentFrameIndex() == -1);
    }

    public void show() {
        luffy.show();           luffy_r.show();
        luffyRun.show();        luffyRun_r.show();
        luffyAttack.show();     luffyAttack_r.show();
        luffyDefend.show();     luffyDefend_r.show();
        luffyJump.show();       luffyJump_r.show();
        luffyESkill.show();     luffyESkill_r.show();
        luffyGSkill.show();     luffyGSkill_r.show();
        luffyFSkill.show();     luffyFSkill_r.show();
        luffyHit.show();        luffyHit_r.show();

        sluffy.show();           sluffy_r.show();
        sluffyRun.show();        sluffyRun_r.show();
        sluffyAttack.show();     sluffyAttack_r.show();
        sluffyDefend.show();     sluffyDefend_r.show();
        sluffyJump.show();       sluffyJump_r.show();
        sluffyESkill.show();     sluffyESkill_r.show();
        sluffyGSkill.show();     sluffyGSkill_r.show();
        sluffyFSkill.show();     sluffyFSkill_r.show();
        sluffySSkill.show();     sluffySSkill_r.show();


        hpBg.show();    luffy_small.show();
        for (int i = 0; i < 100; i++) {
            hp.get(i).show();
        }
    }

    public void move(int roadPx) {
        if(!Button.fire_bool){
            luffy.move();           luffy_r.move();
            luffyRun.move();        luffyRun_r.move();
            luffyAttack.move();     luffyAttack_r.move();
            luffyDefend.move();     luffyDefend_r.move();
            luffyJump.move();       luffyJump_r.move();
            luffyESkill.move();     luffyESkill_r.move();
            luffyGSkill.move();     luffyGSkill_r.move();
            luffyFSkill.move();     luffyFSkill_r.move();

            for (int i = 0; i < 100; i++) {
                if (i < 100*healthPoint/maxHp)
                    hp.get(i).setVisible(true);
                else
                    hp.get(i).setVisible(false);
            }

            if ( !(attacking || attacking_r || ESkilling || ESkilling_r ||
                   GSkilling || GSkilling_r || FSkilling || FSkilling_r ||
                   jumping || jumping_r || defending || defending_r) ){
                   running(roadPx);
               }

            setLocation(px, py);
            stopRunning();

            attack();
            jump();
            defend();

            ESkill();
            GSkill();
            FSkill();

            if ( !(attacking || attacking_r || ESkilling || ESkilling_r ||
                   GSkilling || GSkilling_r || FSkilling || FSkilling_r) )
                setAttackArea();

        }
        else if(Button.fire_bool){
            setInvisible();
            sluffy.setVisible(sec_visible);
            sluffy.move();     sluffy_r.move();
            sluffyRun.move();        sluffyRun_r.move();
            sluffyAttack.move();     sluffyAttack_r.move();
            sluffyDefend.move();     sluffyDefend_r.move();
            sluffyJump.move();       sluffyJump_r.move();
            sluffyESkill.move();     sluffyESkill_r.move();
            sluffyGSkill.move();     sluffyGSkill_r.move();
            sluffyFSkill.move();     sluffyFSkill_r.move();
            sluffySSkill.move();     sluffySSkill_r.move();

            for (int i = 0; i < 100; i++) {
                if (i < 100*healthPoint/maxHp)
                    hp.get(i).setVisible(true);
                else
                    hp.get(i).setVisible(false);
            }

            if ( !(attacking || attacking_r || ESkilling || ESkilling_r ||
                   GSkilling || GSkilling_r || FSkilling || FSkilling_r ||
                   jumping || jumping_r || defending || defending_r) ){
                   secRunning(roadPx);
               }

            secSetLocation(px, py);
            secStopRunning();

            secAttack();
            secJump();
            secDefend();

            secESkill();
            secGSkill();
            secFSkill();
            secSSkill();

            if ( !(attacking || attacking_r || ESkilling || ESkilling_r ||
                   GSkilling || GSkilling_r || FSkilling || FSkilling_r) )
                setAttackArea();
            }

    }

    public void release() {
        luffy.release();            luffy_r.release();
        luffyRun.release();         luffyRun_r.release();
        luffyAttack.release();      luffyAttack_r.release();
        luffyDefend.release();      luffyDefend_r.release();
        luffyJump.release();        luffyJump_r.release();
        luffyESkill.release();      luffyESkill_r.release();
        luffyGSkill.release();      luffyGSkill_r.release();
        luffyFSkill.release();      luffyFSkill_r.release();

        for (int i = 0; i < hp.size(); i++) {
            hp.get(i).release();
        }
    }

     /*************************
      * Get Hit Function Area *
      *************************/
     public void getHit(ArrayList<AttackObject> attacks, int roadPx) {
//         if (luffyHit.getCurrentFrameIndex() == -1)
//             hitVisible = false;
//         if (luffyHit_r.getCurrentFrameIndex() == -1)
//             hitVisible_r = false;
         luffyHit.move();        luffyHit_r.move();
         if (!hitVisible && !hitVisible_r)
             for (AttackObject at : attacks) {
                 if (at.isAttacking() && isInAttackArea(at.getAttackArea())) {
                     healthPoint -= at.damage;
                     setInvisible();
                     hitVisible_r = true;
                     luffyHit_r.setVisible(hitVisible_r);
                     luffyHit_r.reset();

                     notRunning(roadPx);

                     break;
                 }
                 else if (at.isAttacking_r() && isInAttackArea(at.getAttackArea())) {
                     healthPoint -= at.damage;
                     setInvisible();
                     hitVisible = true;
                     luffyHit.setVisible(hitVisible);
                     luffyHit.reset();

                     notRunning(roadPx);

                     break;
                 }
             }

         if (roadPx != 800 && roadPx != -800 && px != 400)
             px = 400;
         if (luffyHit.getCurrentFrameIndex() >= 0) {
             px -= 40;
             if (px < 0)
                 px = 0;
             setLocation(px, py);
         } else if (luffyHit_r.getCurrentFrameIndex() >= 0) {
             px += 40;
             if (px > 800 - luffy.getWidth())
                 px = 800 - luffy.getWidth();
             setLocation(px, py);
         }
         if (luffyHit.getCurrentFrameIndex() == -1 && luffyHit_r.getCurrentFrameIndex() == -1) {
             if (hitVisible) {
                 visible = true;
                 hitVisible = false;
             } else if (hitVisible_r) {
                 visible_r = true;
                 hitVisible_r = false;
             }
             setVisible();
         }
     }

     public boolean isInAttackArea(int[] attackArea) {
         if ( px + luffy.getWidth() >= attackArea[0] && px <= attackArea[3] &&
                 py + luffy.getWidth() >= attackArea[1] && py <= attackArea[2])
             return true;
         return false;
     }

     public void notRunning(int roadPx) {
         py -= (Navigation.controllerPy - Navigation.initialCtrlPy)/10;
         if (py < 175 || py > 375)
             py += (Navigation.controllerPy - Navigation.initialCtrlPy)/10;
         if (roadPx == 800 || roadPx == -800)
             px -= (Navigation.controllerPx -  Navigation.initialCtrlPx)/5;
         if (px > 750 || px < 0)
             px += (Navigation.controllerPx -  Navigation.initialCtrlPx)/5;
         else if (roadPx < 800 && px < 400)
             px--;
         else if (roadPx > -800 && px > 400)
             px++;
     }



     /**********************
      * Move Function Area *
      **********************/

    public void setLocation(int x, int y) {
        luffy.setLocation(x, y);            luffy_r.setLocation(x, y);
        luffyRun.setLocation(x, y);         luffyRun_r.setLocation(x, y);
        luffyAttack.setLocation(x, y);      luffyAttack_r.setLocation(x, y);
        luffyDefend.setLocation(x, y);      luffyDefend_r.setLocation(x, y);
        luffyJump.setLocation(x, y);        luffyJump_r.setLocation(x, y);
        luffyESkill.setLocation(x, y);      luffyESkill_r.setLocation(x, y);
        luffyGSkill.setLocation(x, y);      luffyGSkill_r.setLocation(x, y);
        luffyFSkill.setLocation(x, y);      luffyFSkill_r.setLocation(x, y);
        luffyHit.setLocation(x, y);         luffyHit_r.setLocation(x, y);
    }

    public void secSetLocation(int x, int y){
        sluffy.setLocation(x, y);      sluffy_r.setLocation(x, y);
        sluffyRun.setLocation(x, y);         sluffyRun_r.setLocation(x, y);
        sluffyAttack.setLocation(x, y);      sluffyAttack_r.setLocation(x, y);
        sluffyDefend.setLocation(x, y);      sluffyDefend_r.setLocation(x, y);
        sluffyJump.setLocation(x, y);        sluffyJump_r.setLocation(x, y);
        sluffyESkill.setLocation(x, y);      sluffyESkill_r.setLocation(x, y);
        sluffyGSkill.setLocation(x, y);      sluffyGSkill_r.setLocation(x, y);
        sluffyFSkill.setLocation(x, y);      sluffyFSkill_r.setLocation(x, y);
        sluffySSkill.setLocation(x, y);      sluffySSkill_r.setLocation(x, y);
    }

    //Let luffy run according to Navigarion
    public void running(int roadPx) {
        moving(roadPx);
        //decide Character face direction with Navigation
        if (Navigation.controllerPx - Navigation.initialCtrlPx < 0) {
            visible = false;
            visible_r = false;
            runVisible = false;
            runVisible_r = true;

            luffy.setVisible(visible);
            luffy_r.setVisible(visible_r);
            luffyRun.setVisible(runVisible);
            luffyRun_r.setVisible(runVisible_r);
        }
        else if (Navigation.controllerPx - Navigation.initialCtrlPx > 0) {
            visible = false;
            visible_r = false;
            runVisible = true;
            runVisible_r = false;

            luffy.setVisible(visible);
            luffy_r.setVisible(visible_r);
            luffyRun.setVisible(runVisible);
            luffyRun_r.setVisible(runVisible_r);
        }
    }

    public void secRunning(int roadPx){
        moving(roadPx);
        if (Navigation.controllerPx - Navigation.initialCtrlPx < 0) {
            sec_visible = false;
            sec_visible_r = false;
            runVisible = false;
            runVisible_r = true;

            sluffy.setVisible(sec_visible);
            sluffy_r.setVisible(sec_visible_r);
            sluffyRun.setVisible(runVisible);
            sluffyRun_r.setVisible(runVisible_r);
        }
        else if (Navigation.controllerPx - Navigation.initialCtrlPx > 0) {
            sec_visible = false;
            sec_visible_r = false;
            runVisible = true;
            runVisible_r = false;

            sluffy.setVisible(sec_visible);
            sluffy_r.setVisible(sec_visible_r);
            sluffyRun.setVisible(runVisible);
            sluffyRun_r.setVisible(runVisible_r);
        }
    }

    //Let luffy stop running according to Navigation and which side luffy faced
    public void stopRunning() {
        if (Navigation.controllerPx - Navigation.initialCtrlPx == 0 && runVisible_r == true) {
            visible = false;
            visible_r = true;
            runVisible = false;
            runVisible_r = false;

            luffy.setVisible(visible);
            luffy_r.setVisible(visible_r);
            luffyRun.setVisible(runVisible);
            luffyRun_r.setVisible(runVisible_r);
        }
        else if (Navigation.controllerPx - Navigation.initialCtrlPx == 0 && runVisible == true) {
            visible = true;
            visible_r = false;
            runVisible = false;
            runVisible_r = false;

            luffy_r.setVisible(visible_r);
            luffyRun.setVisible(runVisible);
            luffyRun_r.setVisible(runVisible_r);
            luffy.setVisible(visible);
        }
    }

    public void secStopRunning(){
        if (Navigation.controllerPx - Navigation.initialCtrlPx == 0 && runVisible_r == true) {
            sec_visible = false;
            sec_visible_r = true;
            runVisible = false;
            runVisible_r = false;

            sluffy.setVisible(sec_visible);
            sluffy_r.setVisible(sec_visible_r);
            sluffyRun.setVisible(runVisible);
            sluffyRun_r.setVisible(runVisible_r);
        }
        else if (Navigation.controllerPx - Navigation.initialCtrlPx == 0 && runVisible == true) {
            sec_visible = true;
            sec_visible_r = false;
            runVisible = false;
            runVisible_r = false;

            sluffy_r.setVisible(sec_visible_r);
            sluffyRun.setVisible(runVisible);
            sluffyRun_r.setVisible(runVisible_r);
            sluffy.setVisible(sec_visible);
        }
    }

    //Let all luffy move according to Navigation location
    public void moving(int roadPx) {
        py += (Navigation.controllerPy - Navigation.initialCtrlPy)/10;
        if (py < 175 || py > 375)
            py -= (Navigation.controllerPy - Navigation.initialCtrlPy)/10;
        if (roadPx == 800 || roadPx == -800)
            px += (Navigation.controllerPx -  Navigation.initialCtrlPx)/5;
        if (px > 800 - luffy.getWidth()  || px < 0)
            px -= (Navigation.controllerPx -  Navigation.initialCtrlPx)/5;
        else if (roadPx != 800 && roadPx != -800 && px != 400)
            px = 400;
    }

    //Set all luffy visible
    public void setVisible() {

        luffy.setVisible(visible);
        luffy_r.setVisible(visible_r);

        luffyRun.setVisible(runVisible);
        luffyRun_r.setVisible(runVisible_r);
        luffyAttack.setVisible(false);
        luffyAttack_r.setVisible(false);
        luffyDefend.setVisible(false);
        luffyDefend_r.setVisible(false);
        luffyJump.setVisible(false);
        luffyJump_r.setVisible(false);
        luffyESkill.setVisible(false);
        luffyESkill_r.setVisible(false);
        luffyGSkill.setVisible(false);
        luffyGSkill_r.setVisible(false);
        luffyFSkill.setVisible(false);
        luffyFSkill_r.setVisible(false);
        luffyHit.setVisible(hitVisible);
        luffyHit_r.setVisible(hitVisible_r);

        sluffy.setVisible(sec_visible);
        sluffy_r.setVisible(sec_visible_r);
    }

    public void setInvisible(){
        luffy.setVisible(false);
        luffy_r.setVisible(false);
        luffyRun.setVisible(false);
        luffyRun_r.setVisible(false);
        luffyAttack.setVisible(false);
        luffyAttack_r.setVisible(false);
        luffyDefend.setVisible(false);
        luffyDefend_r.setVisible(false);
        luffyJump.setVisible(false);
        luffyJump_r.setVisible(false);
        luffyESkill.setVisible(false);
        luffyESkill_r.setVisible(false);
        luffyGSkill.setVisible(false);
        luffyGSkill_r.setVisible(false);
        luffyFSkill.setVisible(false);
        luffyFSkill_r.setVisible(false);
    }
    public void secSetVisible() {

        sluffy.setVisible(sec_visible);
        sluffy_r.setVisible(sec_visible_r);
        sluffyRun.setVisible(runVisible);
        sluffyRun_r.setVisible(runVisible_r);
        sluffyAttack.setVisible(false);
        sluffyAttack_r.setVisible(false);
        sluffyDefend.setVisible(false);
        sluffyDefend_r.setVisible(false);
        sluffyJump.setVisible(false);
        sluffyJump_r.setVisible(false);
        sluffyESkill.setVisible(false);
        sluffyESkill_r.setVisible(false);
        sluffyGSkill.setVisible(false);
        sluffyGSkill_r.setVisible(false);
        sluffyFSkill.setVisible(false);
        sluffyFSkill_r.setVisible(false);
        sluffySSkill.setVisible(false);
        sluffySSkill_r.setVisible(false);
    }



    /***********************
     * Skill Function Area *
     ***********************/

    //Set Attack Area
    public void setAttackArea(Animation skill) {
        attackArea[0] = skill.getX();
        attackArea[1] = skill.getY();
        attackArea[2] = skill.getY() + skill.getHeight();
        attackArea[3] = skill.getX() + skill.getWidth();
    }
    //reset attack area
    public void setAttackArea() {
        for(int i = 0; i < 4; i++) {
            attackArea[i] = 0;
        }
    }

    //E skill perform
    public void ESkill() {
        if (Button.ePointerPressed == true && (visible == true || runVisible == true)) {
            visible = false;
            visible_r = false;
            runVisible = false;
            runVisible_r = false;

            setVisible();
            luffyESkill.setVisible(Button.ePointerPressed);
            luffyESkill.reset();
            ESkilling = true;
            damage = 10;

        }
        else if (Button.ePointerPressed == true && (visible_r == true || runVisible_r == true)) {
            visible = false;
            visible_r = false;
            runVisible = false;
            runVisible_r = false;

            setVisible();
            luffyESkill_r.setVisible(Button.ePointerPressed);
            luffyESkill_r.reset();
            ESkilling_r = true;
            damage = 10;

        }

        if ( luffyESkill.isLastFrame() && (ESkilling == true)) {
            visible = true;
            setVisible();
            ESkilling = false;
            luffyESkill.setCurrentFrameIndex(-1);
            damage = 0;
            healthPoint -= 50;
        }
        else if ( luffyESkill_r.isLastFrame() && (ESkilling_r == true)) {
            visible_r = true;
            setVisible();
            ESkilling_r = false;
            luffyESkill_r.setCurrentFrameIndex(-1);
            damage = 0;
            healthPoint -= 40;
        }

        if(ESkilling)
            setAttackArea(luffyESkill);
        else if (ESkilling_r){
            luffyESkill_r.setLocation( (px - luffyESkill_r.getWidth() + luffy_r.getWidth()) ,py);
            setAttackArea(luffyESkill_r);
            }
        Button.ePointerPressed = false;
    }

    //Sec_E skill perform
    public void secESkill() {
        if (Button.ePointerPressed == true && (sec_visible == true || runVisible == true)) {
            sec_visible = false;
            sec_visible_r = false;
            runVisible = false;
            runVisible_r = false;

            secSetVisible();
            sluffyESkill.setVisible(Button.ePointerPressed);
            sluffyESkill.reset();
            ESkilling = true;
            damage = 20;

        }
        else if (Button.ePointerPressed == true && (sec_visible_r == true || runVisible_r == true)) {
            sec_visible = false;
            sec_visible_r = false;
            runVisible = false;
            runVisible_r = false;

            secSetVisible();
            sluffyESkill_r.setVisible(Button.ePointerPressed);
            sluffyESkill_r.reset();
            ESkilling_r = true;
            damage = 20;

        }

        if ( sluffyESkill.isLastFrame() && (ESkilling == true)) {
            sec_visible = true;
            secSetVisible();
            ESkilling = false;
            sluffyESkill.setCurrentFrameIndex(-1);
            damage = 0;
        }
        else if ( sluffyESkill_r.isLastFrame() && (ESkilling_r == true)) {
            sec_visible_r = true;
            secSetVisible();
            ESkilling_r = false;
            sluffyESkill_r.setCurrentFrameIndex(-1);
            damage = 0;
        }

        if(ESkilling){
            sluffyESkill.setLocation((px - 74) , py);
            setAttackArea(sluffyESkill);
        }
        else if (ESkilling_r){
            sluffyESkill_r.setLocation( (px - sluffyESkill_r.getWidth() + sluffy_r.getWidth() + 74) ,py);
            setAttackArea(sluffyESkill_r);
        }

        Button.ePointerPressed = false;
    }

    //G skill perform
    public void GSkill() {
        if (Button.gPointerPressed == true && (visible == true || runVisible == true)){

            visible = false;
            visible_r = false;
            runVisible = false;
            runVisible_r = false;

            setVisible();
            luffyGSkill.setVisible(Button.gPointerPressed);
            luffyGSkill.reset();
            GSkilling = true;
            damage = 25;

        }
        else if (Button.gPointerPressed == true && (visible_r == true || runVisible_r == true)){
            visible = false;
            visible_r = false;
            runVisible = false;
            runVisible_r = false;

            setVisible();
            luffyGSkill_r.setVisible(Button.gPointerPressed);
            luffyGSkill_r.reset();
            GSkilling_r = true;
            damage = 25;

        }

        if ( luffyGSkill.isLastFrame() && (GSkilling == true)) {
            visible = true;
            setVisible();
            GSkilling = false;
            luffyGSkill.setCurrentFrameIndex(-1);
            damage = 0;
            healthPoint += 50;
        }
        else if ( luffyGSkill_r.isLastFrame() && (GSkilling_r == true)) {
            visible_r = true;
            setVisible();
            GSkilling_r = false;
            luffyGSkill_r.setCurrentFrameIndex(-1);
            damage = 0;
            healthPoint += 40;

        }

        if(GSkilling){
            luffyGSkill.setLocation(px, py - luffyGSkill.getHeight() + luffy.getHeight());
            setAttackArea(luffyGSkill);
        }
        else if (GSkilling_r){
            setAttackArea(luffyGSkill_r);
            luffyGSkill_r.setLocation(px, py - luffyGSkill_r.getHeight() + luffy_r.getHeight());
        }

        Button.gPointerPressed = false;
    }

    //Sec_G skill perform
    public void secGSkill() {
        if (Button.gPointerPressed == true && (sec_visible == true || runVisible == true)){

            sec_visible = false;
            sec_visible_r = false;
            runVisible = false;
            runVisible_r = false;

            secSetVisible();
            sluffyGSkill.setVisible(Button.gPointerPressed);
            sluffyGSkill.reset();
            GSkilling = true;
            damage = 40;

        }
        else if (Button.gPointerPressed == true && (sec_visible_r == true || runVisible_r == true)){
            sec_visible = false;
            sec_visible_r = false;
            runVisible = false;
            runVisible_r = false;

            secSetVisible();
            sluffyGSkill_r.setVisible(Button.gPointerPressed);
            sluffyGSkill_r.reset();
            GSkilling_r = true;
            damage = 40;

        }

        if ( sluffyGSkill.isLastFrame() && (GSkilling == true)) {
            sec_visible = true;
            secSetVisible();
            GSkilling = false;
            sluffyGSkill.setCurrentFrameIndex(-1);
            damage = 0;
        }
        else if ( sluffyGSkill_r.isLastFrame() && (GSkilling_r == true)) {
            sec_visible_r = true;
            secSetVisible();
            GSkilling_r = false;
            sluffyGSkill_r.setCurrentFrameIndex(-1);
            damage = 0;
        }

        if(GSkilling)
            setAttackArea(sluffyGSkill);
        else if (GSkilling_r){
            sluffyGSkill_r.setLocation((px - sluffyGSkill_r.getWidth() + sluffy_r.getWidth()), py);
            setAttackArea(sluffyGSkill_r);
        }

        Button.gPointerPressed = false;
    }

    //F skill perform
    public void FSkill() {
        if (Button.fPointerPressed == true && (visible == true || runVisible == true)){

            visible = false;
            visible_r = false;
            runVisible = false;
            runVisible_r = false;

            setVisible();
            luffyFSkill.setVisible(Button.fPointerPressed);
            luffyFSkill.reset();
            FSkilling = true;
            damage = 40;

        }
        else if (Button.fPointerPressed == true && (visible_r == true || runVisible_r == true)){
            visible = false;
            visible_r = false;
            runVisible = false;
            runVisible_r = false;

            setVisible();
            luffyFSkill_r.setVisible(Button.fPointerPressed);
            luffyFSkill_r.reset();
            FSkilling_r = true;
            damage = 40;

        }

        if ( luffyFSkill.isLastFrame() && (FSkilling == true)) {
            visible = true;
            setVisible();
            FSkilling = false;
            luffyFSkill.setCurrentFrameIndex(-1);
            damage = 0;
        }
        else if ( luffyFSkill_r.isLastFrame() && (FSkilling_r == true)) {
            visible_r = true;
            setVisible();
            FSkilling_r = false;
            luffyFSkill_r.setCurrentFrameIndex(-1);
            damage = 0;
        }

        if(FSkilling)
            setAttackArea(luffyFSkill);
        else if (FSkilling_r){
            luffyFSkill_r.setLocation(px - luffyFSkill_r.getWidth() + luffy_r.getWidth(), py);
            setAttackArea(luffyFSkill_r);
        }
        Button.fPointerPressed = false;
    }

    //Sec_F skill perform
    public void secFSkill() {
        if (Button.fPointerPressed == true && (sec_visible == true || runVisible == true)){

            sec_visible = false;
            sec_visible_r = false;
            runVisible = false;
            runVisible_r = false;

            secSetVisible();
            sluffyFSkill.setVisible(Button.fPointerPressed);
            sluffyFSkill.reset();
            FSkilling = true;
            damage = 45;

        }
        else if (Button.fPointerPressed == true && (sec_visible_r == true || runVisible_r == true)){
            sec_visible = false;
            sec_visible_r = false;
            runVisible = false;
            runVisible_r = false;

            secSetVisible();
            sluffyFSkill_r.setVisible(Button.fPointerPressed);
            sluffyFSkill_r.reset();
            FSkilling_r = true;
            damage = 45;

        }

        if ( sluffyFSkill.isLastFrame() && (FSkilling == true)) {
            sec_visible = true;
            secSetVisible();
            FSkilling = false;
            sluffyFSkill.setCurrentFrameIndex(-1);
            damage = 0;
        }
        else if ( sluffyFSkill_r.isLastFrame() && (FSkilling_r == true)) {
            sec_visible_r = true;
            secSetVisible();
            FSkilling_r = false;
            sluffyFSkill_r.setCurrentFrameIndex(-1);
            damage = 0;
        }

        if (FSkilling){
            sluffyFSkill.setLocation(px - 60, py - sluffyFSkill.getWidth() + sluffy.getWidth());
            setAttackArea(sluffyFSkill);
        }
        else if (FSkilling_r){
            sluffyFSkill_r.setLocation(px - sluffyFSkill_r.getWidth() + sluffy_r.getWidth() + 60,
            py - sluffyFSkill_r.getWidth() + sluffy_r.getWidth());
            setAttackArea(sluffyFSkill_r);
        }
        Button.fPointerPressed = false;
    }

    //sec_S perform
    public void secSSkill(){
        if (Button.sPointerPressed == true && (sec_visible == true || runVisible == true)
            && Button.fire_bool && first_S_touch){

            sec_visible = false;
            sec_visible_r = false;
            runVisible = false;
            runVisible_r = false;

            secSetVisible();
            sluffySSkill.setVisible(Button.sPointerPressed);
            sluffySSkill.reset();
            SSkilling = true;
            damage = 50;

        }
        else if (Button.sPointerPressed == true && (sec_visible_r == true || runVisible_r == true)
                && first_S_touch){
            sec_visible = false;
            sec_visible_r = false;
            runVisible = false;
            runVisible_r = false;

            secSetVisible();
            sluffySSkill_r.setVisible(Button.sPointerPressed);
            sluffySSkill_r.reset();
            SSkilling_r = true;
            damage = 50;

        }

        if ( sluffySSkill.isLastFrame() && (SSkilling == true)) {
            sec_visible = true;
            secSetVisible();
            SSkilling = false;
            sluffySSkill.setCurrentFrameIndex(-1);
            damage = 0;
        }
        else if ( sluffySSkill_r.isLastFrame() && (SSkilling_r == true)) {
            sec_visible_r = true;
            secSetVisible();
            SSkilling_r = false;
            sluffySSkill_r.setCurrentFrameIndex(-1);
            damage = 0;
        }

        if (SSkilling){
            sluffySSkill.setLocation(px - 110, py);
            setAttackArea(sluffySSkill);
        }
        else if (SSkilling_r){
            sluffySSkill_r.setLocation(px - sluffySSkill_r.getWidth() + sluffy_r.getWidth() + 110, py);
            setAttackArea(sluffySSkill_r);
        }

        Button.sPointerPressed = false;
    }
    //Luffy attacking perform
    public void attack() {
        if (Button.atPointerPressed == true && (visible == true || runVisible == true)){
            visible = false;
            visible_r = false;
            runVisible = false;
            runVisible_r = false;

            setVisible();
            luffyAttack.setVisible(Button.atPointerPressed);
            luffyAttack.reset();
            attacking = true;
            damage = 10;

        }
        else if (Button.atPointerPressed == true && (visible_r == true || runVisible_r == true)){
            visible = false;
            visible_r = false;
            runVisible = false;
            runVisible_r = false;

            setVisible();
            luffyAttack_r.setVisible(Button.atPointerPressed);
            luffyAttack_r.reset();
            attacking_r = true;
            damage = 10;

        }

        if ( luffyAttack.isLastFrame() && (attacking == true)) {
            visible = true;
            setVisible();
            attacking = false;
            luffyAttack.setCurrentFrameIndex(-1);
            damage = 0;
        }
        else if ( luffyAttack_r.isLastFrame() && attacking_r == true) {
            visible_r = true;
            setVisible();
            attacking_r = false;
            luffyAttack_r.setCurrentFrameIndex(-1);
            damage = 0;
        }
        if(attacking_r)
            luffyAttack_r.setLocation( px - luffyAttack_r.getWidth() + luffy_r.getWidth() ,py);

        if(attacking)
            setAttackArea(luffyAttack);
        else if (attacking_r)
            setAttackArea(luffyAttack_r);

        Button.atPointerPressed = false;
    }

    public void secAttack() {
        if (Button.atPointerPressed == true && (sec_visible == true || runVisible == true)){
            sec_visible = false;
            sec_visible_r = false;
            runVisible = false;
            runVisible_r = false;

            secSetVisible();
            sluffyAttack.setVisible(Button.atPointerPressed);
            sluffyAttack.reset();
            attacking = true;
            damage = 20;

        }
        else if (Button.atPointerPressed == true && (sec_visible_r == true || runVisible_r == true)){
            sec_visible = false;
            sec_visible_r = false;
            runVisible = false;
            runVisible_r = false;

            secSetVisible();
            sluffyAttack_r.setVisible(Button.atPointerPressed);
            sluffyAttack_r.reset();
            attacking_r = true;
            damage = 20;

        }

        if ( sluffyAttack.isLastFrame() && (attacking == true)) {
            sec_visible = true;
            secSetVisible();
            attacking = false;
            sluffyAttack.setCurrentFrameIndex(-1);
            damage = 0;
        }
        else if ( sluffyAttack_r.isLastFrame() && attacking_r == true) {
            sec_visible_r = true;
            secSetVisible();
            attacking_r = false;
            sluffyAttack_r.setCurrentFrameIndex(-1);
            damage = 0;
        }
        if(attacking_r)
            sluffyAttack_r.setLocation( px - sluffyAttack_r.getWidth() + sluffy_r.getWidth() ,py);

        if(attacking)
            setAttackArea(sluffyAttack);
        else if (attacking_r)
            setAttackArea(sluffyAttack_r);

        Button.atPointerPressed = false;
    }
    //Defending perform
    public void defend() {
        if (Button.dfPointerPressed == true && (visible == true || runVisible == true)){
            visible = false;
            visible_r = false;
            runVisible = false;
            runVisible_r = false;

            setVisible();

            luffyDefend.setVisible(Button.dfPointerPressed);
            luffyDefend.reset();
            defending = true;

        }
        else if (Button.dfPointerPressed == true && (visible_r == true || runVisible_r == true)){
            visible = false;
            visible_r = false;
            runVisible = false;
            runVisible_r = false;

            setVisible();

            luffyDefend_r.setVisible(Button.dfPointerPressed);
            luffyDefend_r.reset();
            defending_r = true;

        }

        if ( luffyDefend.isLastFrame() && (defending == true)) {
            visible = true;
            setVisible();
            defending = false;
            luffyDefend.setCurrentFrameIndex(-1);
        }
        else if ( luffyDefend_r.isLastFrame() && (defending_r == true)) {
            visible_r = true;
            setVisible();
            defending_r = false;
            luffyDefend_r.setCurrentFrameIndex(-1);
        }
        Button.dfPointerPressed = false;
    }
    //Sec_Luffy defending_r
    public void secDefend() {
        if (Button.dfPointerPressed == true && (sec_visible == true || runVisible == true)){
            sec_visible = false;
            sec_visible_r = false;
            runVisible = false;
            runVisible_r = false;

            secSetVisible();

            sluffyDefend.setVisible(Button.dfPointerPressed);
            sluffyDefend.reset();
            defending = true;
        }
        else if (Button.dfPointerPressed == true && (sec_visible_r == true || runVisible_r == true)){
            sec_visible = false;
            sec_visible_r = false;
            runVisible = false;
            runVisible_r = false;

            secSetVisible();

            sluffyDefend_r.setVisible(Button.dfPointerPressed);
            sluffyDefend_r.reset();
            defending_r = true;
        }
        if ( sluffyDefend.isLastFrame() && (defending == true)) {
            sec_visible = true;
            secSetVisible();
            defending = false;
            sluffyDefend.setCurrentFrameIndex(-1);
        }
        else if ( sluffyDefend_r.isLastFrame() && (defending_r == true)) {
            sec_visible_r = true;
            secSetVisible();
            defending_r = false;
            sluffyDefend_r.setCurrentFrameIndex(-1);
        }
        if (defending_r)
            sluffyDefend_r.setLocation( (px - sluffyDefend_r.getWidth() + luffy_r.getWidth()) ,py);

        Button.dfPointerPressed = false;
    }

    //Jump perform
    public void jump() {
        if (Button.jpPointerPressed == true && (visible == true || runVisible == true)){
            visible = false;
            visible_r = false;
            runVisible = false;
            runVisible_r = false;

            setVisible();
            luffyJump.setVisible(Button.jpPointerPressed);
            luffyJump.reset();
            jumping = true;

        }
        else if (Button.jpPointerPressed == true && (visible_r == true || runVisible_r == true)){
            visible = false;
            visible_r = false;
            runVisible = false;
            runVisible_r = false;

            setVisible();
            luffyJump_r.setVisible(Button.jpPointerPressed);
            luffyJump_r.reset();
            jumping_r = true;

        }

        if ( luffyJump.isLastFrame() && (jumping == true)) {
            visible = true;
            setVisible();
            jumping = false;
            luffyJump.setCurrentFrameIndex(-1);
        }
        else if ( luffyJump_r.isLastFrame() && (jumping_r == true)) {
            visible_r = true;
            setVisible();
            jumping_r = false;
            luffyJump_r.setCurrentFrameIndex(-1);
        }

        if(jumping) {
            luffyJump.setLocation(px, py + luffy.getHeight() - luffyJump.getHeight());
        }
        else if (jumping_r) {
            luffyJump_r.setLocation(px, py + luffy.getHeight() - luffyJump_r.getHeight());
        }
        Button.jpPointerPressed = false;
    }
    //Sec_Luffy jump perform
    public void secJump() {
        if (Button.jpPointerPressed == true && (sec_visible == true || runVisible == true)){
            sec_visible = false;
            sec_visible_r = false;
            runVisible = false;
            runVisible_r = false;

            secSetVisible();
            sluffyJump.setVisible(Button.jpPointerPressed);
            sluffyJump.reset();
            jumping = true;

        }
        else if (Button.jpPointerPressed == true && (sec_visible_r == true || runVisible_r == true)){
            sec_visible = false;
            sec_visible_r = false;
            runVisible = false;
            runVisible_r = false;

            secSetVisible();
            sluffyJump_r.setVisible(Button.jpPointerPressed);
            sluffyJump_r.reset();
            jumping_r = true;
        }
        if ( sluffyJump.isLastFrame() && (jumping == true)) {
            sec_visible = true;
            secSetVisible();
            jumping = false;
            sluffyJump.setCurrentFrameIndex(-1);
        }
        else if ( sluffyJump_r.isLastFrame() && (jumping_r == true)) {
            sec_visible_r = true;
            secSetVisible();
            jumping_r = false;
            sluffyJump_r.setCurrentFrameIndex(-1);
        }

        if(jumping) {
            sluffyJump.setLocation(px, py + sluffy.getHeight() - sluffyJump.getHeight());
        }
        else if (jumping_r) {
            sluffyJump_r.setLocation(px, py + sluffy.getHeight() - sluffyJump_r.getHeight());
        }
        Button.jpPointerPressed = false;
    }



    /****************************
     * Initialize Function Area *
     ****************************/

    //Initialize all luffy animation frame
    public void addFrame() {
        //luffy add frame
        luffy.addFrame(R.drawable.luffy00);
        luffy.addFrame(R.drawable.luffy01);
        luffy.addFrame(R.drawable.luffy02);
        luffy.addFrame(R.drawable.luffy03);
        luffy_r.addFrame(R.drawable.luffy00_r);
        luffy_r.addFrame(R.drawable.luffy01_r);
        luffy_r.addFrame(R.drawable.luffy02_r);
        luffy_r.addFrame(R.drawable.luffy03_r);

        //luffy add get hit frame
        luffyHit.addFrame(R.drawable.luffy_hit01);
        luffyHit.addFrame(R.drawable.luffy_hit02);
        luffyHit.addFrame(R.drawable.luffy_hit03);
        luffyHit_r.addFrame(R.drawable.luffy_hit01_r);
        luffyHit_r.addFrame(R.drawable.luffy_hit02_r);
        luffyHit_r.addFrame(R.drawable.luffy_hit03_r);

        //luffy add run frame
        luffyRun.addFrame(R.drawable.luffy_run01);
        luffyRun.addFrame(R.drawable.luffy_run02);
        luffyRun.addFrame(R.drawable.luffy_run03);
        luffyRun.addFrame(R.drawable.luffy_run02);
        luffyRun_r.addFrame(R.drawable.luffy_run01_r);
        luffyRun_r.addFrame(R.drawable.luffy_run02_r);
        luffyRun_r.addFrame(R.drawable.luffy_run03_r);
        luffyRun_r.addFrame(R.drawable.luffy_run02_r);

        //luffy add attacking frame
        luffyAttack.addFrame(R.drawable.luffy_attack01);
        luffyAttack.addFrame(R.drawable.luffy_attack02);
        luffyAttack.addFrame(R.drawable.luffy_attack03);
        luffyAttack.addFrame(R.drawable.luffy_attack04);
        luffyAttack.addFrame(R.drawable.luffy_attack05);
        luffyAttack.addFrame(R.drawable.luffy_attack04);
        luffyAttack.addFrame(R.drawable.luffy_attack03);
        luffyAttack.addFrame(R.drawable.luffy_attack02);
        luffyAttack.addFrame(R.drawable.luffy_attack01);
        luffyAttack.addFrame(R.drawable.luffy_attack06);
        luffyAttack.addFrame(R.drawable.luffy_attack07);
        luffyAttack_r.addFrame(R.drawable.luffy_attack00_r);
        luffyAttack_r.addFrame(R.drawable.luffy_attack01_r);
        luffyAttack_r.addFrame(R.drawable.luffy_attack02_r);
        luffyAttack_r.addFrame(R.drawable.luffy_attack03_r);
        luffyAttack_r.addFrame(R.drawable.luffy_attack04_r);
        luffyAttack_r.addFrame(R.drawable.luffy_attack05_r);
        luffyAttack_r.addFrame(R.drawable.luffy_attack04_r);
        luffyAttack_r.addFrame(R.drawable.luffy_attack03_r);
        luffyAttack_r.addFrame(R.drawable.luffy_attack02_r);
        luffyAttack_r.addFrame(R.drawable.luffy_attack01_r);
        luffyAttack_r.addFrame(R.drawable.luffy_attack06_r);
        luffyAttack_r.addFrame(R.drawable.luffy_attack07_r);

        //luffy add defend frame
        luffyDefend.addFrame(R.drawable.luffy_defend01);
        luffyDefend.addFrame(R.drawable.luffy_defend02);
        luffyDefend.addFrame(R.drawable.luffy_defend03);
        luffyDefend.addFrame(R.drawable.luffy_defend04);
        luffyDefend_r.addFrame(R.drawable.luffy_defend01_r);
        luffyDefend_r.addFrame(R.drawable.luffy_defend02_r);
        luffyDefend_r.addFrame(R.drawable.luffy_defend03_r);
        luffyDefend_r.addFrame(R.drawable.luffy_defend04_r);

        //luffy add jump frame
        luffyJump.addFrame(R.drawable.luffy_jump00);
        luffyJump.addFrame(R.drawable.luffy_jump01);
        luffyJump.addFrame(R.drawable.luffy_jump02);
        luffyJump.addFrame(R.drawable.luffy_jump03);
        luffyJump.addFrame(R.drawable.luffy_jump04);
        luffyJump.addFrame(R.drawable.luffy_jump05);
        luffyJump.addFrame(R.drawable.luffy_jump06);
        luffyJump.addFrame(R.drawable.luffy_jump06);
        luffyJump.addFrame(R.drawable.luffy_jump05);
        luffyJump.addFrame(R.drawable.luffy_jump04);
        luffyJump.addFrame(R.drawable.luffy_jump03);
        luffyJump.addFrame(R.drawable.luffy_jump02);
        luffyJump.addFrame(R.drawable.luffy_jump01);
        luffyJump_r.addFrame(R.drawable.luffy_jump00_r);
        luffyJump_r.addFrame(R.drawable.luffy_jump01_r);
        luffyJump_r.addFrame(R.drawable.luffy_jump02_r);
        luffyJump_r.addFrame(R.drawable.luffy_jump03_r);
        luffyJump_r.addFrame(R.drawable.luffy_jump04_r);
        luffyJump_r.addFrame(R.drawable.luffy_jump05_r);
        luffyJump_r.addFrame(R.drawable.luffy_jump06_r);
        luffyJump_r.addFrame(R.drawable.luffy_jump06_r);
        luffyJump_r.addFrame(R.drawable.luffy_jump05_r);
        luffyJump_r.addFrame(R.drawable.luffy_jump04_r);
        luffyJump_r.addFrame(R.drawable.luffy_jump03_r);
        luffyJump_r.addFrame(R.drawable.luffy_jump02_r);
        luffyJump_r.addFrame(R.drawable.luffy_jump01_r);

        //luffy add Eskill frame
        luffyESkill.addFrame(R.drawable.luffy_e00);
        luffyESkill.addFrame(R.drawable.luffy_e01);
        luffyESkill.addFrame(R.drawable.luffy_e02);
        luffyESkill.addFrame(R.drawable.luffy_e03);
        luffyESkill.addFrame(R.drawable.luffy_e04);
        luffyESkill.addFrame(R.drawable.luffy_e05);
        luffyESkill.addFrame(R.drawable.luffy_e06);
        luffyESkill.addFrame(R.drawable.luffy_e07);
        luffyESkill.addFrame(R.drawable.luffy_e08);
        luffyESkill.addFrame(R.drawable.luffy_e09);
        luffyESkill.addFrame(R.drawable.luffy_e10);
        luffyESkill.addFrame(R.drawable.luffy_e11);
        luffyESkill.addFrame(R.drawable.luffy_e12);
        luffyESkill.addFrame(R.drawable.luffy_e13);
        luffyESkill.addFrame(R.drawable.luffy_e14);
        luffyESkill.addFrame(R.drawable.luffy_e15);
        luffyESkill.addFrame(R.drawable.luffy_e16);
        luffyESkill_r.addFrame(R.drawable.luffy_e00_r);
        luffyESkill_r.addFrame(R.drawable.luffy_e01_r);
        luffyESkill_r.addFrame(R.drawable.luffy_e02_r);
        luffyESkill_r.addFrame(R.drawable.luffy_e03_r);
        luffyESkill_r.addFrame(R.drawable.luffy_e04_r);
        luffyESkill_r.addFrame(R.drawable.luffy_e05_r);
        luffyESkill_r.addFrame(R.drawable.luffy_e06_r);
        luffyESkill_r.addFrame(R.drawable.luffy_e07_r);
        luffyESkill_r.addFrame(R.drawable.luffy_e08_r);
        luffyESkill_r.addFrame(R.drawable.luffy_e09_r);
        luffyESkill_r.addFrame(R.drawable.luffy_e10_r);
        luffyESkill_r.addFrame(R.drawable.luffy_e11_r);
        luffyESkill_r.addFrame(R.drawable.luffy_e12_r);
        luffyESkill_r.addFrame(R.drawable.luffy_e13_r);
        luffyESkill_r.addFrame(R.drawable.luffy_e14_r);
        luffyESkill_r.addFrame(R.drawable.luffy_e15_r);
        luffyESkill_r.addFrame(R.drawable.luffy_e16_r);

        //luffy add Gskill frame
        luffyGSkill.addFrame(R.drawable.luffy_g01);
        luffyGSkill.addFrame(R.drawable.luffy_g02);
        luffyGSkill.addFrame(R.drawable.luffy_g03);
        luffyGSkill.addFrame(R.drawable.luffy_g04);
        luffyGSkill.addFrame(R.drawable.luffy_g05);
        luffyGSkill.addFrame(R.drawable.luffy_g06);
        luffyGSkill.addFrame(R.drawable.luffy_g07);
        luffyGSkill.addFrame(R.drawable.luffy_g08);
        luffyGSkill.addFrame(R.drawable.luffy_g09);
        luffyGSkill.addFrame(R.drawable.luffy_g10);
        luffyGSkill.addFrame(R.drawable.luffy_g11);
        luffyGSkill.addFrame(R.drawable.luffy_g12);
        luffyGSkill.addFrame(R.drawable.luffy_g13);
        luffyGSkill.addFrame(R.drawable.luffy_g14);
        luffyGSkill.addFrame(R.drawable.luffy_g15);
        luffyGSkill.addFrame(R.drawable.luffy_g16);
        luffyGSkill.addFrame(R.drawable.luffy_g17);
        luffyGSkill_r.addFrame(R.drawable.luffy_g01_r);
        luffyGSkill_r.addFrame(R.drawable.luffy_g02_r);
        luffyGSkill_r.addFrame(R.drawable.luffy_g03_r);
        luffyGSkill_r.addFrame(R.drawable.luffy_g04_r);
        luffyGSkill_r.addFrame(R.drawable.luffy_g05_r);
        luffyGSkill_r.addFrame(R.drawable.luffy_g06_r);
        luffyGSkill_r.addFrame(R.drawable.luffy_g07_r);
        luffyGSkill_r.addFrame(R.drawable.luffy_g08_r);
        luffyGSkill_r.addFrame(R.drawable.luffy_g09_r);
        luffyGSkill_r.addFrame(R.drawable.luffy_g10_r);
        luffyGSkill_r.addFrame(R.drawable.luffy_g11_r);
        luffyGSkill_r.addFrame(R.drawable.luffy_g12_r);
        luffyGSkill_r.addFrame(R.drawable.luffy_g13_r);
        luffyGSkill_r.addFrame(R.drawable.luffy_g14_r);
        luffyGSkill_r.addFrame(R.drawable.luffy_g15_r);
        luffyGSkill_r.addFrame(R.drawable.luffy_g16_r);
        luffyGSkill_r.addFrame(R.drawable.luffy_g17_r);

        //luffy add Fskill frame
        luffyFSkill.addFrame(R.drawable.luffy_f01);
        luffyFSkill.addFrame(R.drawable.luffy_f02);
        luffyFSkill.addFrame(R.drawable.luffy_f03);
        luffyFSkill.addFrame(R.drawable.luffy_f04);
        luffyFSkill.addFrame(R.drawable.luffy_f05);
        luffyFSkill.addFrame(R.drawable.luffy_f06);
        luffyFSkill.addFrame(R.drawable.luffy_f07);
        luffyFSkill.addFrame(R.drawable.luffy_f08);
        luffyFSkill.addFrame(R.drawable.luffy_f09);
        luffyFSkill.addFrame(R.drawable.luffy_f10);
        luffyFSkill.addFrame(R.drawable.luffy_f11);
        luffyFSkill.addFrame(R.drawable.luffy_f12);
        luffyFSkill.addFrame(R.drawable.luffy_f13);
        luffyFSkill.addFrame(R.drawable.luffy_f14);
        luffyFSkill.addFrame(R.drawable.luffy_f15);
        luffyFSkill.addFrame(R.drawable.luffy_f16);
        luffyFSkill.addFrame(R.drawable.luffy_f17);
        luffyFSkill.addFrame(R.drawable.luffy_f18);
        luffyFSkill_r.addFrame(R.drawable.luffy_f01_r);
        luffyFSkill_r.addFrame(R.drawable.luffy_f02_r);
        luffyFSkill_r.addFrame(R.drawable.luffy_f03_r);
        luffyFSkill_r.addFrame(R.drawable.luffy_f04_r);
        luffyFSkill_r.addFrame(R.drawable.luffy_f05_r);
        luffyFSkill_r.addFrame(R.drawable.luffy_f06_r);
        luffyFSkill_r.addFrame(R.drawable.luffy_f07_r);
        luffyFSkill_r.addFrame(R.drawable.luffy_f08_r);
        luffyFSkill_r.addFrame(R.drawable.luffy_f09_r);
        luffyFSkill_r.addFrame(R.drawable.luffy_f10_r);
        luffyFSkill_r.addFrame(R.drawable.luffy_f11_r);
        luffyFSkill_r.addFrame(R.drawable.luffy_f12_r);
        luffyFSkill_r.addFrame(R.drawable.luffy_f13_r);
        luffyFSkill_r.addFrame(R.drawable.luffy_f14_r);
        luffyFSkill_r.addFrame(R.drawable.luffy_f15_r);
        luffyFSkill_r.addFrame(R.drawable.luffy_f16_r);
        luffyFSkill_r.addFrame(R.drawable.luffy_f17_r);
        luffyFSkill_r.addFrame(R.drawable.luffy_f18_r);
    }

    public void secAddFrame(){
        //Luffy second
        sluffy.addFrame(R.drawable.luffy_sec_n01);
        sluffy.addFrame(R.drawable.luffy_sec_n02);
        sluffy.addFrame(R.drawable.luffy_sec_n03);
        //Luffy second reverse
        sluffy_r.addFrame(R.drawable.luffy_sec_nr01);
        sluffy_r.addFrame(R.drawable.luffy_sec_nr02);
        sluffy_r.addFrame(R.drawable.luffy_sec_nr03);
        //Sec_Luffy run
        sluffyRun.addFrame(R.drawable.sluffy_run01);
        sluffyRun.addFrame(R.drawable.sluffy_run02);
        sluffyRun.addFrame(R.drawable.sluffy_run03);
        sluffyRun.addFrame(R.drawable.sluffy_run04);
        //Sec_Luffy run reverse
        sluffyRun_r.addFrame(R.drawable.sluffy_run01_r);
        sluffyRun_r.addFrame(R.drawable.sluffy_run02_r);
        sluffyRun_r.addFrame(R.drawable.sluffy_run03_r);
        sluffyRun_r.addFrame(R.drawable.sluffy_run04_r);
        //Sec_luffy attack
        sluffyAttack.addFrame(R.drawable.sluffy_attack01);
        sluffyAttack.addFrame(R.drawable.sluffy_attack02);
        sluffyAttack.addFrame(R.drawable.sluffy_attack03);
        //Sec_luffy attack reverse
        sluffyAttack_r.addFrame(R.drawable.sluffy_attack01_r);
        sluffyAttack_r.addFrame(R.drawable.sluffy_attack02_r);
        sluffyAttack_r.addFrame(R.drawable.sluffy_attack03_r);
        //Sec_Luffy jump
        sluffyJump.addFrame(R.drawable.sluffy_jump00);
        sluffyJump.addFrame(R.drawable.sluffy_jump01);
        sluffyJump.addFrame(R.drawable.sluffy_jump01);
        sluffyJump.addFrame(R.drawable.sluffy_jump01);
        sluffyJump.addFrame(R.drawable.sluffy_jump02);
        sluffyJump.addFrame(R.drawable.sluffy_jump03);
        //Sec_Luffy jump reverse
        sluffyJump_r.addFrame(R.drawable.sluffy_jump00);
        sluffyJump_r.addFrame(R.drawable.sluffy_jump01_r);
        sluffyJump_r.addFrame(R.drawable.sluffy_jump01_r);
        sluffyJump_r.addFrame(R.drawable.sluffy_jump01_r);
        sluffyJump_r.addFrame(R.drawable.sluffy_jump02);
        sluffyJump_r.addFrame(R.drawable.sluffy_jump03_r);
        //Sec_Luffy defend
        sluffyDefend.addFrame(R.drawable.sluffy_defend01);
        sluffyDefend.addFrame(R.drawable.sluffy_defend02);
        sluffyDefend.addFrame(R.drawable.sluffy_defend03);
        sluffyDefend.addFrame(R.drawable.sluffy_defend04);
        sluffyDefend.addFrame(R.drawable.sluffy_defend05);
        //Sec_Luffy defend
        sluffyDefend_r.addFrame(R.drawable.sluffy_defend01_r);
        sluffyDefend_r.addFrame(R.drawable.sluffy_defend02_r);
        sluffyDefend_r.addFrame(R.drawable.sluffy_defend03_r);
        sluffyDefend_r.addFrame(R.drawable.sluffy_defend04_r);
        sluffyDefend_r.addFrame(R.drawable.sluffy_defend05_r);
        //Sec_Luffy Eskill
        sluffyESkill.addFrame(R.drawable.sluffy_e01);
        sluffyESkill.addFrame(R.drawable.sluffy_e02);
        sluffyESkill.addFrame(R.drawable.sluffy_e03);
        sluffyESkill.addFrame(R.drawable.sluffy_e04);
        sluffyESkill.addFrame(R.drawable.sluffy_e05);
        sluffyESkill.addFrame(R.drawable.sluffy_e06);
        sluffyESkill.addFrame(R.drawable.sluffy_e07);
        sluffyESkill.addFrame(R.drawable.sluffy_e08);
        sluffyESkill.addFrame(R.drawable.sluffy_e09);
        sluffyESkill.addFrame(R.drawable.sluffy_e10);
        sluffyESkill.addFrame(R.drawable.sluffy_e11);
        sluffyESkill.addFrame(R.drawable.sluffy_e12);
        sluffyESkill.addFrame(R.drawable.sluffy_e13);
        sluffyESkill.addFrame(R.drawable.sluffy_e14);
        sluffyESkill.addFrame(R.drawable.sluffy_e15);
        sluffyESkill.addFrame(R.drawable.sluffy_e16);
        //Sec_Luffy Eskill reverse
        sluffyESkill_r.addFrame(R.drawable.sluffy_e01_r);
        sluffyESkill_r.addFrame(R.drawable.sluffy_e02_r);
        sluffyESkill_r.addFrame(R.drawable.sluffy_e03_r);
        sluffyESkill_r.addFrame(R.drawable.sluffy_e04_r);
        sluffyESkill_r.addFrame(R.drawable.sluffy_e05_r);
        sluffyESkill_r.addFrame(R.drawable.sluffy_e06_r);
        sluffyESkill_r.addFrame(R.drawable.sluffy_e07_r);
        sluffyESkill_r.addFrame(R.drawable.sluffy_e08_r);
        sluffyESkill_r.addFrame(R.drawable.sluffy_e09_r);
        sluffyESkill_r.addFrame(R.drawable.sluffy_e10_r);
        sluffyESkill_r.addFrame(R.drawable.sluffy_e11_r);
        sluffyESkill_r.addFrame(R.drawable.sluffy_e12_r);
        sluffyESkill_r.addFrame(R.drawable.sluffy_e13_r);
        sluffyESkill_r.addFrame(R.drawable.sluffy_e14_r);
        sluffyESkill_r.addFrame(R.drawable.sluffy_e15_r);
        sluffyESkill_r.addFrame(R.drawable.sluffy_e16_r);
        //Sec_Luffy Fskill
        sluffyFSkill.addFrame(R.drawable.sluffy_f01);
        sluffyFSkill.addFrame(R.drawable.sluffy_f02);
        sluffyFSkill.addFrame(R.drawable.sluffy_f03);
        sluffyFSkill.addFrame(R.drawable.sluffy_f04);
        sluffyFSkill.addFrame(R.drawable.sluffy_f05);
        sluffyFSkill.addFrame(R.drawable.sluffy_f06);
        sluffyFSkill.addFrame(R.drawable.sluffy_f07);
        sluffyFSkill.addFrame(R.drawable.sluffy_f08);
        //Sec_Luffy Fskill reverse
        sluffyFSkill_r.addFrame(R.drawable.sluffy_f01_r);
        sluffyFSkill_r.addFrame(R.drawable.sluffy_f02_r);
        sluffyFSkill_r.addFrame(R.drawable.sluffy_f03_r);
        sluffyFSkill_r.addFrame(R.drawable.sluffy_f04_r);
        sluffyFSkill_r.addFrame(R.drawable.sluffy_f05_r);
        sluffyFSkill_r.addFrame(R.drawable.sluffy_f06_r);
        sluffyFSkill_r.addFrame(R.drawable.sluffy_f07_r);
        sluffyFSkill_r.addFrame(R.drawable.sluffy_f08_r);
        //Sec_Luffy Gskill
        sluffyGSkill.addFrame(R.drawable.sluffy_g01);
        sluffyGSkill.addFrame(R.drawable.sluffy_g02);
        sluffyGSkill.addFrame(R.drawable.sluffy_g03);
        sluffyGSkill.addFrame(R.drawable.sluffy_g04);
        sluffyGSkill.addFrame(R.drawable.sluffy_g05);
        //Sec_Luffy Gskill reverse
        sluffyGSkill_r.addFrame(R.drawable.sluffy_g01_r);
        sluffyGSkill_r.addFrame(R.drawable.sluffy_g02_r);
        sluffyGSkill_r.addFrame(R.drawable.sluffy_g03_r);
        sluffyGSkill_r.addFrame(R.drawable.sluffy_g04_r);
        sluffyGSkill_r.addFrame(R.drawable.sluffy_g05_r);
        //Sec_Luffy Sskill
        sluffySSkill.addFrame(R.drawable.sluffy_s01);
        sluffySSkill.addFrame(R.drawable.sluffy_s02);
        sluffySSkill.addFrame(R.drawable.sluffy_s03);
        sluffySSkill.addFrame(R.drawable.sluffy_s04);
        sluffySSkill.addFrame(R.drawable.sluffy_s05);
        sluffySSkill.addFrame(R.drawable.sluffy_s06);
        sluffySSkill.addFrame(R.drawable.sluffy_s07);
        sluffySSkill.addFrame(R.drawable.sluffy_s08);
        sluffySSkill.addFrame(R.drawable.sluffy_s09);
        sluffySSkill.addFrame(R.drawable.sluffy_s10);
        sluffySSkill.addFrame(R.drawable.sluffy_s11);
        //Sec_Luffy Sskill reverse
        sluffySSkill_r.addFrame(R.drawable.sluffy_s01_r);
        sluffySSkill_r.addFrame(R.drawable.sluffy_s02_r);
        sluffySSkill_r.addFrame(R.drawable.sluffy_s03_r);
        sluffySSkill_r.addFrame(R.drawable.sluffy_s04_r);
        sluffySSkill_r.addFrame(R.drawable.sluffy_s05_r);
        sluffySSkill_r.addFrame(R.drawable.sluffy_s06_r);
        sluffySSkill_r.addFrame(R.drawable.sluffy_s07_r);
        sluffySSkill_r.addFrame(R.drawable.sluffy_s08_r);
        sluffySSkill_r.addFrame(R.drawable.sluffy_s09_r);
        sluffySSkill_r.addFrame(R.drawable.sluffy_s10_r);
        sluffySSkill_r.addFrame(R.drawable.sluffy_s11_r);
    }

    //Set all luffy animations delay
    public void frameDelay() {
        luffy.setDelay(5);
        luffy_r.setDelay(5);
        luffyRun.setDelay(2);
        luffyRun_r.setDelay(2);
        luffyAttack.setDelay(2);
        luffyAttack_r.setDelay(2);
        luffyDefend.setDelay(2);
        luffyDefend_r.setDelay(2);
        luffyJump.setDelay(2);
        luffyJump_r.setDelay(2);
        luffyESkill.setDelay(2);
        luffyESkill_r.setDelay(2);
        luffyGSkill.setDelay(2);
        luffyGSkill_r.setDelay(2);
        luffyFSkill.setDelay(2);
        luffyFSkill_r.setDelay(2);
    }

    public void secFrameDelay(){
        sluffy.setDelay(4);
        sluffy_r.setDelay(4);
        sluffyRun.setDelay(2);
        sluffyRun_r.setDelay(2);
        sluffyAttack.setDelay(4);
        sluffyAttack_r.setDelay(4);
        sluffyDefend.setDelay(2);
        sluffyDefend_r.setDelay(2);
        sluffyJump.setDelay(2);
        sluffyJump_r.setDelay(2);
        sluffyESkill.setDelay(2);
        sluffyESkill_r.setDelay(2);
        sluffyGSkill.setDelay(2);
        sluffyGSkill_r.setDelay(2);
        sluffyFSkill.setDelay(2);
        sluffyFSkill_r.setDelay(2);
        sluffySSkill.setDelay(2);
        sluffySSkill_r.setDelay(2);
    }

    //Set all luffy animations repeating
    public void frameRepeating() {
        luffyAttack.setRepeating(false);
        luffyAttack_r.setRepeating(false);
        luffyDefend.setRepeating(false);
        luffyDefend_r.setRepeating(false);
        luffyJump.setRepeating(false);
        luffyJump_r.setRepeating(false);
        luffyESkill.setRepeating(false);
        luffyESkill_r.setRepeating(false);
        luffyGSkill.setRepeating(false);
        luffyGSkill_r.setRepeating(false);
        luffyFSkill.setRepeating(false);
        luffyFSkill_r.setRepeating(false);
        luffyHit.setRepeating(false);
        luffyHit_r.setRepeating(false);
    }
    public void secFrameRepeating(){
        sluffyAttack.setRepeating(false);
        sluffyAttack_r.setRepeating(false);
        sluffyDefend.setRepeating(false);
        sluffyDefend_r.setRepeating(false);
        sluffyJump.setRepeating(false);
        sluffyJump_r.setRepeating(false);
        sluffyESkill.setRepeating(false);
        sluffyESkill_r.setRepeating(false);
        sluffyGSkill.setRepeating(false);
        sluffyGSkill_r.setRepeating(false);
        sluffyFSkill.setRepeating(false);
        sluffyFSkill_r.setRepeating(false);
        sluffySSkill.setRepeating(false);
        sluffySSkill_r.setRepeating(false);
    }

    //Set all luffy animation current index
    public void setCurrentIndex(int index) {
        luffyAttack.setCurrentFrameIndex(index);
        luffyAttack_r.setCurrentFrameIndex(index);
        luffyDefend.setCurrentFrameIndex(index);
        luffyDefend_r.setCurrentFrameIndex(index);
        luffyJump.setCurrentFrameIndex(index);
        luffyJump_r.setCurrentFrameIndex(index);
        luffyESkill.setCurrentFrameIndex(index);
        luffyESkill_r.setCurrentFrameIndex(index);
        luffyGSkill.setCurrentFrameIndex(index);
        luffyGSkill_r.setCurrentFrameIndex(index);
        luffyFSkill.setCurrentFrameIndex(index);
        luffyFSkill_r.setCurrentFrameIndex(index);
        luffyHit.setCurrentFrameIndex(index);
        luffyHit_r.setCurrentFrameIndex(index);
    }
    public void secSetCurrentIndex(int index){
        sluffyAttack.setCurrentFrameIndex(index);
        sluffyAttack_r.setCurrentFrameIndex(index);
        sluffyDefend.setCurrentFrameIndex(index);
        sluffyDefend_r.setCurrentFrameIndex(index);
        sluffyJump.setCurrentFrameIndex(index);
        sluffyJump_r.setCurrentFrameIndex(index);
        sluffyESkill.setCurrentFrameIndex(index);
        sluffyESkill_r.setCurrentFrameIndex(index);
        sluffyGSkill.setCurrentFrameIndex(index);
        sluffyGSkill_r.setCurrentFrameIndex(index);
        sluffyFSkill.setCurrentFrameIndex(index);
        sluffyFSkill_r.setCurrentFrameIndex(index);
        sluffySSkill.setCurrentFrameIndex(index);
        sluffySSkill_r.setCurrentFrameIndex(index);
    }

    public boolean isPerforming(){
         return ((luffyAttack.getCurrentFrameIndex()==-1)&&(luffyAttack_r.getCurrentFrameIndex()==-1)
        &&(luffyDefend.getCurrentFrameIndex()==-1)&&(luffyDefend_r.getCurrentFrameIndex()==-1)
        &&(luffyJump.getCurrentFrameIndex()==-1)&&(luffyJump_r.getCurrentFrameIndex()==-1)
        &&(luffyESkill.getCurrentFrameIndex()==-1)&&(luffyESkill_r.getCurrentFrameIndex()==-1)
        &&(luffyGSkill.getCurrentFrameIndex()==-1)&&(luffyGSkill_r.getCurrentFrameIndex()==-1)
        &&(luffyFSkill.getCurrentFrameIndex()==-1)&&(luffyFSkill_r.getCurrentFrameIndex()==-1)
        &&(sluffyAttack.getCurrentFrameIndex()==-1)&&(sluffyAttack_r.getCurrentFrameIndex()==-1)
       &&(sluffyDefend.getCurrentFrameIndex()==-1)&&(sluffyDefend_r.getCurrentFrameIndex()==-1)
       &&(sluffyJump.getCurrentFrameIndex()==-1)&&(sluffyJump_r.getCurrentFrameIndex()==-1)
       &&(sluffyESkill.getCurrentFrameIndex()==-1)&&(sluffyESkill_r.getCurrentFrameIndex()==-1)
       &&(sluffyGSkill.getCurrentFrameIndex()==-1)&&(sluffyGSkill_r.getCurrentFrameIndex()==-1)
       &&(sluffyFSkill.getCurrentFrameIndex()==-1)&&(sluffyFSkill_r.getCurrentFrameIndex()==-1)
       &&(sluffySSkill.getCurrentFrameIndex()==-1)&&(sluffySSkill_r.getCurrentFrameIndex()==-1));
    }
    public void setSecondModelVisible(){
        sec_visible = true;
        first_S_touch = true;
    }

}
