package s05_base_entity;

import java.time.OffsetDateTime;
import java.util.UUID;

public final class Student extends BaseEntity {
    private final String name;
    private final String email;
    private String nickname;

    public Student(UUID id, OffsetDateTime createdDateTime, OffsetDateTime modifiedDateTime,
                   String name, String email, String nickname) {
        super(id, createdDateTime, modifiedDateTime);
        this.name = name;
        this.email = email;
        this.nickname = nickname;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public String getNickname() {
        return this.nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
