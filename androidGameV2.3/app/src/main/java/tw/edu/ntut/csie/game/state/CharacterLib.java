package tw.edu.ntut.csie.game.state;

import tw.edu.ntut.csie.game.R;

public class CharacterLib {
    public static void luffy(Character ch) {
        ch.loadNormal(R.drawable.luffy);
        ch.loadNormalReverse(R.drawable.luffy_r);

        ch.addRun(R.drawable.luffy_run01);
        ch.addRun(R.drawable.luffy_run02);
        ch.addRun(R.drawable.luffy_run03);
        ch.addRun(R.drawable.luffy_run02);
        ch.addRunReverse(R.drawable.luffy_run01_r);
        ch.addRunReverse(R.drawable.luffy_run02_r);
        ch.addRunReverse(R.drawable.luffy_run03_r);
        ch.addRunReverse(R.drawable.luffy_run02_r);

        //ch.addAttack(R.drawable.luffy_attack00);
        ch.addAttack(R.drawable.luffy_attack01);
        ch.addAttack(R.drawable.luffy_attack02);
        ch.addAttack(R.drawable.luffy_attack03);
        ch.addAttack(R.drawable.luffy_attack04);
        ch.addAttack(R.drawable.luffy_attack05);
        ch.addAttack(R.drawable.luffy_attack04);
        ch.addAttack(R.drawable.luffy_attack03);
        ch.addAttack(R.drawable.luffy_attack02);
        ch.addAttack(R.drawable.luffy_attack01);
        ch.addAttack(R.drawable.luffy_attack06);
        ch.addAttack(R.drawable.luffy_attack07);
        ch.addAttackReverse(R.drawable.luffy_attack00_r);
        ch.addAttackReverse(R.drawable.luffy_attack01_r);
        ch.addAttackReverse(R.drawable.luffy_attack02_r);
        ch.addAttackReverse(R.drawable.luffy_attack03_r);
        ch.addAttackReverse(R.drawable.luffy_attack04_r);
        ch.addAttackReverse(R.drawable.luffy_attack05_r);
        ch.addAttackReverse(R.drawable.luffy_attack04_r);
        ch.addAttackReverse(R.drawable.luffy_attack03_r);
        ch.addAttackReverse(R.drawable.luffy_attack02_r);
        ch.addAttackReverse(R.drawable.luffy_attack01_r);
        ch.addAttackReverse(R.drawable.luffy_attack06_r);
        ch.addAttackReverse(R.drawable.luffy_attack07_r);

    }


}
