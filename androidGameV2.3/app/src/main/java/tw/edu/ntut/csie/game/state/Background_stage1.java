package tw.edu.ntut.csie.game.state;


import tw.edu.ntut.csie.game.R;
import tw.edu.ntut.csie.game.core.MovingBitmap;
import tw.edu.ntut.csie.game.extend.Animation;
import tw.edu.ntut.csie.game.GameObject;

public class Background_stage1 implements GameObject {
    private MovingBitmap _sky;
    private MovingBitmap _road;

    private Animation _wave;

    private int px, py;

    public Background_stage1() {
        _sky = new MovingBitmap(R.drawable.sky);
        _road = new MovingBitmap(R.drawable.road);

        _wave = new Animation();
        px = 0; py = 0;
    }

    public void initialize() {
        _sky.setLocation(px, py);

        _wave.setLocation(px, py + 70);
        _wave.addFrame(R.drawable.wave014);
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

        _road.setLocation(px, py);
    }

    @Override
    public void release() {
        _sky.release();
        _wave.release();
        _road.release();

        _sky = null;
        _wave = null;
        _road = null;
    }

    @Override
    public void move() {
        _wave.move();
    }

    @Override
    public void show() {
        _sky.show();
        _wave.show();
        _road.show();
    }
}
