package s12_monster;

public abstract class Monster {
    private int hp;
    private int attack;
    private int defense;

    public Monster(int hp, int attack, int defense) {
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
    }

    public int getHp() {
        return this.hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttack() {
        return this.attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return this.defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public boolean isAlive() {
        return this.hp > 0;
    }

    public final void attack(Monster target) {
        System.out.printf("%s attack %s%n", this.getClass().getSimpleName(), target.getClass().getSimpleName());

        int damage = calculateDamage(target);
        target.hp = Math.max(target.hp - damage, 0);
    }

    public abstract int calculateDamage(Monster target);
}
