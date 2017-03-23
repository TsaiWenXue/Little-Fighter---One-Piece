package tw.edu.ntut.csie.game.state;


import tw.edu.ntut.csie.game.R;
import tw.edu.ntut.csie.game.core.MovingBitmap;
import tw.edu.ntut.csie.game.extend.Animation;
import tw.edu.ntut.csie.game.GameObject;
import tw.edu.ntut.csie.game.state.Navigation;
import tw.edu.ntut.csie.game.state.StateStage1;
import tw.edu.ntut.csie.game.state.Button;

public class Luffy implements GameObject {
    private MovingBitmap luffy;
    private MovingBitmap luffy_r;
    private Animation luffyRun;
    private Animation luffyRun_r;
    private Animation luffyattack;

    private int px, py;
    private boolean run = false, run_r = false;
    private boolean visible = false, visible_r = false;

    public Luffy() {
        luffy = new MovingBitmap(R.drawable.luffy);
        luffy_r = new MovingBitmap(R.drawable.luffy_r);

        luffyRun = new Animation();
        luffyRun_r = new Animation();
        luffyattack = new Animation();

      //  luffy_attack = new Animation();
        px = 400; py = 200;
    }

    public void initialize() {

        visible_r = false;
        run = false;
        run_r = false;
        Button.atPointerPressed = false;

        luffy.setLocation(px, py);
        luffy_r.setVisible(visible_r);

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

        luffyattack.addFrame(R.drawable.luffy_attack00);
        luffyattack.addFrame(R.drawable.luffy_attack01);
        luffyattack.addFrame(R.drawable.luffy_attack02);
        luffyattack.addFrame(R.drawable.luffy_attack03);
        luffyattack.addFrame(R.drawable.luffy_attack04);
        luffyattack.addFrame(R.drawable.luffy_attack05);
        luffyattack.addFrame(R.drawable.luffy_attack04);
        luffyattack.addFrame(R.drawable.luffy_attack03);
        luffyattack.addFrame(R.drawable.luffy_attack02);
        luffyattack.addFrame(R.drawable.luffy_attack01);
        luffyattack.addFrame(R.drawable.luffy_attack06);
        luffyattack.addFrame(R.drawable.luffy_attack07);
        luffyattack.setDelay(0);

        luffyRun.setVisible(run);
        luffyRun_r.setVisible(run_r);
        luffyattack.setVisible(Button.atPointerPressed);

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
        luffyattack.show();
    }

    @Override
    public void move() {
        luffyRun.move();
        luffyRun_r.move();
        luffyattack.move();

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
        luffyattack.setLocation((px-11),(py-35));
        if (Navigation.controllerPx - Navigation.initialCtrlPx == 0 && (run_r == true || visible_r == true)) {
            //luffy_r.setLocation(px, py);
            visible = false;
            visible_r = true;
            run = false;
            run_r = false;
            Button.atPointerPressed = false;

            luffy.setVisible(visible);
            luffyRun.setVisible(run);
            luffyRun_r.setVisible(run_r);
            luffy_r.setVisible(visible_r);
            luffyattack.setVisible(Button.atPointerPressed);
        }
        else if (Navigation.controllerPx - Navigation.initialCtrlPx == 0 && (run == true || visible == true)) {
            //luffy.setLocation(px, py);
            visible = true;
            visible_r = false;
            run = false;
            run_r = false;
            Button.atPointerPressed = false;

            luffy_r.setVisible(visible_r);
            luffyRun.setVisible(run);
            luffyRun_r.setVisible(run_r);
            luffy.setVisible(visible);
            luffyattack.setVisible(Button.atPointerPressed);
        }

        if (Navigation.controllerPx - Navigation.initialCtrlPx < 0) {
            visible = false;
            visible_r = false;
            run_r = true;
            run = false;
            Button.atPointerPressed = false;
            //luffyRun_r.setLocation(px, py);
            luffy_r.setVisible(visible_r);
            luffy.setVisible(visible);
            luffyRun.setVisible(run);
            luffyRun_r.setVisible(run_r);
            luffyattack.setVisible(Button.atPointerPressed);
        }
        else if (Navigation.controllerPx - Navigation.initialCtrlPx > 0) {
            visible = false;
            visible_r = false;
            run = true;
            run_r = false;
            Button.atPointerPressed = false;
            //luffyRun.setLocation(px, py);
            luffy.setVisible(visible);
            luffy_r.setVisible(visible_r);
            luffyRun_r.setVisible(run_r);
            luffyRun.setVisible(run);
            luffyattack.setVisible(Button.atPointerPressed);
        }
       if (Button.atPointerPressed == true){
         visible = false;
         visible_r = false;
         run = false;
         run_r = false;
         Button.atPointerPressed = true;
         luffyattack.setRepeating(false);
         luffyattack.reset();
         //luffyRun.setLocation(px, py);
         luffy.setVisible(visible);
         luffy_r.setVisible(visible_r);
         luffyRun_r.setVisible(run_r);
         luffyRun.setVisible(run);
         luffyattack.setVisible(Button.atPointerPressed);
         visible = true;
         luffy.setVisible(visible);
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
