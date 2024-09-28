package s05_base_entity;

import java.time.OffsetDateTime;
import java.util.UUID;

public class BaseEntity {
    private final UUID id;
    private final OffsetDateTime createdDateTime;
    private OffsetDateTime modifiedDateTime;

    public BaseEntity(UUID id, OffsetDateTime createdDateTime, OffsetDateTime modifiedDateTime) {
        this.id = id;
        this.createdDateTime = createdDateTime;
        this.modifiedDateTime = modifiedDateTime;
    }

    public UUID getId() {
        return this.id;
    }

    public OffsetDateTime getCreatedDateTime() {
        return this.createdDateTime;
    }

    public OffsetDateTime getModifiedDateTime() {
        return this.modifiedDateTime;
    }

    public void setModifiedDateTime(OffsetDateTime modifiedDateTime) {
        this.modifiedDateTime = modifiedDateTime;
    }
}
