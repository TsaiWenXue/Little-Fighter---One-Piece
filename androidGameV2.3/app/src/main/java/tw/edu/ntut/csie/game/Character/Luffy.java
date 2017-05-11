package tw.edu.ntut.csie.game.Character;

import tw.edu.ntut.csie.game.R;
import tw.edu.ntut.csie.game.extend.Animation;
import tw.edu.ntut.csie.game.state.Button;
import tw.edu.ntut.csie.game.state.Navigation;
import tw.edu.ntut.csie.game.state.Stage1BG;

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

    private int px, py;

    private boolean visible = true, visible_r = false;
    private boolean runVisible = false, runVisible_r = false;

    public boolean attacking = false, attacking_r = false;
    private boolean defending = false, defending_r = false;
    private boolean jumping = false, jumping_r = false;
    private boolean ESkilling = false, ESkilling_r = false;
    private boolean GSkilling = false, GSkilling_r = false;
    private boolean FSkilling = false, FSkilling_r = false;


    public boolean isAttacking() {
        if (attacking || ESkilling || FSkilling || GSkilling)
            return true;
        return false;
    }

    public boolean isAttacking_r() {
        if (attacking_r || ESkilling_r || FSkilling_r || GSkilling_r)
            return true;
        return false;
    }


    private int[] attackArea = new int[4];
    private int damage = 0;


    public Luffy () {
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

        px = 400; py = 200;
    }

    public void initialize(){
        addFrame();
        frameDelay();
        frameRepeating();
        setVisible();
        setCurrentIndex(-1);
        setLocation(px, py);
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

    public int[] getAttackArea() {
        return attackArea;
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
    }

    public void move(int roadPx) {
        luffy.move();           luffy_r.move();
        luffyRun.move();        luffyRun_r.move();
        luffyAttack.move();     luffyAttack_r.move();
        luffyDefend.move();     luffyDefend_r.move();
        luffyJump.move();       luffyJump_r.move();
        luffyESkill.move();     luffyESkill_r.move();
        luffyGSkill.move();     luffyGSkill_r.move();
        luffyFSkill.move();     luffyFSkill_r.move();

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

    public void release() {
//        luffy.release();            luffy_r.release();
//        luffyRun.release();         luffyRun_r.release();
//        luffyAttack.release();      luffyAttack_r.release();
//        luffyDefend.release();      luffyDefend_r.release();
//        luffyJump.release();        luffyJump_r.release();
//        luffyESkill.release();      luffyESkill_r.release();
//        luffyGSkill.release();      luffyGSkill_r.release();
//        luffyFSkill.release();      luffyFSkill_r.release();
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

    //Let all luffy move according to Navigation location
    public void moving(int roadPx) {
        py += (Navigation.controllerPy - Navigation.initialCtrlPy)/10;
        if (py < 175 || py > 375)
            py -= (Navigation.controllerPy - Navigation.initialCtrlPy)/10;
        if (roadPx == 800 || roadPx == -800)
            px += (Navigation.controllerPx -  Navigation.initialCtrlPx)/5;
        if (px > 750 || px < 0)
            px -= (Navigation.controllerPx -  Navigation.initialCtrlPx)/5;
        else if (roadPx < 800 && px < 400)
            px++;
        else if (roadPx > -800 && px > 400)
            px--;
            py += (Navigation.controllerPy - Navigation.initialCtrlPy)/10;
            if (py < 175 || py > 375)
                py -= (Navigation.controllerPy - Navigation.initialCtrlPy)/10;
            if (roadPx == 800 || roadPx == -800)
                px += (Navigation.controllerPx -  Navigation.initialCtrlPx)/5;
            if (px > 750 || px < 0)
                px -= (Navigation.controllerPx -  Navigation.initialCtrlPx)/5;
            else if (roadPx < 800 && px < 400)
                px++;
            else if (roadPx > -800 && px > 400)
                px--;

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
            damage = 0;
        }
        else if ( luffyESkill_r.isLastFrame() && (ESkilling_r == true)) {
            visible_r = true;
            setVisible();
            ESkilling_r = false;
            damage = 0;
        }
        if (ESkilling_r)
            luffyESkill_r.setLocation( (px - luffyESkill_r.getWidth() + luffy_r.getWidth()) ,py);

        if(ESkilling)
            setAttackArea(luffyESkill);
        else if (ESkilling_r)
            setAttackArea(luffyESkill_r);

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
            damage = 0;
        }
        else if ( luffyGSkill_r.isLastFrame() && (GSkilling_r == true)) {
            visible_r = true;
            setVisible();
            GSkilling_r = false;
            damage = 0;
        }

        if (GSkilling)
            luffyGSkill.setLocation(px, py - luffyGSkill.getHeight() + luffy.getHeight());
        else if (GSkilling_r)
            luffyGSkill_r.setLocation(px, py - luffyGSkill_r.getHeight() + luffy_r.getHeight());

        if(GSkilling)
            setAttackArea(luffyGSkill);
        else if (GSkilling_r)
            setAttackArea(luffyGSkill_r);

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
            damage = 0;
        }
        else if ( luffyFSkill_r.isLastFrame() && (FSkilling_r == true)) {
            visible_r = true;
            setVisible();
            FSkilling_r = false;
            damage = 0;
        }

        if (FSkilling_r)
            luffyFSkill_r.setLocation(px - luffyFSkill_r.getWidth() + luffy_r.getWidth(), py);

//        if (FSkilling)
//            luffyFSkill.setLocation(px - luffyFSkill.getWidth() + luffy.getWidth(), py);



        if(FSkilling)
            setAttackArea(luffyFSkill);
        else if (FSkilling_r)
            setAttackArea(luffyFSkill_r);

        Button.fPointerPressed = false;
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
            damage = 0;
        }
        else if ( luffyAttack_r.isLastFrame() && attacking_r == true) {
            visible_r = true;
            setVisible();
            attacking_r = false;
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
        }
        else if ( luffyDefend_r.isLastFrame() && (defending_r == true)) {
            visible_r = true;
            setVisible();
            defending_r = false;
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
        }
        else if ( luffyJump_r.isLastFrame() && (jumping_r == true)) {
            visible_r = true;
            setVisible();
            jumping_r = false;
        }

        if(jumping) {
            luffyJump.setLocation(px, py + luffy.getHeight() - luffyJump.getHeight());
        }
        else if (jumping_r) {
            luffyJump_r.setLocation(px, py + luffy.getHeight() - luffyJump_r.getHeight());
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
    }

}
