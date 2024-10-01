package s10_magician;

import java.time.OffsetDateTime;

public final class AirAttunement extends Attunement {
    private static final int ELITE_SKILL_COOLDOWN_IN_SECOND = 80;

    public AirAttunement(Magician magician) {
        super(magician);
    }

    @Override
    public void onEntry() {
        System.out.println("Air!");
    }

    @Override
    public void attack() {
        System.out.println("Air punch!");
    }

    @Override
    public void useEliteSkill(OffsetDateTime lastEliteAttackUsedDateTime) {
        if (super.isBeforeCooldown(lastEliteAttackUsedDateTime, ELITE_SKILL_COOLDOWN_IN_SECOND)) {
            System.out.println("Not yet");
            return;
        }

        System.out.println("Air storm!");
    }

    @Override
    public void onDeath() {
        System.out.println("wind...");
    }
}
