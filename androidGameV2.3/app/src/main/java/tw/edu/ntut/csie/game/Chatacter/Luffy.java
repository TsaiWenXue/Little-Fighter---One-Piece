package tw.edu.ntut.csie.game.Chatacter;

import tw.edu.ntut.csie.game.R;
import tw.edu.ntut.csie.game.extend.Animation;
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
    private Animation luffyEskill;
    private Animation luffyEskill_r;
    private Animation luffyGskill;
    private Animation luffyGskill_r;
    private Animation luffyFskill;
    private Animation luffyFskill_r;

    private int px, py;

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
        luffyEskill = new Animation();
        luffyEskill_r =new Animation();
        luffyGskill = new Animation();
        luffyGskill_r = new Animation();
        luffyFskill = new Animation();
        luffyFskill_r = new Animation();

        px = 400; py = 200;
    }

    public void initialize(){
        luffyAddFrame();
        luffyFrameDelay();
        luffyFrameRepeating();
        luffyFrameVisibleIni();
        luffySetCurrentIndex(-1);
        luffySetLocation(px, py);
    }

    public int getX() {
        return px;
    }
    public int getY() {
        return py;
    }

    public void show() {
        luffy.show();           luffy_r.show();
        luffyRun.show();        luffyRun_r.show();
        luffyAttack.show();     luffyAttack_r.show();
        luffyDefend.show();     luffyDefend_r.show();
        luffyJump.show();       luffyJump_r.show();
        luffyEskill.show();     luffyEskill_r.show();
        luffyGskill.show();     luffyGskill_r.show();
        luffyFskill.show();     luffyFskill_r.show();
    }

    public void move(int roadPx) {
        luffy.move();           luffy_r.move();
        luffyRun.move();        luffyRun_r.move();
        luffyAttack.move();     luffyAttack_r.move();
        luffyDefend.move();     luffyDefend_r.move();
        luffyJump.move();       luffyJump_r.move();
        luffyEskill.move();     luffyEskill_r.move();
        luffyGskill.move();     luffyGskill_r.move();
        luffyFskill.move();     luffyFskill_r.move();

        luffyRunning(roadPx);
        luffySetLocation(px, py);
/*
        if(chAttack_r.getCurrentFrameIndex() >= 0)
            chAttack_r.setLocation( (px - chAttack_r.getWidth() + ch_r.getWidth()) ,py);
        else
            chAttack_r.setLocation(px, py);*/
    }

    public void release() {
        luffy.release();
        luffy_r.release();
        luffyRun.release();
        luffyRun_r.release();
        luffyAttack.release();
        luffyAttack_r.release();
        luffyDefend.release();
        luffyDefend_r.release();
        luffyJump.release();
        luffyJump_r.release();
        luffyEskill.release();
        luffyEskill_r.release();
        luffyGskill.release();
        luffyGskill_r.release();
        luffyFskill.release();
        luffyFskill_r.release();

        luffy = null;
        luffy_r = null;
        luffyRun = null;
        luffyRun_r = null;
        luffyAttack = null;
        luffyAttack_r = null;
        luffyDefend = null;
        luffyDefend_r = null;
        luffyJump = null;
        luffyJump_r = null;
        luffyEskill = null;
        luffyEskill_r = null;
        luffyGskill = null;
        luffyGskill_r = null;
        luffyFskill = null;
        luffyFskill_r = null;
    }

    public void luffySetLocation(int x, int y) {
        luffy.setLocation(x, y);
        luffy_r.setLocation(x, y);
        luffyRun.setLocation(x, y);
        luffyRun_r.setLocation(x, y);
        luffyAttack.setLocation(x, y);
        luffyAttack_r.setLocation(x, y);
        luffyDefend.setLocation(x, y);
        luffyDefend_r.setLocation(x, y);
        luffyJump.setLocation(x, y);
        luffyJump_r.setLocation(x, y);
        luffyEskill.setLocation(x, y);
        luffyEskill_r.setLocation(x, y);
        luffyGskill.setLocation(x, y);
        luffyGskill_r.setLocation(x, y);
        luffyFskill.setLocation(x, y);
        luffyFskill_r.setLocation(x, y);
    }

    public void luffyRunning (int roadPx) {
        if (luffyAttack_r.getCurrentFrameIndex() == -1 && luffyAttack.getCurrentFrameIndex() == -1) {
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
    }

    public void luffyAddFrame() {
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

        //luffy add attack frame
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
        luffyEskill.addFrame(R.drawable.luffy_e00);
        luffyEskill.addFrame(R.drawable.luffy_e01);
        luffyEskill.addFrame(R.drawable.luffy_e02);
        luffyEskill.addFrame(R.drawable.luffy_e03);
        luffyEskill.addFrame(R.drawable.luffy_e04);
        luffyEskill.addFrame(R.drawable.luffy_e05);
        luffyEskill.addFrame(R.drawable.luffy_e06);
        luffyEskill.addFrame(R.drawable.luffy_e07);
        luffyEskill.addFrame(R.drawable.luffy_e08);
        luffyEskill.addFrame(R.drawable.luffy_e09);
        luffyEskill.addFrame(R.drawable.luffy_e10);
        luffyEskill.addFrame(R.drawable.luffy_e11);
        luffyEskill.addFrame(R.drawable.luffy_e12);
        luffyEskill.addFrame(R.drawable.luffy_e13);
        luffyEskill.addFrame(R.drawable.luffy_e14);
        luffyEskill.addFrame(R.drawable.luffy_e15);
        luffyEskill.addFrame(R.drawable.luffy_e16);

        //luffy add Gskill frame
        luffyGskill.addFrame(R.drawable.luffy_g01);
        luffyGskill.addFrame(R.drawable.luffy_g02);
        luffyGskill.addFrame(R.drawable.luffy_g03);
        luffyGskill.addFrame(R.drawable.luffy_g04);
        luffyGskill.addFrame(R.drawable.luffy_g05);
        luffyGskill.addFrame(R.drawable.luffy_g06);
        luffyGskill.addFrame(R.drawable.luffy_g07);
        luffyGskill.addFrame(R.drawable.luffy_g08);
        luffyGskill.addFrame(R.drawable.luffy_g09);
        luffyGskill.addFrame(R.drawable.luffy_g10);
        luffyGskill.addFrame(R.drawable.luffy_g11);
        luffyGskill.addFrame(R.drawable.luffy_g12);
        luffyGskill.addFrame(R.drawable.luffy_g13);
        luffyGskill.addFrame(R.drawable.luffy_g14);
        luffyGskill.addFrame(R.drawable.luffy_g15);
        luffyGskill.addFrame(R.drawable.luffy_g16);
        luffyGskill.addFrame(R.drawable.luffy_g17);

        //luffy add Fskill frame
        luffyFskill.addFrame(R.drawable.luffy_f01);
        luffyFskill.addFrame(R.drawable.luffy_f02);
        luffyFskill.addFrame(R.drawable.luffy_f03);
        luffyFskill.addFrame(R.drawable.luffy_f04);
        luffyFskill.addFrame(R.drawable.luffy_f05);
        luffyFskill.addFrame(R.drawable.luffy_f06);
        luffyFskill.addFrame(R.drawable.luffy_f07);
        luffyFskill.addFrame(R.drawable.luffy_f08);
        luffyFskill.addFrame(R.drawable.luffy_f09);
        luffyFskill.addFrame(R.drawable.luffy_f10);
        luffyFskill.addFrame(R.drawable.luffy_f11);
        luffyFskill.addFrame(R.drawable.luffy_f12);
        luffyFskill.addFrame(R.drawable.luffy_f13);
        luffyFskill.addFrame(R.drawable.luffy_f14);
        luffyFskill.addFrame(R.drawable.luffy_f15);
        luffyFskill.addFrame(R.drawable.luffy_f16);
        luffyFskill.addFrame(R.drawable.luffy_f17);
        luffyFskill.addFrame(R.drawable.luffy_f18);
    }

    public void luffyFrameDelay() {
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
        luffyEskill.setDelay(2);
        luffyEskill_r.setDelay(2);
        luffyGskill.setDelay(2);
        luffyGskill_r.setDelay(2);
        luffyFskill.setDelay(2);
        luffyFskill_r.setDelay(2);
    }

    public void luffyFrameRepeating() {
        luffyAttack.setRepeating(false);
        luffyAttack_r.setRepeating(false);
        luffyDefend.setRepeating(false);
        luffyDefend_r.setRepeating(false);
        luffyJump.setRepeating(false);
        luffyJump_r.setRepeating(false);
        luffyEskill.setRepeating(false);
        luffyEskill_r.setRepeating(false);
        luffyGskill.setRepeating(false);
        luffyGskill_r.setRepeating(false);
        luffyFskill.setRepeating(false);
        luffyFskill_r.setRepeating(false);
    }

    public void luffyFrameVisibleIni() {
        luffy.setVisible(true);
        luffy_r.setVisible(false);
        luffyRun.setVisible(false);
        luffyRun_r.setVisible(false);
        luffyAttack.setVisible(false);
        luffyAttack_r.setVisible(false);
        luffyDefend.setVisible(false);
        luffyDefend_r.setVisible(false);
        luffyJump.setVisible(false);
        luffyJump_r.setVisible(false);
        luffyEskill.setVisible(false);
        luffyEskill_r.setVisible(false);
        luffyGskill.setVisible(false);
        luffyGskill_r.setVisible(false);
        luffyFskill.setVisible(false);
        luffyFskill_r.setVisible(false);
    }

    public void luffySetCurrentIndex(int index) {
        luffyAttack.setCurrentFrameIndex(index);
        luffyAttack_r.setCurrentFrameIndex(index);
        luffyDefend.setCurrentFrameIndex(index);
        luffyDefend_r.setCurrentFrameIndex(index);
        luffyJump.setCurrentFrameIndex(index);
        luffyJump_r.setCurrentFrameIndex(index);
        luffyEskill.setCurrentFrameIndex(index);
        luffyEskill_r.setCurrentFrameIndex(index);
        luffyGskill.setCurrentFrameIndex(index);
        luffyGskill_r.setCurrentFrameIndex(index);
        luffyFskill.setCurrentFrameIndex(index);
        luffyFskill_r.setCurrentFrameIndex(index);
    }

}
