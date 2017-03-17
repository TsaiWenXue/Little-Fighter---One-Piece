package tw.edu.ntut.csie.game.state;

import java.util.List;
import java.util.Map;

import tw.edu.ntut.csie.game.Game;
import tw.edu.ntut.csie.game.Pointer;
import tw.edu.ntut.csie.game.R;
import tw.edu.ntut.csie.game.core.Audio;
import tw.edu.ntut.csie.game.engine.GameEngine;
import tw.edu.ntut.csie.game.core.MovingBitmap;
import tw.edu.ntut.csie.game.extend.Animation;
import tw.edu.ntut.csie.game.state.Luffy;
import tw.edu.ntut.csie.game.state.Navigation;
import tw.edu.ntut.csie.game.state.Button;

public class StateStage1 extends GameState {
    //Background
    private MovingBitmap _sky;
    private MovingBitmap _road1;
    private MovingBitmap _road2;
    private MovingBitmap _road3;
    private Animation _wave;
    private int px, py;
    public static int roadPx = 0, roadPy = 50;
    private Audio _music;

    private Navigation controller = new Navigation();
    private Luffy luffy = new Luffy();
    private Button button = new Button();

    public StateStage1(GameEngine engine) {
        super(engine);
    }

    @Override
    public void initialize(Map<String, Object> data) {
        px = 0; py = 0;
        _sky = new MovingBitmap(R.drawable.sky);
        _sky.setLocation(px, py);

        _wave = new Animation();
        _wave.setLocation(px, py + 70);
        _wave.addFrame(R.drawable.wave015);
        _wave.addFrame(R.drawable.wave016);
        _wave.addFrame(R.drawable.wave017);
        _wave.addFrame(R.drawable.wave018);
        _wave.addFrame(R.drawable.wave019);
        _wave.addFrame(R.drawable.wave020);
        _wave.addFrame(R.drawable.wave021);
        _wave.addFrame(R.drawable.wave022);
        _wave.addFrame(R.drawable.wave023);
        _wave.addFrame(R.drawable.wave024);
        _wave.addFrame(R.drawable.wave025);
        _wave.addFrame(R.drawable.wave026);
        _wave.addFrame(R.drawable.wave027);
        _wave.addFrame(R.drawable.wave028);
        _wave.addFrame(R.drawable.wave029);
        _wave.addFrame(R.drawable.wave030);
        _wave.addFrame(R.drawable.wave031);
        _wave.addFrame(R.drawable.wave032);
        _wave.addFrame(R.drawable.wave033);

        _road1 = new MovingBitmap(R.drawable.road);
        _road2 = new MovingBitmap(R.drawable.road);
        _road3 = new MovingBitmap(R.drawable.road);
        _road1.setLocation(roadPx-800, roadPy);
        _road2.setLocation(roadPx, roadPy);
        _road3.setLocation(roadPx+800, roadPy);

        _music = new Audio(R.raw.ntut);
        _music.setRepeating(true);
        _music.play();


        controller.initialize();
        luffy.initialize();
        button.initialize();
    }

    @Override
    public void move() {
        _wave.move();
        luffy.move();

        if (roadPx < 800 && roadPx > -800)
            roadPx -= (Navigation.controllerPx - Navigation.initialCtrlPx)/5;
        if (roadPx > 800)
            roadPx = 800;
        else if (roadPx < -800)
            roadPx = -800;
        else if ( (roadPx == 800 && luffy.getX() >= 410) ||
                  (roadPx == -800 && luffy.getX() <= 390) )
            roadPx -= (Navigation.controllerPx -  Navigation.initialCtrlPx)/5;
        _road1.setLocation(roadPx-800, roadPy);
        _road2.setLocation(roadPx, roadPy);
        _road3.setLocation(roadPx+800, roadPy);
    }

    @Override
    public void show() {
        _sky.show();
        _wave.show();
        _road1.show();
        _road2.show();
        _road3.show();

        controller.show();
        luffy.show();
        button.show();
    }

    @Override
    public void release() {
        _sky.release();
        _wave.release();
        _road1.release();
        _road2.release();
        _road3.release();
        _sky = null;
        _wave = null;
        _road1 = null;
        _road2 = null;
        _road3 = null;


        luffy.release();
        controller.release();
        button.release();
        luffy = null;
        controller = null;
        button = null;
    }
    @Override
    public void keyPressed(int keyCode) {
        // TODO Auto-generated method stub
    }

    @Override
    public void keyReleased(int keyCode) {
        // TODO Auto-generated method stub
    }

    @Override
    public void orientationChanged(float pitch, float azimuth, float roll) {

    }

    @Override
    public void accelerationChanged(float dX, float dY, float dZ) {
        // TODO Auto-generated method stub
    }

    @Override
    public boolean pointerPressed(List<Pointer> pointers) {
        controller.pointerPressed(pointers);
        button.pointerPressed(pointers);
        return true;

    }

    @Override
    public boolean pointerMoved(List<Pointer> pointers) {
        controller.pointerMoved(pointers);
        return false;
    }

    @Override
    public boolean pointerReleased(List<Pointer> pointers) {
        controller.pointerReleased(pointers);
        button.pointerReleased(pointers);
        return false;
    }

    @Override
    public void pause() {
        _music.pause();
    }

    @Override
    public void resume() {
        _music.resume();
    }

}
