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
    private int at_y = 350;
    private int df_x = at_x - 80;
    private int df_y = at_y;
    public static boolean atPointerPressed;
    public static boolean dfPointerPressed;

    private MovingBitmap attack = new MovingBitmap(R.drawable.button_attack_normal);
    private MovingBitmap attack_pressed = new MovingBitmap(R.drawable.button_attack_pressed);
    private MovingBitmap defend = new MovingBitmap(R.drawable.button_defend_normal);
    private MovingBitmap defend_pressed = new MovingBitmap(R.drawable.button_defend_pressed);
    public Button() {}

    public void initialize(){
        attack.setLocation(at_x,at_y);
        attack_pressed.setLocation(at_x, at_y);
        attack_pressed.setVisible(false);
        defend.setLocation(df_x,df_y);
        defend_pressed.setLocation(df_x,df_y);
        defend_pressed.setVisible(false);
    }

    @Override
    public void show() {
        attack.show();
        attack_pressed.show();
        defend.show();
        defend_pressed.show();
    }

    @Override
    public void move(){

    }

    public void release() {
        attack.release();
        attack_pressed.release();
        defend.release();
        defend_pressed.release();

        attack = null;
        attack_pressed =null;
        defend = null;
        defend_pressed = null;
    }

    @Override
    public boolean pointerPressed(List<Pointer> pointers) {
        if(pointers.size() >= 1){
            //int touchX = pointers.get(0).getX();
            //int touchY = pointers.get(0).getY();
            int touchX, touchY;
            for(int i = 0; i < pointers.size(); i++){
                touchX = pointers.get(i).getX();
                touchY = pointers.get(i).getY();
                if (MovingBitmap.imageTouched(touchX, touchY, attack)) {
                    atPointerPressed = true;
                    attack_pressed.setVisible(true);
                    attack.setVisible(false);
                    break;
                }
                else if( MovingBitmap.imageTouched(touchX, touchY, defend) ) {
                    dfPointerPressed = true;
                    defend_pressed.setVisible(true);
                    defend.setVisible(false);
                    break;
                }
               else{
                    atPointerPressed = false;
                    dfPointerPressed = false;
                }
            }
            /*
            if ( MovingBitmap.imageTouched(touchX, touchY, attack)) {
                atPointerPressed = true;
                attack_pressed.setVisible(true);
                attack.setVisible(false);
            }
            else if( MovingBitmap.imageTouched(touchX, touchY, attack) ) {
                dfPointerPressed = true;
                defend_pressed.setVisible(true);
                defend.setVisible(false);
            }
           else{
                atPointerPressed = false;
                dfPointerPressed = false;
           }

        }
           */
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

        dfPointerPressed = false;
        defend.setVisible(true);
        defend_pressed.setVisible(false);
        return false;
    }

}
