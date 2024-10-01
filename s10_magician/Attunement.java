package s10_magician;

import java.time.Duration;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class Attunement {
    protected Magician magician;

    public Attunement(final Magician magician) {
        this.magician = magician;
    }

    public void onEntry() {
    }

    public void attack() {
    }

    public void useEliteSkill(OffsetDateTime lastEliteAttackUsedDateTime) {
    }

    public void onDeath() {
    }

    protected boolean isBeforeCooldown(OffsetDateTime lastEliteAttackUsedDateTime, int eliteSkillCooldownInSecond) {
        final OffsetDateTime now = OffsetDateTime.now(ZoneOffset.UTC);
        final Duration cooldown = Duration.ofSeconds(eliteSkillCooldownInSecond);
        final OffsetDateTime cooldownExpiryDateTime = lastEliteAttackUsedDateTime.plus(cooldown);

        return now.isBefore(cooldownExpiryDateTime);
    }
}
