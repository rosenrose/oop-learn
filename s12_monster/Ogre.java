package s12_monster;

public final class Ogre extends Monster {
    public Ogre() {
        this(50, 20, 5);
    }

    public Ogre(int hp, int attack, int defense) {
        super(hp, attack, defense);
    }

    @Override
    public int calculateDamage(Monster target) {
        return this.getAttack() + target.getAttack() - target.getDefense();
    }
}
