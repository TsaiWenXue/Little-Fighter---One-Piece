//package tw.edu.ntut.csie.game.state;
//
//import java.util.Map;
//import java.util.Objects;
//
//import tw.edu.ntut.csie.game.Game;
//import tw.edu.ntut.csie.game.R;
//import tw.edu.ntut.csie.game.core.MovingBitmap;
//import tw.edu.ntut.csie.game.engine.GameEngine;
//import tw.edu.ntut.csie.game.extend.BitmapButton;
//import tw.edu.ntut.csie.game.extend.ButtonEventHandler;
//
///**
// * Created by Hsiang on 2017/6/11.
// */
//
//public class StateVictory extends AbstractGameState {
//    private BitmapButton cont;
//
//    public StateVictory (GameEngine engine) {
//        super(engine);
//    }
//
//    @Override
//    public void initialize(Map<String, Objects> data) {
//
//    }
//}
//public class StateOver extends AbstractGameState {
//    private BitmapButton _menuButton;
//
//    public StateOver(GameEngine engine) {
//        super(engine);
//    }
//
//    @Override
//    public void initialize(Map<String, Object> data) {
//        addGameObject(new MovingBitmap(R.drawable.state_over));
//        _menuButton = new BitmapButton(R.drawable.menu, R.drawable.menu_pressed, 465, 320);
//        _menuButton.addButtonEventHandler(new ButtonEventHandler() {
//            @Override
//            public void perform(BitmapButton button) {
//                changeState(Game.INITIAL_STATE);
//            }
//        });
//        addGameObject(_menuButton);
//        addPointerEventHandler(_menuButton);
//    }
//
//    @Override
//    public void move() {
//        super.move();
//    }
//
//    @Override
//    public void pause() {
//    }
//
//    @Override
//    public void resume() {
//    }
//
//}