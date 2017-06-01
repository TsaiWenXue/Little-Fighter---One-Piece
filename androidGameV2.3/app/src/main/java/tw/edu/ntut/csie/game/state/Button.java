package tw.edu.ntut.csie.game.state;

import java.util.ArrayList;
import java.util.List;

import tw.edu.ntut.csie.game.Pointer;
import tw.edu.ntut.csie.game.R;
import tw.edu.ntut.csie.game.core.MovingBitmap;
import tw.edu.ntut.csie.game.GameObject;
import tw.edu.ntut.csie.game.PointerEventHandler;
import tw.edu.ntut.csie.game.extend.Animation;
import tw.edu.ntut.csie.game.Character.CharacterObject;
import tw.edu.ntut.csie.game.Character.Luffy;

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
    private int s_frame_x = s_x + 10;
    private int s_frame_y = s_y + 15;

    public static int s_frame_count = 0;

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
    public static boolean s_frame_bool = false;
    public static boolean fire_bool = false;

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

    private MovingBitmap s_frame00;
    private MovingBitmap s_frame01;
    private MovingBitmap s_frame02;
    private MovingBitmap s_frame03;
    private MovingBitmap s_frame04;
    private MovingBitmap s_frame05;
    private MovingBitmap s_frame06;
    private MovingBitmap s_frame07;
    private MovingBitmap s_frame08;
    private MovingBitmap s_frame09;
    private MovingBitmap s_frame10;


    private Animation s_skill_cd;
    private Animation e_skill_cd;
    private Animation g_skill_cd;
    private Animation f_skill_cd;

    private Animation s_trigger;

    private Animation fire;

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

        s_trigger = new Animation();
        s_trigger.addFrame(R.drawable.s_trigger01);
        s_trigger.addFrame(R.drawable.s_trigger02);
        s_trigger.addFrame(R.drawable.s_trigger03);
        s_trigger.addFrame(R.drawable.s_trigger04);
        s_trigger.addFrame(R.drawable.s_trigger03);
        s_trigger.addFrame(R.drawable.s_trigger02);
        s_trigger.addFrame(R.drawable.s_trigger01);
        s_trigger.setLocation(s_x, s_y);
        s_trigger.setCurrentFrameIndex(-1);
        s_trigger.setVisible(false);

        S_frameInit();
        SframeSetLocation(s_frame_x, s_frame_y);

        fire = new Animation();
        fire.addFrame(R.drawable.fire_01);
        fire.addFrame(R.drawable.fire_02);
        fire.addFrame(R.drawable.fire_03);
        fire.addFrame(R.drawable.fire_04);
        fire.addFrame(R.drawable.fire_05);
        fire.addFrame(R.drawable.fire_06);
        fire.addFrame(R.drawable.fire_07);
        fire.addFrame(R.drawable.fire_08);
        fire.addFrame(R.drawable.fire_09);
        fire.addFrame(R.drawable.fire_10);
        fire.addFrame(R.drawable.fire_11);
        fire.addFrame(R.drawable.fire_12);
        fire.addFrame(R.drawable.fire_13);
        fire.addFrame(R.drawable.fire_14);
        fire.addFrame(R.drawable.fire_15);
        fire.addFrame(R.drawable.fire_16);
        fire.setLocation(49, 5);
        fire.setCurrentFrameIndex(-1);
        fire.setVisible(false);
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
        s_trigger.show();
        SframeShow();
        fire.show();
    }

    @Override
    public void move(){
        s_skill_cd.move();
        e_skill_cd.move();
        f_skill_cd.move();
        g_skill_cd.move();
        SframeSetVisible();
        if(s_frame_bool){
            s_trigger.setVisible(s_frame_bool);
            s_trigger.move();
        }
        if(fire_bool){
            fire.move();
            fire.setVisible(fire_bool);
        }

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
        s_trigger.release();
        SframeRelease();
        fire.release();
    }

    @Override
    public boolean pointerPressed(List<Pointer> pointers){return false;}
    public boolean pointerPressed(List<Pointer> pointers, CharacterObject ch) {
        int touchX = pointers.get(0).getX();
        int touchY = pointers.get(0).getY();
            if ( attack.imageTouched(touchX, touchY) && ch.isPerforming()) {
                atPointerPressed = true;
                attack_pressed.setVisible(true);
                attack.setVisible(false);
            }
            else if( defend.imageTouched(touchX, touchY) && ch.isPerforming()) {
                dfPointerPressed = true;
                defend_pressed.setVisible(true);
                defend.setVisible(false);
            }
            else if( jump.imageTouched(touchX, touchY) && ch.isPerforming()) {
                jpPointerPressed = true;
                jump_pressed.setVisible(true);
                jump.setVisible(false);
            }
            else if( s_skill.imageTouched(touchX, touchY)
            && !s_cd && s_frame_bool) {
                sPointerPressed = true;
                s_skill_pressed.setVisible(true);
                s_skill.setVisible(false);
                // s_cd = true;
                // s_skill_cd.setVisible(s_cd);
                // s_skill_cd.reset();
                s_frame_bool = false;
                s_trigger.setVisible(s_frame_bool);
                fire_bool = true;
            }
            else if( e_skill.imageTouched(touchX, touchY)
            && !e_cd && ch.isPerforming ()) {
                ePointerPressed = true;
                e_skill_pressed.setVisible(true);
                e_skill.setVisible(false);
                e_cd = true;
                e_skill_cd.setVisible(e_cd);
                e_skill_cd.reset();
                s_frame_count++;
            }
            else if( f_skill.imageTouched(touchX, touchY)
            && !f_cd && ch.isPerforming()) {
                fPointerPressed = true;
                f_skill_pressed.setVisible(true);
                f_skill.setVisible(false);
                f_cd = true;
                f_skill_cd.setVisible(f_cd);
                f_skill_cd.reset();
                s_frame_count++;
            }
            else if( g_skill.imageTouched(touchX, touchY)
            && !g_cd && ch.isPerforming()) {
                gPointerPressed = true;
                g_skill_pressed.setVisible(true);
                g_skill.setVisible(false);
                g_cd = true;
                g_skill_cd.setVisible(g_cd);
                g_skill_cd.reset();
                s_frame_count++;
            }
            if(e_skill_cd.getCurrentFrameIndex() == -1){
            e_cd = false;
            e_skill_cd.setVisible(e_cd);
            }
            if(s_skill_cd.getCurrentFrameIndex() == -1){
            s_cd = false;
            s_skill_cd.setVisible(s_cd);
            }
            if(f_skill_cd.getCurrentFrameIndex() == -1){
            f_cd = false;
            f_skill_cd.setVisible(f_cd);
            }
            if(g_skill_cd.getCurrentFrameIndex() == -1){
            g_cd = false;
            g_skill_cd.setVisible(g_cd);
            }
        return false;
    }

    @Override
    public boolean pointerMoved(List<Pointer> pointers){return false;}
    public boolean pointerMoved(List<Pointer> pointers, CharacterObject ch) {
        for(int i = 1; i < pointers.size(); i++){
            int touchX = pointers.get(i).getX();
            int touchY = pointers.get(i).getY();
            if ( attack.imageTouched(touchX, touchY) && ch.isPerforming()) {
                atPointerPressed = true;
                attack_pressed.setVisible(true);
                attack.setVisible(false);
            }
            else if( defend.imageTouched(touchX, touchY)  && ch.isPerforming()) {
                dfPointerPressed = true;
                defend_pressed.setVisible(true);
                defend.setVisible(false);
            }
            else if( jump.imageTouched(touchX, touchY) && ch.isPerforming() ) {
                jpPointerPressed = true;
                jump_pressed.setVisible(true);
                jump.setVisible(false);
            }
            else if( s_skill.imageTouched(touchX, touchY)
            && !s_cd && s_frame_bool) {
                sPointerPressed = true;
                s_skill_pressed.setVisible(true);
                s_skill.setVisible(false);
                // s_cd = true;
                // s_skill_cd.setVisible(s_cd);
                // s_skill_cd.reset();
                s_frame_bool = false;
                s_trigger.setVisible(s_frame_bool);
                fire_bool = true;
            }
            else if( e_skill.imageTouched(touchX, touchY)
            && !e_cd && ch.isPerforming()) {
                ePointerPressed = true;
                e_skill_pressed.setVisible(true);
                e_skill.setVisible(false);
                e_cd = true;
                e_skill_cd.setVisible(e_cd);
                e_skill_cd.reset();
                s_frame_count++;
            }
            else if( f_skill.imageTouched(touchX, touchY)
            && !f_cd && ch.isPerforming()) {
                fPointerPressed = true;
                f_skill_pressed.setVisible(true);
                f_skill.setVisible(false);
                f_cd = true;
                f_skill_cd.setVisible(f_cd);
                f_skill_cd.reset();
                s_frame_count++;
            }
            else if( g_skill.imageTouched(touchX, touchY)
            && !g_cd && ch.isPerforming()) {
                gPointerPressed = true;
                g_skill_pressed.setVisible(true);
                g_skill.setVisible(false);
                g_cd = true;
                g_skill_cd.setVisible(g_cd);
                g_skill_cd.reset();
                s_frame_count++;
            }
            if(e_skill_cd.getCurrentFrameIndex() == -1){
            e_cd = false;
            e_skill_cd.setVisible(e_cd);
            }
            if(s_skill_cd.getCurrentFrameIndex() == -1){
            s_cd = false;
            s_skill_cd.setVisible(s_cd);
            }
            if(f_skill_cd.getCurrentFrameIndex() == -1){
            f_cd = false;
            f_skill_cd.setVisible(f_cd);
            }
            if(g_skill_cd.getCurrentFrameIndex() == -1){
            g_cd = false;
            g_skill_cd.setVisible(g_cd);
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

        return false;
    }
    public void S_frameInit(){
         s_frame00 = new MovingBitmap(R.drawable.s_frame00);
         s_frame01 = new MovingBitmap(R.drawable.s_frame01);
         s_frame02 = new MovingBitmap(R.drawable.s_frame02);
         s_frame03 = new MovingBitmap(R.drawable.s_frame03);
         s_frame04 = new MovingBitmap(R.drawable.s_frame04);
         s_frame05 = new MovingBitmap(R.drawable.s_frame05);
         s_frame06 = new MovingBitmap(R.drawable.s_frame06);
         s_frame07 = new MovingBitmap(R.drawable.s_frame07);
         s_frame08 = new MovingBitmap(R.drawable.s_frame08);
         s_frame09 = new MovingBitmap(R.drawable.s_frame09);
         s_frame10 = new MovingBitmap(R.drawable.s_frame10);
    }
    public void SframeSetLocation(int _x, int _y){
        s_frame00.setLocation(_x, _y);
        s_frame01.setLocation(_x, _y);
        s_frame02.setLocation(_x, _y);
        s_frame03.setLocation(_x, _y);
        s_frame04.setLocation(_x, _y);
        s_frame05.setLocation(_x, _y);
        s_frame06.setLocation(_x, _y);
        s_frame07.setLocation(_x, _y);
        s_frame08.setLocation(_x, _y);
        s_frame09.setLocation(_x, _y);
        s_frame10.setLocation(_x, _y);
    }
    public void SframeSetVisible(){
    if(!s_frame_bool && !fire_bool){
        switch(s_frame_count){
            case(0):
                s_frame00.setVisible(true);
                s_frame01.setVisible(false);
                s_frame02.setVisible(false);
                s_frame03.setVisible(false);
                s_frame04.setVisible(false);
                s_frame05.setVisible(false);
                s_frame06.setVisible(false);
                s_frame07.setVisible(false);
                s_frame08.setVisible(false);
                s_frame09.setVisible(false);
                s_frame10.setVisible(false);
                break;
            case(1):
                s_frame00.setVisible(false);
                s_frame01.setVisible(true);
                s_frame02.setVisible(false);
                s_frame03.setVisible(false);
                s_frame04.setVisible(false);
                s_frame05.setVisible(false);
                s_frame06.setVisible(false);
                s_frame07.setVisible(false);
                s_frame08.setVisible(false);
                s_frame09.setVisible(false);
                s_frame10.setVisible(false);
                break;
            case(2):
                s_frame00.setVisible(false);
                s_frame01.setVisible(false);
                s_frame02.setVisible(true);
                s_frame03.setVisible(false);
                s_frame04.setVisible(false);
                s_frame05.setVisible(false);
                s_frame06.setVisible(false);
                s_frame07.setVisible(false);
                s_frame08.setVisible(false);
                s_frame09.setVisible(false);
                s_frame10.setVisible(false);
                break;
            case(3):
                s_frame00.setVisible(false);
                s_frame01.setVisible(false);
                s_frame02.setVisible(false);
                s_frame03.setVisible(true);
                s_frame04.setVisible(false);
                s_frame05.setVisible(false);
                s_frame06.setVisible(false);
                s_frame07.setVisible(false);
                s_frame08.setVisible(false);
                s_frame09.setVisible(false);
                s_frame10.setVisible(false);
                break;
            case(4):
                s_frame00.setVisible(false);
                s_frame01.setVisible(false);
                s_frame02.setVisible(false);
                s_frame03.setVisible(false);
                s_frame04.setVisible(true);
                s_frame05.setVisible(false);
                s_frame06.setVisible(false);
                s_frame07.setVisible(false);
                s_frame08.setVisible(false);
                s_frame09.setVisible(false);
                s_frame10.setVisible(false);
                break;
            case(5):
                s_frame00.setVisible(false);
                s_frame01.setVisible(false);
                s_frame02.setVisible(false);
                s_frame03.setVisible(false);
                s_frame04.setVisible(false);
                s_frame05.setVisible(true);
                s_frame06.setVisible(false);
                s_frame07.setVisible(false);
                s_frame08.setVisible(false);
                s_frame09.setVisible(false);
                s_frame10.setVisible(false);
                break;
            case(6):
                s_frame00.setVisible(false);
                s_frame01.setVisible(false);
                s_frame02.setVisible(false);
                s_frame03.setVisible(false);
                s_frame04.setVisible(false);
                s_frame05.setVisible(false);
                s_frame06.setVisible(true);
                s_frame07.setVisible(false);
                s_frame08.setVisible(false);
                s_frame09.setVisible(false);
                s_frame10.setVisible(false);
                break;
            case(7):
                s_frame00.setVisible(false);
                s_frame01.setVisible(false);
                s_frame02.setVisible(false);
                s_frame03.setVisible(false);
                s_frame04.setVisible(false);
                s_frame05.setVisible(false);
                s_frame06.setVisible(false);
                s_frame07.setVisible(true);
                s_frame08.setVisible(false);
                s_frame09.setVisible(false);
                s_frame10.setVisible(false);
                break;
            case(8):
                s_frame00.setVisible(false);
                s_frame01.setVisible(false);
                s_frame02.setVisible(false);
                s_frame03.setVisible(false);
                s_frame04.setVisible(false);
                s_frame05.setVisible(false);
                s_frame06.setVisible(false);
                s_frame07.setVisible(false);
                s_frame08.setVisible(true);
                s_frame09.setVisible(false);
                s_frame10.setVisible(false);
                break;
            case(9):
                s_frame00.setVisible(false);
                s_frame01.setVisible(false);
                s_frame02.setVisible(false);
                s_frame03.setVisible(false);
                s_frame04.setVisible(false);
                s_frame05.setVisible(false);
                s_frame06.setVisible(false);
                s_frame07.setVisible(false);
                s_frame08.setVisible(false);
                s_frame09.setVisible(true);
                s_frame10.setVisible(false);
                break;
            case(10):
                s_frame00.setVisible(false);
                s_frame01.setVisible(false);
                s_frame02.setVisible(false);
                s_frame03.setVisible(false);
                s_frame04.setVisible(false);
                s_frame05.setVisible(false);
                s_frame06.setVisible(false);
                s_frame07.setVisible(false);
                s_frame08.setVisible(false);
                s_frame09.setVisible(false);
                s_frame10.setVisible(true);
                s_frame_count = 0;
                s_frame_bool = true;
                break;
            }
        }
        else{
            s_frame00.setVisible(false);
            s_frame01.setVisible(false);
            s_frame02.setVisible(false);
            s_frame03.setVisible(false);
            s_frame04.setVisible(false);
            s_frame05.setVisible(false);
            s_frame06.setVisible(false);
            s_frame07.setVisible(false);
            s_frame08.setVisible(false);
            s_frame09.setVisible(false);
            s_frame10.setVisible(false);
        }
    }
    public void SframeShow(){

        s_frame00.show();
        s_frame01.show();
        s_frame02.show();
        s_frame03.show();
        s_frame04.show();
        s_frame05.show();
        s_frame06.show();
        s_frame07.show();
        s_frame08.show();
        s_frame09.show();
        s_frame10.show();
    }
    public void SframeRelease(){
        s_frame00.release();
        s_frame01.release();
        s_frame02.release();
        s_frame03.release();
        s_frame04.release();
        s_frame05.release();
        s_frame06.release();
        s_frame07.release();
        s_frame08.release();
        s_frame09.release();
        s_frame10.release();
    }
}
