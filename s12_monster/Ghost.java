package s12_monster;

public final class Ghost extends Monster {
    public Ghost() {
        this(10, 3, 2);
    }

    public Ghost(int hp, int attack, int defense) {
        super(hp, attack, defense);
    }

    public int calculateDamage(Monster target) {
        return target.getAttack() - target.getDefense();
    }
}
