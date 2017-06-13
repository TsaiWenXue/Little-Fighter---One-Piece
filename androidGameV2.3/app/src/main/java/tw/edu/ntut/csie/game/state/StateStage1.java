package tw.edu.ntut.csie.game.state;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import tw.edu.ntut.csie.game.Character.*;
import tw.edu.ntut.csie.game.Enemy.*;
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
    private MovingBitmap clear;
    private BitmapButton ok;
    private MovingBitmap invincible;
    private MovingBitmap invincible_pressed;

    private Navigation controller;
    private Button button;


    private CharacterObject ch;
    private ArrayList<EnemyObject> marins;

    private final static int enemyQuantity = 10;
    private int deadEnemiesQuantity = 0;
    private ArrayList<AttackObject> attacks;

    public StateStage1(GameEngine engine) {
        super(engine);
    }

    @Override
    public void initialize(Map<String, Object> data) {
        invincible = new MovingBitmap(R.drawable.invincible);
        invincible_pressed = new MovingBitmap(R.drawable.invincible_pressed);
        invincible.setLocation(700, 50);
        invincible_pressed.setLocation(700, 50);
        invincible_pressed.setVisible(false);

        bg = new Stage1BG();
        failed = new MovingBitmap(R.drawable.failed);
        clear = new MovingBitmap(R.drawable.stage_clear);
        ok = new BitmapButton(R.drawable.ok);
        failed.setVisible(false);
        clear.setVisible(false);
        ok.setVisible(false);

        _music = new Audio(R.raw.onepiece_op1);
        _music.setRepeating(true);
        _music.play();

        controller = new Navigation();
        button = new Button();

        //Declare the character according to which character is selected in CharacterSelectState
        selectCharacter();

        //Make all enemies
        marins = new ArrayList<EnemyObject>();
        for (int i = 0; i < enemyQuantity; i++) {
            marins.add(new MarinAI());
        }
    }

    @Override
    public void move() {
        //If character is dead, display the failed frame, and stop the stage.
        if (ch.isDead()) {
            failed.setVisible(true);
            ok.setLocation(350, 300);
            ok.setVisible(true);
        }
        //If all enemies are dead, display the success frame
        else if (noEnemy()) {
            clear.setVisible(true);
            ok.setLocation(500, 330);
            ok.setVisible(true);
        }
        //Apply the game in normal
        else {
            attacks = new ArrayList<>();

            for (int i = 0; i < marins.size(); i++) {
                marins.get(i).move(ch, bg.getX());
                //To get all marins attack area
                attacks.add(new AttackObject(marins.get(i)));
            }
            bg.move(ch.getX());
            //If character get hit, character couldn't move.
            if (!ch.getHitting())
                ch.move(bg.getX());
            //If character is attacking, character will not get hit.
            if (!invincible_pressed.isVisible() && ch.isNotPerforming() ) {
                if (!Button.fire_bool)
                    ch.getHit(attacks, bg.getX());
                else
                    ch.secGetHit(attacks, bg.getX());
            }
            button.move(ch);
        }
    }

    @Override
    public void show() {

        bg.show();
        controller.show();
        button.show();
        ch.show();
        for (int i = 0; i < marins.size(); i++) {
            marins.get(i).show();
        }
        failed.show();
        clear.show();
        ok.show();
        invincible.show();
        invincible_pressed.show();
    }

    @Override
    public void release() {
        bg.release();
        _music.release();
        failed.release();
        clear.release();
        ok.release();
        invincible.release();
        invincible_pressed.release();

        controller.release();
        button.release();
        ch.release();
        for (int i = 0; i < marins.size(); i++)
            marins.get(i).release();
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
        for (int i = 0; i < pointers.size(); i++) {
            int touchX = pointers.get(i).getX();
            int touchY = pointers.get(i).getY();
            if (invincible.imageTouched(touchX, touchY) && !invincible_pressed.isVisible()) {
                invincible_pressed.setVisible(true);
            }
            else if (invincible.imageTouched(touchX, touchY) && invincible_pressed.isVisible()) {
                invincible_pressed.setVisible(false);
            }
        }
        if (ch.getHp() > 0 && !ch.getHitting()) {
            controller.pointerPressed(pointers);
            button.pointerPressed(pointers, ch);
        }
        if (ok.pointerPressed(pointers)) {
            //When player is dead, calculate the score, and change state after player pressed continue
            if (ch.isDead()) {
                Record.calTime();
                for (EnemyObject en : marins) {
                    if (en.isDead())
                        Record.killed++;
                }
                changeState(Game.OVER_DEFEAT_STAGE);
            }
            //When player pass the stage, calculate the score, and change state after player pressed continue
            if (noEnemy()) {
                for (EnemyObject en : marins) {
                    if (en.isDead())
                        Record.killed++;
                }
                changeState(Game.STAGE2_STATE);
            }
        }
        return true;

    }

    @Override
    public boolean pointerMoved(List<Pointer> pointers) {
        if (ch.getHp() > 0 && !ch.getHitting()) {
            controller.pointerMoved(pointers);
            button.pointerMoved(pointers, ch);
        }
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
