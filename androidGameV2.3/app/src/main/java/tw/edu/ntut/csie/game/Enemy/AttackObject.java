package tw.edu.ntut.csie.game.Enemy;

import tw.edu.ntut.csie.game.Character.CharacterObject;

/**
 * Created by huyuxiang on 2017/6/10.
 */

public class AttackObject {
    private int[] attackArea = new int[4];
    public int damage;
    public boolean attack = false, attack_r = false;

    public AttackObject(EnemyObject en) {
        damage = en.getDamage();
        attackArea = en.getAttackArea();
        attack = en.isAttacking();
        attack_r = en.isAttacking_r();
    }

    public int[] getAttackArea() {
        return attackArea;
    }
    public boolean isAttacking() {
        return attack;
    }
    public boolean isAttacking_r() {
        return attack_r;
    }
}
