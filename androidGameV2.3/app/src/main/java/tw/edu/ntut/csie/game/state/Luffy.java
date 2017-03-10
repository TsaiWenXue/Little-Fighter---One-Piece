package tw.edu.ntut.csie.game.state;


import tw.edu.ntut.csie.game.R;
import tw.edu.ntut.csie.game.core.MovingBitmap;
import tw.edu.ntut.csie.game.extend.Animation;
import tw.edu.ntut.csie.game.GameObject;

public class Luffy  {
    private MovingBitmap luffy_Normal;
    private int px, py;

    public Luffy() {
        luffy_Normal = new MovingBitmap(R.drawable.luffy01);
        px = 400; py = 200;
    }

    public void initialize() {
        luffy_Normal.setLocation(px, py );
    }
    public void show(){
        luffy_Normal.show();
    };
    public void release(){
        luffy_Normal.release();

        luffy_Normal = null;
    }
}
