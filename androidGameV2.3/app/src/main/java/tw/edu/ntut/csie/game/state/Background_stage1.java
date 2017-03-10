package tw.edu.ntut.csie.game.state;


import tw.edu.ntut.csie.game.R;
import tw.edu.ntut.csie.game.core.MovingBitmap;
import tw.edu.ntut.csie.game.extend.Animation;
import tw.edu.ntut.csie.game.GameObject;
import tw.edu.ntut.csie.game.PointerEventHandler;

public class Background_stage1 implements GameObject, PointerEventHandler{
    private MovingBitmap _sky;
    private MovingBitmap _road1;
    private MovingBitmap _road2;
    private MovingBitmap _road3;

    private Animation _wave;

    private int px, py;

    public Background_stage1() {
        _sky = new MovingBitmap(R.drawable.sky);
        _road1 = new MovingBitmap(R.drawable.road);
        _road2 = new MovingBitmap(R.drawable.road);
        _road3 = new MovingBitmap(R.drawable.road);

        _wave = new Animation();
        px = 0; py = 0;
    }

    public void initialize() {
        _sky.setLocation(px, py);

        _wave.setLocation(px, py + 70);
        //_wave.addFrame(R.drawable.wave014);
       _wave.addFrame(R.drawable.wave015);
        _wave.addFrame(R.drawable.wave016);
        _wave.addFrame(R.drawable.wave017);
        _wave.addFrame(R.drawable.wave018);
        _wave.addFrame(R.drawable.wave019);
        _wave.addFrame(R.drawable.wave020);
        _wave.addFrame(R.drawable.wave021);
        _wave.addFrame(R.drawable.wave022);
        _wave.addFrame(R.drawable.wave023);
        _wave.addFrame(R.drawable.wave024);
        _wave.addFrame(R.drawable.wave025);
        _wave.addFrame(R.drawable.wave026);
        _wave.addFrame(R.drawable.wave027);
        _wave.addFrame(R.drawable.wave028);
        _wave.addFrame(R.drawable.wave029);
        _wave.addFrame(R.drawable.wave030);
        _wave.addFrame(R.drawable.wave031);
        _wave.addFrame(R.drawable.wave032);
        _wave.addFrame(R.drawable.wave033);

        _road1.setLocation(px-800, py+50);
        _road2.setLocation(px, py+50);
        _road3.setLocation(px+800, py+50);
    }

    @Override
    public void release() {
        _sky.release();
        _wave.release();
        _road1.release();
        _road2.release();
        _road3.release();

        _sky = null;
        _wave = null;
        _road1 = null;
        _road2 = null;
        _road3 = null;
    }

    @Override
    public void move() {
        _wave.move();
    }

    @Override
    public void show() {
        _sky.show();
        _wave.show();
        _road1.show();
        _road2.show();
        _road3.show();
    }
}
