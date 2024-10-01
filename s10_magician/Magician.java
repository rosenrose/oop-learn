package s10_magician;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public final class Magician {
    private String name;
    private Attunement attunement;
    private OffsetDateTime lastEliteAttackUsedDateTime;
    private static final OffsetDateTime INIT_ELITE_ATTACK_USED_DATE_TIME = OffsetDateTime.of(1, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC);

    public Magician(String name) {
        this.name = name;
        this.attunement = new NoneAttunement(this);
        this.lastEliteAttackUsedDateTime = INIT_ELITE_ATTACK_USED_DATE_TIME;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAttunement(final Attunement attunement) {
        if (this.attunement.getClass() == attunement.getClass()) {
            return;
        }

        this.attunement = attunement;
        this.attunement.onEntry();
    }

    public void attack() {
        this.attunement.attack();
    }

    public void useEliteSkill() {
        this.attunement.useEliteSkill(this.lastEliteAttackUsedDateTime);
        this.lastEliteAttackUsedDateTime = OffsetDateTime.now(ZoneOffset.UTC);
    }

    public void onDeath() {
        this.attunement.onDeath();
        this.lastEliteAttackUsedDateTime = INIT_ELITE_ATTACK_USED_DATE_TIME;
    }
}
