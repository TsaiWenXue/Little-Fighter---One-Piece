package tw.edu.ntut.csie.game.Character;

import tw.edu.ntut.csie.game.R;
import tw.edu.ntut.csie.game.extend.Animation;
import tw.edu.ntut.csie.game.state.Button;
import tw.edu.ntut.csie.game.state.Navigation;

/**
 * Created by huyuxiang on 2017/4/16.
 */

public class Zoro implements CharacterObject {
    private Animation zoro;             private Animation zoro_r;
    private Animation zoroRun;          private Animation zoroRun_r;
    private Animation zoroAttack;       private Animation zoroAttack_r;

    private int px, py;

    private boolean visible = true, visible_r = false;
    private boolean runVisible = false, runVisible_r = false;

    private boolean attacking = false, attacking_r = false;

    private int[] attackArea = new int[4];
    private int damage = 0;

    public boolean isAttacking() {
        return attacking;
    }

    public boolean isAttacking_r() {
        return attacking_r;
    }

    public Zoro() {
        zoro = new Animation();
        zoro_r = new Animation();

        zoroRun = new Animation();
        zoroRun_r = new Animation();
        zoroAttack = new Animation();
        zoroAttack_r = new Animation();

        px = 400; py = 200;
    }

    public void initialize() {
        addFrame();
        frameDelay();
        frameRepeating();
        setVisible();
        setCurrentIndex(-1);
        setLocation(px, py);
    }

    public int getX(){
        return px;
    }
    public int getY() {
        return py;
    }
    public int getDamage() { return damage; }

    public int[] getAttackArea() { return attackArea; }

    public void show() {
        zoro.show();           zoro_r.show();
        zoroRun.show();        zoroRun_r.show();
        zoroAttack.show();     zoroAttack_r.show();
    }

    public void move(int roadPx) {
        zoro.move();           zoro_r.move();
        zoroRun.move();        zoroRun_r.move();
        zoroAttack.move();     zoroAttack_r.move();

        running(roadPx);
        setLocation(px, py);
        stopRunning();

        attack();
        setAttackArea();
    }

    public void release() {
//        zoro.release();         zoro_r.release();
//        zoroRun.release();      zoroRun_r.release();
//        zoroAttack.release();   zoroAttack_r.release();
    }



    /**********************
     * Move Function Area *
     **********************/

    public void setLocation(int x, int y) {
        zoro.setLocation(x, y);            zoro_r.setLocation(x, y);
        zoroRun.setLocation(x, y);         zoroRun_r.setLocation(x, y);
        zoroAttack.setLocation(x, y);      zoroAttack_r.setLocation(x, y);
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

    //Let all zoro move according to Navigation location
    public void moving(int roadPx) {
        if (!(attacking && attacking_r)) {
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

    //Set all zoro visible
    public void setVisible() {
        zoro.setVisible(visible);
        zoro_r.setVisible(visible_r);
        zoroRun.setVisible(runVisible);
        zoroRun_r.setVisible(runVisible_r);
        zoroAttack.setVisible(false);
        zoroAttack_r.setVisible(false);
    }


    /************************
     *  Skill Functoin Area *
     ************************/

    //Set Attack Area
    public void setAttackArea() {
        if (attacking) {
            attackArea[0] = zoroAttack.getX();
            attackArea[1] = zoroAttack.getY();
            attackArea[2] = zoroAttack.getY() + zoroAttack.getHeight();
            attackArea[3] = zoroAttack.getX() + zoroAttack.getWidth();
        }
        else if(attacking_r) {
            attackArea[0] = zoroAttack_r.getX();
            attackArea[1] = zoroAttack_r.getY();
            attackArea[2] = zoroAttack_r.getY() + zoroAttack_r.getHeight();
            attackArea[3] = zoroAttack_r.getX() + zoroAttack_r.getWidth();
        }
        else {
            for(int i = 0; i < 4; i++) {
                attackArea[i] = 0;
            }
        }
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
        }

        if ( zoroAttack.isLastFrame() && (attacking == true)) {
            visible = true;
            setVisible();
            attacking = false;
        }
        else if ( zoroAttack_r.isLastFrame() && attacking_r == true) {
            visible_r = true;
            setVisible();
            attacking_r = false;
        }
        if(attacking_r)
            zoroAttack_r.setLocation( (px - zoroAttack_r.getWidth() + zoro_r.getWidth()) ,py);
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

         //Zoro add run frame
         zoroRun.addFrame(R.drawable.zoro_run00);
         zoroRun.addFrame(R.drawable.zoro_run01);
         zoroRun.addFrame(R.drawable.zoro_run02);
         zoroRun.addFrame(R.drawable.zoro_run03);
         zoroRun_r.addFrame(R.drawable.zoro_run00_r);
         zoroRun_r.addFrame(R.drawable.zoro_run01_r);
         zoroRun_r.addFrame(R.drawable.zoro_run02_r);
         zoroRun_r.addFrame(R.drawable.zoro_run03_r);

         //Zoro add attack frame
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

     }

     //Set all Zoro animations delay
     public void frameDelay() {
         zoro.setDelay(5);
         zoro_r.setDelay(5);
         zoroRun.setDelay(2);
         zoroRun_r.setDelay(2);
         zoroAttack.setDelay(2);
         zoroAttack_r.setDelay(2);
     }

     //Set all Zoro animations repeating
     public void frameRepeating() {
         zoroAttack.setRepeating(false);
         zoroAttack_r.setRepeating(false);
     }

     //Set all Zoro animation current index
     public void setCurrentIndex(int index) {
         zoroAttack.setCurrentFrameIndex(index);
         zoroAttack_r.setCurrentFrameIndex(index);
     }


}
