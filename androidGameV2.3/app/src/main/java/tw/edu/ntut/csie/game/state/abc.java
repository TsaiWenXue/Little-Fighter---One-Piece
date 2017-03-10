package tw.edu.ntut.csie.game.state;

import java.util.List;
import java.util.Map;

import tw.edu.ntut.csie.game.Game;
import tw.edu.ntut.csie.game.Pointer;
import tw.edu.ntut.csie.game.R;
import tw.edu.ntut.csie.game.core.Audio;
import tw.edu.ntut.csie.game.core.MovingBitmap;
import tw.edu.ntut.csie.game.engine.GameEngine;
import tw.edu.ntut.csie.game.extend.Animation;
import tw.edu.ntut.csie.game.extend.Integer;
import tw.edu.ntut.csie.game.state.Background_stage1;
import tw.edu.ntut.csie.game.GameObject;
import tw.edu.ntut.csie.game.PointerEventHandler;

public class abc implements GameObject, PointerEventHandler{
    private MovingBitmap button_controller;
    private boolean _grab;
    private int controllerPx,controllerPy;

    public abc(){
        button_controller = new MovingBitmap(R.drawable.button_direction);
        controllerPx=40;
        controllerPy=300;
    }
    public void initialize(){

        button_controller.setLocation(controllerPx,controllerPy);
    }

    @Override
    public void move(){}

    @Override
    public void show(){
        button_controller.show();
    }
    @Override
    public void release() {
        button_controller.release();

        button_controller = null;
    }

    @Override
    public boolean pointerPressed(List<Pointer> pointers){
        if(pointers.size() == 1){
            int touchX = pointers.get(0).getX();
            int touchY = pointers.get(0).getY();
            if (touchX > button_controller.getX() && touchX < button_controller.getX() + button_controller.getWidth() &&
                    touchY > button_controller.getY() && touchY < button_controller.getY() + button_controller.getHeight()) {
                _grab = true;
            } else {
                _grab = false;
            }
        }
        return true;
    }
    @Override
    public boolean pointerMoved(List<Pointer> pointers){
        if (_grab)
            button_controller.setLocation(pointers.get(0).getX() - button_controller.getWidth() / 2, pointers.get(0).getY() - button_controller.getHeight() / 2);
        int moveX = button_controller.getX();
        int moveY = button_controller.getY();

        return false;
    }
    @Override
    public boolean pointerReleased(List<Pointer> pointers) {
        _grab = false;
        button_controller.setLocation(40,300);
        return false;
    }
}