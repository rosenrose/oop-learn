package s12_monster;

public final class Ghost extends Monster {
    public Ghost() {
        super(10, 3, 2);
    }

    public Ghost(int hp, int attack, int defense) {
        super(hp, attack, defense);
    }

    @Override
    public int calculateDamage(Monster target) {
        return target.getAttack() - target.getDefense();
    }
}
