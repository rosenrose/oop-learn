package s10_magician;

import java.time.OffsetDateTime;

public final class NoneAttunement extends Attunement {
    public NoneAttunement(Magician magician) {
        super(magician);
    }

    public void onEntry() {
        System.out.println("No attunement");
    }

    public void attack() {
        System.out.println("Punch!");
    }

    public void useEliteSkill(OffsetDateTime lastEliteAttackUsedDateTime) {
        System.out.println("Elite Punch!");
    }

    public void onDeath() {
        System.out.println("I'll be back");
    }
}
