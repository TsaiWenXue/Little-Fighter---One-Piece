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
    }

    @Override
    public boolean pointerPressed(List<Pointer> pointers){
        return false;
    }
    @Override
    public boolean pointerMoved(List<Pointer> pointers){
            for(int i = 0 ; i < pointers.size(); i++){
                int touchX = pointers.get(i).getX();
                int touchY = pointers.get(i).getY();
                if(button_controller.imageTouched(touchX, touchY)){
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
        controllerPx = initialCtrlPx;
        controllerPy = initialCtrlPy;
        button_controller.setLocation(controllerPx, controllerPy);
        return false;
    }
}
