package s10_magician;

public class Program {
    public static void main(String[] args) {
        Magician magician = new Magician("Oz");
        magician.attack();
        magician.useEliteSkill();
        magician.onDeath();
        System.out.println();

        magician.setAttunement(new FireAttunement(magician));
        magician.attack();
        magician.useEliteSkill();
        magician.useEliteSkill();
        magician.onDeath();
        System.out.println();

        magician.setAttunement(new FireAttunement(magician));

        magician.setAttunement(new WaterAttunement(magician));
        magician.attack();
        magician.useEliteSkill();
        magician.onDeath();
        System.out.println();

        magician.setAttunement(new AirAttunement(magician));
        magician.attack();
        magician.useEliteSkill();
        magician.onDeath();
        System.out.println();

        magician.setAttunement(new EarthAttunement(magician));
        magician.attack();
        magician.useEliteSkill();
        magician.onDeath();
        System.out.println();

        magician.setAttunement(new NoneAttunement(magician));
    }
}
