package s10_magician;

import java.time.Duration;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public abstract class Attunement {
    protected Magician magician;

    public Attunement(final Magician magician) {
        this.magician = magician;
    }

    public abstract void onEntry();

    public abstract void attack();

    public abstract void useEliteSkill(OffsetDateTime lastEliteAttackUsedDateTime);

    public abstract void onDeath();

    protected boolean isBeforeCooldown(OffsetDateTime lastEliteAttackUsedDateTime, int eliteSkillCooldownInSecond) {
        final OffsetDateTime now = OffsetDateTime.now(ZoneOffset.UTC);
        final Duration cooldown = Duration.ofSeconds(eliteSkillCooldownInSecond);
        final OffsetDateTime cooldownExpiryDateTime = lastEliteAttackUsedDateTime.plus(cooldown);

        return now.isBefore(cooldownExpiryDateTime);
    }
}
