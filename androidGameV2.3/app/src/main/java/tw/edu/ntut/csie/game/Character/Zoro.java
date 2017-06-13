package tw.edu.ntut.csie.game.Character;

import java.util.ArrayList;

import tw.edu.ntut.csie.game.R;
import tw.edu.ntut.csie.game.core.MovingBitmap;
import tw.edu.ntut.csie.game.core.SoundEffects;
import tw.edu.ntut.csie.game.extend.Animation;
import tw.edu.ntut.csie.game.state.Button;
import tw.edu.ntut.csie.game.state.Navigation;
import tw.edu.ntut.csie.game.Enemy.AttackObject;
/**
 * Created by huyuxiang on 2017/4/16.
 */

public class Zoro implements CharacterObject {
    public ArrayList<MovingBitmap> hp;
    public MovingBitmap hpBg;
    private Animation zoro;
    private Animation zoro_r;
    private Animation zoroRun;
    private Animation zoroRun_r;
    private Animation zoroAttack;
    private Animation zoroAttack_r;
    private Animation zoroDefend;
    private Animation zoroDefend_r;
    private Animation zoroJump;
    private Animation zoroJump_r;
    private Animation zoroESkill;
    private Animation zoroESkill_r;
    private Animation zoroGSkill;
    private Animation zoroGSkill_r;
    private Animation zoroFSkill;
    private Animation zoroFSkill_r;
    private Animation zoroFF;
    private Animation zoroFF_r;
    private Animation zoroHit;
    private Animation zoroHit_r;

    private Animation szoroESkill;
    private Animation szoroESkill_r;
    private Animation szoroGSkill;
    private Animation szoroGSkill_r;
    private Animation szoroGG;
    private Animation szoroGG_r;
    private Animation szoroFSkill;
    private Animation szoroFSkill_r;
    private Animation szoroFF;
    private Animation szoroFF_r;
    private Animation szoroSSkill;
    private Animation szoroSSkill_r;
    private Animation szoroSS;
    private Animation szoroSS_r;
    private Animation szoroHit;
    private Animation szoroHit_r;

    private SoundEffects zoroSound;

    private MovingBitmap zoro_small;

    private int px, py;
    private final int maxHp = 200;
    private int healthPoint;

    private boolean visible = true, visible_r = false;
    private boolean runVisible = false, runVisible_r = false;
    private boolean hitVisible = false, hitVisible_r = false;

    private boolean attacking = false, attacking_r = false;
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

    public Zoro() {
        super();
        hp = new ArrayList<MovingBitmap>();
        hpBg = new MovingBitmap(R.drawable.healthpoint_bg);
        zoro_small = new MovingBitmap(R.drawable.zoro_s);
        zoro_small.setLocation(9, 18);
        zoro = new Animation();
        zoro_r = new Animation();

        zoroRun = new Animation();
        zoroRun_r = new Animation();
        zoroAttack = new Animation();
        zoroAttack_r = new Animation();
        zoroDefend = new Animation();
        zoroDefend_r = new Animation();
        zoroJump = new Animation();
        zoroJump_r = new Animation();
        zoroESkill = new Animation();
        zoroESkill_r =new Animation();
        zoroGSkill = new Animation();
        zoroGSkill_r = new Animation();
        zoroFSkill = new Animation();
        zoroFSkill_r = new Animation();
        zoroFF = new Animation();
        zoroFF_r = new Animation();

        zoroSound = new SoundEffects();
        zoroHit = new Animation();
        zoroHit_r = new Animation();

        for (int i = 0 ; i < 100; i++) {
            hp.add(new MovingBitmap(R.drawable.healthpoint));
            hp.get(i).setLocation(50 + i, 50);
        }
        hpBg.setLocation(49, 50);

        szoroESkill = new Animation();
        szoroESkill_r =new Animation();
        szoroGSkill = new Animation();
        szoroGSkill_r = new Animation();
        szoroGG = new Animation();
        szoroGG_r = new Animation();
        szoroFSkill = new Animation();
        szoroFSkill_r = new Animation();
        szoroFF = new Animation();
        szoroFF_r = new Animation();
        szoroSSkill = new Animation();
        szoroSSkill_r = new Animation();
        szoroSS = new Animation();
        szoroSS_r = new Animation();

        px = 400; py = 200;
        initialize();
    }

    public void initialize() {
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
        secSetInvisble();

        soundEffectsInit();
    }

    public void show() {
        zoro.show();           zoro_r.show();
        zoroRun.show();        zoroRun_r.show();
        zoroAttack.show();     zoroAttack_r.show();
        zoroDefend.show();     zoroDefend_r.show();
        zoroJump.show();       zoroJump_r.show();
        zoroESkill.show();     zoroESkill_r.show();
        zoroGSkill.show();     zoroGSkill_r.show();
        zoroFSkill.show();     zoroFSkill_r.show();
        zoroHit.show();        zoroHit_r.show();

        szoroGSkill.show();     szoroGSkill_r.show();
        szoroESkill.show();     szoroESkill_r.show();
        szoroFSkill.show();     szoroFSkill_r.show();
        szoroSSkill.show();     szoroSSkill_r.show();

        zoroFF.show();      zoroFF_r.show();
        szoroFF.show();     szoroFF_r.show();
        szoroGG.show();     szoroGG_r.show();
        szoroSS.show();     szoroSS_r.show();

        hpBg.show();    zoro_small.show();
        for (int i = 0; i < 100; i++) {
            hp.get(i).show();
        }
    }

    public void move(int roadPx) {
        zoro.move();           zoro_r.move();
        zoroRun.move();        zoroRun_r.move();
        zoroAttack.move();     zoroAttack_r.move();
        zoroDefend.move();     zoroDefend_r.move();
        zoroJump.move();       zoroJump_r.move();
        zoroESkill.move();     zoroESkill_r.move();
        zoroGSkill.move();     zoroGSkill_r.move();
        zoroFSkill.move();     zoroFSkill_r.move();

        szoroESkill.move();     szoroESkill_r.move();
        szoroGSkill.move();     szoroGSkill_r.move();
        szoroFSkill.move();     szoroFSkill_r.move();
        szoroSSkill.move();     szoroSSkill_r.move();

        zoroFF.move();       zoroFF_r.move();
        szoroGG.move();      szoroGG_r.move();
        szoroSS.move();      szoroSS_r.move();
        szoroFF.move();      szoroFF_r.move();

        //Zoro in mormal mode
        if(!Button.fire_bool){
            //Let second mode invisible
            secSetInvisble();

            //To appear the health point line
            for (int i = 0; i < 100; i++) {
                if (i < 100*healthPoint/maxHp)
                    hp.get(i).setVisible(true);
                else
                    hp.get(i).setVisible(false);
            }

            //If not attacking, than zoro can run
            if ( !(attacking || attacking_r || ESkilling || ESkilling_r ||
                   GSkilling || GSkilling_r || FSkilling || FSkilling_r ||
                   jumping || jumping_r || defending || defending_r) ){
                   running(roadPx);
               }

            //Set zoro's location according to px and py
            setLocation(px, py);
            //Handle the event zoro should stop running
            stopRunning();

            // Perform each skills.
            attack();
            jump();
            defend();
            ESkill();
            GSkill();
            FSkill();

            //Reset zoro's attack area while zoro is not attacking
            if ( !(attacking || attacking_r || ESkilling || ESkilling_r ||
                   GSkilling || GSkilling_r || FSkilling || FSkilling_r ||
                   SSkilling || SSkilling_r) )
                setAttackArea();

        }
        //Set zoro's second mode
        else if(Button.fire_bool){
            //Let zoro's first mode invisible
            setInvisible();

            //To appear the health point line
            for (int i = 0; i < 100; i++) {
                if (i < 100*healthPoint/maxHp)
                    hp.get(i).setVisible(true);
                else
                    hp.get(i).setVisible(false);
            }

            //To perform running when zoro is not attacking
            if ( !(attacking || attacking_r || ESkilling || ESkilling_r ||
                   GSkilling || GSkilling_r || FSkilling || FSkilling_r ||
                   SSkilling || SSkilling_r || jumping || jumping_r ||
                   defending || defending_r) ){
                    running(roadPx);
               }

            secSetLocation(px, py);
            stopRunning();

            attack();
            jump();
            defend();

            secESkill();
            secGSkill();
            secFSkill();
            secSSkill();

            if ( !(attacking || attacking_r || ESkilling || ESkilling_r ||
                   GSkilling || GSkilling_r || FSkilling || FSkilling_r ||
                   SSkilling || SSkilling_r) )
                setAttackArea();
            }

    }

    public void release() {
       zoro.release();             zoro_r.release();
       zoroRun.release();          zoroRun_r.release();
       zoroAttack.release();       zoroAttack_r.release();
       zoroDefend.release();       zoroDefend_r.release();
       zoroJump.release();         zoroJump_r.release();
       zoroESkill.release();       zoroESkill_r.release();
       zoroGSkill.release();       zoroGSkill_r.release();
       zoroFSkill.release();       zoroFSkill_r.release();
       zoroHit.release();          zoroHit_r.release();
       szoroESkill.release();      szoroESkill_r.release();
       szoroFSkill.release();      szoroFSkill_r.release();
       szoroGSkill.release();      szoroGSkill_r.release();
       szoroSSkill.release();      szoroSSkill_r.release();
       zoro_small.release();       zoroSound.release();
       szoroGG.release();       szoroGG_r.release();
       szoroSS.release();       szoroSS_r.release();
       szoroFF.release();       szoroFF_r.release();
       zoroFF.release();        zoroFF_r.release();

        for (int i = 0; i < hp.size(); i++) {
            hp.get(i).release();
        }
        hpBg.release();
    }

    /************************
     * Get information area *
     ************************/
    public int getX(){
        return px;
    }
    public int getY() {
        return py;
    }
    public int getWidth() {
        return zoro.getWidth();
    }
    public int getHeight() {
        return zoro.getHeight();
    }
    public int getDamage() { return damage; }
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
        return (hitVisible || hitVisible_r );
    }
    /********************
    * Get Hit Function Area *
    ********************/

     // Handle the event zoro get hit
    public void getHit(ArrayList<AttackObject> attacks, int roadPx){
        zoroHit.move();
        zoroHit_r.move();
        //If zoro is not get hitting, then perform getHit
        if (!hitVisible && !hitVisible_r)
            //If zoro is in one of enemieses attack area, then get hit
            for (AttackObject at : attacks) {
                //Decide which side to be hit
                if (at.isAttacking() && isInAttackArea(at.getAttackArea())) {
                    healthPoint -= at.damage;
                    visible = false;
                    visible_r = false;
                    runVisible = false;
                    runVisible_r = false;
                    setInvisible();
                    hitVisible_r = true;
                    zoroHit_r.setVisible(hitVisible_r);
                    zoroHit_r.reset();

                    //zoro should stop running while get hit.
                    notRunning(roadPx);

                    break;
                }
                if (at.isAttacking_r() && isInAttackArea(at.getAttackArea())) {
                    healthPoint -= at.damage;
                    visible = false;
                    visible_r = false;
                    runVisible = false;
                    runVisible_r = false;
                    setInvisible();
                    hitVisible = true;
                    zoroHit.setVisible(hitVisible);
                    zoroHit.reset();

                    notRunning(roadPx);

                    break;
                }
            }

        //Let zoro get back to the middle of the screen after being hit away
        if (roadPx != 800 && roadPx != -800 && px != 400)
            px = 400;

        //Let zoro be hit away
        if (zoroHit.getCurrentFrameIndex() >= 0) {
            px -= 10;
            if (px < 0)
                px = 0;
            setLocation(px, py);
        } else if (zoroHit_r.getCurrentFrameIndex() >= 0) {
            px += 10;
            if (px > 800 - zoro.getWidth())
                px = 800 - zoro.getWidth();
            setLocation(px, py);
        }
        //Handle the situation when zoro is finishing get hit event.
        if ((hitVisible || hitVisible_r) && zoroHit.getCurrentFrameIndex() == -1
            && zoroHit_r.getCurrentFrameIndex() == -1) {
            if (hitVisible) {
                visible = true;
                visible_r = false;
                hitVisible = false;
            } else if (hitVisible_r) {
                visible = false;
                visible_r = true;
                hitVisible_r = false;
            }
            setVisible();
        }
    }
    public void secGetHit(ArrayList<AttackObject> attacks, int roadPx) {
        zoroHit.move();
        zoroHit_r.move();
        //If zoro is not get hitting, then perform getHit
        if (!hitVisible && !hitVisible_r)
            //If zoro is in one of enemieses attack area, then get hit
            for (AttackObject at : attacks) {
                //Decide which side to be hit
                if (at.isAttacking() && isInAttackArea(at.getAttackArea())) {
                    healthPoint -= at.damage;
                    visible = false;
                    visible_r = false;
                    runVisible = false;
                    runVisible_r = false;
                    secSetInvisble();
                    hitVisible_r = true;
                    zoroHit_r.setVisible(hitVisible_r);
                    zoroHit_r.reset();

                    //zoro should stop running while get hit.
                    notRunning(roadPx);

                    break;
                }
                if (at.isAttacking_r() && isInAttackArea(at.getAttackArea())) {
                    healthPoint -= at.damage;
                    visible = false;
                    visible_r = false;
                    runVisible = false;
                    runVisible_r = false;
                    secSetInvisble();
                    hitVisible = true;
                    zoroHit.setVisible(hitVisible);
                    zoroHit.reset();

                    notRunning(roadPx);

                    break;
                }
            }

        //Let zoro get back to the middle of the screen after being hit away
        if (roadPx != 800 && roadPx != -800 && px != 400)
            px = 400;

        //Let zoro be hit away
        if (zoroHit.getCurrentFrameIndex() >= 0) {
            px -= 10;
            if (px < 0)
                px = 0;
            secSetLocation(px, py);
        } else if (zoroHit_r.getCurrentFrameIndex() >= 0) {
            px += 10;
            if (px > 800 - zoro.getWidth())
                px = 800 - zoro.getWidth();
            secSetLocation(px, py);
        }

         //Handle the situation when zoro is finishing get hit event.
         if ((hitVisible || hitVisible_r) && zoroHit.getCurrentFrameIndex() == -1 && zoroHit_r.getCurrentFrameIndex() == -1) {
             if (hitVisible) {
                 visible = true;
                 visible_r = false;
                 hitVisible = false;
             } else if (hitVisible_r) {
                 visible = false;
                 visible_r = true;
                 hitVisible_r = false;
             }
             secSetVisible();
         }
    }
    //To determine if zoro is in the attack area
    public boolean isInAttackArea(int[] attackArea) {
        if ( px + zoro.getWidth() >= attackArea[0] && px <= attackArea[3] &&
                py + zoro.getWidth() >= attackArea[1] && py <= attackArea[2])
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
        zoro.setLocation(x, y);            zoro_r.setLocation(x, y);
        zoroRun.setLocation(x, y);         zoroRun_r.setLocation(x, y);
        zoroAttack.setLocation(x, y);      zoroAttack_r.setLocation(x, y);
        zoroDefend.setLocation(x, y);      zoroDefend_r.setLocation(x, y);
        zoroJump.setLocation(x, y);        zoroJump_r.setLocation(x, y);
        zoroESkill.setLocation(x, y);      zoroESkill_r.setLocation(x, y);
        zoroFSkill.setLocation(x, y);      zoroFSkill_r.setLocation(x, y);
        zoroGSkill.setLocation(x, y);      zoroGSkill_r.setLocation(x, y);
        zoroHit.setLocation(x, y);         zoroHit_r.setLocation(x, y);
        zoroFF.setLocation(x, y);          zoroFF_r.setLocation(x, y);
    }

    public void secSetLocation(int x, int y){
        zoro.setLocation(x, y);            zoro_r.setLocation(x, y);
        zoroRun.setLocation(x, y);         zoroRun_r.setLocation(x, y);
        zoroAttack.setLocation(x, y);      zoroAttack_r.setLocation(x, y);
        zoroDefend.setLocation(x, y);      zoroDefend_r.setLocation(x, y);
        zoroJump.setLocation(x, y);        zoroJump_r.setLocation(x, y);
        szoroESkill.setLocation(x, y);     szoroESkill_r.setLocation(x, y);
        szoroGSkill.setLocation(x, y);     szoroGSkill_r.setLocation(x, y);
        szoroFSkill.setLocation(x, y);     szoroFSkill_r.setLocation(x, y);
        szoroSSkill.setLocation(x, y);     szoroSSkill_r.setLocation(x, y);
        zoroHit.setLocation(x, y);         zoroHit_r.setLocation(x, y);
        szoroSS.setLocation(x, y);         szoroSS_r.setLocation(x, y);
        szoroGG.setLocation(x, y);         szoroGG_r.setLocation(x, y);
        szoroFF.setLocation(x, y);         szoroFF_r.setLocation(x, y);
    }
    //Let zoro run according to Navigarion
    public void running(int roadPx) {
        moving(roadPx);
        //decide Character face direction with Navigation
        if (Navigation.controllerPx - Navigation.initialCtrlPx < 0) {
            visible = false;
            visible_r = false;
            runVisible = false;
            runVisible_r = true;

            zoro.setVisible(visible);
            zoro_r.setVisible(visible_r);
            zoroRun.setVisible(runVisible);
            zoroRun_r.setVisible(runVisible_r);
        }
        else if (Navigation.controllerPx - Navigation.initialCtrlPx > 0) {
            visible = false;
            visible_r = false;
            runVisible = true;
            runVisible_r = false;

            zoro.setVisible(visible);
            zoro_r.setVisible(visible_r);
            zoroRun.setVisible(runVisible);
            zoroRun_r.setVisible(runVisible_r);
        }
    }

    //Let zoro stop running according to Navigation and which side zoro faced
    public void stopRunning() {
        if (Navigation.controllerPx - Navigation.initialCtrlPx == 0 && runVisible_r == true) {
            visible = false;
            visible_r = true;
            runVisible = false;
            runVisible_r = false;

            zoro.setVisible(visible);
            zoro_r.setVisible(visible_r);
            zoroRun.setVisible(runVisible);
            zoroRun_r.setVisible(runVisible_r);
        }
        else if (Navigation.controllerPx - Navigation.initialCtrlPx == 0 && runVisible == true) {
            visible = true;
            visible_r = false;
            runVisible = false;
            runVisible_r = false;

            zoro_r.setVisible(visible_r);
            zoroRun.setVisible(runVisible);
            zoroRun_r.setVisible(runVisible_r);
            zoro.setVisible(visible);
        }
    }
    //Let all zoro move according to Navigation location
    public void moving(int roadPx) {
        py += (Navigation.controllerPy - Navigation.initialCtrlPy)/10;
        if (py < 175 || py > 375)
            py -= (Navigation.controllerPy - Navigation.initialCtrlPy)/10;
        if (roadPx == 800 || roadPx == -800)
            px += (Navigation.controllerPx -  Navigation.initialCtrlPx)/5;
        if (px > 800 - zoro.getWidth()  || px < 0)
            px -= (Navigation.controllerPx -  Navigation.initialCtrlPx)/5;
        else if (roadPx != 800 && roadPx != -800 && px != 400)
            px = 400;
    }

    //Set all zoro visible
    public void setVisible() {
        zoro.setVisible(visible);
        zoro_r.setVisible(visible_r);
        zoroRun.setVisible(runVisible);
        zoroRun_r.setVisible(runVisible_r);
        zoroAttack.setVisible(false);
        zoroAttack_r.setVisible(false);
        zoroDefend.setVisible(false);
        zoroDefend_r.setVisible(false);
        zoroJump.setVisible(false);
        zoroJump_r.setVisible(false);
        zoroESkill.setVisible(false);
        zoroESkill_r.setVisible(false);
        zoroGSkill.setVisible(false);
        zoroGSkill_r.setVisible(false);
        zoroFSkill.setVisible(false);
        zoroFSkill_r.setVisible(false);
        zoroFF.setVisible(false);
        zoroFF_r.setVisible(false);
        zoroHit.setVisible(hitVisible);
        zoroHit_r.setVisible(hitVisible_r);
    }
    public void secSetVisible() {
        zoro.setVisible(visible);
        zoro_r.setVisible(visible_r);
        zoroRun.setVisible(runVisible);
        zoroRun_r.setVisible(runVisible_r);
        szoroESkill.setVisible(false);
        szoroESkill_r.setVisible(false);
        szoroGSkill.setVisible(false);
        szoroGSkill_r.setVisible(false);
        szoroGG.setVisible(false);
        szoroGG_r.setVisible(false);
        szoroFSkill.setVisible(false);
        szoroFSkill_r.setVisible(false);
        szoroFF.setVisible(false);
        szoroFF_r.setVisible(false);
        szoroSSkill.setVisible(false);
        szoroSSkill_r.setVisible(false);
        szoroSS.setVisible(false);
        szoroSS_r.setVisible(false);
        zoroHit.setVisible(hitVisible);
        zoroHit_r.setVisible(hitVisible_r);
    }

    //Set all zoro invisible
    public void setInvisible(){
        zoro.setVisible(visible);
        zoro_r.setVisible(visible_r);
        zoroRun.setVisible(runVisible);
        zoroRun_r.setVisible(runVisible_r);
        zoroESkill.setVisible(false);
        zoroESkill_r.setVisible(false);
        zoroGSkill.setVisible(false);
        zoroGSkill_r.setVisible(false);
        zoroFSkill.setVisible(false);
        zoroFSkill_r.setVisible(false);
        zoroFF.setVisible(false);
        zoroFF_r.setVisible(false);
    }

    public void secSetInvisble(){
        zoro.setVisible(visible);
        zoro_r.setVisible(visible_r);
        zoroRun.setVisible(runVisible);
        zoroRun_r.setVisible(runVisible_r);
        szoroESkill.setVisible(false);
        szoroESkill_r.setVisible(false);
        szoroGSkill.setVisible(false);
        szoroGSkill_r.setVisible(false);
        szoroFSkill.setVisible(false);
        szoroFSkill_r.setVisible(false);
        szoroSSkill.setVisible(false);
        szoroSSkill_r.setVisible(false);
        szoroFF.setVisible(false);
        szoroFF_r.setVisible(false);
        szoroGG.setVisible(false);
        szoroGG_r.setVisible(false);
        szoroSS.setVisible(false);
        szoroSS_r.setVisible(false);
    }



    /************************
     *  Skill Functoin Area *
     ************************/

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
        //To determine which side to perform skill when E button is perssed.
        if (Button.ePointerPressed == true && (visible == true || runVisible == true)) {
            visible = false;
            visible_r = false;
            runVisible = false;
            runVisible_r = false;

            setVisible();
            zoroESkill.setVisible(Button.ePointerPressed);
            zoroESkill.reset();
            ESkilling = true;
            damage = 10;
            zoroSound.play(6);
        }
        else if (Button.ePointerPressed == true && (visible_r == true || runVisible_r == true)) {
            visible = false;
            visible_r = false;
            runVisible = false;
            runVisible_r = false;

            setVisible();
            zoroESkill_r.setVisible(Button.ePointerPressed);
            zoroESkill_r.reset();
            ESkilling_r = true;
            damage = 10;
            zoroSound.play(6);
        }

        //To reset zoro state after E skill finish performing
        if ( zoroESkill.isLastFrame() && (ESkilling == true)) {
            visible = true;
            setVisible();
            ESkilling = false;
            zoroESkill.setCurrentFrameIndex(-1);
            damage = 0;
        }
        else if ( zoroESkill_r.isLastFrame() && (ESkilling_r == true)) {
            visible_r = true;
            setVisible();
            ESkilling_r = false;
            zoroESkill_r.setCurrentFrameIndex(-1);
            damage = 0;
        }

        //Set zoro attack area according to E skill
        if(ESkilling)
            setAttackArea(zoroESkill);
        else if (ESkilling_r){
            //To handle the different location setting when it faced left
            zoroESkill_r.setLocation( (px - zoroESkill_r.getWidth() + zoro_r.getWidth()) ,py);
            setAttackArea(zoroESkill_r);
            }
        Button.ePointerPressed = false;
    }
    //Sec_E skill perform
    public void secESkill() {
        if (Button.ePointerPressed == true && (visible == true || runVisible == true)) {
            visible = false;
            visible_r = false;
            runVisible = false;
            runVisible_r = false;

            secSetVisible();
            szoroESkill.setVisible(Button.ePointerPressed);
            szoroESkill.reset();
            ESkilling = true;
            damage = 20;
            zoroSound.play(6);
        }
        else if (Button.ePointerPressed == true && (visible_r == true || runVisible_r == true)) {
            visible = false;
            visible_r = false;
            runVisible = false;
            runVisible_r = false;

            secSetVisible();
            szoroESkill_r.setVisible(Button.ePointerPressed);
            szoroESkill_r.reset();
            ESkilling_r = true;
            damage = 20;
            zoroSound.play(6);
        }

        if ( szoroESkill.isLastFrame() && (ESkilling == true)) {
            visible = true;
            secSetVisible();
            ESkilling = false;
            szoroESkill.setCurrentFrameIndex(-1);
            damage = 0;
        }
        else if ( szoroESkill_r.isLastFrame() && (ESkilling_r == true)) {
            visible_r = true;
            secSetVisible();
            ESkilling_r = false;
            szoroESkill_r.setCurrentFrameIndex(-1);
            damage = 0;
        }

        if(ESkilling){
            szoroESkill.setLocation(px, py);
            setAttackArea(szoroESkill);
        }
        else if (ESkilling_r){
            szoroESkill_r.setLocation( (px - szoroESkill_r.getWidth() + zoro_r.getWidth()) ,py);
            setAttackArea(szoroESkill_r);
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
            zoroGSkill.setVisible(Button.gPointerPressed);
            zoroGSkill.reset();
            GSkilling = true;
            damage = 25;
            zoroSound.play(5);
        }
        else if (Button.gPointerPressed == true && (visible_r == true || runVisible_r == true)){
            visible = false;
            visible_r = false;
            runVisible = false;
            runVisible_r = false;

            setVisible();
            zoroGSkill_r.setVisible(Button.gPointerPressed);
            zoroGSkill_r.reset();
            GSkilling_r = true;
            damage = 25;
            zoroSound.play(5);
        }

        if ( zoroGSkill.isLastFrame() && (GSkilling == true)) {
            visible = true;
            setVisible();
            GSkilling = false;
            zoroGSkill.setCurrentFrameIndex(-1);
            damage = 0;
        }
        else if ( zoroGSkill_r.isLastFrame() && (GSkilling_r == true)) {
            visible_r = true;
            setVisible();
            GSkilling_r = false;
            zoroGSkill_r.setCurrentFrameIndex(-1);
            damage = 0;

        }

        if(GSkilling){
            zoroGSkill.setLocation(px, py);
            setAttackArea(zoroGSkill);
        }
        else if (GSkilling_r){
            zoroGSkill_r.setLocation(px - zoroGSkill_r.getWidth() + zoro_r.getWidth(), py);
            setAttackArea(zoroGSkill_r);
        }

        Button.gPointerPressed = false;
    }

    //Sec_G skill perform
    public void secGSkill() {
        if (Button.gPointerPressed == true && (visible == true || runVisible == true)){
            visible = false;
            visible_r = false;
            runVisible = false;
            runVisible_r = false;

            secSetVisible();
            szoroGSkill.setVisible(Button.gPointerPressed);
            szoroGG.setVisible(true);
            szoroGSkill.reset();
            szoroGG.reset();
            GSkilling = true;
            damage = 40;
            zoroSound.play(5);
        }
        else if (Button.gPointerPressed == true && (visible_r == true || runVisible_r == true)){
            visible = false;
            visible_r = false;
            runVisible = false;
            runVisible_r = false;

            secSetVisible();
            szoroGSkill_r.setVisible(Button.gPointerPressed);
            szoroGG_r.setVisible(true);
            szoroGSkill_r.reset();
            szoroGG_r.reset();
            GSkilling_r = true;
            damage = 40;
            zoroSound.play(5);
        }

        if ( szoroGSkill.isLastFrame() && (GSkilling == true)) {
            visible = true;
            secSetVisible();
            GSkilling = false;
            szoroGSkill.setCurrentFrameIndex(-1);
            szoroGG.setCurrentFrameIndex(-1);
            damage = 0;
        }
        else if ( szoroGSkill_r.isLastFrame() && (GSkilling_r == true)) {
            visible_r = true;
            secSetVisible();
            GSkilling_r = false;
            szoroGSkill_r.setCurrentFrameIndex(-1);
            szoroGG_r.setCurrentFrameIndex(-1);
            damage = 0;
        }

        if(GSkilling){
            szoroGSkill.setLocation(px + 22 , py);
            szoroGG.setLocation(px - 80, py - szoroGG.getHeight() + zoro.getHeight());
            setAttackArea(szoroGG);
        }
        else if (GSkilling_r){
            szoroGSkill_r.setLocation((px - szoroGSkill_r.getWidth() + zoro_r.getWidth())-22, py);
            szoroGG_r.setLocation(px, py - szoroGG_r.getHeight() + zoro_r.getHeight());
            setAttackArea(szoroGG_r);
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
            zoroFSkill.setVisible(Button.fPointerPressed);
            zoroFF.setVisible(true);
            zoroFSkill.reset();
            zoroFF.reset();
            FSkilling = true;
            damage = 40;
            zoroSound.play(7);
        }
        else if (Button.fPointerPressed == true && (visible_r == true || runVisible_r == true)){
            visible = false;
            visible_r = false;
            runVisible = false;
            runVisible_r = false;

            setVisible();
            zoroFSkill_r.setVisible(Button.fPointerPressed);
            zoroFF_r.setVisible(true);
            zoroFSkill_r.reset();
            zoroFF_r.reset();
            FSkilling_r = true;
            damage = 40;
            zoroSound.play(7);
        }

        if ( zoroFSkill.isLastFrame() && (FSkilling == true)) {
            visible = true;
            setVisible();
            FSkilling = false;
            zoroFSkill.setCurrentFrameIndex(-1);
            zoroFF.setCurrentFrameIndex(-1);
            damage = 0;
        }
        else if ( zoroFSkill_r.isLastFrame() && (FSkilling_r == true)) {
            visible_r = true;
            setVisible();
            FSkilling_r = false;
            zoroFSkill_r.setCurrentFrameIndex(-1);
            zoroFF_r.setCurrentFrameIndex(-1);
            damage = 0;
        }

        if(FSkilling)
            setAttackArea(zoroFF);
        else if (FSkilling_r){
            zoroFSkill_r.setLocation(px - zoroFSkill_r.getWidth() + zoro_r.getWidth(), py);
            zoroFF_r.setLocation(px - zoroFF_r.getWidth() + zoro_r.getWidth(), py);
            setAttackArea(zoroFF_r);
        }
        Button.fPointerPressed = false;
    }

    //Sec_F skill perform
    public void secFSkill() {
        if (Button.fPointerPressed == true && (visible == true || runVisible == true)){
            visible = false;
            visible_r = false;
            runVisible = false;
            runVisible_r = false;

            secSetVisible();
            szoroFSkill.setVisible(Button.fPointerPressed);
            szoroFF.setVisible(true);
            szoroFSkill.reset();
            szoroFF.reset();
            FSkilling = true;
            damage = 45;
            zoroSound.play(7);
        }
        else if (Button.fPointerPressed == true && (visible_r == true || runVisible_r == true)){
            visible = false;
            visible_r = false;
            runVisible = false;
            runVisible_r = false;

            secSetVisible();
            szoroFSkill_r.setVisible(Button.fPointerPressed);
            szoroFF_r.setVisible(true);
            szoroFSkill_r.reset();
            szoroFF_r.reset();
            FSkilling_r = true;
            damage = 45;
            zoroSound.play(7);
        }

        if ( szoroFSkill.isLastFrame() && (FSkilling == true)) {
            visible = true;
            secSetVisible();
            FSkilling = false;
            szoroFSkill.setCurrentFrameIndex(-1);
            szoroFF.setCurrentFrameIndex(-1);
            damage = 0;
        }
        else if ( szoroFSkill_r.isLastFrame() && (FSkilling_r == true)) {
            visible_r = true;
            secSetVisible();
            FSkilling_r = false;
            szoroFSkill_r.setCurrentFrameIndex(-1);
            szoroFF_r.setCurrentFrameIndex(-1);
            damage = 0;
        }

        if (FSkilling){
            szoroFSkill.setLocation(px, py);
            setAttackArea(szoroFF);
        }
        else if (FSkilling_r){
            szoroFSkill_r.setLocation(px - szoroFSkill_r.getWidth() + zoro_r.getWidth(), py);
            szoroFF_r.setLocation(px - szoroFF_r.getWidth() + zoro_r.getWidth(), py);
            setAttackArea(szoroFF_r);
        }
        Button.fPointerPressed = false;
    }
    //sec_S perform
    public void secSSkill(){
        if (Button.sPointerPressed == true && (visible == true || runVisible == true)
            && Button.fire_bool){
            visible = false;
            visible_r = false;
            runVisible = false;
            runVisible_r = false;

            secSetVisible();
            szoroSSkill.setVisible(Button.sPointerPressed);
            szoroSS.setVisible(true);
            szoroSSkill.reset();
            szoroSS.reset();
            SSkilling = true;
            damage = 50;
            zoroSound.play(4);
        }
        else if (Button.sPointerPressed == true && (visible_r == true || runVisible_r == true)){
            visible = false;
            visible_r = false;
            runVisible = false;
            runVisible_r = false;

            secSetVisible();
            szoroSSkill_r.setVisible(Button.sPointerPressed);
            szoroSS_r.setVisible(true);
            szoroSSkill_r.reset();
            szoroSS_r.reset();
            SSkilling_r = true;
            damage = 50;
            zoroSound.play(4);
        }

        if ( szoroSSkill.isLastFrame() && (SSkilling == true)) {
            visible = true;
            secSetVisible();
            SSkilling = false;
            szoroSSkill.setCurrentFrameIndex(-1);
            szoroSS.setCurrentFrameIndex(-1);
            damage = 0;
        }
        else if ( szoroSSkill_r.isLastFrame() && (SSkilling_r == true)) {
            visible_r = true;
            secSetVisible();
            SSkilling_r = false;
            szoroSSkill_r.setCurrentFrameIndex(-1);
            szoroSS_r.setCurrentFrameIndex(-1);
            damage = 0;
        }

        if (SSkilling){
            szoroSS.setLocation(px, py);
            szoroSSkill.setLocation(px - 40, py - szoroSSkill.getHeight() + zoro.getHeight());
            setAttackArea(szoroSSkill);
        }
        else if (SSkilling_r){
            szoroSS_r.setLocation(px, py);
            szoroSSkill_r.setLocation(px - szoroSSkill_r.getWidth() + zoro_r.getWidth() + 40,
                                      py - szoroSSkill_r.getHeight()+ zoro_r.getHeight());
            setAttackArea(szoroSSkill_r);
        }

        Button.sPointerPressed = false;
    }

    //zoro attacking perform
    public void attack() {
        if (Button.atPointerPressed == true && (visible == true || runVisible == true)){
            visible = false;
            visible_r = false;
            runVisible = false;
            runVisible_r = false;

            setVisible();
            zoroAttack.setVisible(Button.atPointerPressed);
            zoroAttack.reset();
            attacking = true;
            damage = 10;
            zoroSound.play(1);
        }
        else if (Button.atPointerPressed == true && (visible_r == true || runVisible_r == true)){
            visible = false;
            visible_r = false;
            runVisible = false;
            runVisible_r = false;

            setVisible();
            zoroAttack_r.setVisible(Button.atPointerPressed);
            zoroAttack_r.reset();
            attacking_r = true;
            damage = 10;
            zoroSound.play(1);
        }

        if ( zoroAttack.isLastFrame() && (attacking == true)) {
            visible = true;
            setVisible();
            attacking = false;
            zoroAttack.setCurrentFrameIndex(-1);
            damage = 0;
        }
        else if ( zoroAttack_r.isLastFrame() && attacking_r == true) {
            visible_r = true;
            setVisible();
            attacking_r = false;
            zoroAttack_r.setCurrentFrameIndex(-1);
            damage = 0;
        }
        if(attacking_r)
            zoroAttack_r.setLocation( (px - zoroAttack_r.getWidth() + zoro_r.getWidth()) ,py);

        if(attacking)
            setAttackArea(zoroAttack);
        else if (attacking_r)
            setAttackArea(zoroAttack_r);

        Button.atPointerPressed = false;
    }
    //Defending perform
    public void defend() {
        if (Button.dfPointerPressed == true && (visible == true || runVisible == true)){
            zoroSound.play(3);
            visible = false;
            visible_r = false;
            runVisible = false;
            runVisible_r = false;

            setVisible();

            zoroDefend.setVisible(Button.dfPointerPressed);
            zoroDefend.reset();
            defending = true;
        }
        else if (Button.dfPointerPressed == true && (visible_r == true || runVisible_r == true)){
            visible = false;
            visible_r = false;
            runVisible = false;
            runVisible_r = false;

            setVisible();

            zoroDefend_r.setVisible(Button.dfPointerPressed);
            zoroDefend_r.reset();
            defending_r = true;
            zoroSound.play(3);
        }

        if ( zoroDefend.isLastFrame() && (defending == true)) {
            visible = true;
            setVisible();
            defending = false;
            zoroDefend.setCurrentFrameIndex(-1);
        }
        else if ( zoroDefend_r.isLastFrame() && (defending_r == true)) {
            visible_r = true;
            setVisible();
            defending_r = false;
            zoroDefend_r.setCurrentFrameIndex(-1);
        }
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
            zoroJump.setVisible(Button.jpPointerPressed);
            zoroJump.reset();
            jumping = true;
            zoroSound.play(2);
        }
        else if (Button.jpPointerPressed == true && (visible_r == true || runVisible_r == true)){
            visible = false;
            visible_r = false;
            runVisible = false;
            runVisible_r = false;

            setVisible();
            zoroJump_r.setVisible(Button.jpPointerPressed);
            zoroJump_r.reset();
            jumping_r = true;
            zoroSound.play(2);
        }

        if ( zoroJump.isLastFrame() && (jumping == true)) {
            visible = true;
            setVisible();
            jumping = false;
            zoroJump.setCurrentFrameIndex(-1);
        }
        else if ( zoroJump_r.isLastFrame() && (jumping_r == true)) {
            visible_r = true;
            setVisible();
            jumping_r = false;
            zoroJump_r.setCurrentFrameIndex(-1);
        }

        if(jumping) {
            zoroJump.setLocation(px, py + zoro.getHeight() - zoroJump.getHeight());
        }
        else if (jumping_r) {
            zoroJump_r.setLocation(px, py + zoro.getHeight() - zoroJump_r.getHeight());
        }
        Button.jpPointerPressed = false;
    }

    /****************************
     * Initialize Function Area *
     ****************************/

     //Initialize all Zoro animation frame
     public void addFrame() {
         //Zoro add frame
         zoro.addFrame(R.drawable.zoro_00);
         zoro.addFrame(R.drawable.zoro_01);
         zoro.addFrame(R.drawable.zoro_02);
         zoro.addFrame(R.drawable.zoro_03);
         zoro_r.addFrame(R.drawable.zoro_00_r);
         zoro_r.addFrame(R.drawable.zoro_01_r);
         zoro_r.addFrame(R.drawable.zoro_02_r);
         zoro_r.addFrame(R.drawable.zoro_03_r);

         //zoro add get hit frame
         zoroHit.addFrame(R.drawable.zoro_hit01);
         zoroHit.addFrame(R.drawable.zoro_hit02);
         zoroHit.addFrame(R.drawable.zoro_hit03);
         zoroHit.addFrame(R.drawable.zoro_hit04);
         zoroHit_r.addFrame(R.drawable.zoro_hit01_r);
         zoroHit_r.addFrame(R.drawable.zoro_hit02_r);
         zoroHit_r.addFrame(R.drawable.zoro_hit03_r);
         zoroHit_r.addFrame(R.drawable.zoro_hit04_r);

         //Zoro add run frame
         zoroRun.addFrame(R.drawable.zoro_run00);
         zoroRun.addFrame(R.drawable.zoro_run01);
         zoroRun.addFrame(R.drawable.zoro_run02);
         zoroRun.addFrame(R.drawable.zoro_run03);
         zoroRun_r.addFrame(R.drawable.zoro_run00_r);
         zoroRun_r.addFrame(R.drawable.zoro_run01_r);
         zoroRun_r.addFrame(R.drawable.zoro_run02_r);
         zoroRun_r.addFrame(R.drawable.zoro_run03_r);

         //Zoro add attacking frame
         zoroAttack.addFrame(R.drawable.zoro_attack00);
         zoroAttack.addFrame(R.drawable.zoro_attack01);
         zoroAttack.addFrame(R.drawable.zoro_attack02);
         zoroAttack.addFrame(R.drawable.zoro_attack03);
         zoroAttack.addFrame(R.drawable.zoro_attack04);
         zoroAttack_r.addFrame(R.drawable.zoro_attack00_r);
         zoroAttack_r.addFrame(R.drawable.zoro_attack01_r);
         zoroAttack_r.addFrame(R.drawable.zoro_attack02_r);
         zoroAttack_r.addFrame(R.drawable.zoro_attack03_r);
         zoroAttack_r.addFrame(R.drawable.zoro_attack04_r);

         //zoro add defend frame
         zoroDefend.addFrame(R.drawable.zoro_df01);
         zoroDefend.addFrame(R.drawable.zoro_df02);
         zoroDefend.addFrame(R.drawable.zoro_df03);
         zoroDefend_r.addFrame(R.drawable.zoro_df01_r);
         zoroDefend_r.addFrame(R.drawable.zoro_df02_r);
         zoroDefend_r.addFrame(R.drawable.zoro_df03_r);

         //zoro add jump frame
         zoroJump.addFrame(R.drawable.zoro_jp01);
         zoroJump.addFrame(R.drawable.zoro_jp02);
         zoroJump.addFrame(R.drawable.zoro_jp03);
         zoroJump.addFrame(R.drawable.zoro_jp04);
         zoroJump.addFrame(R.drawable.zoro_jp05);
         zoroJump.addFrame(R.drawable.zoro_jp05);
         zoroJump.addFrame(R.drawable.zoro_jp04);
         zoroJump.addFrame(R.drawable.zoro_jp03);
         zoroJump.addFrame(R.drawable.zoro_jp02);
         zoroJump.addFrame(R.drawable.zoro_jp01);
         zoroJump_r.addFrame(R.drawable.zoro_jp01_r);
         zoroJump_r.addFrame(R.drawable.zoro_jp02_r);
         zoroJump_r.addFrame(R.drawable.zoro_jp03_r);
         zoroJump_r.addFrame(R.drawable.zoro_jp04_r);
         zoroJump_r.addFrame(R.drawable.zoro_jp05_r);
         zoroJump_r.addFrame(R.drawable.zoro_jp05_r);
         zoroJump_r.addFrame(R.drawable.zoro_jp04_r);
         zoroJump_r.addFrame(R.drawable.zoro_jp03_r);
         zoroJump_r.addFrame(R.drawable.zoro_jp02_r);
         zoroJump_r.addFrame(R.drawable.zoro_jp01_r);
         //zoro add Eskill frame
         zoroESkill.addFrame(R.drawable.zoro_e01);
         zoroESkill.addFrame(R.drawable.zoro_e02);
         zoroESkill.addFrame(R.drawable.zoro_e03);
         zoroESkill.addFrame(R.drawable.zoro_e04);
         zoroESkill.addFrame(R.drawable.zoro_e05);
         zoroESkill_r.addFrame(R.drawable.zoro_e01_r);
         zoroESkill_r.addFrame(R.drawable.zoro_e02_r);
         zoroESkill_r.addFrame(R.drawable.zoro_e03_r);
         zoroESkill_r.addFrame(R.drawable.zoro_e04_r);
         zoroESkill_r.addFrame(R.drawable.zoro_e05_r);

         //zoro add Gskill frame
         zoroGSkill.addFrame(R.drawable.zoro_g01);
         zoroGSkill.addFrame(R.drawable.zoro_g02);
         zoroGSkill.addFrame(R.drawable.zoro_g03);
         zoroGSkill.addFrame(R.drawable.zoro_g04);
         zoroGSkill.addFrame(R.drawable.zoro_g05);
         zoroGSkill.addFrame(R.drawable.zoro_g06);
         zoroGSkill.addFrame(R.drawable.zoro_g07);
         zoroGSkill.addFrame(R.drawable.zoro_g08);
         zoroGSkill.addFrame(R.drawable.zoro_g09);
         zoroGSkill.addFrame(R.drawable.zoro_g10);
         zoroGSkill_r.addFrame(R.drawable.zoro_g01_r);
         zoroGSkill_r.addFrame(R.drawable.zoro_g02_r);
         zoroGSkill_r.addFrame(R.drawable.zoro_g03_r);
         zoroGSkill_r.addFrame(R.drawable.zoro_g04_r);
         zoroGSkill_r.addFrame(R.drawable.zoro_g05_r);
         zoroGSkill_r.addFrame(R.drawable.zoro_g06_r);
         zoroGSkill_r.addFrame(R.drawable.zoro_g07_r);
         zoroGSkill_r.addFrame(R.drawable.zoro_g08_r);
         zoroGSkill_r.addFrame(R.drawable.zoro_g09_r);
         zoroGSkill_r.addFrame(R.drawable.zoro_g10_r);

         //zoro add Fskill frame
         zoroFSkill.addFrame(R.drawable.zoro_f01);
         zoroFSkill.addFrame(R.drawable.zoro_f02);
         zoroFSkill.addFrame(R.drawable.zoro_f03);
         zoroFSkill_r.addFrame(R.drawable.zoro_f01_r);
         zoroFSkill_r.addFrame(R.drawable.zoro_f02_r);
         zoroFSkill_r.addFrame(R.drawable.zoro_f03_r);

         //zoro FF add frame
         zoroFF.addFrame(R.drawable.zoro_ff01);
         zoroFF.addFrame(R.drawable.zoro_ff02);
         zoroFF.addFrame(R.drawable.zoro_ff03);
         zoroFF.addFrame(R.drawable.zoro_ff04);
         zoroFF_r.addFrame(R.drawable.zoro_ff01_r);
         zoroFF_r.addFrame(R.drawable.zoro_ff02_r);
         zoroFF_r.addFrame(R.drawable.zoro_ff03_r);
         zoroFF_r.addFrame(R.drawable.zoro_ff04_r);
     }

     public void secAddFrame(){
         //Sec_zoro Eskill
         szoroESkill.addFrame(R.drawable.szoro_e01);
         szoroESkill.addFrame(R.drawable.szoro_e02);
         szoroESkill.addFrame(R.drawable.szoro_e03);
         szoroESkill.addFrame(R.drawable.szoro_e04);
         szoroESkill.addFrame(R.drawable.szoro_e05);
         szoroESkill.addFrame(R.drawable.szoro_e06);
         szoroESkill.addFrame(R.drawable.szoro_e07);
         szoroESkill.addFrame(R.drawable.szoro_e08);
         //Sec_zoro Eskill reverse
         szoroESkill_r.addFrame(R.drawable.szoro_e01_r);
         szoroESkill_r.addFrame(R.drawable.szoro_e02_r);
         szoroESkill_r.addFrame(R.drawable.szoro_e03_r);
         szoroESkill_r.addFrame(R.drawable.szoro_e04_r);
         szoroESkill_r.addFrame(R.drawable.szoro_e05_r);
         szoroESkill_r.addFrame(R.drawable.szoro_e06_r);
         szoroESkill_r.addFrame(R.drawable.szoro_e07_r);
         szoroESkill_r.addFrame(R.drawable.szoro_e08_r);
         //Sec_zoro Fskill
         szoroFSkill.addFrame(R.drawable.szoro_f01);
         szoroFSkill.addFrame(R.drawable.szoro_f02);
         szoroFSkill.addFrame(R.drawable.szoro_f03);
         //Sec_zoro Fskill reverse
         szoroFSkill_r.addFrame(R.drawable.szoro_f01_r);
         szoroFSkill_r.addFrame(R.drawable.szoro_f02_r);
         szoroFSkill_r.addFrame(R.drawable.szoro_f03_r);
         //Sec_zoro Gskill
         szoroGSkill.addFrame(R.drawable.szoro_g01);
         szoroGSkill.addFrame(R.drawable.szoro_g02);
         szoroGSkill.addFrame(R.drawable.szoro_g03);
         szoroGSkill.addFrame(R.drawable.szoro_g04);
         szoroGSkill.addFrame(R.drawable.szoro_g05);
         szoroGSkill.addFrame(R.drawable.szoro_g06);
         //Sec_zoro Gskill reverse
         szoroGSkill_r.addFrame(R.drawable.szoro_g01_r);
         szoroGSkill_r.addFrame(R.drawable.szoro_g02_r);
         szoroGSkill_r.addFrame(R.drawable.szoro_g03_r);
         szoroGSkill_r.addFrame(R.drawable.szoro_g04_r);
         szoroGSkill_r.addFrame(R.drawable.szoro_g05_r);
         szoroGSkill_r.addFrame(R.drawable.szoro_g06_r);
         //Sec_zoro Sskill
         szoroSSkill.addFrame(R.drawable.zoro_s01);
         szoroSSkill.addFrame(R.drawable.zoro_s02);
         szoroSSkill.addFrame(R.drawable.zoro_s03);
         szoroSSkill.addFrame(R.drawable.zoro_s04);
         szoroSSkill.addFrame(R.drawable.zoro_s05);
         szoroSSkill.addFrame(R.drawable.zoro_s06);
         szoroSSkill.addFrame(R.drawable.zoro_s07);
         szoroSSkill.addFrame(R.drawable.zoro_s08);
         szoroSSkill.addFrame(R.drawable.zoro_s09);
         szoroSSkill.addFrame(R.drawable.zoro_s10);
         szoroSSkill.addFrame(R.drawable.zoro_s11);
         szoroSSkill.addFrame(R.drawable.zoro_s12);
         szoroSSkill.addFrame(R.drawable.zoro_s13);
         szoroSSkill.addFrame(R.drawable.zoro_s14);
         szoroSSkill.addFrame(R.drawable.zoro_s15);
         szoroSSkill.addFrame(R.drawable.zoro_s16);
         szoroSSkill.addFrame(R.drawable.zoro_s17);
         //Sec_zoro Sskill reverse
         szoroSSkill_r.addFrame(R.drawable.zoro_s01_r);
         szoroSSkill_r.addFrame(R.drawable.zoro_s02_r);
         szoroSSkill_r.addFrame(R.drawable.zoro_s03_r);
         szoroSSkill_r.addFrame(R.drawable.zoro_s04_r);
         szoroSSkill_r.addFrame(R.drawable.zoro_s05_r);
         szoroSSkill_r.addFrame(R.drawable.zoro_s06_r);
         szoroSSkill_r.addFrame(R.drawable.zoro_s07_r);
         szoroSSkill_r.addFrame(R.drawable.zoro_s08_r);
         szoroSSkill_r.addFrame(R.drawable.zoro_s09_r);
         szoroSSkill_r.addFrame(R.drawable.zoro_s10_r);
         szoroSSkill_r.addFrame(R.drawable.zoro_s11_r);
         szoroSSkill_r.addFrame(R.drawable.zoro_s12_r);
         szoroSSkill_r.addFrame(R.drawable.zoro_s13_r);
         szoroSSkill_r.addFrame(R.drawable.zoro_s14_r);
         szoroSSkill_r.addFrame(R.drawable.zoro_s15_r);
         szoroSSkill_r.addFrame(R.drawable.zoro_s16_r);
         //sZoro FF add frame
         szoroFF.addFrame(R.drawable.szoro_ff01);
         szoroFF.addFrame(R.drawable.szoro_ff02);
         szoroFF.addFrame(R.drawable.szoro_ff03);
         szoroFF.addFrame(R.drawable.szoro_ff04);
         szoroFF_r.addFrame(R.drawable.szoro_ff01_r);
         szoroFF_r.addFrame(R.drawable.szoro_ff02_r);
         szoroFF_r.addFrame(R.drawable.szoro_ff03_r);
         szoroFF_r.addFrame(R.drawable.szoro_ff04_r);
         //sZoro GG add frame
         szoroGG.addFrame(R.drawable.szoro_gg01);
         szoroGG.addFrame(R.drawable.szoro_gg02);
         szoroGG.addFrame(R.drawable.szoro_gg03);
         szoroGG.addFrame(R.drawable.szoro_gg04);
         szoroGG.addFrame(R.drawable.szoro_gg05);
         szoroGG.addFrame(R.drawable.szoro_gg06);
         szoroGG.addFrame(R.drawable.szoro_gg07);
         szoroGG.addFrame(R.drawable.szoro_gg08);
         szoroGG.addFrame(R.drawable.szoro_gg09);
         szoroGG.addFrame(R.drawable.szoro_gg10);
         szoroGG.addFrame(R.drawable.szoro_gg11);
         szoroGG.addFrame(R.drawable.szoro_gg12);
         szoroGG.addFrame(R.drawable.szoro_gg13);
         szoroGG.addFrame(R.drawable.szoro_gg14);
         szoroGG.addFrame(R.drawable.szoro_gg15);
         szoroGG.addFrame(R.drawable.szoro_gg16);
         szoroGG_r.addFrame(R.drawable.szoro_gg01_r);
         szoroGG_r.addFrame(R.drawable.szoro_gg02_r);
         szoroGG_r.addFrame(R.drawable.szoro_gg03_r);
         szoroGG_r.addFrame(R.drawable.szoro_gg04_r);
         szoroGG_r.addFrame(R.drawable.szoro_gg05_r);
         szoroGG_r.addFrame(R.drawable.szoro_gg06_r);
         szoroGG_r.addFrame(R.drawable.szoro_gg07_r);
         szoroGG_r.addFrame(R.drawable.szoro_gg08_r);
         szoroGG_r.addFrame(R.drawable.szoro_gg09_r);
         szoroGG_r.addFrame(R.drawable.szoro_gg10_r);
         szoroGG_r.addFrame(R.drawable.szoro_gg11_r);
         szoroGG_r.addFrame(R.drawable.szoro_gg12_r);
         szoroGG_r.addFrame(R.drawable.szoro_gg13_r);
         szoroGG_r.addFrame(R.drawable.szoro_gg14_r);
         szoroGG_r.addFrame(R.drawable.szoro_gg15_r);
         szoroGG_r.addFrame(R.drawable.szoro_gg16_r);
         //sZoro SS add frame
         szoroSS.addFrame(R.drawable.zoro_sa01);
         szoroSS.addFrame(R.drawable.zoro_sa02);
         szoroSS.addFrame(R.drawable.zoro_sa03);
         szoroSS_r.addFrame(R.drawable.zoro_sa01);
         szoroSS_r.addFrame(R.drawable.zoro_sa02);
         szoroSS_r.addFrame(R.drawable.zoro_sa03);
     }

     //Set all Zoro animations delay
     public void frameDelay() {
         zoro.setDelay(5);
         zoro_r.setDelay(5);
         zoroRun.setDelay(2);
         zoroRun_r.setDelay(2);
         zoroAttack.setDelay(2);
         zoroAttack_r.setDelay(2);
         zoroDefend.setDelay(2);
         zoroDefend_r.setDelay(2);
         zoroJump.setDelay(2);
         zoroJump_r.setDelay(2);
         zoroESkill.setDelay(2);
         zoroESkill_r.setDelay(2);
         zoroGSkill.setDelay(2);
         zoroGSkill_r.setDelay(2);
         zoroFSkill.setDelay(2);
         zoroFSkill_r.setDelay(2);
         zoroHit.setDelay(4);
         zoroHit_r.setDelay(4);
     }
     public void secFrameDelay(){
         zoro.setDelay(4);
         zoro_r.setDelay(4);
         zoroRun.setDelay(2);
         zoroRun_r.setDelay(2);
         zoroAttack.setDelay(2);
         zoroAttack_r.setDelay(2);
         zoroDefend.setDelay(2);
         zoroDefend_r.setDelay(2);
         zoroJump.setDelay(2);
         zoroJump_r.setDelay(2);
         szoroESkill.setDelay(2);
         szoroESkill_r.setDelay(2);
         szoroGSkill.setDelay(2);
         szoroGSkill_r.setDelay(2);
         szoroFSkill.setDelay(2);
         szoroFSkill_r.setDelay(2);
         szoroSSkill.setDelay(2);
         szoroSSkill_r.setDelay(2);
         zoroHit.setDelay(4);
         zoroHit_r.setDelay(4);
     }
     //Set all Zoro animations repeating
     public void frameRepeating() {
         zoroAttack.setRepeating(false);
         zoroAttack_r.setRepeating(false);
         zoroDefend.setRepeating(false);
         zoroDefend_r.setRepeating(false);
         zoroJump.setRepeating(false);
         zoroJump_r.setRepeating(false);
         zoroESkill.setRepeating(false);
         zoroESkill_r.setRepeating(false);
         zoroGSkill.setRepeating(false);
         zoroGSkill_r.setRepeating(false);
         zoroFSkill.setRepeating(false);
         zoroFSkill_r.setRepeating(false);
         zoroHit.setRepeating(false);
         zoroHit_r.setRepeating(false);
         zoroFF.setRepeating(false);
         zoroFF_r.setRepeating(false);
     }

     public void secFrameRepeating(){
         zoroAttack.setRepeating(false);
         zoroAttack_r.setRepeating(false);
         zoroDefend.setRepeating(false);
         zoroDefend_r.setRepeating(false);
         zoroJump.setRepeating(false);
         zoroJump_r.setRepeating(false);
         szoroESkill.setRepeating(false);
         szoroESkill_r.setRepeating(false);
         szoroGSkill.setRepeating(false);
         szoroGSkill_r.setRepeating(false);
         szoroFSkill.setRepeating(false);
         szoroFSkill_r.setRepeating(false);
         szoroSSkill.setRepeating(false);
         szoroSSkill_r.setRepeating(false);
         zoroHit.setRepeating(false);
         zoroHit_r.setRepeating(false);
         szoroSS.setRepeating(false);
         szoroSS_r.setRepeating(false);
         szoroFF.setRepeating(false);
         szoroFF_r.setRepeating(false);
         szoroGG.setRepeating(false);
         szoroGG_r.setRepeating(false);
     }
     //Set all Zoro animation current index
     public void setCurrentIndex(int index) {
         zoroAttack.setCurrentFrameIndex(index);
         zoroAttack_r.setCurrentFrameIndex(index);
         zoroDefend.setCurrentFrameIndex(index);
         zoroDefend_r.setCurrentFrameIndex(index);
         zoroJump.setCurrentFrameIndex(index);
         zoroJump_r.setCurrentFrameIndex(index);
         zoroESkill.setCurrentFrameIndex(index);
         zoroESkill_r.setCurrentFrameIndex(index);
         zoroGSkill.setCurrentFrameIndex(index);
         zoroGSkill_r.setCurrentFrameIndex(index);
         zoroFSkill.setCurrentFrameIndex(index);
         zoroFSkill_r.setCurrentFrameIndex(index);
         zoroHit.setCurrentFrameIndex(index);
         zoroHit_r.setCurrentFrameIndex(index);
         zoroFF.setCurrentFrameIndex(index);
         zoroFF_r.setCurrentFrameIndex(index);
     }
     public void secSetCurrentIndex(int index){
         zoroAttack.setCurrentFrameIndex(index);
         zoroAttack_r.setCurrentFrameIndex(index);
         zoroDefend.setCurrentFrameIndex(index);
         zoroDefend_r.setCurrentFrameIndex(index);
         zoroJump.setCurrentFrameIndex(index);
         zoroJump_r.setCurrentFrameIndex(index);
         szoroESkill.setCurrentFrameIndex(index);
         szoroESkill_r.setCurrentFrameIndex(index);
         szoroGSkill.setCurrentFrameIndex(index);
         szoroGSkill_r.setCurrentFrameIndex(index);
         szoroFSkill.setCurrentFrameIndex(index);
         szoroFSkill_r.setCurrentFrameIndex(index);
         szoroSSkill.setCurrentFrameIndex(index);
         szoroSSkill_r.setCurrentFrameIndex(index);
         zoroHit.setCurrentFrameIndex(index);
         zoroHit_r.setCurrentFrameIndex(index);
         szoroSS.setCurrentFrameIndex(index);
         szoroSS_r.setCurrentFrameIndex(index);
         szoroFF.setCurrentFrameIndex(index);
         szoroFF_r.setCurrentFrameIndex(index);
         szoroGG.setCurrentFrameIndex(index);
         szoroGG_r.setCurrentFrameIndex(index);
     }
     public boolean isNotPerforming(){ return ((zoroAttack.getCurrentFrameIndex()==-1)&&(zoroAttack_r.getCurrentFrameIndex()==-1)
     &&(zoroDefend.getCurrentFrameIndex()==-1)&&(zoroDefend_r.getCurrentFrameIndex()==-1)
     &&(zoroJump.getCurrentFrameIndex()==-1)&&(zoroJump_r.getCurrentFrameIndex()==-1)
     &&(zoroESkill.getCurrentFrameIndex()==-1)&&(zoroESkill_r.getCurrentFrameIndex()==-1)
     &&(zoroGSkill.getCurrentFrameIndex()==-1)&&(zoroGSkill_r.getCurrentFrameIndex()==-1)
     &&(zoroFSkill.getCurrentFrameIndex()==-1)&&(zoroFSkill_r.getCurrentFrameIndex()==-1)
    &&(szoroESkill.getCurrentFrameIndex()==-1)&&(szoroESkill_r.getCurrentFrameIndex()==-1)
    &&(szoroGSkill.getCurrentFrameIndex()==-1)&&(szoroGSkill_r.getCurrentFrameIndex()==-1)
    &&(szoroFSkill.getCurrentFrameIndex()==-1)&&(szoroFSkill_r.getCurrentFrameIndex()==-1)
    &&(szoroSSkill.getCurrentFrameIndex()==-1)&&(szoroSSkill_r.getCurrentFrameIndex()==-1));
}
     public void setSecondModelVisible(){};
     public void soundEffectsInit(){
         zoroSound.addSoundEffect(1, R.raw.zoat);
         zoroSound.addSoundEffect(2, R.raw.zojp);
         zoroSound.addSoundEffect(3, R.raw.zodf);
         zoroSound.addSoundEffect(4, R.raw.zos);
         zoroSound.addSoundEffect(5, R.raw.zog);
         zoroSound.addSoundEffect(6, R.raw.zoe);
         zoroSound.addSoundEffect(7, R.raw.zof);
     }
}
