package s10_magician;

import java.time.OffsetDateTime;

public final class NoneAttunement extends Attunement {
    public NoneAttunement(Magician magician) {
        super(magician);
    }

    @Override
    public void onEntry() {
        System.out.println("No attunement");
    }

    @Override
    public void attack() {
        System.out.println("Punch!");
    }

    @Override
    public void useEliteSkill(OffsetDateTime lastEliteAttackUsedDateTime) {
        System.out.println("Elite Punch!");
    }

    @Override
    public void onDeath() {
        System.out.println("I'll be back");
    }
}
