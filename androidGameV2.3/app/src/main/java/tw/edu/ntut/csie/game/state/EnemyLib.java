package tw.edu.ntut.csie.game.state;

import tw.edu.ntut.csie.game.R;

public class EnemyLib {
    public static void marin (Enemy en) {
        en.loadNormal(R.drawable.marin);
        en.loadNormalReverse(R.drawable.marin);

        en.addRun(R.drawable.marin_run01);
        en.addRun(R.drawable.marin_run02);
        en.addRun(R.drawable.marin_run03);
        en.addRunReverse(R.drawable.marin_run01_r);
        en.addRunReverse(R.drawable.marin_run02_r);
        en.addRunReverse(R.drawable.marin_run03_r);

        en.addHit(R.drawable.marin_hit01_r);
        en.addHit(R.drawable.marin_hit02_r);
        en.addHit(R.drawable.marin_hit03_r);
        en.addHit(R.drawable.marin_hit04_r);
        en.addHit(R.drawable.marin_hit05_r);
        en.addHit_r(R.drawable.marin_hit01);
        en.addHit_r(R.drawable.marin_hit02);
        en.addHit_r(R.drawable.marin_hit03);
        en.addHit_r(R.drawable.marin_hit04);
        en.addHit_r(R.drawable.marin_hit05);
    }
}
