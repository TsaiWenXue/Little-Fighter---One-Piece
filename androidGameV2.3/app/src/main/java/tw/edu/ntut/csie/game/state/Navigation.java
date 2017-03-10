package tw.edu.ntut.csie.game.state;


import java.util.List;

import tw.edu.ntut.csie.game.Pointer;
import tw.edu.ntut.csie.game.R;
import tw.edu.ntut.csie.game.core.MovingBitmap;
import tw.edu.ntut.csie.game.extend.Animation;
import tw.edu.ntut.csie.game.GameObject;
import tw.edu.ntut.csie.game.PointerEventHandler;

public class Navigation implements GameObject, PointerEventHandler {

    private MovingBitmap button_controller;
    private MovingBitmap button_background;
    private boolean _grab;
    public int controllerPx, controllerPy;

    public Navigation() {
        button_controller = new MovingBitmap(R.drawable.button_direction);
        button_background = new MovingBitmap(R.drawable.button_background);
        controllerPx = 40;
        controllerPy = 300;
    }

    public void initialize(){
        button_controller.setLocation(controllerPx, controllerPy);
        button_background.setLocation(controllerPx + button_controller.getWidth()/2 - button_background.getWidth()/2,
                                      controllerPy + button_controller.getHeight()/2 - button_background.getHeight()/2 );
        //button_background.setLocation(controllerPx, controllerPy);
    }

    @Override
    public void move(){}

    @Override
    public void show(){
        button_background.show();
        button_controller.show();
    }

    @Override
    public void release() {
        button_controller.release();
        button_background.release();

        button_controller = null;
        button_background = null;
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
        if (_grab){
            if ((controllerPx - 40) * (controllerPx - 40) + (controllerPy - 300) * (controllerPy - 300)<=
                (button_controller.getWidth() / 2) * (button_controller.getWidth() / 2)){
                controllerPx = pointers.get(0).getX() - button_controller.getWidth() / 2;
                controllerPy = pointers.get(0).getY() - button_controller.getHeight() / 2;
                }
            button_controller.setLocation(controllerPx, controllerPy);
        }
        return false;

    }
    @Override
    public boolean pointerReleased(List<Pointer> pointers) {
        _grab = false;
        controllerPx = 40;
        controllerPy = 300;
        button_controller.setLocation(controllerPx, controllerPy);
        return false;
    }
}
