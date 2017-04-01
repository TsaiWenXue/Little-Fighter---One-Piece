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
    public static int initialCtrlPx = 40, initialCtrlPy = 300;
    public static int controllerPx, controllerPy;

    public Navigation() {
        button_controller = new MovingBitmap(R.drawable.button_direction);
        button_background = new MovingBitmap(R.drawable.button_background);
        controllerPx = initialCtrlPx;
        controllerPy = initialCtrlPy;
    }

    public void initialize(){
        button_controller.setLocation(controllerPx, controllerPy);
        button_background.setLocation(initialCtrlPx + button_controller.getWidth()/2 - button_background.getWidth()/2,
                                      initialCtrlPy + button_controller.getHeight()/2 - button_background.getHeight()/2 );
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
        if(pointers.size() >= 1){
            /*int touchX = pointers.get(0).getX();
            int touchY = pointers.get(0).getY();
            if (touchX > button_controller.getX() && touchX < button_controller.getX() + button_controller.getWidth() &&
                    touchY > button_controller.getY() && touchY < button_controller.getY() + button_controller.getHeight()) {
                _grab = true;
            } else {
                _grab = false;
            }*/
            int touchX, touchY;
            for(int i = 0; i < pointers.size(); i++){
                touchX = pointers.get(i).getX();
                touchY = pointers.get(i).getY();
                if (MovingBitmap.imageTouched(touchX, touchY, button_controller)) {
                    _grab = true;
                    break;
                }
               else{
                    _grab = false;
                }
            }
        }
        return true;
    }
    @Override
    public boolean pointerMoved(List<Pointer> pointers){
        if (_grab){
          for(int i = 0; i<pointers.size(); i++){
            controllerPx = pointers.get(i).getX() - button_controller.getWidth() / 2;
            controllerPy = pointers.get(i).getY() - button_controller.getHeight() / 2;
            if ((controllerPx - initialCtrlPx) * (controllerPx - initialCtrlPx) + (controllerPy - initialCtrlPy) * (controllerPy - initialCtrlPy) >=
                (button_controller.getWidth() / 2) * (button_controller.getWidth() / 2)) {
                    double distant = Math.sqrt( (controllerPx - initialCtrlPx) * (controllerPx - initialCtrlPx) +
                                                (controllerPy - initialCtrlPy) * (controllerPy - initialCtrlPy) );
                    controllerPx = (int)((controllerPx - initialCtrlPx) * ((button_controller.getWidth()/2) / distant) + initialCtrlPx);
                    controllerPy = (int)((controllerPy - initialCtrlPy) * ((button_controller.getWidth()/2) / distant) + initialCtrlPy);
                }
            button_controller.setLocation(controllerPx, controllerPy);
          }
        }
        return false;

    }
    @Override
    public boolean pointerReleased(List<Pointer> pointers) {
        _grab = false;
        controllerPx = initialCtrlPx;
        controllerPy = initialCtrlPy;
        button_controller.setLocation(controllerPx, controllerPy);
        return false;
    }
}
