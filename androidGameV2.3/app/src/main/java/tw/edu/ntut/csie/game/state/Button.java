package tw.edu.ntut.csie.game.state;

import java.util.ArrayList;
import java.util.List;

import tw.edu.ntut.csie.game.Pointer;
import tw.edu.ntut.csie.game.R;
import tw.edu.ntut.csie.game.core.MovingBitmap;
import tw.edu.ntut.csie.game.GameObject;
import tw.edu.ntut.csie.game.PointerEventHandler;
import tw.edu.ntut.csie.game.extend.BitmapButton;

public class Button implements GameObject, PointerEventHandler {
    private int at_x = 700;
    private int at_y = 300;
    public static boolean atPointerPressed;
    
    private MovingBitmap attack = new MovingBitmap(R.drawable.button_attack_normal);
    private MovingBitmap attack_pressed = new MovingBitmap(R.drawable.button_attack_pressed);
    public Button() {}

    public void initialize(){
        attack.setLocation(at_x,at_y);
        attack_pressed.setLocation(at_x, at_y);
        attack_pressed.setVisible(false);
    }

    @Override
    public void show() {
        attack.show();
        attack_pressed.show();
    }

    @Override
    public void move(){

    }

    public void release() {
        attack.release();
        attack = null;
    }

    @Override
    public boolean pointerPressed(List<Pointer> pointers) {
        if(pointers.size() == 1){
            int touchX = pointers.get(0).getX();
            int touchY = pointers.get(0).getY();
            if (touchX > attack.getX() && touchX < attack.getX() + attack.getWidth() &&
                touchY > attack.getY() && touchY < attack.getY() + attack.getHeight()) {
                atPointerPressed = true;
                attack_pressed.setVisible(true);
                attack.setVisible(false);
            } else {
                atPointerPressed = false;
            }
        }

        return false;
    }

    @Override
    public boolean pointerMoved(List<Pointer> pointers) {

        return false;
    }

    @Override
    public boolean pointerReleased(List<Pointer> pointers) {
        atPointerPressed = false;
        attack.setVisible(true);
        attack_pressed.setVisible(false);
        return false;
    }

}
