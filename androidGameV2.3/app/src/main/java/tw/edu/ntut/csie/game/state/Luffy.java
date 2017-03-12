package tw.edu.ntut.csie.game.state;


import tw.edu.ntut.csie.game.R;
import tw.edu.ntut.csie.game.core.MovingBitmap;
import tw.edu.ntut.csie.game.extend.Animation;
import tw.edu.ntut.csie.game.GameObject;
import tw.edu.ntut.csie.game.state.Navigation;
import tw.edu.ntut.csie.game.state.StateStage1;

public class Luffy implements GameObject {
    private MovingBitmap luffy;
    private int px, py;

    public Luffy() {
        luffy = new MovingBitmap(R.drawable.luffy01);
        px = 400; py = 200;
    }

    public void initialize() {
        luffy.setLocation(px, py );
    }

    public int getX() {
        return luffy.getX();
    }
    public int getY() {
        return luffy.getY();
    }

    @Override
    public void show(){
        luffy.show();
    }

    @Override
    public void move() {

        //px += (Navigation.controllerPx -  Navigation.initialCtrlPx)/10;

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

    }

    @Override
    public void release(){
        luffy.release();

        luffy = null;
    }
}
