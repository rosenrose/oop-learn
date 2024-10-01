package s12_monster;

public class Program {
    public static void main(String[] args) {
        Monster ogre = new Ogre();
        Monster troll = new Troll();
        Monster ghost = new Ghost();

        ogre.attack(troll);
        troll.attack(ghost);
        ghost.attack(ogre);

        System.out.println(ogre.getHp());
        System.out.println(troll.getHp());
        System.out.println(ghost.getHp());
    }
}
