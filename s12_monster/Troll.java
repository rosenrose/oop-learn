package s12_monster;

public final class Troll extends Monster {
    public Troll() {
        super(100, 10, 10);
    }

    public Troll(int hp, int attack, int defense) {
        super(hp, attack, defense);
    }

    @Override
    public int calculateDamage(Monster target) {
        return this.getAttack() - target.getDefense() / 2;
    }
}
