package tw.edu.ntut.csie.game.state;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import tw.edu.ntut.csie.game.Character.*;
import tw.edu.ntut.csie.game.Enemy.AttackObject;
import tw.edu.ntut.csie.game.Enemy.EnemyObject;
import tw.edu.ntut.csie.game.Enemy.MarinAI;
import tw.edu.ntut.csie.game.Game;
import tw.edu.ntut.csie.game.Pointer;
import tw.edu.ntut.csie.game.R;
import tw.edu.ntut.csie.game.core.Audio;
import tw.edu.ntut.csie.game.core.MovingBitmap;
import tw.edu.ntut.csie.game.engine.GameEngine;
import tw.edu.ntut.csie.game.extend.BitmapButton;

public class StateStage1 extends GameState {
    private Stage1BG bg;
    private Audio _music;
    private MovingBitmap failed;
    private BitmapButton ok;
    private boolean okPressed = false;

    private Navigation controller;
    private Button button;


    private CharacterObject ch;
    private ArrayList<EnemyObject> marins;

    private final static int enemyQuantity = 1;
    private int deadEnemiesQuantity = 0;
    private ArrayList<AttackObject> attacks;

    public StateStage1(GameEngine engine) {
        super(engine);
    }

    @Override
    public void initialize(Map<String, Object> data) {
        bg = new Stage1BG();
        failed = new MovingBitmap(R.drawable.failed);
        ok = new BitmapButton(R.drawable.ok);
        failed.setVisible(false);
        ok.setVisible(false);
        ok.setLocation(350, 300);

        _music = new Audio(R.raw.onepiece_op1);
        _music.setRepeating(true);
        _music.play();

        controller = new Navigation();
        button = new Button();
        controller.initialize();
        button.initialize();


        selectCharacter();
//        en01 = new MarinAI();
//        en01.initialize();
        marins = new ArrayList<EnemyObject>();
        for (int i = 0; i < enemyQuantity; i++) {
            marins.add(new MarinAI());
            marins.get(i).initialize();
        }
    }

    @Override
    public void move() {
        if (ch.isDead()) {
            failed.setVisible(true);
            ok.setVisible(true);
        }
        else if (noEnemy()) {
            changeState(Game.STAGE2_STATE);
        }
        else {
            attacks = new ArrayList<>();

            for (EnemyObject en : marins) {
                en.move(ch, bg.getX());
                attacks.add(new AttackObject(en));
            }
            bg.move(ch.getX());
            if (!ch.getHitting())
                ch.move(bg.getX());
            ch.getHit(attacks, bg.getX());
            button.move();
        }
    }

    @Override
    public void show() {
        bg.show();
        controller.show();
        button.show();
//        en01.show();
        ch.show();
        for (EnemyObject en : marins) {
            en.show();
        }
        failed.show();
        ok.show();
    }

    @Override
    public void release() {
        bg.release();
        _music.release();
        failed.release();
        ok.release();
        failed = null;
        ok = null;

        ch.release();
        controller.release();
        button.release();
//        en01.release();
        for (EnemyObject en : marins)
            en.release();
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
        if (ch.getHp() > 0) {
            controller.pointerPressed(pointers);
            button.pointerPressed(pointers, ch);
        }
        if (ok.pointerPressed(pointers))
            changeState(Game.OVER_STATE);
        return true;

    }

    @Override
    public boolean pointerMoved(List<Pointer> pointers) {
        controller.pointerMoved(pointers);
        button.pointerMoved(pointers, ch);
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

    public void selectCharacter() {
        switch (CharacterSelectState.character) {
            case 0:
                ch = new Luffy();
                break;
            case 1:
                CharacterSelectState.character = 0;
                ch = new Zoro();
                break;
        }
        ch.initialize();
    }

    public boolean noEnemy() {
        deadEnemiesQuantity = 0;
        for (EnemyObject en : marins)
            if (en.isDead())
                deadEnemiesQuantity++;
        if (deadEnemiesQuantity == enemyQuantity)
            return true;
        return false;
    }

}
