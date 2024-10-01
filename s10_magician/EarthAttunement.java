package s10_magician;

import java.time.OffsetDateTime;

public final class EarthAttunement extends Attunement {
    private static final int ELITE_SKILL_COOLDOWN_IN_SECOND = 100;

    public EarthAttunement(Magician magician) {
        super(magician);
    }

    public void onEntry() {
        System.out.println("Earth!");
    }

    public void attack() {
        System.out.println("Earth punch!");
    }

    public void useEliteSkill(OffsetDateTime lastEliteAttackUsedDateTime) {
        if (super.isBeforeCooldown(lastEliteAttackUsedDateTime, ELITE_SKILL_COOLDOWN_IN_SECOND)) {
            System.out.println("Not yet");
            return;
        }

        System.out.println("Earth storm!");
    }

    public void onDeath() {
        System.out.println("dust...");
    }
}
