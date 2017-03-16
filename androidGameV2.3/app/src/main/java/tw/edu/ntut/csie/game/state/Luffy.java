package tw.edu.ntut.csie.game.state;


import tw.edu.ntut.csie.game.R;
import tw.edu.ntut.csie.game.core.MovingBitmap;
import tw.edu.ntut.csie.game.extend.Animation;
import tw.edu.ntut.csie.game.GameObject;
import tw.edu.ntut.csie.game.state.Navigation;
import tw.edu.ntut.csie.game.state.StateStage1;

public class Luffy implements GameObject {
    private MovingBitmap luffy;
    private MovingBitmap luffy_r;
    private Animation luffyRun;
    private Animation luffyRun_r;

    private int px, py;
    private boolean run = false, run_r = false;

    public Luffy() {
        luffy = new MovingBitmap(R.drawable.luffy);
        luffy_r = new MovingBitmap(R.drawable.luffy_r);

        luffyRun = new Animation();
        luffyRun_r = new Animation();
        px = 400; py = 200;
    }

    public void initialize() {
        luffy.setLocation(px, py );
        luffy_r.setVisible(false);

        luffyRun.addFrame(R.drawable.luffy_run01);
        luffyRun.addFrame(R.drawable.luffy_run02);
        luffyRun.addFrame(R.drawable.luffy_run03);
        luffyRun.addFrame(R.drawable.luffy_run02);
        luffyRun.setDelay(2);

        luffyRun_r.addFrame(R.drawable.luffy_run01_r);
        luffyRun_r.addFrame(R.drawable.luffy_run02_r);
        luffyRun_r.addFrame(R.drawable.luffy_run03_r);
        luffyRun_r.addFrame(R.drawable.luffy_run02_r);
        luffyRun_r.setDelay(2);

        luffyRun.setVisible(false);
        luffyRun_r.setVisible(false);
    }

    public int getX() {
        if (Navigation.controllerPx - Navigation.initialCtrlPx < 0)
            return luffy_r.getX();
        else
            return luffy.getX();
    }
    public int getY() {
        return luffy.getY();
    }

    @Override
    public void show(){
        luffy.show();
        luffy_r.show();
        luffyRun.show();
        luffyRun_r.show();
    }

    @Override
    public void move() {
        luffyRun.move();
        luffyRun_r.move();

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

        luffy.setLocation(px, py);
        luffy_r.setLocation(px, py);
        luffyRun.setLocation(px, py);
        luffyRun_r.setLocation(px, py);
        if (Navigation.controllerPx - Navigation.initialCtrlPx == 0 && run_r == true) {
            //luffy_r.setLocation(px, py);
            luffy.setVisible(false);
            luffyRun.setVisible(false);
            luffyRun_r.setVisible(false);
            luffy_r.setVisible(true);
        }
        else if (Navigation.controllerPx - Navigation.initialCtrlPx == 0 && run == true) {
            //luffy.setLocation(px, py);
            luffy_r.setVisible(false);
            luffyRun.setVisible(false);
            luffyRun_r.setVisible(false);
            luffy.setVisible(true);
        }

        if (Navigation.controllerPx - Navigation.initialCtrlPx < 0) {
            run_r = true;
            run = false;
            //luffyRun_r.setLocation(px, py);
            luffy_r.setVisible(false);
            luffy.setVisible(false);
            luffyRun.setVisible(false);
            luffyRun_r.setVisible(run_r);
        }
        else if (Navigation.controllerPx - Navigation.initialCtrlPx > 0) {
            run = true;
            run_r = false;
            //luffyRun.setLocation(px, py);
            luffy.setVisible(false);
            luffy_r.setVisible(false);
            luffyRun_r.setVisible(false);
            luffyRun.setVisible(run);
        }
    }

    @Override
    public void release(){
        luffy.release();
        luffy_r.release();

        luffy = null;
        luffy_r = null;
    }
}
