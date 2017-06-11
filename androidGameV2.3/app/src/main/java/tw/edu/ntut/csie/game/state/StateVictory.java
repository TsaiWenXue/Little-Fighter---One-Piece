package tw.edu.ntut.csie.game.state;

import java.util.Map;
import java.util.Objects;

import tw.edu.ntut.csie.game.Game;
import tw.edu.ntut.csie.game.R;
import tw.edu.ntut.csie.game.core.MovingBitmap;
import tw.edu.ntut.csie.game.engine.GameEngine;
import tw.edu.ntut.csie.game.extend.BitmapButton;
import tw.edu.ntut.csie.game.extend.ButtonEventHandler;

/**
 * Created by Hsiang on 2017/6/11.
 */

public class StateVictory extends AbstractGameState {
    private BitmapButton continueButton;

    public StateVictory (GameEngine engine) {
        super(engine);
    }

    @Override
    public void initialize(Map<String, Object> data) {
        addGameObject(new MovingBitmap(R.drawable.victory));
        continueButton = new BitmapButton(R.drawable.ok, R.drawable.ok_pressed, 350, 300);
        continueButton.addButtonEventHandler(new ButtonEventHandler() {
            @Override
            public void perform(BitmapButton button) {
                changeState(Game.INITIAL_STATE);
            }
        });
        addGameObject(continueButton);
        addPointerEventHandler(continueButton);
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