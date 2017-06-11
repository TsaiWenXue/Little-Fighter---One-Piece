package tw.edu.ntut.csie.game.state;

import java.util.Map;

import tw.edu.ntut.csie.game.Character.Record;
import tw.edu.ntut.csie.game.Game;
import tw.edu.ntut.csie.game.R;
import tw.edu.ntut.csie.game.core.MovingBitmap;
import tw.edu.ntut.csie.game.engine.GameEngine;
import tw.edu.ntut.csie.game.extend.BitmapButton;
import tw.edu.ntut.csie.game.extend.ButtonEventHandler;

/**
 * Created by Hsiang on 2017/6/12.
 */

public class StateDefeat extends AbstractGameState {
    private BitmapButton continueButton;
    private MovingBitmap minTen;
    private MovingBitmap min;
    private MovingBitmap secTen;
    private MovingBitmap sec;

    private MovingBitmap one, ten, hund;

    public StateDefeat (GameEngine engine) {
        super(engine);
    }

    @Override
    public void initialize(Map<String, Object> data) {
        addGameObject(new MovingBitmap(R.drawable.defeat));
        int seconds = (int)(Record.time / 1000);
        int minutes = seconds/60;
        seconds = seconds % 60;

        sec = getNum(seconds%10);
        seconds /= 10;
        secTen = getNum(seconds%10);

        min = getNum(minutes % 10);
        minutes /= 10;
        minTen = getNum(minutes % 10);

        minTen.setLocation(380, 50);
        min.setLocation(400, 50);
        secTen.setLocation(480, 50);
        sec.setLocation(500, 50);

        addGameObject(minTen);
        addGameObject(min);
        addGameObject(secTen);
        addGameObject(sec);

        int killNumber = Record.killed;
        one = getNum(killNumber % 10);
        killNumber /= 10;
        ten = getNum(killNumber % 10);
        killNumber /= 10;
        hund = getNum(killNumber % 10);

        hund.setLocation(380, 125);
        ten.setLocation(400, 125);
        one.setLocation(420, 125);

        addGameObject(hund);
        addGameObject(ten);
        addGameObject(one);

        continueButton = new BitmapButton(R.drawable.ok, R.drawable.ok_pressed, 350, 400);
        continueButton.addButtonEventHandler(new ButtonEventHandler() {
            @Override
            public void perform(BitmapButton button) {
                changeState(Game.INITIAL_STATE);
            }
        });
        addGameObject(continueButton);
        addPointerEventHandler(continueButton);
    }

    public MovingBitmap getNum(int num) {
        switch (num) {
            case 0:
                return new MovingBitmap(R.drawable.digit_0);
            case 1:
                return new MovingBitmap(R.drawable.digit_1);
            case 2:
                return new MovingBitmap(R.drawable.digit_2);
            case 3:
                return new MovingBitmap(R.drawable.digit_3);
            case 4:
                return new MovingBitmap(R.drawable.digit_4);
            case 5:
                return new MovingBitmap(R.drawable.digit_5);
            case 6:
                return new MovingBitmap(R.drawable.digit_6);
            case 7:
                return new MovingBitmap(R.drawable.digit_7);
            case 8:
                return new MovingBitmap(R.drawable.digit_8);
            case 9:
                return new MovingBitmap(R.drawable.digit_9);
            default:
                return null;
        }
    }

    @Override
    public void move() {
        super.move();
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }
}
