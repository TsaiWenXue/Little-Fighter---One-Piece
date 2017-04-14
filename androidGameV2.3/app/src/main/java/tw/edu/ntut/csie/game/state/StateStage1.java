package tw.edu.ntut.csie.game.state;

import java.util.List;
import java.util.Map;

import tw.edu.ntut.csie.game.Pointer;
import tw.edu.ntut.csie.game.R;
import tw.edu.ntut.csie.game.core.Audio;
import tw.edu.ntut.csie.game.engine.GameEngine;

public class StateStage1 extends GameState {
    private Stage1BG bg;
    private Audio _music;

    private Navigation controller;
    private Button button;

    private Character ch;
    private Enemy en;

    public StateStage1(GameEngine engine) {
        super(engine);
    }

    @Override
    public void initialize(Map<String, Object> data) {
        bg = new Stage1BG();

        _music = new Audio(R.raw.onepiece_op1);
        _music.setRepeating(true);
        _music.play();

        controller = new Navigation();
        button = new Button();
        controller.initialize();
        button.initialize();

        ch = new Character();
        switch (StateRun.character) {
            case 0:
                CharacterLib.luffy(ch);
                break;
            case 1:
                CharacterLib.zoro(ch);
                break;
        }
        ch.initialize();

        en = new Enemy();
        EnemyLib.marin(en);
        en.initialize();
    }

    @Override
    public void move() {
        ch.move();
        bg.move(ch);
        en.move(ch);
    }

    @Override
    public void show() {
        bg.show();
        controller.show();
        ch.show();
        button.show();
        en.show();
    }

    @Override
    public void release() {
        bg.release();
        bg = null;
        _music.release();
        _music = null;

        ch.release();
        controller.release();
        button.release();
        ch = null;
        controller = null;
        button = null;

        en.release();
        en = null;
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
        button.pointerMoved(pointers);
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
