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
public class StateStage1 extends GameState {

    private Stage1BG bg;
    private Audio _music;

    private Navigation controller;
    private Button button;

    private Character ch;

    public StateStage1(GameEngine engine) {
        super(engine);
    }

    public void luffy() {
        ch.loadNormal(R.drawable.luffy);
        ch.loadNormalReverse(R.drawable.luffy_r);

        ch.addRun(R.drawable.luffy_run01);
        ch.addRun(R.drawable.luffy_run02);
        ch.addRun(R.drawable.luffy_run03);
        ch.addRun(R.drawable.luffy_run02);
        ch.addRunReverse(R.drawable.luffy_run01_r);
        ch.addRunReverse(R.drawable.luffy_run02_r);
        ch.addRunReverse(R.drawable.luffy_run03_r);
        ch.addRunReverse(R.drawable.luffy_run02_r);

        ch.addAttack(R.drawable.luffy_attack00);
        ch.addAttack(R.drawable.luffy_attack01);
        ch.addAttack(R.drawable.luffy_attack02);
        ch.addAttack(R.drawable.luffy_attack03);
        ch.addAttack(R.drawable.luffy_attack04);
        ch.addAttack(R.drawable.luffy_attack05);
        ch.addAttack(R.drawable.luffy_attack04);
        ch.addAttack(R.drawable.luffy_attack03);
        ch.addAttack(R.drawable.luffy_attack02);
        ch.addAttack(R.drawable.luffy_attack01);
        ch.addAttack(R.drawable.luffy_attack06);
        ch.addAttack(R.drawable.luffy_attack07);
        ch.addAttackReverse(R.drawable.luffy_attack00_r);
        ch.addAttackReverse(R.drawable.luffy_attack01_r);
        ch.addAttackReverse(R.drawable.luffy_attack02_r);
        ch.addAttackReverse(R.drawable.luffy_attack03_r);
        ch.addAttackReverse(R.drawable.luffy_attack04_r);
        ch.addAttackReverse(R.drawable.luffy_attack05_r);
        ch.addAttackReverse(R.drawable.luffy_attack04_r);
        ch.addAttackReverse(R.drawable.luffy_attack03_r);
        ch.addAttackReverse(R.drawable.luffy_attack02_r);
        ch.addAttackReverse(R.drawable.luffy_attack01_r);
        ch.addAttackReverse(R.drawable.luffy_attack06_r);
        ch.addAttackReverse(R.drawable.luffy_attack07_r);

    }

    @Override
    public void initialize(Map<String, Object> data) {
        bg = new Stage1BG();

        _music = new Audio(R.raw.onepiece_op1);
        _music.setRepeating(true);
        _music.play();

        controller = new Navigation();
        button = new Button();
        ch = new Character();
        luffy();

        controller.initialize();
        ch.initialize();
        button.initialize();
    }

    @Override
    public void move() {
        ch.move();
        bg.move(ch);
    }

    @Override
    public void show() {
        bg.show();
        controller.show();
        ch.show();
        button.show();
    }

    @Override
    public void release() {
        bg.release();
        bg = null;

        ch.release();
        controller.release();
        button.release();
        ch = null;
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
