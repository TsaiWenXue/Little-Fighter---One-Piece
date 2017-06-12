package tw.edu.ntut.csie.game.state;

import java.util.List;
import java.util.Map;

import tw.edu.ntut.csie.game.Character.Record;
import tw.edu.ntut.csie.game.Game;
import tw.edu.ntut.csie.game.Pointer;
import tw.edu.ntut.csie.game.R;
import tw.edu.ntut.csie.game.core.Audio;
import tw.edu.ntut.csie.game.engine.GameEngine;
import tw.edu.ntut.csie.game.core.MovingBitmap;

public class CharacterSelectState extends GameState {
    private Audio _music;

    private MovingBitmap background;
    private int bg_X = 0, bg_Y = 0;

    private MovingBitmap luffy;
    private MovingBitmap zoro;
    private int character_X = 130, character_Y = 105;

    private MovingBitmap luffyName;
    private MovingBitmap zoroName;
    private int name_X = 130, name_Y = 275;

    private MovingBitmap characterLeft;
    private int characterLeft_X = 50, characterLeft_Y = 150;
    private MovingBitmap characterRight;
    private int characterRight_X = 280, characterRight_Y = 150;
    private MovingBitmap stageLeft;
    private int stageLeft_X = 420, stageLeft_Y = 190;
    private MovingBitmap stageRight;
    private int stageRight_X = 695, stageRight_Y = 190;
    private MovingBitmap difficultLeft;
    private int difficultLeft_X = 420, difficultLeft_Y = 270;
    private MovingBitmap difficultRight;
    private int difficultRight_X = 695, difficultRight_Y = 270;

    private MovingBitmap start;
    private int start_X = 500, start_Y = 105;

    private MovingBitmap stage1;
    private MovingBitmap stage2;
    private int stage_X = 500, stage_Y = 185;

    private MovingBitmap easy;
    private MovingBitmap normal;
    private int difficult_X = 500, difficult_Y = 265;


    public static int character = 0;
    public static int stage = 0;
    public static int difficult = 0;

    public CharacterSelectState(GameEngine engine) {
        super(engine);
    }

    @Override
    public void initialize(Map<String, Object> data) {
        background = new MovingBitmap(R.drawable.character_select);
        background.setLocation(bg_X, bg_Y);

        luffy = new MovingBitmap(R.drawable.luffy_f);
        luffyName = new MovingBitmap(R.drawable.name_luffy_f);
        luffy.setLocation(character_X, character_Y);
        luffyName.setLocation(name_X, name_Y);
        zoro = new MovingBitmap(R.drawable.zoro_f);
        zoroName = new MovingBitmap(R.drawable.name_zoro_f);
        zoro.setLocation(character_X, character_Y);
        zoroName.setLocation(name_X, name_Y);
        zoro.setVisible(false); zoroName.setVisible(false);

        characterLeft = new MovingBitmap(R.drawable.arrow_left);
        characterRight = new MovingBitmap(R.drawable.arrow_right);
        stageLeft = new MovingBitmap(R.drawable.arrow_left);
        stageRight = new MovingBitmap(R.drawable.arrow_right);
        difficultLeft = new MovingBitmap(R.drawable.arrow_left);
        difficultRight = new MovingBitmap(R.drawable.arrow_right);
        characterLeft.setLocation(characterLeft_X, characterLeft_Y);
        characterRight.setLocation(characterRight_X, characterRight_Y);
        stageLeft.setLocation(stageLeft_X, stageLeft_Y);
        stageRight.setLocation(stageRight_X, stageRight_Y);
        difficultLeft.setLocation(difficultLeft_X, difficultLeft_Y);
        difficultRight.setLocation(difficultRight_X, difficultRight_Y);

        start = new MovingBitmap(R.drawable.game_start);
        start.setLocation(start_X, start_Y);

        stage1 = new MovingBitmap(R.drawable.stage1);
        stage2 = new MovingBitmap(R.drawable.stage2);
        stage1.setLocation(stage_X, stage_Y);
        stage2.setLocation(stage_X, stage_Y);
        stage2.setVisible(false);

        easy = new MovingBitmap(R.drawable.easy);
        normal = new MovingBitmap(R.drawable.normal);
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
        stageRight.release();

        difficultRight.release();

        start.release();

        stage1.release();
        stage2.release();

        easy.release();
        normal.release();

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
            //To start the game when start button pressed
            if (touchX > start_X && touchX < start_X + start.getWidth() &&
                touchY > start_Y && touchY < start_Y + start.getHeight()) {
                Record.reset();
                //Select Stage
                switch(stage){
                    case 0:
                    changeState(Game.STAGE1_STATE);
                    break;
                    case 1:
                    stage = 0;
                    changeState(Game.STAGE2_STATE);
                    break;
                }
            }

            //Player select stage;
            if (touchX > stageRight_X && touchX < stageRight_X + stageRight.getWidth() &&
                touchY > stageRight_Y && touchY < stageRight_Y + stageRight.getHeight()) {
                stage++;
            }
            else if (touchX > stageLeft_X && touchX < stageLeft_X + stageLeft.getWidth() &&
                touchY > stageLeft_Y && touchY < stageLeft_Y + stageLeft.getHeight()) {
                stage--;
            }

            //Player select difficult
            if (touchX > difficultRight_X && touchX < difficultRight_X + difficultRight.getWidth() &&
                touchY > difficultRight_Y && touchY < difficultRight_Y + difficultRight.getHeight()) {
                difficult++;
            }
            else if (touchX > difficultLeft_X && touchX < difficultLeft_X + difficultLeft.getWidth() &&
                touchY > difficultLeft_Y && touchY < difficultLeft_Y + difficultLeft.getHeight()) {
                difficult--;
            }

            //Player select character
            if (touchX > characterRight_X && touchX < characterRight_X + characterRight.getWidth() &&
                touchY > characterRight_Y && touchY < characterRight_Y + characterRight.getHeight()) {
                character++;
            }
            else if (touchX > characterLeft_X && touchX < characterLeft_X + characterLeft.getWidth() &&
                touchY > characterLeft_Y && touchY < characterLeft_Y + characterLeft.getHeight()) {
                character--;
            }

            //To handle the stage, difficult, character out of range
            if (stage < 0)
                stage = -stage;
            if (difficult < 0)
                difficult = -difficult;
            if (character < 0)
                character  = -character;
            stage = stage % 2;
            difficult = difficult % 2;
            character = character % 2;

            //Change the current stage name to selected stage
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

            //Change the current difficult name to selected difficult
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

            //Change the current character name and image to selected charater
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
