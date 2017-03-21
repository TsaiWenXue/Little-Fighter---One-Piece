package tw.edu.ntut.csie.game.state;

import java.util.List;
import java.util.Map;

import tw.edu.ntut.csie.game.Game;
import tw.edu.ntut.csie.game.Pointer;
import tw.edu.ntut.csie.game.R;
import tw.edu.ntut.csie.game.core.Audio;
import tw.edu.ntut.csie.game.engine.GameEngine;
import tw.edu.ntut.csie.game.core.MovingBitmap;

public class StateRun extends GameState {
    private Audio _music;

    private MovingBitmap background = new MovingBitmap(R.drawable.character_select);
    private int bg_X = 0, bg_Y = 0;

    private MovingBitmap luffy = new MovingBitmap(R.drawable.luffy_f);
    private MovingBitmap zoro = new MovingBitmap(R.drawable.zoro_f);
    private int character_X = 130, character_Y = 105;

    private MovingBitmap luffyName = new MovingBitmap(R.drawable.name_luffy_f);
    private MovingBitmap zoroName = new MovingBitmap(R.drawable.name_zoro_f);
    private int name_X = 130, name_Y = 275;

    private MovingBitmap characterLeft = new MovingBitmap(R.drawable.arrow_left);
    private int characterLeft_X = 50, characterLeft_Y = 150;
    private MovingBitmap characterRight = new MovingBitmap(R.drawable.arrow_right);
    private int characterRight_X = 280, characterRight_Y = 150;
    private MovingBitmap stageLeft = new MovingBitmap(R.drawable.arrow_left);
    private int stageLeft_X = 420, stageLeft_Y = 190;
    private MovingBitmap stageRight = new MovingBitmap(R.drawable.arrow_right);
    private int stageRight_X = 695, stageRight_Y = 190;
    private MovingBitmap difficultLeft = new MovingBitmap(R.drawable.arrow_left);
    private int difficultLeft_X = 420, difficultLeft_Y = 270;
    private MovingBitmap difficultRight = new MovingBitmap(R.drawable.arrow_right);
    private int difficultRight_X = 695, difficultRight_Y = 270;

    private MovingBitmap start = new MovingBitmap(R.drawable.game_start);
    private int start_X = 500, start_Y = 105;

    private MovingBitmap stage1 = new MovingBitmap(R.drawable.stage1);
    private MovingBitmap stage2 = new MovingBitmap(R.drawable.stage2);
    private int stage_X = 500, stage_Y = 185;

    private MovingBitmap easy = new MovingBitmap(R.drawable.easy);
    private MovingBitmap normal = new MovingBitmap(R.drawable.normal);
    private int difficult_X = 500, difficult_Y = 265;


    public static int character = 0;
    public static int stage = 0;
    public static int difficult = 0;

    public StateRun(GameEngine engine) {
        super(engine);
    }

    @Override
    public void initialize(Map<String, Object> data) {
        background.setLocation(bg_X, bg_Y);

        luffy.setLocation(character_X, character_Y);
        luffyName.setLocation(name_X, name_Y);
        zoro.setLocation(character_X, character_Y);
        zoroName.setLocation(name_X, name_Y);
        zoro.setVisible(false); zoroName.setVisible(false);

        characterLeft.setLocation(characterLeft_X, characterLeft_Y);
        characterRight.setLocation(characterRight_X, characterRight_Y);
        stageLeft.setLocation(stageLeft_X, stageLeft_Y);
        stageRight.setLocation(stageRight_X, stageRight_Y);
        difficultLeft.setLocation(difficultLeft_X, difficultLeft_Y);
        difficultRight.setLocation(difficultRight_X, difficultRight_Y);

        start.setLocation(start_X, start_Y);

        stage1.setLocation(stage_X, stage_Y);
        stage2.setLocation(stage_X, stage_Y);
        stage2.setVisible(false);

        easy.setLocation(difficult_X, difficult_Y);
        normal.setLocation(difficult_X, difficult_Y);
        normal.setVisible(false);

        _music = new Audio(R.raw.onepiece_op1);
        _music.setRepeating(true);
        _music.play();

    }

    @Override
    public void move() {

    }

    @Override
    public void show() {
        background.show();

        luffy.show(); luffyName.show();
        zoro.show(); zoroName.show();

        characterLeft.show();
        characterRight.show();
        stageLeft.show();
        stageRight.show();
        difficultLeft.show();
        difficultRight.show();

        start.show();

        stage1.show();
        stage2.show();

        easy.show();
        normal.show();
    }

    @Override
    public void release() {
        _music.release();
        background.release();

        luffy.release(); luffyName.release();
        zoro.release(); zoroName.release();

        characterLeft.release();
        characterRight.release();
        stageLeft.release();
        stageRight.release();
        difficultLeft.release();
        difficultRight.release();

        start.release();

        stage1.release();
        stage2.release();

        easy.release();
        normal.release();


        _music = null;
        background = null;

        luffy = null; luffyName = null;
        zoro = null; zoroName = null;

        characterLeft = null;
        characterRight = null;
        stageLeft = null;
        stageRight = null;
        difficultLeft = null;
        difficultRight = null;

        start = null;

        stage1 = null;
        stage2 = null;

        easy = null;
        normal = null;
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
        if (pointers.size() == 1) {
            int touchX = pointers.get(0).getX();
            int touchY = pointers.get(0).getY();
            if (touchX > start_X && touchX < start_X + start.getWidth() &&
                touchY > start_Y && touchY < start_Y + start.getHeight()) {
                    changeState(Game.STAGE1_STATE);
            }

            if (touchX > stageRight_X && touchX < stageRight_X + stageRight.getWidth() &&
                touchY > stageRight_Y && touchY < stageRight_Y + stageRight.getHeight()) {
                stage++;
            }
            else if (touchX > stageLeft_X && touchX < stageLeft_X + stageLeft.getWidth() &&
                touchY > stageLeft_Y && touchY < stageLeft_Y + stageLeft.getHeight()) {
                stage--;
            }

            if (touchX > difficultRight_X && touchX < difficultRight_X + difficultRight.getWidth() &&
                touchY > difficultRight_Y && touchY < difficultRight_Y + difficultRight.getHeight()) {
                difficult++;
            }
            else if (touchX > difficultLeft_X && touchX < difficultLeft_X + difficultLeft.getWidth() &&
                touchY > difficultLeft_Y && touchY < difficultLeft_Y + difficultLeft.getHeight()) {
                difficult--;
            }

            if (touchX > characterRight_X && touchX < characterRight_X + characterRight.getWidth() &&
                touchY > characterRight_Y && touchY < characterRight_Y + characterRight.getHeight()) {
                character++;
            }
            else if (touchX > characterLeft_X && touchX < characterLeft_X + characterLeft.getWidth() &&
                touchY > characterLeft_Y && touchY < characterLeft_Y + characterLeft.getHeight()) {
                character--;
            }

            if (stage < 0)
                stage = -stage;
            if (difficult < 0)
                difficult = -difficult;
            if (character < 0)
                character  = -character;
            stage = stage % 2;
            difficult = difficult % 2;
            character = character % 2;

            switch (stage) {
                case 0:
                    stage1.setVisible(true);
                    stage2.setVisible(false);
                    break;
                case 1:
                    stage1.setVisible(false);
                    stage2.setVisible(true);
                    break;
            }

            switch (difficult) {
                case 0:
                    easy.setVisible(true);
                    normal.setVisible(false);
                    break;
                case 1:
                    easy.setVisible(false);
                    normal.setVisible(true);
                    break;
            }

            switch (character) {
                case 0:
                    luffy.setVisible(true); luffyName.setVisible(true);
                    zoro.setVisible(false); zoroName.setVisible(false);
                    break;
                case 1:
                    luffy.setVisible(false); luffyName.setVisible(false);
                    zoro.setVisible(true); zoroName.setVisible(true);
                    break;
            }
        }

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
        _music.pause();
    }

    @Override
    public void resume() {
        _music.resume();
    }
}
