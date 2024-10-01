package s10_magician;

import java.time.OffsetDateTime;

public final class WaterAttunement extends Attunement {
    private static final int ELITE_SKILL_COOLDOWN_IN_SECOND = 75;

    public WaterAttunement(Magician magician) {
        super(magician);
    }

    @Override
    public void onEntry() {
        System.out.println("Water!");
    }

    @Override
    public void attack() {
        System.out.println("Water punch!");
    }

    @Override
    public void useEliteSkill(OffsetDateTime lastEliteAttackUsedDateTime) {
        if (super.isBeforeCooldown(lastEliteAttackUsedDateTime, ELITE_SKILL_COOLDOWN_IN_SECOND)) {
            System.out.println("Not yet");
            return;
        }

        System.out.println("Water storm!");
    }

    @Override
    public void onDeath() {
        System.out.println("drown...");
    }
}
