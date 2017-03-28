package tw.edu.ntut.csie.game.state;


import tw.edu.ntut.csie.game.R;
import tw.edu.ntut.csie.game.core.MovingBitmap;
import tw.edu.ntut.csie.game.extend.Animation;
import tw.edu.ntut.csie.game.GameObject;
import tw.edu.ntut.csie.game.state.Navigation;
import tw.edu.ntut.csie.game.state.StateStage1;
import tw.edu.ntut.csie.game.state.Button;

public class Character implements GameObject {
    private MovingBitmap ch;
    private MovingBitmap ch_r;
    private Animation chRun;
    private Animation chRun_r;
    private Animation chAttack;
    private Animation chAttack_r;

    private int px, py;
    private boolean run = false, run_r = false;
    private boolean visible = false, visible_r = false;

    public Character() {
        /*luffy = new MovingBitmap(R.drawable.luffy);
        luffy_r = new MovingBitmap(R.drawable.luffy_r);

        luffyRun = new Animation();
        luffyRun_r = new Animation();
        luffyattack = new Animation();
        luffyattack_r = new Animation();*/
        ch = new MovingBitmap();
        ch_r = new MovingBitmap();

        chRun = new Animation();
        chRun_r = new Animation();
        chAttack = new Animation();
        chAttack_r = new Animation();

        px = 400; py = 200;
    }


    //Character normal bitmap loadin
    public void loadNormal(int resId) {
        ch.loadBitmap(resId);
    }
    public void loadNormalReverse(int resId) {
        ch_r.loadBitmap(resId);
    }

    //Character Run add frame
    public void addRun(int resId) {
        chRun.addFrame(resId);
    }
    public void addRunReverse(int resId) {
        chRun_r.addFrame(resId);
    }

    //Character Attack add frame
    public void addAttack(int resId) {
        chAttack.addFrame(resId);
    }
    public void addAttackReverse(int resId) {
        chAttack_r.addFrame(resId);
    }


    public void initialize() {
        visible = true;
        visible_r = false;
        run = false;
        run_r = false;

        ch.setLocation(px, py);
        ch_r.setVisible(visible_r);

        chAttack.setDelay(1);
        chAttack.setRepeating(false);
        chAttack.setDelay(1);
        chAttack_r.setRepeating(false);

        chRun.setVisible(run);
        chRun.setDelay(2);
        chRun_r.setVisible(run_r);
        chRun_r.setDelay(2);
        chAttack.setVisible(Button.atPointerPressed);
        chAttack_r.setVisible(Button.atPointerPressed);

    }

    public int getX() {
        if (Navigation.controllerPx - Navigation.initialCtrlPx < 0)
            return ch_r.getX();
        else
            return ch.getX();
    }
    public int getY() {
        return ch.getY();
    }

    @Override
    public void show(){
        ch.show();
        ch_r.show();
        chRun.show();
        chRun_r.show();
        chAttack.show();
        chAttack_r.show();
    }

    @Override
    public void move() {
        chRun.move();
        chRun_r.move();
        chAttack.move();
        chAttack_r.move();

        //Let Character move base on navigation
        py += (Navigation.controllerPy - Navigation.initialCtrlPy)/10;
        if (py < -20 || py > 375)
            py -= (Navigation.controllerPy - Navigation.initialCtrlPy)/10;
        if (StateStage1.roadPx == 800 || StateStage1.roadPx == -800)
            px += (Navigation.controllerPx -  Navigation.initialCtrlPx)/5;
        if (px > 750 || px < 0)
            px -= (Navigation.controllerPx -  Navigation.initialCtrlPx)/5;
        else if (StateStage1.roadPx < 800 && px < 400)
            px++;
        else if (StateStage1.roadPx > -800 && px > 400)
            px--;
        ch.setLocation(px, py);
        ch_r.setLocation(px, py);
        chRun.setLocation(px, py);
        chRun_r.setLocation(px, py);
        chAttack.setLocation((px-11),(py-35));
        chAttack_r.setLocation((px-353),(py-35));

        //Character stop running
        if (Navigation.controllerPx - Navigation.initialCtrlPx == 0 && run_r == true) {
            visible = false;
            visible_r = true;
            run = false;
            run_r = false;

            ch.setVisible(visible);
            chRun.setVisible(run);
            chRun_r.setVisible(run_r);
            ch_r.setVisible(visible_r);
        }
        else if (Navigation.controllerPx - Navigation.initialCtrlPx == 0 && run == true) {
            visible = true;
            visible_r = false;
            run = false;
            run_r = false;

            ch_r.setVisible(visible_r);
            chRun.setVisible(run);
            chRun_r.setVisible(run_r);
            ch.setVisible(visible);
        }

        //decide Character face direction with Navigation
        if (Navigation.controllerPx - Navigation.initialCtrlPx < 0) {
            visible = false;
            visible_r = false;
            run_r = true;
            run = false;

            ch_r.setVisible(visible_r);
            ch.setVisible(visible);
            chRun.setVisible(run);
            chRun_r.setVisible(run_r);
        }
        else if (Navigation.controllerPx - Navigation.initialCtrlPx > 0) {
            visible = false;
            visible_r = false;
            run = true;
            run_r = false;

            ch.setVisible(visible);
            ch_r.setVisible(visible_r);
            chRun_r.setVisible(run_r);
            chRun.setVisible(run);
        }

        //Character Attack perform
        if (Button.atPointerPressed == true && (visible == true || run == true)){
            visible = false;
            visible_r = false;
            run = false;
            run_r = false;
            chAttack.setVisible(Button.atPointerPressed);
            ch.setVisible(visible);
            ch_r.setVisible(visible_r);
            chRun_r.setVisible(run_r);
            chRun.setVisible(run);
            chAttack.reset();
        }
        else if (Button.atPointerPressed == true && (visible_r == true || run_r == true)){
            visible = false;
            visible_r = false;
            run = false;
            run_r = false;

            chAttack_r.setVisible(Button.atPointerPressed);
            ch.setVisible(visible);
            ch_r.setVisible(visible_r);
            chRun_r.setVisible(run_r);
            chRun.setVisible(run);
            chAttack_r.reset();
        }

        if ( chAttack.isLastFrame() && (visible_r == false)) {
            visible = true;
            ch.setVisible(visible);
        }
        else if ( chAttack_r.isLastFrame() ) {
            visible_r = true;
            ch_r.setVisible(visible_r);
        }

    }

    @Override
    public void release(){
        ch.release();
        ch_r.release();

        ch = null;
        ch_r = null;
    }
}
