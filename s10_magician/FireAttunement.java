package s10_magician;

import java.time.OffsetDateTime;

public final class FireAttunement extends Attunement {
    private static final int ELITE_SKILL_COOLDOWN_IN_SECOND = 90;

    public FireAttunement(Magician magician) {
        super(magician);
    }

    public void onEntry() {
        System.out.println("Fire!");
    }

    public void attack() {
        System.out.println("Fire punch!");
    }

    public void useEliteSkill(OffsetDateTime lastEliteAttackUsedDateTime) {
        if (super.isBeforeCooldown(lastEliteAttackUsedDateTime, ELITE_SKILL_COOLDOWN_IN_SECOND)) {
            System.out.println("Not yet");
            return;
        }

        System.out.println("Fire storm!");
    }

    public void onDeath() {
        System.out.println("ash...");
    }
}
