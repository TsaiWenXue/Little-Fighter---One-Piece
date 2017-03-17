package tw.edu.ntut.csie.game.state;

import java.util.List;
import java.util.Map;

import tw.edu.ntut.csie.game.Game;
import tw.edu.ntut.csie.game.Pointer;
import tw.edu.ntut.csie.game.R;
import tw.edu.ntut.csie.game.core.Audio;
import tw.edu.ntut.csie.game.engine.GameEngine;
import tw.edu.ntut.csie.game.state.Luffy;

public class SelectCharacter extends GameState {

    public static final int DEFAULT_SCORE_DIGITS = 4;

    public SelectCharacter(GameEngine engine) {
        super(engine);
    }

    @Override
    public void initialize(Map<String, Object> data) {

    }

    @Override
    public void move() {

    }

    @Override
    public void show() {

    }

    @Override
    public void release() {

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

        return true;

    }

    @Override
    public boolean pointerMoved(List<Pointer> pointers) {

        return false;
    }

    @Override
    public boolean pointerReleased(List<Pointer> pointers) {
        return false;
    }

    @Override
    public void pause() {
        //_music.pause();
    }

    @Override
    public void resume() {
       // _music.resume();
    }
}
