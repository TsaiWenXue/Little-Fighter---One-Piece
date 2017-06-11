package tw.edu.ntut.csie.game.state;


import tw.edu.ntut.csie.game.core.MovingBitmap;
import tw.edu.ntut.csie.game.extend.Animation;
import tw.edu.ntut.csie.game.R;

public class Stage2BG{
    private Animation _sandback;
    private MovingBitmap _road1;
    private MovingBitmap _road2;
    private MovingBitmap _road3;

    private int px, py;
    public static int roadPx = 0, roadPy = 50;

    public Stage2BG(){
        _sandback = new Animation();
        _road1 = new MovingBitmap(R.drawable.sand);
        _road2 = new MovingBitmap(R.drawable.sand);
        _road3 = new MovingBitmap(R.drawable.sand);
        initialize();
    }

    public int getX(){
        return roadPx;
    }
    public void initialize(){
        px = 0; py = 0;

        _sandback.setLocation(px,py);
        _sandback.addFrame(R.drawable.sback1);
        _sandback.addFrame(R.drawable.sback2);
        _sandback.setDelay(5);

        _road1.setLocation(roadPx-800, roadPy);
        _road2.setLocation(roadPx, roadPy);
        _road3.setLocation(roadPx+800, roadPy);
    }

    public void move(int chPx) {
        _sandback.move();

        if (roadPx < 800 && roadPx > -800)
            roadPx -= (Navigation.controllerPx - Navigation.initialCtrlPx)/5;
        if (roadPx > 800)
            roadPx = 800;
        else if (roadPx < -800)
            roadPx = -800;
        else if ( (roadPx == 800 && chPx >= 410) ||
                  (roadPx == -800 && chPx <= 390) )
            roadPx -= (Navigation.controllerPx -  Navigation.initialCtrlPx)/5;

        if (roadPx != -800 && roadPx != 800 &&
                (chPx >= 410 || chPx <= 390)) {
            roadPx -= chPx - 400;
        }
        _road1.setLocation(roadPx-800, roadPy);
        _road2.setLocation(roadPx, roadPy);
        _road3.setLocation(roadPx+800, roadPy);
    }

    public void show() {
        _road1.show();
        _road2.show();
        _road3.show();
        _sandback.show();
    }

    public void release(){
        _sandback.release();
        _road1.release();
        _road2.release();
        _road3.release();
    }


}
