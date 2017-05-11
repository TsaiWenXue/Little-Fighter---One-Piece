package tw.edu.ntut.csie.game.state;

import java.util.ArrayList;
import java.util.List;

import tw.edu.ntut.csie.game.Pointer;
import tw.edu.ntut.csie.game.R;
import tw.edu.ntut.csie.game.core.MovingBitmap;
import tw.edu.ntut.csie.game.GameObject;
import tw.edu.ntut.csie.game.PointerEventHandler;
import tw.edu.ntut.csie.game.extend.BitmapButton;
import tw.edu.ntut.csie.game.state.Navigation;
import tw.edu.ntut.csie.game.extend.Animation;

public class Button implements GameObject, PointerEventHandler {
    private int at_x = 700;
    private int at_y = 350;
    private int df_x = at_x - 80;
    private int df_y = at_y - 20;
    private int jp_x = at_x - 15;
    private int jp_y = at_y - 80;
    private int s_x = at_x + 15;
    private int s_y = at_y - 170;
    private int e_x = at_x - 135;
    private int e_y = at_y - 85;
    private int f_x = at_x - 170;
    private int f_y = at_y;
    private int g_x = s_x - 85;
    private int g_y = s_y + 20;

    public static boolean atPointerPressed;
    public static boolean dfPointerPressed;
    public static boolean jpPointerPressed;
    public static boolean sPointerPressed;
    public static boolean ePointerPressed;
    public static boolean fPointerPressed;
    public static boolean gPointerPressed;

    public static boolean s_cd = false;
    public static boolean e_cd = false;
    public static boolean f_cd = false;
    public static boolean g_cd = false;

    private MovingBitmap attack;
    private MovingBitmap attack_pressed;
    private MovingBitmap defend;
    private MovingBitmap defend_pressed;
    private MovingBitmap jump;
    private MovingBitmap jump_pressed;
    private MovingBitmap s_skill;
    private MovingBitmap s_skill_pressed;
    private MovingBitmap e_skill;
    private MovingBitmap e_skill_pressed;
    private MovingBitmap f_skill;
    private MovingBitmap f_skill_pressed;
    private MovingBitmap g_skill;
    private MovingBitmap g_skill_pressed;

    private Animation s_skill_cd;
    private Animation e_skill_cd;
    private Animation g_skill_cd;
    private Animation f_skill_cd;

    public Button() {}

    public void initialize(){

        attack = new MovingBitmap(R.drawable.button_attack_normal);
        attack_pressed = new MovingBitmap(R.drawable.button_attack_pressed);
        attack.setLocation(at_x,at_y);
        attack_pressed.setLocation(at_x, at_y);
        attack_pressed.setVisible(false);

        defend = new MovingBitmap(R.drawable.button_defend_normal);
        defend_pressed = new MovingBitmap(R.drawable.button_defend_pressed);
        defend.setLocation(df_x,df_y);
        defend_pressed.setLocation(df_x,df_y);
        defend_pressed.setVisible(false);

        jump = new MovingBitmap(R.drawable.jump_normal);
        jump_pressed = new MovingBitmap(R.drawable.jump_pressed);
        jump.setLocation(jp_x,jp_y);
        jump_pressed.setLocation(jp_x,jp_y);
        jump_pressed.setVisible(false);

        s_skill = new MovingBitmap(R.drawable.s_normal);
        s_skill_pressed = new MovingBitmap(R.drawable.s_pressed);
        s_skill.setLocation(s_x,s_y);
        s_skill_pressed.setLocation(s_x,s_y);
        s_skill_pressed.setVisible(false);

        e_skill = new MovingBitmap(R.drawable.e_normal);
        e_skill_pressed = new MovingBitmap(R.drawable.e_pressed);
        e_skill.setLocation(e_x,e_y);
        e_skill_pressed.setLocation(e_x,e_y);
        e_skill_pressed.setVisible(false);

        f_skill = new MovingBitmap(R.drawable.f_normal);
        f_skill_pressed = new MovingBitmap(R.drawable.f_pressed);
        f_skill.setLocation(f_x,f_y);
        f_skill_pressed.setLocation(f_x,f_y);
        f_skill_pressed.setVisible(false);

        g_skill = new MovingBitmap(R.drawable.g_normal);
        g_skill_pressed = new MovingBitmap(R.drawable.g_pressed);
        g_skill.setLocation(g_x,g_y);
        g_skill_pressed.setLocation(g_x,g_y);
        g_skill_pressed.setVisible(false);

        s_skill_cd = new Animation();
        s_skill_cd.cdTimeInit(9, s_x, s_y);
        e_skill_cd = new Animation();
        e_skill_cd.cdTimeInit(3, e_x, e_y);
        f_skill_cd = new Animation();
        f_skill_cd.cdTimeInit(5, f_x, f_y);
        g_skill_cd = new Animation();
        g_skill_cd.cdTimeInit(4, g_x, g_y);
      }

    @Override
    public void show() {

        attack.show();
        attack_pressed.show();
        defend.show();
        defend_pressed.show();
        jump.show();
        jump_pressed.show();
        s_skill.show();
        s_skill_pressed.show();
        e_skill.show();
        e_skill_pressed.show();
        f_skill.show();
        f_skill_pressed.show();
        g_skill.show();
        g_skill_pressed.show();
        s_skill_cd.show();
        e_skill_cd.show();
        f_skill_cd.show();
        g_skill_cd.show();
    }

    @Override
    public void move(){
        s_skill_cd.move();
        e_skill_cd.move();
        f_skill_cd.move();
        g_skill_cd.move();
    }

    public void release() {

        attack.release();
        attack_pressed.release();
        defend.release();
        defend_pressed.release();
        jump.release();
        jump_pressed.release();
        s_skill.release();
        s_skill_pressed.release();
        e_skill.release();
        e_skill_pressed.release();
        f_skill.release();
        f_skill_pressed.release();
        g_skill.release();
        g_skill_pressed.release();
        s_skill_cd.release();
        e_skill_cd.release();
        f_skill_cd.release();
        g_skill_cd.release();
    }

    @Override
    public boolean pointerPressed(List<Pointer> pointers) {
        int touchX = pointers.get(0).getX();
        int touchY = pointers.get(0).getY();
            if ( attack.imageTouched(touchX, touchY)) {
                atPointerPressed = true;
                attack_pressed.setVisible(true);
                attack.setVisible(false);
            }
            else if( defend.imageTouched(touchX, touchY) ) {
                dfPointerPressed = true;
                defend_pressed.setVisible(true);
                defend.setVisible(false);
            }
            else if( jump.imageTouched(touchX, touchY) ) {
                jpPointerPressed = true;
                jump_pressed.setVisible(true);
                jump.setVisible(false);
            }
            else if( s_skill.imageTouched(touchX, touchY) && !s_cd) {
                sPointerPressed = true;
                s_skill_pressed.setVisible(true);
                s_skill.setVisible(false);
            }
            else if( e_skill.imageTouched(touchX, touchY) && !e_cd) {
                ePointerPressed = true;
                e_skill_pressed.setVisible(true);
                e_skill.setVisible(false);
                e_cd = true;
                e_skill_cd.setVisible(e_cd);
                e_skill_cd.reset();
            }
            else if( f_skill.imageTouched(touchX, touchY) ) {
                fPointerPressed = true;
                f_skill_pressed.setVisible(true);
                f_skill.setVisible(false);
            }
            else if( g_skill.imageTouched(touchX, touchY) ) {
                gPointerPressed = true;
                g_skill_pressed.setVisible(true);
                g_skill.setVisible(false);
            }
            if(e_skill_cd.isLastFrame()){
            e_cd = false;
            e_skill_cd.setVisible(e_cd);
    }
        return false;
    }

    @Override
    public boolean pointerMoved(List<Pointer> pointers) {
        for(int i = 1; i < pointers.size(); i++){
            int touchX = pointers.get(i).getX();
            int touchY = pointers.get(i).getY();
            if ( attack.imageTouched(touchX, touchY)) {
                atPointerPressed = true;
                attack_pressed.setVisible(true);
                attack.setVisible(false);
            }
            else if( defend.imageTouched(touchX, touchY) ) {
                dfPointerPressed = true;
                defend_pressed.setVisible(true);
                defend.setVisible(false);
            }
            else if( jump.imageTouched(touchX, touchY) ) {
                jpPointerPressed = true;
                jump_pressed.setVisible(true);
                jump.setVisible(false);
            }
            else if( s_skill.imageTouched(touchX, touchY) ) {
                sPointerPressed = true;
                s_skill_pressed.setVisible(true);
                s_skill.setVisible(false);
            }
            else if( e_skill.imageTouched(touchX, touchY) && !e_cd) {
                ePointerPressed = true;
                e_skill_pressed.setVisible(true);
                e_skill.setVisible(false);
                e_cd = true;
                e_skill_cd.setVisible(e_cd);
                e_skill_cd.reset();
            }
            else if( f_skill.imageTouched(touchX, touchY) ) {
                fPointerPressed = true;
                f_skill_pressed.setVisible(true);
                f_skill.setVisible(false);
            }
            else if( g_skill.imageTouched(touchX, touchY) ) {
                gPointerPressed = true;
                g_skill_pressed.setVisible(true);
                g_skill.setVisible(false);
            }
            if(e_skill_cd.isLastFrame()){
            e_cd = false;
            e_skill_cd.setVisible(e_cd);
    }
        }

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

        jpPointerPressed = false;
        jump.setVisible(true);
        jump_pressed.setVisible(false);

        sPointerPressed = false;
        s_skill.setVisible(true);
        s_skill_pressed.setVisible(false);

        ePointerPressed = false;
        e_skill.setVisible(true);
        e_skill_pressed.setVisible(false);

        fPointerPressed = false;
        f_skill.setVisible(true);
        f_skill_pressed.setVisible(false);

        gPointerPressed = false;
        g_skill.setVisible(true);
        g_skill_pressed.setVisible(false);

//         if(e_skill_cd.isLastFrame() && e_cd){
//         e_cd = false;
//         e_skill_cd.setVisible(e_cd);
// }
        return false;
    }

}
